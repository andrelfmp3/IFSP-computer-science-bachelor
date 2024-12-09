#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void imprimirCentralizado( const char *str );

int main () {

    char string[41];

    printf("String: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1] = '\0';

    imprimirCentralizado(string);

    return 0;

}

void imprimirCentralizado( const char *str ){
    int espacos = (80 - strlen(str))/2;

    for(int i = 0; i < espacos; i++){
        printf(" ");
    }

    printf("%s", str);

    for(int i = 0; i < espacos; i++){
        printf(" ");
    }
}