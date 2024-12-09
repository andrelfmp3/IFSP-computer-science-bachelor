#include <stdio.h>
#include <stdlib.h>

int main() {

    float Preco;
    float Desconto;

    printf("Valor do produto: ");
    scanf("%f", &Preco);

    Desconto = Preco*0.91;

    printf("Preco de venda com 9%% de desconto: %.2f", Desconto);

    return 0;

}