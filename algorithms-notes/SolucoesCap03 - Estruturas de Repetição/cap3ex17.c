#include <stdio.h>
#include <stdlib.h>

int main() {

    int fibonacci0 = 0;
    int fibonacci1 = 1;
    int fibonacciBase = 0;
    int posicao;

    printf("Termo desejado: ");
    scanf("%d", &posicao);

    if(posicao == 0 || posicao == 1 ){
        printf("Fibonacci de %d e 1", posicao);
    }else{

    for(int i = 1; i <= posicao; i++){
        fibonacciBase = fibonacci0 + fibonacci1;
        fibonacci0 = fibonacci1;
        fibonacci1 = fibonacciBase;
    }

    printf("Fibonacci de %d e %d", posicao, fibonacciBase);
    return 0; 
    }

}
    
