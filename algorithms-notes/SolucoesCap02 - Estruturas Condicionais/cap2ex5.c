#include <stdio.h>
#include <stdlib.h>

int main() {

    int N1;
    int N2;
    int N3;

    printf("N1: ");
    scanf("%d", &N1);

    printf("N2: ");
    scanf("%d", &N2);

    printf("N3: ");
    scanf("%d", &N3);

    if ( N1 >= N2 && N2 >= N3 ){
        printf("%d >= %d >= %d", N1, N2, N3);
    } else if (N1 >= N3 && N3 >= N2 ){
        printf("%d >= %d >= %d", N1, N3, N2 );
    } else if (N2 >= N1 && N1 >= N3){
        printf( "%d >= %d >= %d", N2, N1, N3 );
    } else if (N2 >= N3 && N3 >= N1){
        printf("%d >= %d >= %d", N2, N3, N1);
    } else if (N3 >= N1 && N1 >= N2){
        printf("%d >= %d >= %d", N3, N1, N2);
    } else if (N3 >= N2 && N2 >= N1){
        printf("%d >= %d >= %d", N3, N2, N1);
    }
    
    return 0; 

}
