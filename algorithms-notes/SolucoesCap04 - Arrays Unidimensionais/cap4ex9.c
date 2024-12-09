#include <stdio.h>
#include <stdlib.h>

int main(){

    int temp;
    int array[5] = {0};
    int arrayInv[5] = {0};
    int t = (int)(sizeof(array)/sizeof(array[0]));

    for(int i = 0; i < t; i++){
        printf("array[%d]: ",i);
        scanf("%d", &array[i]);
    }

    for(int i = 0; i < t;i++){
        temp = array[i];
        arrayInv[i] = array[t-i-1];
        array[i] = temp;
    }

    printf("\n\n");

    for(int i = 0 ; i < t ; i++){
        printf("\narrayInv[%d] = %d",i,arrayInv[i]);
    }
    return 0;
}