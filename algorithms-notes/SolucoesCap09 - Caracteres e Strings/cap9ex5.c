#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main () {

    char string[41];

    printf("Nome: ");
    fgets(string, 41, stdin);
    string[strlen(string)-1] = '\0';

    for(int i = 0; i < 5; i++){
        printf("%s\n", string);
    }

    return 0;

}