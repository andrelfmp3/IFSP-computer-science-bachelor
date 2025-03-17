'''
10. Faça o algoritmo que receba dois valores inteiros nas variáveis A e B. O programa
deve trocar os valores entre as variáveis (ou seja, ao término do programa a variável A deve ter
o valor inicial de B e vice-versa). Apresentar as duas variáveis o final.
'''

a = int(input("Insira a variavel A: "))
b = int(input("Insira a variavel B: "))

a = a ^ b
b = a ^ b
a = a ^ b

print(f"A é {a}")
print(f"B é {b}")
