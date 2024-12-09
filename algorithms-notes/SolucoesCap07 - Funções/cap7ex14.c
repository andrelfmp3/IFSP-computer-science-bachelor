#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void imprimeDuplaClassificada(int n1, int n2, bool emOrdemCrescente);

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
        bool emOrdemCrescente = i % 2 == 0? true : false;
        imprimeDuplaClassificada(array1[i], array2[i], emOrdemCrescente);
    }

    return 0; 

}

void imprimeDuplaClassificada(int n1, int n2, bool emOrdemCrescente){
    if(emOrdemCrescente == true){
        if(n1 <= n2){
            printf("%d e %d: %d <= %d\n", n1, n2, n1, n2);
        } else {
            printf("%d e %d: %d <= %d\n", n1, n2, n2, n1);
        }
    } else {
        if(n1 <= n2){
            printf("%d e %d: %d >= %d\n", n1, n2, n2, n1);
        } else {
            printf("%d e %d: %d >= %d\n", n1, n2, n1, n2);
        }
    }
}