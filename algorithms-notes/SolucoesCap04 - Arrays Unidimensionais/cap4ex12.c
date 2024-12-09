#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[5] = {0};
    int t = (int)(sizeof(array)/sizeof(array[0]));
    int insert;
    int temp;

    for(int i = 0; i < t; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
    }

    for(int i = 0; i < t; i++){
        array[i] = array[i+1];
    }

    printf("\n\n");
    for(int i = 0; i < t - 1; i++){
        printf("\narray[%d] = %d",i,array[i]);
    }
    return 0;
}