#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[10] = {0};
    int t = (int)(sizeof(array)/sizeof(array[0]));
    int remove;
    int temp;

    for(int i = 0; i < t; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }

    printf("\nPosicao a ser removida (0 a 9): ");
    scanf("%d", &remove);

    while(remove > t){
        printf("\nPosicao invalida, forneca novamente!");
        printf("\nPosicao a ser removida (0 a 9): ");
        scanf("%d", &remove);
    }

    for(int i = 0; i < t; i++){
        if(i == remove){
            for(int j = i; j < t; j++){
                array[j] = array[j+1];
            }
        }
    }

    printf("\n\n");
    for(int i = 0 ; i < t - 1 ; i++){
        printf("\narray[%d] = %d", i, array[i]);
    }
    return 0;
}