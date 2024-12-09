#include <stdio.h>
#include <stdlib.h>

int main() {
    float n1;
    float n2;
    float np;
    float m;

    printf("Nota Av. 1: ");
    scanf("%f", &n1);
    printf("Nota Av. 2: ");
    scanf("%f", &n2);
    printf("Nota Optativa: ");
    scanf("%f", &np);

    if(np > n1){
        m =  (np+n2)/2;
    } else if(np>n2 >= n2){
        m = (np+n1)/2;
    } else {
        m = (n1+n2)/2;
    }

    if (m>=6){
        printf("Media: %.2f", m);
        printf("\nAprovado!");
    }
    else if(m>=4 && m<6){
        printf("Media: %.2f", m);
        printf("\nExame.");
    }
    else{
        printf("Media: %.2f", m);
        printf("\nReprovado...");
    }

    return 0;
}
