#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5];
    int t = (int)sizeof(array)/sizeof(array[0]);
    int busca;
    int aparicoes = 0;

    for(int i = 0; i < t; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
        printf("\n");
    }
    printf("Buscar por: ");
    scanf("%d", &busca);

    for(int i = 0; i < t; i++){
        if(array[i] == busca){
            aparicoes++;
        }
    }

    if(aparicoes > 0){
        if(aparicoes > 1){
            printf("\nO array contem %d ocorrencias do valor %d.", aparicoes, busca);
        }else{
            printf("\nO array contem %d ocorrencia do valor %d.", aparicoes, busca);
        }
    }else{
        printf("\nO array nao contem o valor %d.", busca);
    }
    return 0;
}