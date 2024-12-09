#include <stdio.h>
#include  <stdlib.h>

int main() {

    float l;
    float p;
    float a;

    printf( "Quantos lados tem o quadrado: ");
    scanf( "%f", &l );

    p = 4*l;
    a = l*l;

    printf( "Perimetro = %.2f\n", p);
    printf( "Area = %.2f\n", a);


    return 0;

}