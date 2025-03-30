def fibonacci(index): # obtido via exercicio
    fib = 1
    ant = 0
    soma = 1
    if index == 1: return 0
    if index == 2: return 1          
    for i in range(index-2):
        soma = fib + ant
        ant = fib
        fib = soma
    return fib

for i in range (1, 10):
    print(fibonacci(i))