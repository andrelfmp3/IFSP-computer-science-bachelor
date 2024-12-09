#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

    float n; //numero

    printf("Numero: ");
    scanf("%f", &n);

    printf("Valor absoluto: %.2f", fabs(n));

    return 0;
}