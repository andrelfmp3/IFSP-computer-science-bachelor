#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

bool ehPalindromo( const char *str );

int main() {

    char string[41];

    printf("Frase: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1] = '\0';

    if(ehPalindromo(string) == true){
        printf("\"%s\" eh um palindromo!", string);
    } else {
        printf("\"%s\" nao eh um palindromo!", string);
    }

    return 0;
}

bool ehPalindromo( const char *str ){
    int c = 0; //contador
    int len = strlen(str);
    for(int i = 0; i < len/2; i++){
        if (str[i + c] != str[len - 1 - i - c]) { //rever criterios 
            return false; 
            c = c + 1;
        } else {
            return true;
        }
    }
}

