//Andre Lyra Fernandes - RESOLVIDO

#include <stdio.h>
#include <stdlib.h>

// Declaração dos métodos
long int fatorialIterativa(int n); 

int main() {

    int num;

    printf("Numero: ");
    scanf("%d", &num);
    printf("O fatorial de %d eh %ld\n", num, fatorialIterativa(num));

    return 0;
    
}

// Método para calcular fatorial, de forma iterativa
long int fatorialIterativa(int num) {
    long int fatorialIterativa = 1; // Inicializa o fatorial com 1

    while (num > 0) {
        fatorialIterativa *= num;
        num--;
    }

    return fatorialIterativa; 
}
