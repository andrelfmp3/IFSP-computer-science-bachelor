#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {

    float a;
    float b;
    float c;
    float delta;
    float x1;
    float x2;

    printf("a: ");
    scanf("%f", &a);

    printf("b: ");
    scanf("%f", &b);

    printf("c: ");
    scanf("%f", &c);

    if( a == 0 ){
        printf("Nao existe equacao do segundo grau!");
    } else {

        delta = b*b-4*a*c;
        x1 = ( -b + ( sqrt ( delta ) ) ) / (2*a);
        x2 = ( -b - ( sqrt ( delta ) ) ) / (2*a);

        printf("Delta: %.2f\n", delta);

        if(delta < 0){
            printf("S = {}");
        } else if(x1 > x2){
            printf("S = {%.2f, %.2f}", x2, x1);
        } else if ( x1 < x2){
            printf("S = {%.2f, %.2f}", x1, x2);
        } else if (x1 == x2){
            printf("S = {%.2f}", x1);
        }
    }

    return 0;

}