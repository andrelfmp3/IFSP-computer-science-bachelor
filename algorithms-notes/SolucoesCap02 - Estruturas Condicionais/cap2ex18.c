#include <stdio.h>
#include <stdlib.h>

int main() {

    float N1;
    float N2;
    char operacao;

    printf("N1: ");
    scanf("%f", &N1);

    printf("N2: ");
    scanf("%f", &N2);

    printf("Escolha uma operacao de acordo com o menu:\n    +) Adicao;\n    -) Subtracao;\n    *) Multiplicacao;\n    /) Divisao    \nOperacao:  ");
    scanf(" %c", &operacao);

    switch (operacao) {
        case '+':
            printf("%.2f + %.2f = %.2f", N1, N2, N1+N2);
        break;

        case '-':
            printf("%.2f - %.2f = %.2f", N1, N2, N1-N2);
        break;

        case '*':
            printf("%.2f * %.2f = %.2f", N1, N2, N1*N2);
        break;

        case '/':
            printf("%.2f / %.2f = %.2f", N1, N2, N1/N2);
        break;

        default:
            printf("Opcao invalida!");
    }

    return 0;
}