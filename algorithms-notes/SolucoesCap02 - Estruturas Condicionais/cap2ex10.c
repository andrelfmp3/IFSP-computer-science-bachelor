#include <stdio.h>
#include <stdlib.h>

int main() {

    float a;
    float b;
    float c;

    printf("a: ");
    scanf("%f", &a);

    printf("b: ");
    scanf("%f", &b);

    printf("c: ");
    scanf("%f", &c);

    if ( a == b && b == c){
        printf("Triangulo EQUILATERO");
    } else if ( a == b && b != c){
        printf ("Triangulo ISOSCELES");
    } else if ( a == c && c != b){
        printf("Triangulo ISOSCELES");
    } else if ( b == c && c != a){
        printf("Triangulos ISOSCELES");
    } else if ( a + b <= c){
        printf ("As medidas fornecidas dos lados nao representam um triangulo valido!");
    } else if ( a + c <= b){
        printf ("As medidas fornecidas dos lados nao representam um triangulo valido!");
    } else if ( b + c <= a){
        printf ("As medidas fornecidas dos lados nao representam um triangulo valido!");
    } else if ( a!= b && b != c){
        printf ("Triangulo ESCALENO");
    }

    return 0; 

}