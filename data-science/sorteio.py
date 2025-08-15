import random

# Lista do sorteio
sorteio = random.sample(range(1, 61), 6)
print(f"Números sorteados: {sorteio}")

print("Escolha 6 números entre 1 e 60")

# Lista do usuário
numeros = []
while len(numeros) < 6:
    numero = int(input(f"Insira o número: "))
    numeros.append(numero)

print(f"Seus números: {numeros}")


# Verificar acertos
acertos = len(set(numeros) & set(sorteio))
if acertos == 6:
    print("Parabéns! Você acertou todos os números!")
    
for num in sorteio:
    if num in numeros:
        if 5 in sorteio and 5 in numeros:
            print("Você acertou (5)")
        if 4 in sorteio and 4 in numeros:
            print("Você acertou (4)")


