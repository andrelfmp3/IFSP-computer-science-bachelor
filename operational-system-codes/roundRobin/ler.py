#Grupo: 
#ANDRÉ LYRA FERNANDES
#MARIANA PEIXOTO CHAHUD
#LARISSA  GABRIELA SANT´ANGELO DIAS
#VICTÓRIA CAROLINA FERREIRA DA SILVA
def ler_arquivo(nome_arquivo):
    processos = []
    with open('test.txt', 'r') as arquivo:
        linha = arquivo.readline()
        while linha:
            linha = linha.strip()
            id_processo = linha[:3]
            instrucoes = linha[3:]
            processos.append((id_processo, instrucoes))
            linha = arquivo.readline()
    return processos
    processos.close()
  






