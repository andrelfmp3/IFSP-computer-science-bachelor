#include <stdio.h>
#include <stdlib.h>

void somatorioMedia (float a[], int n, float *somatorio, float *media);

int main() {

    float array[10];
    float somatorio;
    float media;
    float n = 10; //quantidade de valores

    for(int i = 0; i < 10; i++){
        printf("n[%d]: ", i);
        scanf("%f", &array[i] );
    }

        somatorioMedia(array, n, &somatorio, &media);

    return 0; 

}

void somatorioMedia (float a[], int n, float *somatorio, float *media){
    for(int i = 0; i < 10; i++){
        *somatorio = *somatorio + a[i];
    }

    *media = *somatorio/n;

    printf("Somatorio: %.2f\n", *somatorio);
    printf("Media: %.2f", *media);
}
