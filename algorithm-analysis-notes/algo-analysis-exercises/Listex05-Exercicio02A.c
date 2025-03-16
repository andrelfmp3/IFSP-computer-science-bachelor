// Andre Lyra Fernandes - RESOLVIDO

#include <stdio.h>
#include <stdlib.h>

// Declaração dos métodos
int calculaExponencialmente(int num);

int main() {

    int num;
    
    printf("Numero: ");
    scanf("%d", &num);
    printf("2^n de %d eh %d", num, expo(num));

    return 0;
    
}

// Função para calcular exponenciais
int calculaExponencialmente(int num){
    if (num == 0){
        return 1;
    } 
    else if (num == 1){
        return 2;
    }

    return 2 * expo(num-1); 
}