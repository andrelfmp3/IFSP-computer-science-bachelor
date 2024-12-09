#include <stdio.h>
#include <stdlib.h>

int main() {

    int qntdpessoas = 0;
    float peso;
    float quantidademais60 = 0;
    float pesomais60 = 0;
    float maispesada = 0;
    float media;

    do{
        qntdpessoas = qntdpessoas + 1;
        printf("Entre com o peso da pessoa %02d: ", qntdpessoas);
        scanf("%f", &peso);

        if(peso > 60){
            quantidademais60 = quantidademais60 + 1;
            pesomais60 = peso + pesomais60;
            media = pesomais60 / quantidademais60;

        }

        if(peso > maispesada){
            maispesada = peso;
        }

    }while(peso > 0);

        printf("Media dos pesos acima de 60kg: %.2f\n", media);
        printf("A pessoa mais pesada possui %.2fkg", maispesada);

    return 0;
}