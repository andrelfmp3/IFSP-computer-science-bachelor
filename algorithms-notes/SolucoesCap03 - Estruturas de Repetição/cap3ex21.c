#include <stdio.h>
#include <stdlib.h>

int main() {

    int a;
    // a = altura

    printf("Altura: ");
    scanf("%d", &a);

    if(a > 0){
        for(int i = 0; i < a; i++){
            for(int j = a-1; j > i; j--){
                printf(" ");
            }
            for(int k = 0; k <= i; k++){
                printf("*");
                if (k > 0){
                printf("*");
                }
                }
            printf("\n");
            }
    } else if (a < 0){
        a = a*-1;
        for(int i = a; i>0; i--){
            for(int j = i+1; j <= a; j++){
                printf(" ");
            }
            for(int k = 0; k <= i-1; k++){
            printf("*");
            if( k > 0){
                printf("*");
            }
            }
            printf("\n");
        }
    }






















    return 0;
}