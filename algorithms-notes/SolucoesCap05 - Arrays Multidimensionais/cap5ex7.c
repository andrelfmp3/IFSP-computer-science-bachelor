#include <stdio.h>
#include <stdlib.h>

int main() {

    int a[3][2]; //array a
    int b[2][3]; // array b

    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 2; j++){
            printf("array1[%d][%d]: ", i, j);
            scanf("%d", &a[i][j]);
        }
    }

    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 3; j++){
            printf("array2[%d][%d]: ", i, j);
            scanf("%d", &b[i][j]);
        }
    }
    
    printf("A x B =\n");
    printf("%03d %03d %03d\n", (a[0][0]*b[0][0] + a[0][1]*b[1][0]), (a[0][0]*b[0][1] + a[0][1]*b[1][1]), (a[0][0]*b[0][2] + a[0][1]*b[1][2]));
    printf("%03d %03d %03d\n", (a[1][0]*b[0][0] + a[1][1]*b[1][0]), (a[1][0]*b[0][1] + a[1][1]*b[1][1]), (a[1][0]*b[0][2] + a[1][1]*b[1][2]));
    printf("%03d %03d %03d\n", (a[2][0]*b[0][0] + a[2][1]*b[1][0]), (a[2][0]*b[0][1] + a[2][1]*b[1][1]), (a[2][0]*b[0][2] + a[2][1]*b[1][2]));

    return 0;

}