#include <stdio.h>
#include <stdlib.h>

int main() {

    int atual;
    int sucessor;
    int antecessor;
    
    printf("Forneca um numero inteiro: ");
    scanf("%d", &atual);

    sucessor=atual+1;
    antecessor=atual-1;

    printf("Sucessor de 1992: %d\n", sucessor);
    printf("Antecessor de 1992: %d", antecessor);

    return 0;

}
