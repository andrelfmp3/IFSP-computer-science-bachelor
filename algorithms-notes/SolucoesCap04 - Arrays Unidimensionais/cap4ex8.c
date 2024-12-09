#include <stdlib.h>
#include <stdio.h>

int main(){

    int array[5] = {0};
    int arrayPar[5] = {0};
    int arrayImpar[5] = {0};
    int par = 0;
    int impar = 0;
    int t = (int) sizeof(array)/sizeof(array[0]);

    for(int i = 0; i < t; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }

    for(int i = 0; i < t; i++){
        if(array[i]%2 == 0){
            arrayPar[i] = array[i];
            par++;
        }else{
            arrayImpar[i] = array[i];
            impar++;
        }
    }

    printf("\nNumeros pares:");
    if(par <= 0){
        printf(" nao ha");
    }else{
        for(int i = 0; i < t; i ++){
            if(arrayPar[i] != 0){
                printf(" %d", arrayPar[i]);
            }
        }
    }
    printf(".");

    printf("\nNumeros impares:");
    if(impar <= 0){
        printf(" nao ha");
    }else{
        for(int i = 0; i < t; i++){
            if(arrayImpar[i] != 0){
                printf(" %d",arrayImpar[i]);
            }
        }
    }
    printf(".");
    return 0;
}