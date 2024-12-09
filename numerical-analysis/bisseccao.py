print('Metodo da Bissecao')

# Entrada dos valores
num1 = float(input('Entre com um valor 1: '))
num2 = float(input('Entre com um valor 2: '))
num3 = int(input('Numero de interações: '))  # Convertido para inteiro
num4 = float(input('Condicao de parada: '))  # Tolerância para a condição de parada

# Verificação se os valores têm sinais opostos
if num1 * num2 > 0:
    print('Os valores nao tem sinais opostos.')
else:
    # Início do método da Bisseção
    for i in range(num3):
        soma1 = (num1 + num2) / 2  # Calcula o meio entre num1 e num2
        print(f'Iteracao {i + 1}: Meio = {soma1}')

        # Verifica a condição de parada
        if abs(num2 - num1) < num4:
            print(f'Condicao de parada atingida após {i + 1} iteracoes.')
            print(f'Erro relativo: {((i + 1) - (i))/i}') # exato - aproximado / aproximado
            break  # Encerra o loop caso a condição de parada seja atendida

        if num1 * soma1 < 0:
            num2 = soma1  # A raiz está entre num1 e soma1
        else:
            num1 = soma1  # A raiz está entre soma1 e num2

    else:
        print(f'O numero maximo de interacoes ({num3}) foi atingido.')

