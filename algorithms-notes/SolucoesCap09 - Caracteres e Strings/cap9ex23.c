#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void imprimirCaixa( const char *str );

int main() {

char string[41];

fgets(string, 41, stdin);
string[strlen(string) -1] = '\0';

imprimirCaixa(string);

return 0;

}

void imprimirCaixa( const char *str ){
    printf("++===================++\n");
    printf("|| %s ||\n", str);
    printf("++===================++\n");
}
