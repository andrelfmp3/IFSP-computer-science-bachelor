#include <stdio.h>
#include <stdlib.h>

int main() {

    int atual;
    int nascimento;
    int idade;

    printf("Ano de nascimento: ");
    scanf("%d", &nascimento);

    printf("Ano atual: ");
    scanf("%d", &atual);

    idade=atual-nascimento;

    printf("Idade aproximada: %d anos ", idade);

    return 0;

}