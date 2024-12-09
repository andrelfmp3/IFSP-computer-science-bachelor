#include <stdio.h>
#include <stdlib.h>


typedef struct{
    int vermelho;
    int verde;
    int azul;;
} Cor;

Cor novaCor (int vermelho, int verde, int azul);
void imprimirCor (const Cor *c);

int main() {

    Cor cor;
    Cor c;

    printf("Vermelho: ");
    scanf("%d", &cor.vermelho);
    printf("Verde: ");
    scanf("%d", &cor.verde);
    printf("Azul: ");
    scanf("%d", &cor.azul);

    c = novaCor (cor.vermelho, cor.verde, cor.azul);
    imprimirCor(&c);
    return 0;
}

Cor novaCor (int vermelho, int verde, int azul){

    Cor cor;

    if(vermelho >= 255){
        cor.vermelho = 255;
    }else if(vermelho <= 0){
        cor.vermelho = 0;
    }else{
        cor.vermelho = vermelho;
    }

    if(verde >= 255){
        cor.verde = 255;
    }else if(verde <= 0){
        cor.verde = 0;
    }else{
        cor.verde = verde;
    }

    if(azul >= 255){
        cor.azul = 255;
    }else if(azul <= 0){
        cor.azul = 0;
    }else{
        cor.azul = azul;
    }

    return cor;

}

void imprimirCor (const Cor *c){
    printf("Cor: rgb( %d, %d, %d )", c->vermelho, c->verde, c->azul);
}