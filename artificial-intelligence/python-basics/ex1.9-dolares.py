'''
9. Faça o algoritmo que calcule o valor em Reais (VAL_REAL), correspondente aos
dólares que um turista possui no cofre do hotel. O programa deve solicitar os seguintes dados:
Quantidade de dólares guardados no cofre (VAL_DOLAR) e cotação do dólar naquele dia (COT).
'''

# Solicita ao usuário a quantidade de dólares no cofre e a cotação do dólar
VAL_DOLAR = float(input("Insira a quantidade de dólares: "))
COT = float(input("Insira a cotação do dólar: "))

# Calcula o valor em Reais
VALOR_REAL = VAL_DOLAR * COT

# Exibe o resultado
print(f"O valor equivalente em Reais é R$ {VALOR_REAL}")
