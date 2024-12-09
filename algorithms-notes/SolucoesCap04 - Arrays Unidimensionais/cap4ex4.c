#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5];
    int t = (int)(sizeof(array)/sizeof(array[0]));
    int num;

    for(int i = 0; i < t; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
        printf("\n");
    }
    printf("Buscar por: ");
    scanf("%d", &num);

    for(int i = 0; i < t; i++){
        if(array[i] == num){
            printf("\nIndice %d: ACHEI", i);
        }else{
            printf("\nIndice %d: NAO ACHEI", i);
        }
    }
    return 0;
}