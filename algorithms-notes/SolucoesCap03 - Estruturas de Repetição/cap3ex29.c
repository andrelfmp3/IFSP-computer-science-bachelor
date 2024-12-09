#include <stdio.h>
#include <stdlib.h>

int main(){

    int n1;
    int n2;

    int divisao;
    char questao;

    do{
        printf("N1: ");
        scanf("%d", &n1);
        printf("N2: ");
        scanf("%d", &n2);

        while(n2 == 0){
            printf("Nao existe divisao inteira por zero!\n");
            printf("Entre novamente com N2: ");
            scanf("%d", &n2);
        }
        divisao = n1/n2;
        printf("%d / %d = %d\n", n1, n2, divisao);
        printf("Voce deseja realizar outro calculo? (S/N): ");
        scanf(" %c", &questao);
    }while(questao == 'S');

    return 0;
}