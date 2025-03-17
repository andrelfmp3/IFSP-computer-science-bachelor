'''
7. Faça o algoritmo para calcular o volume de uma esfera (VOL). O raio (R) da esfera
será fornecido pelo usuário. Obs.: VOL = 3.14*R2 (apresentar o volume da esfera)
'''
import math

r = float(input("Insira o raio da esfera: "))
volume = (4/3) * math.pi * r**3  # volume está errado, VOL = 3.14*R2 é área
print(f"O volume da esfera é {volume}")