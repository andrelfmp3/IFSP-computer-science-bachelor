import numpy # https://numpy.org/devdocs/user/quickstart.html
import matplotlib.pyplot as pyplot # pip install matplotlib

# Função principal
def ajuste_minimos_quadrados():

    # Entrada de dados
    loopValores = False
    while not loopValores:
        print("Valores de x separados por espaço:")
        x = numpy.array(list(map(float, input().split()))) # rever
        print("Valores de y separados por espaço:")
        y = numpy.array(list(map(float, input().split()))) # rever

        if len(x) != len(y):
            print("\nERRO: quantidade de x deve ser igual a quantidade de y. Insira novamente")
        else:
            loopValores = True

    # Escolher o grau do polinômio
    loopGrau = False
    while not loopGrau:
        print("Grau do polinômio (1, 2 ou 3):")
        grau = int(input())
        if grau not in [1, 2, 3]:
            print("\nErro: o grau deve ser 1, 2 ou 3.")
        else:
            loopGrau = True

    # Ajustar o polinômio pelo método dos mínimos quadrados. REVER
    coeficientes = numpy.polyfit(x, y, grau)
    polinomio = numpy.poly1d(coeficientes)

    # Mostrar o polinômio ajustado. REVER
    print(f"Polinômio ajustado (grau {grau}):")
    print(polinomio)

    # Gerar valores para o gráfico. REVER
    x_ajustado = numpy.linspace(min(x), max(x), 500)
    y_ajustado = polinomio(x_ajustado)

    # Implementação do gráfico. REVER
    pyplot.scatter(x, y, color='orange', label='Dados')
    pyplot.plot(x_ajustado, y_ajustado, color='black', label='Ajuste')
    pyplot.suptitle('André Lyra Fernandes e Victória Carolina Ferreira da Silva')
    pyplot.title('Método dos Mínimos Quadrados')
    pyplot.xlabel('x')
    pyplot.ylabel('y')
    pyplot.legend()
    pyplot.grid()
    pyplot.show()

# Chama a função
ajuste_minimos_quadrados()
