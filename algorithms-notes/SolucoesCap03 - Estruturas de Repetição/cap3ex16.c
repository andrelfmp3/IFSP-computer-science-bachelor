#include <stdio.h>
#include <stdlib.h>

int main() {

    int fibonacci0 = 0;
    int fibonacci1 = 1;
    int fibonacciBase = 0;

    printf("%d ",fibonacci1);

    for(int i = 0; i <= 18; i++){
        fibonacciBase = fibonacci0 + fibonacci1;
        fibonacci0 = fibonacci1;
        fibonacci1 = fibonacciBase;
        printf("%d ", fibonacciBase);
    }
    return 0; 

}
    
