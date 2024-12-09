#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void imprimirDireita( const char *str );

int main() {

    char str[41];

    printf("String: ");
    fgets(str, 41, stdin);
    str[strlen(str) -1 ] = '\0';

    imprimirDireita(str);

    return 0;

}

void imprimirDireita( const char *str ){

    int qntdd = strlen(str);

    int espacos = 80 - qntdd;

    for(int i = 0; i < espacos; i++){
        printf(" ");
    }
    printf("%s", str);

}