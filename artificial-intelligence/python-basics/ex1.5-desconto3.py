'''
5. Faça o algoritmo para calcular qual foi a porcentagem de desconto dada em um
determinado produto (DESC), sabendo-se o preço original do produto (PRECO) e o preço que
foi cobrado por ele depois do desconto (PRECOF).
'''

preco = float(input("Insira o valor total: "))
desc = float(input("Insira o preço com desconto total: "))
dif = preco - desc
precof = dif / (preco / 100)

print(f"O valor está com {precof}% de desconto")
