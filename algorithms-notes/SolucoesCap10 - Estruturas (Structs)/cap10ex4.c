#include <stdio.h>
#include <stdlib.h>

typedef struct{
    float real;
    float imaginario;
} Complexo;

Complexo somar (const Complexo *c1, const Complexo *c2);

void imprimirComplexo (const Complexo *c);

int main() {

    Complexo c1;
    Complexo c2;
    Complexo c;

    printf("Complexo 1:\n");

    printf("    Parte real: ");
    scanf("%f", &c1.real);

    printf("    Parte imaginaria: ");
    scanf("%f", &c1.imaginario);

    printf("\nComplexo 2:\n");

    printf("    Parte real: ");
    scanf("%f", &c2.real);

    printf("    Parte imaginaria: ");
    scanf("%f", &c2.imaginario);

    c = somar(&c1, &c2);
    printf("\n(%.2f + %.2fi) + (%.2f + %.2fi) = ", c1.real, c1.imaginario, c2.real, c2.imaginario);
    imprimirComplexo(&c);
    return 0;
}

Complexo somar (const Complexo *c1, const Complexo *c2){

    Complexo c;
    c.imaginario = c1->imaginario + c2->imaginario;
    c.real = c1->real + c2-> real;
    return c;

}

void imprimirComplexo (const Complexo *c){
    printf("(%.2f + %.2fi)", c->real, c->imaginario);
}