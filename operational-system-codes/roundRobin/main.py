from processos import Processos
from escalonador import escalonador
from ler import ler_arquivo
import time

# Criando uma instância da classe Processos
processos_obj = Processos()

# Lendo os processos do arquivo
processos = ler_arquivo("Teste.txt")

# Adicionando os processos na instância de Processos
for id_processo, instrucoes in processos:
    processos_obj.adicionar_processo(id_processo, instrucoes)

# Esperando um tempo suficiente para os processos serem adicionados à fila
time.sleep(1)

# Obtendo a fila de processos atual como uma lista
fila_de_processos = processos_obj.get_fila_de_processos()
print(f"Fila de processos prontos: {fila_de_processos} \n")

# Executando o escalonador com a fila de processos
escalonador(fila_de_processos, 5)

#Grupo: 
#ANDRÉ LYRA FERNANDES
#MARIANA PEIXOTO CHAHUD
#LARISSA  GABRIELA SANT´ANGELO DIAS
#VICTÓRIA CAROLINA FERREIRA DA SILVA


