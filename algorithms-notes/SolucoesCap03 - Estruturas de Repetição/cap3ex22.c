#include <stdio.h>
#include <stdlib.h>

int main() {

    int mn;
    int n1;
    int n2;
    int n3;
    int n4;
    int n5;

    printf("N1: ");
    scanf("%d", &n1);    

    printf("N2: ");
    scanf("%d", &n2);  

    printf("N3: ");
    scanf("%d", &n3);  

    printf("N4: ");
    scanf("%d", &n4); 

    printf("N5: ");
    scanf("%d", &n5);

    if(n1 < 0 || n2 < 0 || n3 < 0 || n4 < 0 || n5 < 0){
        printf("Forneca apenas numeros positivos.");
    } else {
        if(n1 >= n2 && n1 >= n3 && n1 >= n4 && n1 >= n5){
            mn = n1;
        } else if (n2 >= n1 && n2 >= n3 && n2 >= n4 && n2 >= n5){
            mn = n2;
        } else if (n3 >= n1 && n3 >= n2 && n3 >= n4 && n3 >= n5){
            mn = n3;
        } else if (n4 >= n1 && n4 >= n2 && n4 >= n3 && n4 >= n5){
            mn = n4;
        } else if (n5 >= n1 && n5 >= n2 && n5 >= n3 && n5 >= n4){
            mn = n5;
        }
    }   

        for(int i = mn; i > 0; i--){
                printf("%04d  ", i);

                if(n1 >= i){
                    printf("*");
                } else if (n1 < i){
                    printf(" ");
                }

                if(n2 >= i){
                    printf("*");
                } else {
                    printf(" ");
                }

                if(n3 >= i){
                    printf("*");
                } else {
                    printf(" ");
                }

                if(n4 >= i){
                    printf("*");
                } else {
                    printf(" ");
                }

                if(n5 >= i){
                    printf("*");
                } else {
                    printf(" ");
                }

                printf("\n");
            }

    return 0;
}