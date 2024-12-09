#include <stdio.h>
#include <stdlib.h>

int main(){

    int valor;
    int lidos = 0;
    int maiorNumero = 0;
    int menorNumero;

    do{
        printf("Entre com um valor: ");
        scanf("%d", &valor);
        lidos++;

        if(valor >= 0){
            if(valor > maiorNumero){
                maiorNumero = valor;
            }
            
            if(valor < menorNumero){
                menorNumero = valor;
            }
        }else if(lidos < 0 && lidos == 1 || lidos == 2){
            menorNumero = maiorNumero;
        }
    }while (valor >= 0);
        printf("Menor numero: %d\n", menorNumero);
        printf("Maior numero: %d\n", maiorNumero);
    return 0;
}