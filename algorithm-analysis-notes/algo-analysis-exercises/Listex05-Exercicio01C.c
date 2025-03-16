// Andre Lyra Fernandes - RESOLVIDO

#include <stdlib.h>
#include <stdio.h>

// Declaração dos métodos
void ImprimirMover(int origem, int destino);
void resolveHanoi(int n, int origem, int destino, int meio);

int main() {

    int num; 
    
    printf("Numero: ");
    scanf("%d", &num); 
    resolveHanoi(num, 1, 3, 2);
    
    return 0; 
    
}

// Método para "printar" situação dos movimentos
void ImprimirMover(int origem, int destino) {
    printf("Mover disco da torre %d para torre %d\n", origem, destino);
}

// Método para resolver torre de Hanoit
void resolveHanoi(int num, int origem, int destino, int meio) {
    if(num > 0){
        resolveHanoi(num -1, origem, meio, destino);
        ImprimirMover(origem, destino);
        resolveHanoi(num-1, meio, destino, origem ); 
    }
}