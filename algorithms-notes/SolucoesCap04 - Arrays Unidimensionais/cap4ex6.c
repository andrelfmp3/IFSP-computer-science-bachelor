#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5] = {0};
    int arrayPos[5] = {0};
    int t = (int)sizeof(array)/sizeof(array[0]);
    int j = (int)sizeof(arrayPos)/sizeof(arrayPos[0]);
    int c = 0;
    int busca;

    for(int i = 0; i < t; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
        printf("\n");
    }
    printf("Buscar por: ");
    scanf("%d", &busca);

    for(int i = 0; i < t; i++){
        if(array[i] == busca){
            arrayPos[c++] = i;
        }
    }

    if(c == 0){
        printf("O array nao contem o valor %d.", busca);
    }else if(c == 1){
        printf("O valor %d foi encontrado no indice %d do array.", busca, arrayPos[0]);
    }else if(c == 2){
        printf("O valor %d foi encontrado nos indices %d e %d do array.", busca, arrayPos[0], arrayPos[1]);
    }else if(c == 3){
        printf("O valor %d foi encontrado nos indices %d, %d e %d do array.", busca, arrayPos[0], arrayPos[1], arrayPos[2]);
    }else if(c == 4){
        printf("O valor %d foi encontrado nos indices %d, %d, %d e %d do array.", busca, arrayPos[0], arrayPos[1], arrayPos[2], arrayPos[3]);
    }else{
        printf("O valor %d foi encontrado nos indices %d, %d, %d, %d e %d do array.", busca, arrayPos[0], arrayPos[1], arrayPos[2], arrayPos[3], arrayPos[4]);
    }
    return 0;
}