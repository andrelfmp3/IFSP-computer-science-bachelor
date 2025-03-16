// André Lyra Fernandes - Resolvido
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int contador = 0; //variável global, conta instruções

//declaração de métodos
void imprimeArray(int array[], int tamanho, char msg[]);
void geraArrayInteiro(int array[], int tamanho);
void insertionSortInvertido(int array[], int n);

int main() {
    int tamanho; //tamanho do array

    printf("Entre com o tamanho do Array de Inteiros: ");
    scanf(" %d", &tamanho);

    int array[tamanho];

    //Gerando o array 
    geraArrayInteiro(array, tamanho);
    printf("Ordenacao\n\n");
    imprimeArray(array, tamanho, "Array Desord. []: ");
    printf("\n");
    insertionSortInvertido(array, tamanho); 
    imprimeArray(array, tamanho, "Array Ord []: ");
    printf("\nNumero de Operacoes para Ordenacao: %d\n", contador);

    return 0;
}

// método para exibir na tela todos os valores do array
void imprimeArray(int array[], int tamanho, char msg[]) {
    printf("%s", msg); 
    for(int i = 0; i < tamanho; i++){
        printf("%d ", array[i]);
    };
}

// método para ordenar array adaptado                                       NAO INVERTIDO
void insertionSortInvertido(int array[], int tamanho) {
    int chave;

    for(int j = 1; j < tamanho; j++) {
        contador = contador + 1;
        chave = array[j];
        int i = j - 1;

        while((i >= 0) && (array[i] < chave)) { 
            array[i + 1] = array[i];
            i--;
            contador = contador + 1;
        }

        array[i + 1] = chave;
        imprimeArray(array, tamanho, "Array Ord Decrescente.[] = "); //método chama método (recursividade)
        printf("- %d\n", chave);
    }
}

//método para gerar array com valores aleatórios (%100 para fins de organização)
void geraArrayInteiro(int array[], int n) {
    srand(time(NULL));

    for(int i = 0; i < n; i++) {
        array[i] = rand() % 100;
    }     
}
