#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int tamanho( const char *str );

int main(){

    char frase[41];

    printf("Frase: ");
    fgets(frase, 41, stdin);

    printf("%d caractere(s)!", tamanho(frase));

    return 0;
}

int tamanho( const char *str ){
    int c = 0; //contador
    do{
        c = c + 1;
    } while (str[c] != '\0');

    return c-1;
}