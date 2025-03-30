'''
4. Faça o algoritmo para calcular quanto será pago por um produto (PAG), sendo que
o preço do produto (PR) e o desconto (D) são fornecidos pelo usuário. Apresentar o valor a ser
pago pelo produto.
'''

pr = float(input("Insira o valor total: "))
d = float(input("Insira o desconto total: "))
pag = (pr / 100) * (100-d)
print(f"O valor com {d}% de desconto é {pag}")
