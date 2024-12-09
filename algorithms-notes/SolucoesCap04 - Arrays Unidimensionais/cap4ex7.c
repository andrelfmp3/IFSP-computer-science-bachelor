#include <stdio.h>
#include <stdlib.h>

int main(){

    int array1[5] = {0};
    int t = (int) sizeof(array1)/sizeof(array1[0]);
    int array2[5] = {0};
    int k = (int) sizeof(array2)/sizeof(array2[0]);
    int arraySoma[5] = {0};
    int l = (int) sizeof(arraySoma)/sizeof(arraySoma[0]);
    
    printf("Forneca os valores do primeiro array:\n");
    for(int i = 0; i < t; i++){
        printf("array1[%d]: ", i);
        scanf("%d", &array1[i]);
    }
    printf("\n");

    printf("Forneca os valores do primeiro array:\n");
    for(int i = 0; i < k; i++){
        printf("array2[%d]: ", i);
        scanf("%d", &array2[i]);
    }
    printf("\n");
    
    for(int i = 0; i < l; i++){
        arraySoma[i] = array1[i] + array2[i];
        printf("arraySoma[%d] = %d\n", i, arraySoma[i]);
    }
    return 0;
}