// Andre Lyra Fernandes - RESOLVIDO

#include <stdio.h>
#include <stdlib.h>

// Declaração dos métodos
int fib(int num);

int main() {

    int num;
    printf("Numero: ");
    scanf("%d", &num);

    printf("O numero %d na sequencia de Fibonacci eh %d\n", num, fib(num));

    return 0;
    
}

// Método para calcular fibonacci
int fib(int num) {
    if (num <= 1){
        return num;
    }
    
    int atual = 1;
    int anterior = 0;

    for (int i = 2; i <= num; i++) {
        int temp = atual;
        atual = atual + anterior;
        anterior = temp;
    }

    return atual;
}
