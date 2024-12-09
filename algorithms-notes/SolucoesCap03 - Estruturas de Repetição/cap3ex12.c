#include <stdio.h>

int main() {
    int n1;
    int n2;
    int contador = 0;

    printf("N1: ");
    scanf("%d", &n1);

    printf("N2: ");
    scanf("%d", &n2);

    if (n1 <= n2){
        for(int i = n1; i <= n2; i++) {
            if(i % 2 == 0) {
                contador++;
            }
    }
    } else if ( n2 <= n1){
        for(int i = n2; i <= n1; i++){
            if(i%2==0){
                contador++;
            }
    }
    }

    if(n1 <= n2){
    printf("Numeros pares entre %d e %d: %d", n1, n2, contador);
    } else {
        printf("Numeros pares entre %d e %d: %d", n2, n1, contador);
    }
    return 0;
}