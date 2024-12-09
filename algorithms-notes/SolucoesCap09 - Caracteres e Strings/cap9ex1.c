#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

    char s[41];

    printf("String: ");
    fgets( s, 41, stdin );
    s[strlen(s) -1] = '\0';

    printf("%c, %c, %c, %c.", s[0], s[1], s[2], s[3]);

    return 0;
}