#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int lePositivo ();
bool ehTriangulo(int ladoA, int ladoB, int ladoC);
int tipoTriangulo(int ladoA, int ladoB, int ladoC);

int main(){

    int ladoA[5];
    int ladoB[5];
    int ladoC[5];

    for(int i = 0; i < 5; i++){
        printf("LadoA[%d]: ", i);
        ladoA[i] = lePositivo();

        printf("LadoB[%d]: ", i);
        ladoB[i] = lePositivo();

        printf("LadoC[%d]: ", i);
        ladoC[i] = lePositivo();
    }

    for(int i = 0; i < 5; i++){
        printf("Valores %d, %d e %d: ", ladoA[i], ladoB[i], ladoC[i]);

        if(tipoTriangulo(ladoA[i], ladoB[i], ladoC[i]) == 1){
            printf("triangulo equilatero\n");
        } else if (tipoTriangulo(ladoA[i], ladoB[i], ladoC[i]) == 2){
            printf("triangulo isosceles\n");
        } else if (tipoTriangulo(ladoA[i], ladoB[i], ladoC[i]) == 3){
            printf("triangulo escaleno\n");
        } else if (tipoTriangulo(ladoA[i], ladoB[i], ladoC[i]) == 0){
            printf("nao formam um triangulo\n");
        } else{
            printf("\n");
        }
    }
    
    return 0;
    
}

int lePositivo(){
    int n;
    do{
        scanf("%d", &n);
        if (n <= 0){
            printf("Entre com um valor positivo: \n");
        }
    } while (n <= 0);

    return n;
}


bool ehTriangulo(int ladoA, int ladoB, int ladoC){
    if (ladoA + ladoB > ladoC || ladoA + ladoC > ladoB || ladoB + ladoC > ladoA){
        return true;
    } else {
        return false;
    }
}


int tipoTriangulo(int ladoA, int ladoB, int ladoC){
    if (ladoA + ladoB <= ladoC || ladoA + ladoC <= ladoB || ladoB + ladoC <= ladoA){
        return 0; //NAO forma triangulo
    } else if (ladoA == ladoB && ladoB == ladoC){
        return 1; 
    } else if (ladoA == ladoB && ladoB != ladoC || ladoC == ladoA && ladoA != ladoB || ladoB == ladoC && ladoC != ladoA){
        return 2; 
    } else if (ladoA != ladoB && ladoB != ladoC){
        return 3; 
    }
}