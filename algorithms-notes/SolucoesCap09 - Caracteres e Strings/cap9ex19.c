#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void substring( char *recorte, const char *origem, int inicio, int fim );

int main () {

    char origem[41];

    int inicio;
    int fim;

    char recorte[41]; 

    printf("String: ");
    fgets(origem, 41, stdin);
    origem[strlen(origem) -1] = '\0';

    printf("Inicio: ");
    scanf("%d", &inicio);

    printf("Fim: ");
    scanf("%d", &fim);

    substring(recorte, origem, inicio, fim);

    return 0;

}

void substring(char *recorte, const char *origem, int inicio, int fim) {  //rever
    if (inicio >= fim || fim > strlen(origem)) {
        printf("Recorte: %s\n", origem);
    } else {
        int j = 0;
        for (int i = inicio; i < fim; i++) {
            recorte[j] = origem[i];
            j++;
        }
        printf("Recorte: %s\n", recorte);
    }
}
















