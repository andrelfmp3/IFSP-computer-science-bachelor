#include <stdio.h>
#include <stdlib.h>


int main() {

    int i;

    printf("Entre com sua idade: ");
    scanf("%d", &i);

    if (i < 16){
        printf("Nao eleitor.");
    } else if (18 <= i && i <= 65){
        printf("Eleitor obrigatorio.");
    } else if (16 <= i && i < 18 || i >= 65){
        printf("Eleitor facultativo.");
    }

    return 0;
}