#include <stdio.h>
#include <stdlib.h>

int main(){

    int array1[5] = {0};
    int array2[5] = {0};
    int arrayintersec[5] = {0};
    int t = (int)(sizeof(array1)/sizeof(array1[0]));
    int c = 0;
    int cintsc = 0;
    int vr = 0;

    printf("Forneca os valores do primeiro array:");
    for(int i = 0; i < t; i++){
        printf("array[%d]", i);
        scanf("%d", &array1[i]);
    }

    printf("\nForneca os valores do segundo array:");
    for(int i = 0; i < t; i++){
        printf("array[%d]: ", i);
        scanf("%d", &array2[i]);
    }

    for(int i = 0; i < t; i++){
        for(int j = 0; j < t; j++){
            if(array1[i] == array2[j]){
                for(int k = 0; k < t; k++){
                    if(arrayintersec[k] == array1[i]){
                        vr++;
                    }
                }
                if(vr == 0){
                    arrayintersec[i] = array1[i];
                    c++;
                }else{
                    vr = 0;
                }
            }
        }
    }

    while(cintsc < 2){
        ++cintsc;
        for(int i = 0; i < t; i++){
            if(arrayintersec[i] == 0){
                for(int j = i; j < t; j++){
                    arrayintersec[j] = arrayintersec[j+1];
                }
            }
        }
    }

    if(c == 0){
        printf("\nNao ha interseccao entre os elementos dos dois arrays fornecidos!");
    }else{
        for(int i = 0; i < c; i++){
            printf("\narrayInterseccao[%d] = %d", i, arrayintersec[i]);
        }
    }
    return 0;
}