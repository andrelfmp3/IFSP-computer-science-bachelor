## **Projeto Visão Computacional (nome a definir)** 

### **Objetivo**
Desenvolver uma aplicação de visão computacional em Python que permita ao usuário escrever, desenhar, apontar, grifar e interagir com elementos da tela, usando apenas gestos da mão em tempo real. Ideal para uso didático em aulas presenciais ou online.

---

### **Tecnologias Utilizadas (Criar yml)**
- **Python 3.13* (versão mais recente disponível)
- **OpenCV** (captura de vídeo e desenho)
- **MediaPipe** (detecção da mão e pontos-chave)
- **Tkinter / PyQt5** (para interface gráfica, se necessário)
- **Numpy** (manipular matrizes)
- **Math** (para calculo de distâncias)
- **Base de dados: A definir (?)** 

---


### **Ambiente**

conda env update -n muppets -f ambienteMuppets.yml --prune

ou

conda install opencv
pip mediapipe (disponivel apenas via pip, já baixa numpy 1.26.4)
pip install PyQt5, conda deu problemas

conda deu erro 
**qt.qpa.plugin: Could not load the Qt platform plugin "windows" in "" even though it was found. This application failed to start because no Qt platform plugin could be initialized.**. 
Para resolver colocou-se  
**os.environ['QT_QPA_PLATFORM_PLUGIN_PATH'] = os.path.join(sys.prefix, 'Library', 'plugins', 'platforms')**
por fim, colocou-se simplemente pip para funcionar. caso de erro e precise do conta, usar dessa maneira


### **Funcionalidades Principais**

#### Hand Mouse (True por padrão)
- **Apontar (1 dedo)** → Cursor do mouse / apontar na tela
- **Borracha (2 dedos)**
- **Ativar Modo Overlay Paint**

#### Overley Paint (False por padrão)
- **Desativar Modo Overlay Paint**
- **Dois dedos juntos (indicador e dedo médio)** → "Desenhar". Translucido, então "Grifa"
- **Figuras Geométricas** 
- **Selecionar cor**
- **Limpar tela**

#### Interação com Tela
- **Sobreposição** sobre slides / navegador (overlay)
- Alternar entre câmera e tela

---

### Exemplos de Aplicações
- 
- Professor explica um código no projetor e grifa uma função diretamente no vscode, sem precisar ir ao computador.
- Professor explica um slide no projetor e puxa uma seta relacionando tópicos, sem precisar ir ao computador.


