#include <stdio.h>
#include <stdlib.h>

int main() {

    float n1;

    printf("Entre com um valor: ");
    scanf("%f", &n1);

    float n2;
    float n3;

    n2 = n1/2;
    n3 = n1*3;

    if (n1 >= 20) {
        printf("A metade de %.2f e %.2f", n1, n2);
    } else if (n1 <= 20){
        printf ("O triplo de %.2f e %.2f", n1, n3);
    }


    return 0; 

}

