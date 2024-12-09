#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int hora;
    int minuto;
    int segundo;
} Hora;

Hora gerarHora (int quantidadeSegundos);

void imprimirHora (const Hora *hora);

int main() {

    int seg;

    printf("Segundos: ");
    scanf("%d", &seg);

    printf("\nHora correspondente: ");
    gerarHora(seg);
    
    return 0;
}

Hora gerarHora (int quantidadeSegundos){

    Hora horas;

    horas.hora = quantidadeSegundos / 3600;
    horas.minuto = (quantidadeSegundos % 3600) / 60;
    horas.segundo = quantidadeSegundos % 60;

    imprimirHora(&horas);

}

void imprimirHora (const Hora *horas){
    printf("%2d:%2d:%2d", horas->hora, horas->minuto, horas->segundo);
}