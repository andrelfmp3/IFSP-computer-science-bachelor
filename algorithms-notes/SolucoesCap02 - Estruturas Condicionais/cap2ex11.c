#include <stdio.h>
#include <stdlib.h>

int main() {

    int alfa;
    int beta;
    int gama;

    printf("alfa: ");
    scanf("%d", &alfa);

    printf("beta: ");
    scanf("%d", &beta);

    printf("gama: ");
    scanf("%d", &gama);

    if (alfa + beta + gama != 180){
        printf("As medidas fornecidas dos angulos nao representam um triangulo valido!");
    } else if (alfa + beta == gama || alfa + gama == beta || gama + beta == alfa){
        printf("Triangulo RETANGULO");
    } else if (alfa >= 90 || beta >= 90 || gama >=90){
        printf("Triangulo OBTUSANGULO");
    } else if (alfa <= 90 && beta <=90 && gama <=90){
        printf("Triangulo ACUTANGULO");
    }


    return 0;

}