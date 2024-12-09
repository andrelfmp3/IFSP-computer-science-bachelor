#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void inverter( char *destino, const char *origem );

int main() {

    char string[41];
    char stringinv[41];

    printf("String: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1] = '\0';

    inverter(stringinv, string);

    return 0;
}

void inverter( char *destino, const char *origem ){
    int tamanho = strlen(origem);

    for(int i = 0; i < tamanho; i++){
        destino[tamanho -i -1] = origem[i]; //-1?
    }

    destino[strlen(destino)] = '\0';

    printf("Invertida: %s", destino);
}
