import math

# Desenvolva um programa em Python que:
# Leia os valores a, b e c do teclado, relativos a uma equação do segundo grau.

def verificaValidade(valor): # se é possível converter pra float, aceita int, float e negativos. String não converte para float
    try:
        float(valor);
        return True
    except ValueError:
        return False

print("Considere uma equação de 2º grau, onde a.(x^2) + b.x + c = 0")

a = input("Insira o valor A: ")
while not verificaValidade(a) or float(a) == 0: # enquanto não contiver uma letra. aceita negativos e float
    a = input("Valor de A inválido, insira novamente: ")
     
b = input("Insira o valor B: ")
while not verificaValidade(b):
    b = input("Valor de B inválido, insira novamente: ")

c = input("Insira o valor C: ")
while not verificaValidade(c):
    c = input("Valor de C inválido, insira novamente: ")

print(f"A equação inserida é ({a}x^2) + ({b}x) + ({c}). ")

a = float(a)
b = float(b)
c = float(c)

# Resolva o valor de delta em uma equação de Báskara.

delta = (math.pow(b, 2)) -4*a*c
print(f"O delta é {delta}")

# Resolva o valor de x1 e x2 a partir dos valores de delta obtidos na etapa anterior.

if delta < 0:
    print("Delta negativo.")
else:
    x1 = (-b + math.sqrt(delta)) / (2 * a)
    x2 = (-b - math.sqrt(delta)) / (2 * a)
    print(f"Os possíveis resultados são {x1} e {x2}")