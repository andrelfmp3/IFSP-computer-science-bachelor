#include <stdio.h>
#include <stdlib.h>

int absoluto (int a);

int main() {

    int a[5];

    for ( int i = 0; i < 5; i++) {
        printf( "n%d: ", i);
        scanf( "%d",&a[i]);
    }

    for ( int i = 0; i < 5; i++) {
        printf( "absoluto(%d) = %d\n", a[i] , absoluto( a[i]) );
    }

    return 0;

}


int absoluto (int a) {

    if ( a < 0) {
        return -a;
    } else {
        return a;
    }

}


