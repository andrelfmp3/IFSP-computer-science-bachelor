#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contarPalavras( const char *str );

int main() {

    char string[41];

    printf("Frase: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1 ] = '\0';

    printf("Quantidade de palavras: %d", contarPalavras(string));

    return 0;

}

int contarPalavras( const char *str ){
    int cont = 0;
    for(int i = 0; str[i] != '\0'; i++){
        if( str[i] == ' '){
            cont = cont + 1;
        }
    }
    return cont + 1;
}
