#include <stdio.h>
#include <stdlib.h>

int somaDivisores (int n); //int?

int main() {

    int array[5];

    for(int i = 0; i < 5; i++){
        printf("n[%d]: ", i);
        scanf("%d", &array[i]);
        if(array[i] < 0){
            do{
            printf("Entre com um valor positivo: ");
            scanf("%d", &array[i]);
            } while (array[i] < 0);
        }
    }

    for(int i = 0; i < 5; i++){
        printf("Soma dos divisores de %d: %d", array[i], somaDivisores(array[i]));
        printf("\n");
    }

    return 0;

}

    int somaDivisores (int n) {
        int soma = 0;
        for(int i = 1; i < n; i++){
            if(n%i == 0){
                soma = soma + i;
            }
        }
        return soma;
    }
