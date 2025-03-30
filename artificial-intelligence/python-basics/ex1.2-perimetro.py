'''
2. Faça o algoritmo para calcular a área (AREA) e o perímetro (P) de uma sala, sendo
que os comprimentos (L e C) são fornecidos pelo usuário. Apresente a área e o perímetro depois
de calculados.
'''

c = float(input("Insira o comprimento da sala: "))
l = float(input("Insira o lado da sala: "))
a = c*l
p = c + c + l + l

print(f"A sala tem {a} de área!")
print(f"A sala tem {p} de perimetro!")