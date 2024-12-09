#include <stdio.h>
#include <stdlib.h>

int main() {

    int array[2][3];

    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 3; j++){
            printf("array[%d][%d]: ", i, j);
            scanf("%d", &array[i][j]);
        }
    }

    printf("M:\n");
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 3; j++){
            printf("%03d", array[i][j]);
            if(j != 2){
                printf(" ");
            }
        }
        printf("\n");
    }

    printf("\n");

    printf("Mt:\n");
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 2; j++){
            printf("%03d", array[j][i]);
            if(j != 1){
                printf(" ");
            }
        }
        printf("\n");
    }

    return 0; 

}