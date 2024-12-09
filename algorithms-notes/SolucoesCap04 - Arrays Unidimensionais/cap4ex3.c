#include <stdio.h>
#include <stdlib.h>

int main(){

    float array[5];
    int t = (int)(sizeof(array)/sizeof(array[0]));
    float soma = 0;
    float produto = 1;

    for(int i = 0; i < t; i++){
        printf("\narray[%d]: ", i);
        scanf("%f", &array[i]);
    }
    for(int i = 0; i < t; i++){
        soma += array[i]; /*Poderia ser também soma = soma + array[i]*/
        produto *= array[i]; /*Poderia ser também produto = prouto * array[i]*/
    }
    printf("\nSomatorio: %.2f", soma);
    printf("\nProdutorio: %.2f", produto);
    return 0;
}