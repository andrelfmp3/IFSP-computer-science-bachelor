#include <stdio.h>
#include <stdlib.h>

int main() {

    int quantidadelados;
    float medidadoslados; 

    printf("Entre com a quantidade de lados: ");
    scanf("%d", &quantidadelados);

    printf("Entre com a medida do lado: ");
    scanf("%f", &medidadoslados);

    if (quantidadelados == 3){
        printf("TRIANGULO de perimetro %.2f", medidadoslados*quantidadelados);
    } else if (quantidadelados == 4){
        printf("QUADRADO de area %.2f", medidadoslados*medidadoslados);
    } else if (quantidadelados == 5){
        printf ("PENTAGONO");
    } else {
        printf("Poligono nao identificado");
    }



    return 0;

}