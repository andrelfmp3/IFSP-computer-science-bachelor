#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main () {

    char string[41];

    printf("Sentenca: ");
    fgets(string, 41, stdin);
    string[strlen(string) -1] = '\0';

    int indice = strlen(string);

    for(int i = 0; i < indice; i++){
        if( i%2 != 0){
            if (string[i] == ' '){
                printf("' '");
            } else {
                printf("%c", string[i]);
            }

            if( i < indice-2){ 
                printf(", ");
            }
        }
    }


    return 0;

}