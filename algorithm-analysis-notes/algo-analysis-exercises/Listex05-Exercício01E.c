// Andre Lyra Fernandes - RESOLVIDO

#include <stdio.h>
#include <stdlib.h>

// Declaração dos métodos
int calculaFibonacci(int num);

int main() {

    int num;
    printf("Numero: ");
    scanf("%d", &num);

    printf("O numero %d na sequencia de Fibonacci eh %d\n", num, calculaFibonacci(num)); 

    return 0;
    
}

// Método para calcular fibonacci
int calculaFibonacci(int num) {
    if (num <= 1) // Condição de parada para os casos base
        return num;
    else
        return fib(num - 1) + fib(num - 2); // Chamadas recursivas para calcular Fibonacci
}
