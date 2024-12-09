#include <stdio.h>
#include <stdlib.h>

int main() {

    int F;
    float C;

    printf("Temperatura em graus Fahrenheit: ");
    scanf( "%d", &F);

    C=(F-32)/1.8;

    printf("%d.00 graus Fahrenheit correspondem a %.2f graus Celsius", F, C);

    return 0;

}