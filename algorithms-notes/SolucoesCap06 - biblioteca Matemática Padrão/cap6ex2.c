#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {

    double b; //base
    double e; //expoente

    printf("Base: ");
    scanf("%lf", &b);

    printf("Expoente: ");
    scanf("%lf", &e);

    printf("%.2lf ^ %.2lf = %.2lf", b, e, pow(b, e)  );

    return 0;

}