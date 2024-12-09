#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

typedef struct{
    int dia;
    int mes;
    int ano;
} Data;

int diaDoAno (const Data *data);
bool ehBissexto (int ano);

int main() {

    Data data;
    int diasAnos;

    printf("dia: ");
    scanf("%d", &data.dia);

    printf("mes: ");
    scanf("%d", &data.mes);

    printf("ano: ");
    scanf("%d", &data.ano);

    diasAnos = diaDoAno(&data);
    printf("O dia do ano da data %02d/%02d/%02d eh %02d.", data.dia, 
    data.mes, data.ano, diasAnos);

    return 0;
}

int diaDoAno (const Data *data){

    int diasPorMes[12] = {31, 28, 31, 20, 31, 30, 31, 31, 30, 31, 30, 31};
    int diaAno = 0;

    if(ehBissexto(data->ano) == true){
        diasPorMes[1] = 29;
    }

    for(int i = 0; i < (data->mes)-1; i++){
        diaAno += diasPorMes[i];
    }

    diaAno += data->dia;
    return diaAno;

}

bool ehBissexto (int ano){

    if ( ano % 4 == 0) {
        return true;
    } else {
        return false;
    }

}