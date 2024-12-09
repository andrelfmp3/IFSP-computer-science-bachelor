#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {                                 //confere apenas o primero caractere, ver os outros. Usar strcmp

    char string[3][41];

    for(int i = 0; i < 3; i++){
        printf("String %d: ", i+1);
        fgets(string[i], 41, stdin);
        string[i][strlen(string[i]) -1] = '\0';
    }

    if(string[0][0] <= string[1][0] && string[1][0] <= string[2][0]){
        printf("%s, %s e %s", string[0], string[1], string[2]);
    } else if (string[0][0] <= string[2][0] && string[2][0] <= string[1][0]){
        printf("%s, %s e %s", string[0], string[2], string[1]);
    } else if (string[1][0] <= string[0][0] && string[0][0] <= string[2][0]){
        printf("%s, %s e %s", string[1], string[0], string[2]);
    } else if (string[1][0] <= string[2][0] && string[2][0] <= string[0][0]){
        printf("%s, %s e %s", string[1], string[2], string[0]);
    } else if (string[2][0] <= string[1][0] && string[1][0] <= string[0][0]){
        printf("%s, %s e %s", string[2], string[1], string[0]);
    } else if (string[2][0] <= string[0][0] && string[0][0] <= string[1][0]){
        printf("%s, %s e %s", string[2], string[0], string[1]);
    }

    return 0;
}