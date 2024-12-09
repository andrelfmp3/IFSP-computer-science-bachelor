#include <stdio.h>
#include <stdlib.h>

int main() {

    int array1[3][3];
    int array2[3][3];

    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            printf("array1[%d][%d]: ", i, j);
            scanf("%d", &array1[i][j]);
        }
    }

    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            printf("array2[%d][%d]: ", i, j);
            scanf("%d", &array2[i][j]);
        }
    }

    printf("array1:       array2:       arraySoma:\n");
    printf("%03d %03d %03d   %03d %03d %03d   %03d %03d %03d\n", array1[0][0], array1[0][1], array1[0][2], array2[0][0], array2[0][1], array2[0][2], array1[0][0]+array2[0][0], array1[0][1]+array2[0][1], array1[0][2]+array2[0][2]);
    printf("%03d %03d %03d + %03d %03d %03d = %03d %03d %03d\n", array1[1][0], array1[1][1], array1[1][2], array2[1][0], array2[1][1], array2[1][2], array1[1][0]+array2[1][0], array1[1][1]+array2[1][1], array1[1][2]+array2[1][2]);
    printf("%03d %03d %03d   %03d %03d %03d   %03d %03d %03d\n", array1[2][0], array1[2][1], array1[2][2], array2[2][0], array2[2][1], array2[2][2], array1[2][0]+array2[2][0], array1[2][1]+array2[2][1], array1[2][2]+array2[2][2]);


    return 0; 
}