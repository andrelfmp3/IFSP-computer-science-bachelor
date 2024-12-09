#include <stdio.h>
#include <stdlib.h>

int buscar ( const int *a, int n, int chave );

int main () {

    int a[10];
    int n = 10;
    int chave;

    for(int i = 0; i < 10; i++){
        printf("n[%d]: ", i);
        scanf("%d", &a[i]);
    }

    printf("Buscar por: \n");
    scanf("%d", &chave);

    buscar(a, n, chave);

    return 0;

}

    int buscar ( const int *a, int n, int chave ){
        for(int i = 0; i < n; i++){
            if (a[i] == chave){
                printf("O valor %d foi encontrado na posicao %d.\n", chave, i);
                return 0;
            }
        }
        printf("O valor %d nao foi encontrado.", chave);
        return 1;
    }