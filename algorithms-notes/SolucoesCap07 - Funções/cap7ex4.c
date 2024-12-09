#include <stdio.h>
#include <stdlib.h>

int lePositivo();
int somatorio(int n);

int main() {

    int array[5];

    for(int i = 0; i < 5; i++){
        printf("n[%d]: ", i);
        array[i] = lePositivo();
    }

    for(int i = 0; i < 5; i++){
        printf("Somatorio de 1 a %d: %d\n", array[i], somatorio(array[i]));
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

int somatorio (int n){
    int soma = 0;
    for(int i = 0; i <= n; i++){
        soma = soma + i ;
    }

    return soma;
}
