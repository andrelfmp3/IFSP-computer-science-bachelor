#include <stdio.h>
#include <stdlib.h>

int main() {

    int N;
    int n;
    int M;

    printf("Primeiro numero: ");
    scanf("%d", &N);
    
    printf("Segundo numero: ");
    scanf("%d", &n);

    M=(N+n)/2;

    printf("Media aritmetica: %d", M);

    return 0;

}