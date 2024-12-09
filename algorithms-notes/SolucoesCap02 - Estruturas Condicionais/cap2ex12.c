#include <stdio.h>
#include <stdlib.h>

int main() {
    
    int h1;
    int h2;
    int m1;
    int m2;

    printf("Idade Homem 1: ");
    scanf("%d", &h1);

    printf("Idade Homem 2: ");
    scanf("%d", &h2);

    printf("Idade Mulher 1: ");
    scanf("%d", &m1);

    printf("Idade Mulher 2: ");
    scanf("%d", &m2);

    if (h1 >= h2 && m1 >= m2 ){
        printf("Idade homem mais velho + idade mulher mais nova: %d\n", h1+m2);
    } else if (h1 >= h2 && m2 >= m1){
        printf("Idade homem mais velho + idade mulher mais nova: %d\n", h1+m1);
    } else if (h2 >= h1 && m1 >= m2){
        printf("Idade homem mais velho + idade mulher mais nova: %d\n", h2+m2);
    } else if (h2 >= h1 && m2 >= m1){
        printf("idade homem mais velho + idade mulher mais nova: %d\n", h2+m1);
    }

    if(h1 >= h2 && m1 >= m2){
        printf("Idade homem mais novo * idade mulher mais velha: %d", h2*m1);
    } else if (h1 >= h2 && m2 >= m1){
        printf("Idade homem mais novo * idade mulher mais velha: %d", h2*m2);
    } else if (h2 >= h1 && m1 >= m2){
        printf("Idade homem mais novo * idade mulher mais velha: %d", h1*m1);
    } else if (h2 >= h1 && m2 >= m1){
        printf("Idade homem mais novo * idade mulher mais velha: %d", h1*m2);
    }

    return 0; 

}