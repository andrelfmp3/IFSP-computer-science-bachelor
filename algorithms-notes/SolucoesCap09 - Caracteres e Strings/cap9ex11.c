#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contarOcorrencias(const char *str, char c);

int main() {
    char caractere;
    char string[41]; // 100, pois não especificou quantidade, até aparecer "fim"

    printf("Caractere: ");
    scanf(" %c", &caractere);
    getchar(); // descarta o caractere de nova linha do buffer

    do {
        printf("Frase: ");
        fgets(string, 41, stdin);
        string[strlen(string) - 1] = '\0';

        if (strcmp(string, "fim") != 0) {
            printf("\"%s\" tem %d ocorrencia(s) do caractere '%c'\n", string, contarOcorrencias(string, caractere), caractere);
        }
    } while (strcmp(string, "fim") != 0);

    return 0;
}

int contarOcorrencias(const char *str, char c) {
    int contador = 0;
    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == c) {
            contador = contador + 1;
        }
    }
    return contador;
}