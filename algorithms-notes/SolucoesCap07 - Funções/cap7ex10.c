#include <stdio.h>
#include <stdlib.h>

int calculaDigito(int n);

int main() {

    int digito;

    printf("Numero: ");
    scanf("%d", &digito);
    printf("Digito verificador de %d: %d", digito, calculaDigito(digito));
    return 0;

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