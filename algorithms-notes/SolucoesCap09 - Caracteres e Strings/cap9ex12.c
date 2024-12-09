#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contarOcorrencias(const char *str, char c);

int main() {

    char string[41];
    char a = 'a';
    char b = 'b';
    char c = 'c';
    char d = 'd';
    char e = 'e';

    char A = 'A';
    char B = 'B';
    char C = 'C';
    char D = 'D';
    char E = 'E';


    printf("Frase: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1] = '\0';

    printf("A/a: %d\n", contarOcorrencias(string, a) + contarOcorrencias(string, A));
    printf("B/b: %d\n", contarOcorrencias(string, b) + contarOcorrencias(string, B));
    printf("C/c: %d\n", contarOcorrencias(string, c) + contarOcorrencias(string, C));
    printf("D/d: %d\n", contarOcorrencias(string, d) + contarOcorrencias(string, D));
    printf("E/e: %d\n", contarOcorrencias(string, e) + contarOcorrencias(string, E));

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