#include <stdio.h>
#include <stdlib.h>

int main() {
    
    float B;
    float b;
    float h;
    float A;

    printf("Valor da base maior: ");
    scanf("%f", &B);

    printf("Valor da base menor");
    scanf("%f", &b);

    printf("Valor da altura");
    scanf("%f", &h);

    A=(B+b)*h/2;

    printf("Area = %.2f", A);

    return 0;

}