import mediapipe as mp 
import cv2 
from PyQt5 import QtCore, QtGui, QtWidgets
import numpy as np 
import sys 

# inicializa detecção de mãos, e limita para uma mao
modulo_maos = mp.solutions.hands
detector_maos = modulo_maos.Hands(max_num_hands=1)

# utiltario para desenhar as landmarks da mao
desenhador_mp = mp.solutions.drawing_utils

def calcular_distancia(ponto1, ponto2): # funcao para calcular distancia de pontos (no caso, landmarks)
    return np.linalg.norm(np.array(ponto1) - np.array(ponto2))

class BarraFerramentas(QtWidgets.QWidget):
    
    def __init__(self, sobreposicao_transparente):
        super().__init__()  # Inicializa QWidget 
        self.sobreposicao = sobreposicao_transparente 
        self.drag_position = None # define para lidar com erro de "AttributeError: 'BarraFerramentas' object has no attribute 'drag_position'"
        self.inicializar_interface()  # Inicializa a interface gráfica 

    def inicializar_interface(self):
        
        # janela
        self.setWindowFlags(QtCore.Qt.FramelessWindowHint | QtCore.Qt.WindowStaysOnTopHint) # janela sem borda e no top
        self.setWindowTitle("Ferramentas de Pintura")
        layout = QtWidgets.QVBoxLayout() # layout vertical
        layout.setSpacing(8) # espaçamento 

        # botao cor
        self.botao_cor = QtWidgets.QPushButton("Selecionar Cor")
        self.botao_cor.clicked.connect(self.selecionar_cor)
        layout.addWidget(self.botao_cor)

        # espessura 
        layout.addWidget(QtWidgets.QLabel("Espessura"))
        self.espessura_pincel = QtWidgets.QSlider(QtCore.Qt.Horizontal)
        self.espessura_pincel.setRange(1, 20)
        self.espessura_pincel.setValue(10) # valor padrao
        layout.addWidget(self.espessura_pincel)

        layout.addWidget(QtWidgets.QLabel("Forma"))
        self.grupo_formas = QtWidgets.QButtonGroup(self)
        
        # radio buttons
        self.forma_livre = QtWidgets.QRadioButton("Livre")
        self.forma_livre.setChecked(True) # livre é padrao 
        self.forma_circulo = QtWidgets.QRadioButton("Círculo")
        self.forma_linha = QtWidgets.QRadioButton("Linha")
        self.forma_retangulo = QtWidgets.QRadioButton("Retângulo")
        self.forma_triangulo = QtWidgets.QRadioButton("Triângulo")
        self.forma_quadrado = QtWidgets.QRadioButton("Quadrado")
        
        # identificadores 
        self.grupo_formas.addButton(self.forma_livre, 0)
        self.grupo_formas.addButton(self.forma_circulo, 1)
        self.grupo_formas.addButton(self.forma_linha, 2)
        self.grupo_formas.addButton(self.forma_retangulo, 3)
        self.grupo_formas.addButton(self.forma_triangulo, 4)
        self.grupo_formas.addButton(self.forma_quadrado, 5)
        
        # adiciona no laytout
        layout.addWidget(self.forma_livre)
        layout.addWidget(self.forma_circulo)
        layout.addWidget(self.forma_linha)
        layout.addWidget(self.forma_retangulo)
        layout.addWidget(self.forma_triangulo)
        layout.addWidget(self.forma_quadrado)
        
        # cria botao, relaciona com funcao e adiciona esse botao no layout
        self.botao_salvar = QtWidgets.QPushButton("Salvar Desenho")
        self.botao_salvar.clicked.connect(self.salvar_desenho)
        layout.addWidget(self.botao_salvar)

        self.botao_limpar = QtWidgets.QPushButton("Limpar Tela")
        self.botao_limpar.clicked.connect(self.sobreposicao.limpar_canvas)
        layout.addWidget(self.botao_limpar)

        self.botao_webcam = QtWidgets.QPushButton("Alternar Webcam")
        self.botao_webcam.clicked.connect(self.sobreposicao.alternar_webcam)
        layout.addWidget(self.botao_webcam)

        self.botao_sair = QtWidgets.QPushButton("Sair")
        self.botao_sair.clicked.connect(QtWidgets.qApp.quit)
        layout.addWidget(self.botao_sair)

        self.setLayout(layout) # aplica layout
        
        self.setStyleSheet( # modo noturno simples, feito com auxilio de IA.
            """
            QWidget { background: #000; color: #fff; }
            QPushButton, QRadioButton { background: #222; border: none; padding: 5px; }
            QPushButton:hover { background: #333; }
            QSlider::groove:horizontal { background: #444; height: 15px; }
            QSlider::handle:horizontal { background: #fff; width: 12px; }
            """
            )

    # funcoes para arrastar menu (barra de título que permite foi removida, para o usuário não fechar a barra acidentalmente)
    def mousePressEvent(self, event):
        if event.button() == QtCore.Qt.LeftButton:
            self.drag_position = event.globalPos() - self.frameGeometry().topLeft()
            event.accept()

    def mouseMoveEvent(self, event):
        if event.buttons() == QtCore.Qt.LeftButton and self.drag_position is not None:
            self.move(event.globalPos() - self.drag_position)
            event.accept()

    # seleciona cor (QcolorDialog)
    def selecionar_cor(self):
        seletor = QtWidgets.QColorDialog(self)
        seletor.setOption(QtWidgets.QColorDialog.ShowAlphaChannel)
        if seletor.exec_():
            self.sobreposicao.cor_pincel = seletor.selectedColor()

    # salva o desenho em png
    def salvar_desenho(self):
        caminho, _ = QtWidgets.QFileDialog.getSaveFileName(self, "Salvar Imagem", "", "PNG (*.png)")
        if caminho:
            imagem_para_salvar = QtGui.QImage(self.sobreposicao.canvas.size(), QtGui.QImage.Format_ARGB32)
            imagem_para_salvar.fill(QtCore.Qt.white)

            pintor = QtGui.QPainter(imagem_para_salvar)
            pintor.drawImage(0, 0, self.sobreposicao.canvas)
            pintor.end()

            imagem_para_salvar.save(caminho)
            QtWidgets.QMessageBox.information(self, "Salvo", "Imagem salva com sucesso!")

# classe da tela transparente 
class SobreposicaoTransparente(QtWidgets.QWidget):
    def __init__(self):
        super().__init__()
        
        #tamanho da tela inteira
        self.tela = QtWidgets.QApplication.primaryScreen().geometry()
        self.setGeometry(self.tela)
        
        # sem bordas, transparente, e ignora mouse
        self.setWindowFlags(QtCore.Qt.FramelessWindowHint | QtCore.Qt.WindowStaysOnTopHint)
        self.setAttribute(QtCore.Qt.WA_TranslucentBackground)
        self.setAttribute(QtCore.Qt.WA_TransparentForMouseEvents)

        # cria canvas 
        self.canvas = QtGui.QImage(self.width(), self.height(), QtGui.QImage.Format_ARGB32)
        self.canvas.fill(QtCore.Qt.transparent)

        # Inicializa webcam
        self.camera = cv2.VideoCapture(0)
        self.webcam_ativa = True

        # Parâmetros iniciais
        self.cor_pincel = QtGui.QColor(255, 0, 0, 180)
        self.x_anterior = self.y_anterior = 0
        
        self.modo_desenho = False
        self.modo_borracha = False

        # controla status do desenho
        self.desenhando_forma = False
        self.inicio_forma = None
        self.fim_forma = None

        # timer que atualiza camera
        self.temporizador = QtCore.QTimer()
        self.temporizador.timeout.connect(self.atualizar_quadro)
        self.temporizador.start(15)

        # barra de ferramentas
        self.barra = BarraFerramentas(self)
        self.barra.move(20, 20) # cordenada fixa (testar em outros monitores)
        self.barra.show()

    def limpar_canvas(self):
        self.canvas.fill(QtCore.Qt.transparent)
        self.update()

    def alternar_webcam(self):
        self.webcam_ativa = not self.webcam_ativa
        self.update()

    def atualizar_quadro(self):
        
        ret, quadro = self.camera.read()
        if not ret:
            return

        quadro = cv2.flip(quadro, 1) # Espelha horizontalmente (efeito de espelho)
        rgb = cv2.cvtColor(quadro, cv2.COLOR_BGR2RGB) # Converte para RGB (padronziar)
        resultado = detector_maos.process(rgb) # aplica a detecao

        # variaveis auxiliares 
        self.posicao_dedo_indicador = None
        forma_selecionada = self.barra.grupo_formas.checkedId()
        self.modo_desenho = False
        self.modo_borracha = False

        # se detectao mao   
        if resultado.multi_hand_landmarks:
            for handLms in resultado.multi_hand_landmarks:
                desenhador_mp.draw_landmarks(quadro, handLms, modulo_maos.HAND_CONNECTIONS)

            mao = resultado.multi_hand_landmarks[0]
            marcadores = mao.landmark
            
            # indicador
            x1, y1 = int(marcadores[8].x * self.width()), int(marcadores[8].y * self.height())
            self.posicao_dedo_indicador = (x1, y1)

            # Verifica quais dedos estão levantados para identificar gestos
            dedos = [ 
                marcadores[8].y < marcadores[6].y,
                marcadores[12].y < marcadores[10].y,
                marcadores[16].y < marcadores[14].y,
                marcadores[20].y < marcadores[18].y
            ]

            # Comandos
            self.modo_desenho = dedos == [True, False, False, False]
            self.modo_borracha = dedos == [True, True, False, False]

            # modo forma geometrica
            if self.modo_desenho and forma_selecionada in (1, 2, 3, 4, 5):
                if not self.desenhando_forma:
                    self.inicio_forma = (x1, y1)
                    self.desenhando_forma = True
                self.fim_forma = (x1, y1)
            else:
                if self.desenhando_forma and self.inicio_forma and self.fim_forma:
                    self._desenhar_forma_final(forma_selecionada)
                self.desenhando_forma = False
                self.inicio_forma = None
                self.fim_forma = None

            # modo livre (borracha é livre)
            if self.modo_borracha or (self.modo_desenho and forma_selecionada == 0):
                if self.x_anterior == 0 and self.y_anterior == 0:
                    self.x_anterior, self.y_anterior = x1, y1
                else:
                    x_suave = int(0.85 * self.x_anterior + 0.15 * x1)
                    y_suave = int(0.85 * self.y_anterior + 0.15 * y1)
                    if calcular_distancia((x_suave, y_suave), (self.x_anterior, self.y_anterior)) > 3:
                        pintor = QtGui.QPainter(self.canvas)
                        if self.modo_borracha:
                            pintor.setCompositionMode(QtGui.QPainter.CompositionMode_Clear)
                            caneta = QtGui.QPen(QtCore.Qt.transparent, self.barra.espessura_pincel.value() * 2)
                        else:
                            caneta = QtGui.QPen(self.cor_pincel, self.barra.espessura_pincel.value())
                        pintor.setPen(caneta)
                        pintor.drawLine(self.x_anterior, self.y_anterior, x_suave, y_suave)
                        pintor.end()
                        self.x_anterior, self.y_anterior = x_suave, y_suave
            else:
                self.x_anterior = 0
                self.y_anterior = 0
        else:
            # se a mão desaparecer, finaliza desenho da forma
            if self.desenhando_forma and self.inicio_forma and self.fim_forma:
                self._desenhar_forma_final(forma_selecionada)
            self.desenhando_forma = False
            self.inicio_forma = None
            self.fim_forma = None
            self.x_anterior = 0
            self.y_anterior = 0

        self.quadro_com_landmarks = quadro  # <--- Armazenar o quadro com landmarks
        self.update()

    # Desenha a forma finalizada no canvas
    def _desenhar_forma_final(self, forma_selecionada):
        pintor = QtGui.QPainter(self.canvas)
        caneta = QtGui.QPen(self.cor_pincel, self.barra.espessura_pincel.value())
        pintor.setPen(caneta)

        if forma_selecionada == 1:  # Círculo
            x0, y0 = self.inicio_forma
            x1_, y1_ = self.fim_forma
            raio = int(calcular_distancia((x0, y0), (x1_, y1_)))
            pintor.drawEllipse(QtCore.QPoint(x0, y0), raio, raio)
        elif forma_selecionada == 2:  # Linha
            pintor.drawLine(*self.inicio_forma, *self.fim_forma)
        elif forma_selecionada == 3:  # Retângulo
            x0, y0 = self.inicio_forma
            x1_, y1_ = self.fim_forma
            ret = QtCore.QRect(min(x0, x1_), min(y0, y1_), abs(x1_ - x0), abs(y1_ - y0))
            pintor.drawRect(ret)
        elif forma_selecionada == 4:  # Triângulo
            x0, y0 = self.inicio_forma
            x1_, y1_ = self.fim_forma
            base_meio_x = (x0 + x1_) // 2
            pontos = [
                QtCore.QPoint(base_meio_x, y0),  # topo
                QtCore.QPoint(x0, y1_),          # canto inferior esquerdo
                QtCore.QPoint(x1_, y1_)          # canto inferior direito
            ]
            pintor.drawPolygon(QtGui.QPolygon(pontos))   
        elif forma_selecionada == 5:  # Quadrado
            x0, y0 = self.inicio_forma
            x1_, y1_ = self.fim_forma
            lado = min(abs(x1_ - x0), abs(y1_ - y0))
            topo_esq_x = min(x0, x1_)
            topo_esq_y = min(y0, y1_)
            quadrado = QtCore.QRect(topo_esq_x, topo_esq_y, lado, lado)
            pintor.drawRect(quadrado)
        pintor.end()    

    # Evento de pintura (renderiza o canvas e elementos visuais)
    def paintEvent(self, evento):
        pintor = QtGui.QPainter(self)
        pintor.setRenderHint(QtGui.QPainter.Antialiasing)
        pintor.fillRect(self.rect(), QtCore.Qt.transparent)

        # destaca landmarks da mão
        if self.webcam_ativa and hasattr(self, 'quadro_com_landmarks'):
            quadro = self.quadro_com_landmarks
            quadro = cv2.cvtColor(quadro, cv2.COLOR_BGR2RGB)
            quadro_qt = QtGui.QImage(quadro.data, quadro.shape[1], quadro.shape[0], QtGui.QImage.Format_RGB888)
            quadro_qt = quadro_qt.scaled(320, 240, QtCore.Qt.KeepAspectRatio)
            x_webcam = 20
            y_webcam = self.height() - quadro_qt.height() - 20
            pintor.drawImage(x_webcam, y_webcam, quadro_qt)

        pintor.drawImage(0, 0, self.canvas)

        # Desenha círculo indicador no dedo (landmark 8)
        if self.desenhando_forma and self.inicio_forma and self.fim_forma:
            caneta = QtGui.QPen(self.cor_pincel, self.barra.espessura_pincel.value(), QtCore.Qt.DashLine)
            pintor.setPen(caneta)
            forma_selecionada = self.barra.grupo_formas.checkedId()
            x0, y0 = self.inicio_forma
            x1_, y1_ = self.fim_forma
            if forma_selecionada == 1:
                raio = int(calcular_distancia((x0, y0), (x1_, y1_)))
                pintor.drawEllipse(QtCore.QPoint(x0, y0), raio, raio)
            elif forma_selecionada == 2:
                pintor.drawLine(x0, y0, x1_, y1_)
            elif forma_selecionada == 3:
                ret = QtCore.QRect(min(x0, x1_), min(y0, y1_), abs(x1_ - x0), abs(y1_ - y0))
                pintor.drawRect(ret)
            elif forma_selecionada == 4:
                base_meio_x = (x0 + x1_) // 2
                pontos = [
                    QtCore.QPoint(base_meio_x, y0),
                    QtCore.QPoint(x0, y1_),
                    QtCore.QPoint(x1_, y1_)
                ]
                pintor.drawPolygon(QtGui.QPolygon(pontos))
            elif forma_selecionada == 5:  # Quadrado
                x0, y0 = self.inicio_forma
                x1_, y1_ = self.fim_forma
                lado = min(abs(x1_ - x0), abs(y1_ - y0))  # lado igual para altura e largura
                topo_esq_x = min(x0, x1_)
                topo_esq_y = min(y0, y1_)
                quadrado = QtCore.QRect(topo_esq_x, topo_esq_y, lado, lado)
                pintor.drawRect(quadrado)
            
    
        # destaca dedo indicador (mouse)
        if hasattr(self, 'posicao_dedo_indicador') and self.posicao_dedo_indicador:
            cor = QtGui.QColor(255, 255, 255, 150) if self.modo_borracha else self.cor_pincel
            pintor.setBrush(cor)
            pintor.setPen(QtCore.Qt.NoPen)
            x, y = self.posicao_dedo_indicador
            pintor.drawEllipse(x - 10, y - 10, 20, 20)

        pintor.end()
        
    # executa aplicacao
def executar():
    app = QtWidgets.QApplication(sys.argv)
    sobreposicao = SobreposicaoTransparente()
    sobreposicao.show()
    sys.exit(app.exec_())

    # chama executar
if __name__ == "__main__":
    executar()