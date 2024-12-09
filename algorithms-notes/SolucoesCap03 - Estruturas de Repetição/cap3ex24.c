#include <stdio.h>
#include <stdlib.h>

int main() {

    int idade = 0;
    int soma21 = 0;
    int soma50 = 0;
    int contador = 1;

    do{
        printf("Idade da pessoa %02d: ", contador);
        scanf("%d", &idade);

        if(idade < 21 && idade > 0){
            soma21 = soma21 + 1;
        } else if (idade > 50 && idade > 0){
            soma50 = soma50 + 1;            
        }

        contador = contador +1;
    } while(idade >= 0);

    printf("Total de pessoas menores de 21 anos: %d\n", soma21);
    printf("Total de pessoas com mais de 50 anos: %d", soma50);

    return 0;
}