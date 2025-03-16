// Andre Lyra Fernandes - RESOLVIDO

#include <stdio.h>
#include <stdlib.h>

// Declaração dos métodos
int max(int *array, int tamanho);

int main() {

    int *array;
    int tamanho;   
    
    printf("Digite o tamanho do array: ");
    scanf("%d", &tamanho);

    array = (int*) malloc(tamanho * sizeof(int));

    for (int i = 0; i < tamanho; i++) {
        printf("elemento %d do array: ", i+1);
        scanf("%d", &array[i]);
    }

    printf("O maior elemento do array e %d", max(array, tamanho));
    
    return 0;
}

// Metódo para definir o máximo
int max(int *array, int tamanho) {
    if (tamanho == 1) {
        return array[0];
    }

    if (array[tamanho-1] > max(array, tamanho-1)) {
        return array[tamanho-1];
    } return max(array, tamanho-1);
}