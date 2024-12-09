#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool ehPar(int n);
bool ehDivisivel(int dividendo, int divisor);

int main(){

    int array1[5];
    int array2[5];

    for(int i = 0; i < 5; i++){

        printf("n1[%d]: ", i);
        scanf("%d", &array1[i]);

        printf("n2[%d]: ", i);
        scanf("%d", &array2[i]);
    }

    for(int i = 0; i < 5; i++){
        if( ehPar(array1[i]) == true ){
            printf("%d eh par", array1[i]);
        } else {
            printf("%d eh impar", array1[i]);
        }

        if(ehDivisivel(array1[i], array2[i]) == true){
            printf(" e %d eh divisivel por %d", array1[i], array2[i]);
        } else {
            printf(" e %d nao eh divisivel por %d", array1[i], array2[i]);
        }

        printf("\n");
    }

    return 0;

}

bool ehPar(int n){
    if(n%2 == 0){
        n = true;
        return true;
    } else {
        n = false;
        return false;
    }
}

bool ehDivisivel(int dividendo, int divisor){
    if( dividendo%divisor == 0){
        return true;
    } else {
        return false;
    }

}