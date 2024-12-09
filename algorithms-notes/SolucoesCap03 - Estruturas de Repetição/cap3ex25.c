#include <stdio.h>
#include <stdlib.h>

int main() {

    int valor;
    float somatorio = 0;
    float media = 0;
    int quantidade = 0;

    while(valor >= 0){
        printf("Entre com um valor: ");
        scanf("%d", &valor);

        if(valor > 0){
        quantidade++;
        somatorio = (valor + somatorio);
        media = somatorio / quantidade;
        }

    }

    printf("Somatorio: %.2f\n", somatorio);
    printf("Media: %.2f\n", media);
    printf("Quantidade: %d\n", quantidade);


    return 0;
}