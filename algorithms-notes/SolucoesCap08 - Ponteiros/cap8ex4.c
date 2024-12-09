#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void decompoeData(int diaDoAno, int ano, int *mes, int *dia);
bool ehBissexto(int ano);

int main() {
    int diaDoAno;
    int ano;
    int mes;
    int dia;

    printf("Dia do ano: ");
    scanf("%d", &diaDoAno);

    printf("Ano: ");
    scanf("%d", &ano);

    decompoeData(diaDoAno, ano, &mes, &dia);

    return 0;
}

void decompoeData(int diaDoAno, int ano, int *mes, int *dia) {
    if (ehBissexto(ano) == false) {
        if (diaDoAno >= 1 && diaDoAno <= 31) {
            *mes = 1;
            *dia = diaDoAno;
        } else if (diaDoAno >= 32 && diaDoAno <= 59) {
            *mes = 2;
            *dia = diaDoAno - 31;
        } else if (diaDoAno >= 60 && diaDoAno <= 90) {
            *mes = 3;
            *dia = diaDoAno - 59;
        } else if (diaDoAno >= 91 && diaDoAno <= 120) {
            *mes = 4;
            *dia = diaDoAno - 90;
        } else if (diaDoAno >= 121 && diaDoAno <= 151) {
            *mes = 5;
            *dia = diaDoAno - 120;
        } else if (diaDoAno >= 152 && diaDoAno <= 181) {
            *mes = 6;
            *dia = diaDoAno - 151;
        } else if (diaDoAno >= 182 && diaDoAno <= 212) {
            *mes = 7;
            *dia = diaDoAno - 181;
        } else if (diaDoAno >= 213 && diaDoAno <= 243) {
            *mes = 8;
            *dia = diaDoAno - 212;
        } else if (diaDoAno >= 244 && diaDoAno <= 273) {
            *mes = 9;
            *dia = diaDoAno - 243;
        } else if (diaDoAno >= 274 && diaDoAno <= 304) {
            *mes = 10;
            *dia = diaDoAno - 273;
        } else if (diaDoAno >= 305 && diaDoAno <= 334) {
            *mes = 11;
            *dia = diaDoAno - 304;
        } else if (diaDoAno >= 335 && diaDoAno <= 365) {
            *mes = 12;
            *dia = diaDoAno - 334;
        }
    } else {
        if (diaDoAno >= 1 && diaDoAno <= 31) {
            *mes = 1;
            *dia = diaDoAno -1;
        } else if (diaDoAno >= 32 && diaDoAno <= 60) {
            *mes = 2;
            *dia = diaDoAno - 32;
        } else if (diaDoAno >= 61 && diaDoAno <= 91) {
            *mes = 3;
            *dia = diaDoAno - 60;
        } else if (diaDoAno >= 92 && diaDoAno <= 121) {
            *mes = 4;
            *dia = diaDoAno - 91;
        } else if (diaDoAno >= 122 && diaDoAno <= 152) {
            *mes = 5;
            *dia = diaDoAno - 121;
        } else if (diaDoAno >= 153 && diaDoAno <= 182) {
            *mes = 6;
            *dia = diaDoAno - 152;
        } else if (diaDoAno >= 183 && diaDoAno <= 213) {
            *mes = 7;
            *dia = diaDoAno - 182;
        } else if (diaDoAno >= 214 && diaDoAno <= 244) {
            *mes = 8;
            *dia = diaDoAno - 213;
        } else if (diaDoAno >= 245 && diaDoAno <= 274) {
            *mes = 9;
            *dia = diaDoAno - 244;
        } else if (diaDoAno >= 275 && diaDoAno <= 305) {
            *mes = 10;
            *dia = diaDoAno - 274;
        } else if (diaDoAno >= 306 && diaDoAno <= 335) {
            *mes = 11;
            *dia = diaDoAno - 305;
        } else if (diaDoAno >= 336 && diaDoAno <= 366) {
            *mes = 12;
            *dia = diaDoAno - 335;
        }
    }
    printf("O dia %d do ano %d cai no dia %d do mes %d.\n", diaDoAno, ano, *dia, *mes);
}

bool ehBissexto (int ano){
    if( ano%400 == 0 || ano%4 == 0 && ano%100 != 0){
        return true;
    } else {
        return false;
    }
}