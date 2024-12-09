#include <stdio.h>
#include <stdlib.h>

int main() {

    float n1;
    float n2;
    float n3;

    printf("N1: ");
    scanf("%f", &n1);

    printf("N2: ");
    scanf("%f", &n2);

    printf("N3: ");
    scanf("%f", &n3);

    if ( n1 >= n2 && n2 >= n3 ){
        printf("A soma dos dois numeros maiores fornecidos e %.2f", n1+n2);
    } else if (n1 >= n3 && n3 >= n2 ){
        printf("A soma dos dois numeros maiores fornecidos e %.2f", n1+n3);
    } else if (n2 >= n1 && n1 >= n3){
        printf("A soma dos dois numeros maiores fornecidos e %.2f", n2+n1);
    } else if (n2 >= n3 && n3 >= n1){
        printf("A soma dos dois numeros maiores fornecidos e %.2f", n2+n3);
    } else if (n3 >= n1 && n1 >= n2){
        printf("A soma dos dois numeros maiores fornecidos e %.2f", n3+n1);
    } else if (n3 >= n2 && n2 >= n1){
        printf("A soma dos dois numeros maiores fornecidos e %.2f", n3+n2);
    }

    return 0;

}