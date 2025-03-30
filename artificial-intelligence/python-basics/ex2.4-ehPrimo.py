numero = int(input("Insira um valor inteiro: "))

primo = True # maiusculo = boolean

if (numero <= 1):
        primo = False
else:
    for i in range(2, numero): # depois de um
        if numero % i == 0:
            primo = False
            break

if primo:
    print(f"O número {numero} é primo.")
else:
    print(f"O número {numero} não é primo.")