#include <stdio.h>
#include <stdlib.h>

int main() {

    float horaaula;
    int quantidade;
    float desconto;
    float salario;

    printf("Valor da hora/aula: ");
    scanf("%f", &horaaula);

    printf("Quantidade de aulas: ");
    scanf("%d", &quantidade);

    printf("Porcentagem de desconto do INSS: ");
    scanf("%f", &desconto);

    salario = (horaaula*quantidade/100)*(100-desconto);

    printf("Salario Liquido: %.2f", salario);

    return 0;

}