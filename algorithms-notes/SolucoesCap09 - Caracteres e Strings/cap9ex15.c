#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void tornarMaiuscula( char *str );

int main() {

    char string[41];

    printf("frase: ");
    fgets(string, 41, stdin);
    string[strlen(string)-1] = '\0';

    tornarMaiuscula(string);

    return 0;

}

void tornarMaiuscula( char *str ){
    for(int i = 0; str[i] != '\0'; i++){
        if(str[i] == 'A'){
            str[i] = 'a';
        } else if (str[i] == 'B'){
            str[i] = 'b';
        } else if (str[i] == 'C'){
            str[i] = 'c';
        } else if (str[i] == 'D'){
            str[i] = 'd';
        } else if (str[i] == 'E'){
            str[i] = 'e';
        } else if (str[i] == 'F'){
            str[i] = 'f';
        } else if (str[i] == 'G'){
            str[i] = 'g';
        } else if (str[i] == 'H'){
            str[i] = 'h';
        } else if (str[i] == 'I'){
            str[i] = 'i';
        } else if (str[i] == 'J'){
            str[i] = 'j';
        } else if (str[i] == 'K'){
            str[i] = 'k';
        } else if (str[i] == 'L'){
            str[i] = 'l';
        } else if (str[i] == 'M'){
            str[i] = 'm';
        } else if (str[i] == 'N'){
            str[i] = 'n';
        } else if (str[i] == 'O'){
            str[i] = 'o';
        } else if (str[i] == 'P'){
            str[i] = 'p';
        } else if (str[i] == 'Q'){
            str[i] = 'q';
        } else if (str[i] == 'R'){
            str[i] = 'r';
        } else if (str[i] == 'S'){
            str[i] = 's';
        } else if (str[i] == 'T'){
            str[i] = 't';
        } else if (str[i] == 'U'){
            str[i] = 'u';
        } else if (str[i] == 'V'){
            str[i] = 'v';
        } else if (str[i] == 'W'){
            str[i] = 'w';
        } else if (str[i] == 'X'){
            str[i] = 'x';
        } else if (str[i] == 'Y'){
            str[i] = 'y';
        } else if (str[i] == 'Z'){
            str[i] = 'z';
        }

    }
    printf("%s", str);
}