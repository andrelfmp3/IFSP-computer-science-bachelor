// Andre Lyra Fernandes - RESOLVIDO

#include <stdio.h>
#include <stdlib.h>

// Declaração dos métodos
double harmonica(double n);

int main() {

    double n;

    printf("Numero: ");
    scanf(" %lf", &n);
    printf("O numero de serie harmonica de %.f eh %.2f", n, harmonica(n));
}

// Método que retorna hamonica
double harmonica(double n) {
    if (n == 1.0) {
        return 1.0;
    }

    return harmonica(n-1.0) + 1.0/n;
}