#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contarOcorrencias(const char *str, char c);

int main() {

    char string[41];
    char a = 'a';
    char e = 'e';
    char i = 'i';
    char o = 'o';
    char u = 'u';

    char A = 'A';
    char E = 'E';
    char I = 'I';
    char O = 'O';
    char U = 'U';


    printf("Frase: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1] = '\0';

    printf("A/a: %d\n", contarOcorrencias(string, a) + contarOcorrencias(string, A));
    printf("E/e: %d\n", contarOcorrencias(string, e) + contarOcorrencias(string, E));
    printf("I/i: %d\n", contarOcorrencias(string, i) + contarOcorrencias(string, I));
    printf("O/o: %d\n", contarOcorrencias(string, o) + contarOcorrencias(string, O));
    printf("U/u: %d\n", contarOcorrencias(string, u) + contarOcorrencias(string, U));

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