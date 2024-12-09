#include <stdio.h>
#include <stdlib.h>

int main(){

    float valor = 0;
    int operacao;

    //contas:
    int deposito;
    int saque;


    printf("Saldo inicial: ");
    scanf("%f", &valor);
    printf("Operacoes:\n");
    printf("\t1) Deposito;\n");
    printf("\t2) Saque;\n");
    printf("\t3) Fim;\n");

    do{
        printf("Operacao desejada: ");
        scanf("%d", &operacao);
        switch (operacao){
        case 1:
            printf("Valor a depositar: ");
            scanf("%d", &deposito);

            valor = valor + deposito;

            break;
        case 2:
            printf("Valor a sacar: ");
            scanf("%d", &saque);

            valor = valor - saque;

        case 3:
            if(valor > 0){
                printf("Saldo final: R$%.2f\n", valor);
                printf("Conta preferencial.\n");
            }else if(valor == 0){
                printf("Saldo final: R$%.2f\n", valor);
                printf("Sem saldo.\n");
            }else if(valor < 0){
                printf("Saldo final: -R$%.2f\n", valor*-1);
                printf("Conta devedora.\n");
            }
        }
    } while (operacao != 3);

    return 0;
}
