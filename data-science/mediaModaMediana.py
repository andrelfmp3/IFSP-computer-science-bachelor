# Lista de salários (com repetição conforme número de funcionários)
salarios = (
    [45]*1 +
    [15]*1 +
    [10]*2 +
    [5.7]*1 +
    [5]*3 +
    [3.7]*4 +
    [3]*1 +
    [2]*12
)

# Número de elementos
n = len(salarios)

# Média (aritmética)
soma = 0
for valor in salarios:
    soma += valor
media = soma / n

# Variância (populacional)
soma_quadrados = 0
for valor in salarios:
    soma_quadrados += (valor - media) ** 2
variancia = soma_quadrados / n   # se quiser amostral: / (n-1)

# Desvio padrão
desvio_padrao = variancia ** 0.5

# Mediana
salarios_ordenados = sorted(salarios)
if n % 2 == 1:  # ímpar
    mediana = salarios_ordenados[n // 2]
else:  # par
    mediana = (salarios_ordenados[n // 2 - 1] + salarios_ordenados[n // 2]) / 2

# Moda (valor que mais aparece)
frequencias = {}
for valor in salarios:
    frequencias[valor] = frequencias.get(valor, 0) + 1

maior_frequencia = 0
moda = 0
for valor, freq in frequencias.items():
    if freq > maior_frequencia:
        maior_frequencia = freq
        moda = valor

# Resultados
print("Média:", media)
print("Mediana:", mediana)
print("Moda:", moda)
print("Variância:", variancia)
print("Desvio Padrão:", desvio_padrao)
