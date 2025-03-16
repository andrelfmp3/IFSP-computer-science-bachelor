// André Lyra Fernandes bc303139x RESOLVIDO
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Declaração das funções
void geraArrayInteiro(int array[], int tamanho);
void MergeSortRecursivo(int A[], int p, int r, int tamanho);
void IntercalaComSentinela(int A[], int p, int q, int r);
void ImprimeArrayInteiro(int array[], int tamanho, char a[]);
int BuscaBinariaRecursiva(int array[], int começo, int fim, int x);

int main() {

    int tamanho;
    int valorProcurado;

    printf("Entre com o tamanho de Array de Inteiros: ");
    scanf("%d", &tamanho);

    int *array = (int *)malloc(tamanho * sizeof(int)); 

    geraArrayInteiro(array, tamanho);
    MergeSortRecursivo(array, 0, tamanho - 1, tamanho);
    ImprimeArrayInteiro(array, tamanho, "Array Gerado Ordenado =");

    printf("Entre com o valor inteiro a ser procurado: ");
    scanf("%d", &valorProcurado);

    int posicao = BuscaBinariaRecursiva(array, 0, tamanho - 1, valorProcurado);

    if (posicao == -1){
        printf("O Valor %d nao foi encontrado no Array!\n", valorProcurado);
    } else {
        printf("O Valor %d foi encontrado no índice %d do Array!\n", valorProcurado, posicao);
    }

    free(array);
    return 0;

}

// Função para gerar array com números inteiros aleatórios 
void geraArrayInteiro(int array[], int tamanho) {
    srand(time(NULL));
    for(int i = 0; i < tamanho; i++) {
        array[i] = rand() % 100;
    }     
}

// Função para imprimir array inteiro
void ImprimeArrayInteiro(int array[], int tamanho, char a[]){
    printf("%s", a);
    for(int i = 0; i < tamanho; i++){
        printf(" %d", array[i]);
    }
    printf("\n"); 
}

// Função MergeSort Recursivo
void MergeSortRecursivo(int A[], int p, int r, int tamanho) { 
    if (p < r) {
        int q = (p + r) / 2;
        MergeSortRecursivo(A, p, q, tamanho);
        MergeSortRecursivo(A, q + 1, r, tamanho);
        IntercalaComSentinela(A, p, q, r);
    }
}

// Função Intercala com Sentinela
void IntercalaComSentinela(int A[], int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;

    int L[n1 + 1];
    int R[n2 + 1];

    for (int i = 0; i < n1; i++) { 
        L[i] = A[p + i];
    }

    for (int j = 0; j < n2; j++) { 
        R[j] = A[q + j + 1]; 
    }
    R[n2] = __INT_MAX__;
    L[n1] = __INT_MAX__;

    int i = 0;
    int j = 0;

    for (int k = p; k <= r; k++) {
        if (L[i] <= R[j]) {
            A[k] = L[i];
            i++;
        } else {
            A[k] = R[j];
            j++;
        }
    }
}

// Função BuscaBinaria Recursiva
int BuscaBinariaRecursiva(int array[], int começo, int fim, int valorProcurado) {
    if (começo <= fim) {

        int valor = começo + (fim - começo)/ 2;

        if (array[valor] == valorProcurado){
            return valorProcurado;
        }
        if (array[valor] > valorProcurado){
            return BuscaBinariaRecursiva(array, começo, valor - 1, valorProcurado);
        }

        return BuscaBinariaRecursiva(array, valor + 1, fim, valorProcurado);
    }

    return -1;
}
