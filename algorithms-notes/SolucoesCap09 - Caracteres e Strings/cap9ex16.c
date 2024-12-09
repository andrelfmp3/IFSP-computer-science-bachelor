#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void removerLetra(char *str, char c);

int main() {
    char string[41];
    char caractere;

    printf("Frase: ");
    fgets(string, 41, stdin);
    string[strlen(string) - 1] = '\0';

    printf("Caractere: ");
    scanf(" %c", &caractere);  // Corrigido para evitar a captura do caractere de nova linha

    removerLetra(string, caractere);

    return 0;
}

void removerLetra(char *str, char c) { // FUNCAO FEITA COM CHAT GPT, REVER ATENTAMENTE.
    int i, j;
    char uppercaseC = toupper(c);
    char lowercaseC = tolower(c);

    for (i = 0, j = 0; str[i] != '\0'; i++) {
        if (str[i] != uppercaseC && str[i] != lowercaseC) {
            str[j] = str[i];
            j++;
        }
    }
    str[j] = '\0'; // Adiciona o caractere de terminação da string no novo final

    printf("%s\n", str);
}