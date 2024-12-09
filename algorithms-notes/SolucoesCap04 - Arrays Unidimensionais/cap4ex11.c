#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[10] = {0};
    int t = (int)(sizeof(array)/sizeof(array[0]));
    int insert;
    int temp;
    int qtd;

    printf("Quantidade de elementos (1 a 9): ");
    scanf("%d", &qtd);

    while(qtd > t){
        printf("n\nQuantidade incorreta, forneca novamente!");
        printf("\nQuantidade de elementos (1 a 9): ");
        scanf("%d", &qtd);
    }

    for(int i = 0; i < qtd; i++){
        printf("array[%d]:", i);
        scanf("%d", &array[i]);
    }

    printf("\nValor que sera inserido: ");
    scanf("%d", &insert);

    temp = array[1];

    for(int i = qtd + 1; i > 0; i--){
        array[i] = array[i - 1];
    }
    array[0] = insert;

    printf("\n\n");
    for(int i = 0; i < qtd +1; i++){
        printf("\narray[%d] = %d", i, array[i]);
    }
    return 0;
}