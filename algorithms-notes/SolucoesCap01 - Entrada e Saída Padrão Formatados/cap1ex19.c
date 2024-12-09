#include <stdio.h>
#include <stdlib.h>

int main() {

    float D;
    float C;
    float A;
    float r;
    float p;

    printf("Valor do raio do circulo: ");
    scanf("%f", &r);
    
    p=3.141592;
    D=2*r;
    C=2*p*r;
    A=p*r*r;

    printf("Diametro = %.2f\n", D);
    printf("Circunferencia = %.2f\n", C);
    printf("Area = %.2f\n", A);

    return 0;

}