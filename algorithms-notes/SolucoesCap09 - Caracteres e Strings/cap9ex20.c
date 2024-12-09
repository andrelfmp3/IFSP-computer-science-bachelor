#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool contem(const char *fonte, const char *aPesquisar);

int main() {
    char fonte[41];
    char aPesquisar[41];

    printf("String fonte: ");
    fgets(fonte, 41, stdin);
    fonte[strlen(fonte) - 1] = '\0';

    printf("String a pesquisar: ");
    fgets(aPesquisar, 41, stdin);
    aPesquisar[strlen(aPesquisar) - 1] = '\0';

    if (contem(fonte, aPesquisar)) {
        printf("\"%s\" esta contida em \"%s\"\n", aPesquisar, fonte);
    } else {
        printf("\"%s\" nao esta contida em \"%s\"\n", aPesquisar, fonte);
    }

    return 0;
}

bool contem(const char *fonte, const char *aPesquisar) {                        //funçao do david, rever 
    int lenFonte = strlen(fonte);
    int lenPesquisar = strlen(aPesquisar);

    for (int i = 0; i <= lenFonte - lenPesquisar; i++) {
        int j;
        for (j = 0; j < lenPesquisar; j++) {
            if (fonte[i + j] != aPesquisar[j]) {
                break;
            }
        }
        if (j == lenPesquisar) {
            return true;
        }
    }
    return false;
}