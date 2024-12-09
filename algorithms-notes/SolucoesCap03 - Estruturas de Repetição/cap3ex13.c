#include <stdio.h>
#include <stdlib.h>

int main() {

    int n1;
    int n2;
    int contador2 = 0;
    int contador3 = 0;
    int contador4 = 0;

    printf("N1: ");
    scanf("%d", &n1);

    printf("N2: ");
    scanf("%d", &n2);

    if(n1 >= n2){
        for(int i = n1; i>=n2; i-- ){
            if (i%2==0){
                contador2++;
            }
            if (i%3==0){
                contador3++;
            }
            if (i%4==0){
                contador4++;
            }
            }
        }else{
            for(int i = n2; i>=n1; i-- ){
            if (i%2==0){
                contador2++;
            }
            if (i%3==0){
                contador3++;
            }
            if (i%4==0){
                contador4++;
            }
            }
        }
    

    printf("Multiplos de 2: %d\n", contador2);
    printf("Multiplos de 3: %d\n", contador3);
    printf("Multiplos de 4: %d\n", contador4);
    
    return 0;
}
