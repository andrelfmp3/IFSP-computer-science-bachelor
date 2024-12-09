#include <stdio.h>
#include <stdlib.h>

int main() {

    float N;

    printf( "Entre um valor qualquer: " );
    scanf( "%f", &N );

    printf( "%f\n", N );
    printf( "%.2f\n", N );
    printf( "%.3f", N );

    return 0;

}

