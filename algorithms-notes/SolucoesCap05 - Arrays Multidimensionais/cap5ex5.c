#include <stdio.h>
#include <stdlib.h>

int main() {

    int a[3][3];
    
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
        printf("array[%d][%d]: ", i, j);
        scanf("%d", &a[i][j]);
        }
    }

    printf("Determinante: %d", ((a[0][0]*a[1][1]*a[2][2]) + (a[0][1]*a[1][2]*a[2][0]) + (a[0][2]*a[1][0]*a[2][1]))
    - ((a[0][2]*a[1][1]*a[2][0]) + (a[0][0]*a[1][2]*a[2][1]) + (a[0][1]*a[1][0]*a[2][2])));
    return 0;

}