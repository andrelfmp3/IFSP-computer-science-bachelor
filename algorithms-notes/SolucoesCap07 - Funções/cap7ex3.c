#include <stdio.h>
#include <stdlib.h>

float maiorNumero(float n1, float n2);

int main(){

    float array1[5];
    float array2[5];

    for(int i = 0; i < 5; i++){

        printf("n1[%d]: ", i);
        scanf("%f", &array1[i]);
        if (array1[i] < 0){
            do{
            printf("Entre com um valor positivo!\n");
            printf("n1[%d]: ", i);
            scanf("%f", &array1[i]);
            } while( array1[i] < 0);
        }

        printf("n2[%d]: ", i);
        scanf("%f", &array2[i]);
        if (array2[i] < 0){
            do{
            printf("Entre com um valor positivo!\n");
            printf("n2[%d]: ", i);
            scanf("%f", &array2[i]);
            } while( array2[i] < 0);
        }
        
    }

    for(int i = 0; i < 5; i++){
        if (array1[i] == array2[i]){
            printf("%.2f, %.2f: Eles sao iguais\n", array1[i], array2[i]);
        } else {
            printf("%.2f, %.2f: O maior valor e %.2f\n", array1[i], array2[i], maiorNumero(array1[i], array2[i]));
        }
    }

    return 0; 

}

float maiorNumero(float n1, float n2){
    if(n1 > n2){
        return n1;
    } else {
        return n2;
    }
}