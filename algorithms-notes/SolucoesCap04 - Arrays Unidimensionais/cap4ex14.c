#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[10] = {0};
    int t = (int)(sizeof(array)/sizeof(array[0]));
    int c = 0;
    int cpar = 0;

    for(int i = 0; i < t; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array[i]);
        if(array[i]%2 == 0){
            array[i] = 0;
            cpar++;
        }
    }
    while(c < 2){
        ++c;
        for(int i = 0; i < t; i++){
            if(array[i] == 0){
                for(int j = i; j < t; j++){
                    array[j] = array[j+1];
                }
            }
        }

        printf("\n\n");
        for(int i = 0; i < t-cpar; i++){
            printf("\narray[%d] = %d", i, array[i]);
        }
    }
    return 0;
}