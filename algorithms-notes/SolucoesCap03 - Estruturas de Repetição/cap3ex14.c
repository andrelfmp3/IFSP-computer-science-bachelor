#include <stdio.h>
#include <stdlib.h>

int main() {

    int n1;
    int n2;
    int somatorio;

    printf("N1: ");
    scanf("%d", &n1);

    printf("N2: ");
    scanf("%d", &n2);

    if(n1 >= n2){
        for(int i = n1; i >= n2; i--){
            somatorio += i;
        }
    } else if (n2 >= n1){
        for(int i = n2; i >= n1; i--){
            somatorio += i;
        }
    }

    if( n1 >= n2 ){
        printf("Somatorio entre %d e %d: %d", n2, n1, somatorio);
    } else {
        printf("Somatorio entre %d e %d: %d", n1, n2, somatorio);
    }

    return 0;

}