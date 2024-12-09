#include <stdio.h>
#include <stdlib.h>

int main(){

    int array[3][4];
    int m; //número que multiplica o array, arrayMult

    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 4; j++){
            printf("array[%d][%d]: ",i, j);
            scanf("%d", &array[i][j]);
        }
    }

    printf("Multiplicar por: ");
    scanf("%d", &m);

    printf("arrayMult:\n");
    for(int i = 0; i < 3; i++){
        printf("%03d %03d %03d %03d\n", array[i][0]*m, array[i][1]*m, array[i][2]*m,  array[i][3]*m);
        }

    return 0;

}