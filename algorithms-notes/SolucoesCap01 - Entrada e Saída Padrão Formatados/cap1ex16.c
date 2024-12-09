#include <stdio.h>
#include <stdlib.h>

int main() {

    float b;
    float h;
    float a;

    printf("Valor da base: ");
    scanf("%f", &b);

    printf("Valor da altura: ");
    scanf("%f", &h);

    a = (b*h)/2;

    printf("Area = %.2f", a);

    return 0;

}