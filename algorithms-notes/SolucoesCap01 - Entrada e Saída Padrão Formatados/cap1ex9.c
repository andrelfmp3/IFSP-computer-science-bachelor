#include <stdio.h>
#include <stdlib.h>

int main() {

    int b;
    int h;
    int a;

    printf( "Valor da largura: ");
    scanf( "%d", &b);

    printf( "Valor da altura: ");
    scanf( "%d", &h);

    a = (b*h)/2;

    printf( "Area = %d", a);

    return 0;

}