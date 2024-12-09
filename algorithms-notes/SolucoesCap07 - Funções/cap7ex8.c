#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int lePositivo ();
int somaDividores (int n);
bool saoAmigos (int n1, int n2);

int main() {

    int array1[5];
    int array2[5];

    for(int i = 0; i < 5; i++){
        printf("n1[%d]: ", i);
        array1[i] = lePositivo();

        printf("n2[%d]: ", i);
        array2[i] = lePositivo();

    }

    for(int i = 0; i < 5; i++){
        if(saoAmigos(array1[i], array2[i]) == true){
            printf("%d e %d sao amigos\n", array1[i], array2[i]);
        } else if (saoAmigos(array1[i], array2[i]) == false) {
            printf("%d e %d nao sao amigos\n", array1[i], array2[i]);
        }
    } 

    return 0;
    
}

bool saoAmigos (int n1, int n2){
    
    int soma1 = 0;
    int soma2 = 0;

    for(int i = 1; i < n1; i++){
        if(n1%i == 0){
            soma1 = soma1 + i;
        }
    }

    for(int i = 1; i < n2; i++){
        if(n2%i == 0){
            soma2 = soma2 + i;
        }
    }

    if(soma2 == n1 && soma1 == n2){
        return true;
    } else {
        return false;
    }

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
