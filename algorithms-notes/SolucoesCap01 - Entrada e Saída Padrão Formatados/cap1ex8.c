#include <stdio.h>
#include <stdlib.h>

int main() {

    int l;
    int h;
    int a;
    int p;

    printf("Valor da largura: ");
    scanf( "%d", &l);

    printf( "Valor da altura: ");
    scanf( "%d", &h);

    p = (2*l)+(2*h);
    a = l*h;

    printf( "Perimetro = %d\n", p);
    printf( "Area = %d", a);

    return 0;

}