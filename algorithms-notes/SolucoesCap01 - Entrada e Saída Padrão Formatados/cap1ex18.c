#include <stdio.h>
#include <stdlib.h>

int main() {

    float D;
    float d;
    float A;

    printf("Valor da diagonal maior: ");
    scanf("%f", &D);

    printf("Valor da diaguonal menor: ");
    scanf("%f", &d);

    A=D*d/2;

    printf("Area = %.2f", A);

    return 0; 

}

