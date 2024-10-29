# main.py

from Processos import Processos
from escalonador import escalonador
import time

# Criando uma instância da classe Processos
processos_obj = Processos()

# Definindo os tempos de execução para cada processo
tempos_processos = {
    "P1": 5,
    "P2": 7,
    "P3": 9,
    "P4": 10
}

# Chamando os métodos para iniciar os processos com os tempos específicos
processos_obj.setP1(tempos_processos["P1"])
processos_obj.setP2(tempos_processos["P2"])
processos_obj.setP3(tempos_processos["P3"])
processos_obj.setP4(tempos_processos["P4"])

# Esperando um tempo suficiente para os processos serem adicionados à fila
time.sleep(1)

# Obtendo a fila de processos atual como uma lista
fila_de_processos = processos_obj.get_fila_de_processos()

# Executando o escalonador com a fila de processos
escalonador(fila_de_processos, 5)