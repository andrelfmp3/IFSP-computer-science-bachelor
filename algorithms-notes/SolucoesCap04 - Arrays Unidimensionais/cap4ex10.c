#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5] = {0};
    int arrayCopia[5] = {0};
    int t = (int)(sizeof(array)/sizeof(array[0]));
    int busq ;
    int c = 0;
    int temp;

    for(int i = 0; i < t; i++){
        printf("\narray[%d]: ", i);
        scanf("%d", &array[i]);
    }

    printf("\nCopiar maiores que:");
    scanf("%d", &busq);

    for(int i = 0; i < t; i++){
        if(array[i] > busq){
            arrayCopia[i] = array[i];
            c++;
        }
    }

    for(int i = 0; i < t; i++){
        if(arrayCopia[i] > 0){
            arrayCopia[i-c] = arrayCopia[i];
        }
        arrayCopia[i] = 0;
    }

    printf("\n\n");
    if(c > 0){
        for(int i = 0 ; i < t ; i++){
            if(arrayCopia[i] > 0){
                printf("\narrayCopia[%d] = %d", i, arrayCopia[i]);
            }
        }
    }else{
        printf("Nao houve copia!");
    }
    return 0;
}

