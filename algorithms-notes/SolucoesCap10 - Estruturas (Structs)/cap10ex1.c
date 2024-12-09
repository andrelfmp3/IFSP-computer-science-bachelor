#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int dia;
    int mes;
    int ano;
} Data;

//estudar para prova, ex feito pelo david

int comparaData (const Data *d1, const Data *d2);               
void imprimirData (const Data *data);

int main() {
    Data data1;
    Data data2; 

    printf("Data 1\n");
    printf("\tdia: ");
    scanf("%d", &data1.dia);
    printf("\tmes: ");
    scanf("%d", &data1.mes);
    printf("\tano: ");
    scanf("%d", &data1.ano);

    printf("Data 2\n");
    printf("\tdia: ");
    scanf("%d", &data2.dia);
    printf("\tmes: ");
    scanf("%d", &data2.mes);
    printf("\tano: ");
    scanf("%d", &data2.ano);

    if (comparaData (&data1, &data2) <= 0){
        imprimirData(&data1);
        printf(" <= ");
        imprimirData(&data2);
    } else {
        imprimirData(&data2);
        printf(" <= ");
        imprimirData(&data1);
    }

    return 0;

}

int comparaData (const Data *d1, const Data *d2){
    if(d1 -> ano < d2 -> ano){
        return -1;
    } else if (d1 -> ano > d2 -> ano){
        return 1;
    } else if(d1 -> mes < d2 -> mes){
        return -1;
    } else if (d1 -> mes > d2 -> mes){
        return 1;
    } else if(d1 -> ano < d2 -> dia){
        return -1;
    } else if (d1 -> ano > d2 -> dia){
        return 1;
    } else {
        return 0;
    }
}

void imprimirData (const Data *data){
    printf("%02d/%02d/%04d", data->dia, data->mes, data->ano);
}