#include <stdio.h>
#include <stdlib.h>

int main() {

    int l;
    int p;
    int a;

    printf( "Quantos lados tem o quadrado: " );
    scanf( "%d", &l);

    p = 4*l;
    a = l*l;

    printf( "Perimetro = %d\n", p);
    printf( "Area = %d\n", a);

    return 0;

} 