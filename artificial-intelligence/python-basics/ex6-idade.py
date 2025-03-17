'''
6. Faça o algoritmo que calcule a idade de uma pessoa, sendo que o ano atual (AA) e
o ano do nascimento da pessoa (AN) são fornecidos pelo usuário. (considere que a pessoa já
fez aniversário nesse ano). Apresentar a idade da pessoa depois de calculada.
'''

aa = int(input('Insira o ano atual: '))
an = int(input('Insira o ano de nascimento: '))

idade = aa - an

print(f"Possui {idade} anos de idade!")