#include <stdio.h>
#include <stdlib.h>

void decompoeTempo (int totalSeg, int *horas, int *minutos, int *segundos);

int main() { 

    int totalSeg;
    int horas;
    int minutos;
    int segundos;

    printf("Total de segundos: ");
    scanf("%d", &totalSeg);

    decompoeTempo (totalSeg, &horas, &minutos, &segundos);

    return 0; 

}

void decompoeTempo (int totalSeg, int *horas, int *minutos, int *segundos){
    *horas = totalSeg / 3600;
    *minutos = (totalSeg%3600)/60;
    *segundos = ((totalSeg%3600)%60)%60; //rever lógica

    printf("%d segundo(s) corresponde(m) a:\n", totalSeg);
    printf("    %d hora(s)\n", *horas);
    printf("    %d minuto(s)\n", *minutos);
    printf("    %d segundo(s)\n", *segundos);
}
