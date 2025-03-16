// Andre Lyra Fernandes - RESOLVIDO

#include <stdio.h>
#include <stdlib.h>

// Declaração dos métodos
int MinDivisorComum(int a, int b);

int main() {

    int a;
    int b;
    
    printf("Numero (1): ");
    scanf("%d", &a);
    
    printf("Numero (2): ");
    scanf("%d", &b);

    printf("MMC de %d e %d eh %d", a, b, MinDivisorComum(a, b));

    return 0;
}

// Metódo para resolver MDC
int MinDivisorComum(int a, int b){
    if (a % b == 0) {
        return b;
    }
    
    return MinDivisorComum(b, a % b);

}