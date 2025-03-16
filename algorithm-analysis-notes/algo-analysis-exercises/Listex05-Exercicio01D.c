// Andre Lyra Fernandes - RESOLVIDO

#include <stdio.h>
#include <stdlib.h>

// Declaração dos métodos
void imprimeArray(int array[], int tamanho);
void ordena(int array[], int tamanho);
int BuscaBinariaRecursiva(int array[], int inicio, int fim, int num);

int main() {

    int valor;
    printf("Entre com o tamanho do Array: ");
    scanf("%d", &valor);

    int array[valor];
    printf("Entre com os %d numeros inteiros:\n", valor);
    for (int i = 0; i < valor; i++) {
        scanf("%d", &array[i]);
    }

    insertionSort(array, valor); // Ordena os números inseridos pelo usuário
    imprimeArray(array, valor);

    int num;
    printf("Entre com o valor inteiro para ser procurado: ");
    scanf("%d", &num);

    if (BuscaBinariaRecursiva(array, 0, valor - 1, num) == -1)
        printf("O valor %d nao foi encontrado\n", num);
    else
        printf("O valor %d foi encontrado na posicao %d.\n", num, BuscaBinariaRecursiva(array, 0, valor - 1, num) + 1);

    return 0;
    
}

// Método para imprimir array
void imprimeArray(int array[], int tamanho) {
    printf("Array Gerado = ");
    for (int i = 0; i < tamanho; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}

// Método para ordenar array por inserção, visto que buscaBinaria funciona apenas para arrays ordenados
void insertionSort(int array[], int n) {
    int chave;

    for(int j = 1; j < n; j++) {
        chave = array[j];
        int i = j - 1;

        while((i >= 0) && (array[i] > chave)) { 
            array[i + 1] = array[i];
            i--;
        }
    }
}

// Método de busca binaria recursiva, para array já ordenado
int BuscaBinariaRecursiva(int array[], int inicio, int fim, int num) {
    if (inicio > fim)
        return -1;

    int meio = (inicio + fim) / 2;

    if (array[meio] == num)
        return meio;
    else if (array[meio] < num)
        return BuscaBinariaRecursiva(array, meio + 1, fim, num);
    else
        return BuscaBinariaRecursiva(array, inicio, meio - 1, num);
}