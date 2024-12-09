#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;
    printf("Digite um valor inteiro entre 1 e 100: \n");
    scanf("%d", &n);

    
    if (n < 1 || n > 100) {
        printf("Numero incorreto!\n");
        return 0;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            int val = abs(i-j)+1; 
            printf("%3d", val); 
            if (j < n) printf(" "); 
        }
        printf("\n"); 
    }

    return 0;
}
