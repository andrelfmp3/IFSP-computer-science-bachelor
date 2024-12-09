#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main () { //rever

    char string[41];

    printf("Sentenca: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1] = '\0';

    int caracteres = strlen(string);

    for(int i = 0; i < caracteres; i++){
        if(i%2 == 0){
            if (string[i] == ' '){
                printf("' '");
            } else {
                printf("%c", string[i]);
            }
            if (i < caracteres-2){
                 // (ultimo caractere e caractere nulo)).
            printf(", ");
            }
        }
    }

    return 0;
    
}