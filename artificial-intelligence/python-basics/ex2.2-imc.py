'''
Faça um código que leia o sexo de uma pessoa e sua altura do teclado. Em seguida, verifique e calcule:
(1) Se o sexo for masculino, calcular o peso ideal como sendo: Peso Homem = altura-100 – 10%;              elevado?
(2) Se o sexo for feminino, calcular o peso ideal como sendo: Peso Mulher = altura-100 – 15%.
'''

sexo = int(input("Insira 0 se for Homem, e 1 se for Mulher: "))

while sexo != 1 and sexo != 0:
    sexo = int(input("Valor incorreto. Insira 0 se for Homem, e 1 se for Mulher: "))
    
altura = float(input("Insira sua altura: "))


if sexo == 0:
    peso = altura - 100 - ((altura - 100) * 0.10)  
    print(f"O seu peso ideal é {peso} kg")
else:
    peso = altura - 100 - ((altura - 100) * 0.15) 
    print(f"O seu peso ideal é {peso} kg")

    