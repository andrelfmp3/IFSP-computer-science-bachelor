#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool numeroCorreto(int n);
int obtemDigito(int n);
int obtemNumero(int n);
int calculaDigito(int n);

int main(){

    int numero;

    printf("Numero: \n");
    scanf("%d", &numero);

    if(numeroCorreto(numero) == true){
        printf("Numero completo: %d\n", numero);
        printf("Numero: %d\n", obtemNumero(numero));
        printf("Digito: %d\n", obtemDigito(numero));
        printf("Digito calculado: %d\n", calculaDigito( obtemNumero(numero) ));
        printf("O numero fornecido esta correto!\n");
    } else {
        printf("Numero completo: %d\n", numero);
        printf("Numero: %d\n", obtemNumero(numero));
        printf("Digito: %d\n", obtemDigito(numero));
        printf("Digito calculado: %d\n", calculaDigito( obtemNumero(numero) ));
        printf("O numero fornecido esta incorreto!\n");
    }

    return 0;

}

bool numeroCorreto(int n){
    if(obtemDigito(n) != calculaDigito( obtemNumero (n) )){
        return false;
    } else {
        return true;
    }
}

int obtemDigito(int n){
    int m;
    m = n%10;
    return m;
}

int obtemNumero(int n){
    int unidade;
    int dezena;
    int centena;
    int milhar;
    int dezenaDeMilhar;

    int m;

    unidade = n%10;
    dezena = (n/10)%10;
    centena =  (n/100)%10;
    milhar =  (n/1000)%10;
    dezenaDeMilhar = (n/10000)%10;

    m = dezena + centena*10 + milhar*100 + dezenaDeMilhar*1000;

    return m;
}

int calculaDigito(int n){
    int unidade;
    int dezena;
    int centena;
    int milhar;

    int verificado;

    unidade = n%10;
    dezena = (n/10)%10;
    centena = (n/100)%10;
    milhar =  (n/1000)%10;

    verificado = ((((milhar*5)+(centena*4)+(dezena*3)+(unidade*2))%11)-11)*-1; //multiplicar por -1?
    if (verificado == 10 || verificado == 11){
        return 0;
    } else {
        return verificado;
    }
}

