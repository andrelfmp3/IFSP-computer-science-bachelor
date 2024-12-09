#include <stdio.h>
#include <stdlib.h>

void pInterno( const double *a1, const double *a2, double *pi, int n );

int main () {

    double a1[5];
    double a2[5];
    double pi[5]; //produto interno
    int n = 5;

    for(int i = 0; i < 5; i++){
        printf("a1[%d]: ", i);
        scanf("%lf", &a1[i]);
    }

    for(int i = 0; i < 5; i++){
        printf("a2[%d]: ", i);
        scanf("%lf", &a2[i]);
    }

    pInterno(a1, a2, pi, n );

    return 0;

}

void pInterno( const double *a1, const double *a2, double *pi, int n ){
    for(int i = 0; i < n; i++){
        pi[i] = a1[i]*a2[i];
    }

    for(int i = 0; i < n; i++){
        printf("%.2f x %.2f = %.2f\n", a1[i], a2[i], pi[i]);
    }
}