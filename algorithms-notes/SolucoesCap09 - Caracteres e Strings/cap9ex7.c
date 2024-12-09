#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {          //PERGUNTAR PARA DAVID. como colocar arramultidimensional em fgets (para aplicar em um for). Ver Video

    char par11[41];
    char par12[41];
    char par21[41];
    char par22[41];
    char par31[41];
    char par32[41];
    char par41[41];
    char par42[41];
    char par51[41];
    char par52[41];

    printf("Par 1, palavra 1: ");
    fgets(par11, 41, stdin);
    par11[strlen(par11) -1] = '\0';
    
    printf("Par 1, palavra 2: ");
    fgets(par12, 41, stdin);
    par12[strlen(par12) -1] = '\0';

    printf("Par 2, palavra 1: ");
    fgets(par21, 41, stdin);
    par21[strlen(par21) -1] = '\0';

    printf("Par 2, palavra 2: ");
    fgets(par22, 41, stdin);
    par22[strlen(par22) -1] = '\0';

    printf("Par 3, palavra 1: ");
    fgets(par31, 41, stdin);
    par31[strlen(par31) -1] = '\0';

    printf("Par 3, palavra 2: ");
    fgets(par32, 41, stdin);
    par32[strlen(par32) -1] = '\0';

    printf("Par 4, palavra 1: ");
    fgets(par41, 41, stdin);
    par41[strlen(par41) -1] = '\0';

    printf("Par 4, palavra 2: ");
    fgets(par42, 41, stdin);
    par42[strlen(par42) -1] = '\0';

    printf("Par 5, palavra 1: ");
    fgets(par51, 41, stdin);
    par51[strlen(par51) -1] = '\0';

    printf("Par 5, palavra 2: ");
    fgets(par52, 41, stdin);
    par52[strlen(par52) -1] = '\0';

    printf("\n"); //apenas para leitura do jjudge


    printf("%s - %s: ", par11, par12);
        if (par11[0] == par12[0]){
        printf("IGUAIS\n");
    } else if (par11[0] >= par12[0]){
        printf("ORDEM DECRESCENTE\n");
    } else if(par11[0] <= par12[0]){
        printf("ORDEM CRESCENTE\n");
    }
    printf("%s - %s: ", par21, par22);
        if (par21[0] == par22[0]){
        printf("IGUAIS\n");
    } else if (par21[0] >= par22[0]){
        printf("ORDEM DECRESCENTE\n");
    } else if(par21[0] <= par22[0]){
        printf("ORDEM CRESCENTE\n");
    }
    printf("%s - %s: ", par31, par32);
        if (par31[0] == par32[0]){
        printf("IGUAIS\n");
    } else if (par31[0] >= par32[0]){
        printf("ORDEM DECRESCENTE\n");
    } else if(par31[0] <= par32[0]){
        printf("ORDEM CRESCENTE\n");
    }
    printf("%s - %s: ", par41, par42);
        if (par41[0] == par42[0]){
        printf("IGUAIS\n");
    } else if (par41[0] >= par42[0]){
        printf("ORDEM DECRESCENTE\n");
    } else if(par41[0] <= par42[0]){
        printf("ORDEM CRESCENTE\n");
    }
    printf("%s - %s: ", par51, par52);
        if (par51[0] == par52[0]){
        printf("IGUAIS\n");
    } else if (par51[0] >= par52[0]){
        printf("ORDEM DECRESCENTE\n");
    } else if(par51[0] <= par52[0]){
        printf("ORDEM CRESCENTE\n");
    }


}