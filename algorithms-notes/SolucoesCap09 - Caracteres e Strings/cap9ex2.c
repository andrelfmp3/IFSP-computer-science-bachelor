#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main () { //rever lógica

    char string[41];

    printf("Sentence: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1] = '\0'; // remove pulo de linha

    int caracteres = strlen(string);

    printf("Primeiro caractere: %c\n", string[0]);
    printf("Ultimo caractere: %c\n", string[caracteres-1]); 
    //-1, visto que string[strlen(string) -1] = '\0' 
    printf("Numero de caracteres: %d\n", caracteres);

    return 0;

}