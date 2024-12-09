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
        if(str[i] == 'a'){
            str[i] = 'A';
        } else if (str[i] == 'b'){
            str[i] = 'B';
        } else if (str[i] == 'c'){
            str[i] = 'C';
        } else if (str[i] == 'd'){
            str[i] = 'D';
        } else if (str[i] == 'e'){
            str[i] = 'E';
        } else if (str[i] == 'f'){
            str[i] = 'F';
        } else if (str[i] == 'g'){
            str[i] = 'G';
        } else if (str[i] == 'h'){
            str[i] = 'H';
        } else if (str[i] == 'i'){
            str[i] = 'I';
        } else if (str[i] == 'j'){
            str[i] = 'J';
        } else if (str[i] == 'k'){
            str[i] = 'K';
        } else if (str[i] == 'l'){
            str[i] = 'L';
        } else if (str[i] == 'm'){
            str[i] = 'M';
        } else if (str[i] == 'n'){
            str[i] = 'N';
        } else if (str[i] == 'o'){
            str[i] = 'O';
        } else if (str[i] == 'p'){
            str[i] = 'P';
        } else if (str[i] == 'q'){
            str[i] = 'Q';
        } else if (str[i] == 'r'){
            str[i] = 'R';
        } else if (str[i] == 's'){
            str[i] = 'S';
        } else if (str[i] == 't'){
            str[i] = 'T';
        } else if (str[i] == 'u'){
            str[i] = 'U';
        } else if (str[i] == 'v'){
            str[i] = 'V';
        } else if (str[i] == 'w'){
            str[i] = 'W';
        } else if (str[i] == 'x'){
            str[i] = 'X';
        } else if (str[i] == 'y'){
            str[i] = 'Y';
        } else if (str[i] == 'z'){
            str[i] = 'Z';
        }

    }
    printf("%s", str);
}