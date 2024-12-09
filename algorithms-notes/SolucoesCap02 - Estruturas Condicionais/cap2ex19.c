#include <stdio.h>
#include <stdlib.h>

int main() {

    char tipo;
    float f;
    float c;
    float x;

    printf("Escolha uma operacao de acordo com o meu\n    C) Celsius -> Fahrenheit\n    F) Fahrenheit -> Celsius\n Opcao:");
    scanf(" %c", &tipo);

    switch(tipo){
        case'C':
            printf("Entre com a temperatura em graus Celsius: ");
            scanf("%f", &c);
            x = (1.8*c)+32;
            printf("%.2f graus Celsius correspondem a %.2f graus Fahrenheit", c, x);
        break;

        case'F':
            printf("Entre com a temperatura em graus Fahrenheit: ");
            scanf("%f", &f);
            x = (f-32)/1.8;
            printf("%.2f graus Fahrenheit correspondem a %.2f graus Celsius", f, x);
        break;

        default:
            printf("Opcao invalida!");
    }

    return 0;
}