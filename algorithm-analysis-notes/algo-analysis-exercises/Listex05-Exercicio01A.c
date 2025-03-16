//Andre Lyra Fernandes - RESOLVIDO

#include <stdlib.h>
#include <stdio.h>

// Declaração dos métodos
long fatorialRecursiva(int num); //declaração da função

int main() {

    int num; 

    printf("Numero: ");
    scanf("%d", &num); 
    printf("O fatorial do %d eh %ld \n", num, fatorialRecursiva(num));

    return 0;

}

// Metódo farotiral de num, de forca recursiva
long fatorialRecursiva(int num){ 
    if(num <= 1){
        return 1; 
    }
    return num * fatorialRecursiva (num-1); 
}