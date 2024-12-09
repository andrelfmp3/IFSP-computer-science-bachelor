#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main () {

    char string[41];

    printf("Nome: ");
    fgets(string, 41, stdin);
    string[strlen(string)-1] = '\0';

    int qntdcaracteres = strlen(string); 

    for(int i = 0; i < qntdcaracteres; i++){
        printf("%s\n", string);
    }

    return 0;

}