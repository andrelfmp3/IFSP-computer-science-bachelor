// Andre Lyra Fernandes - RESOLVIDO

#include <stdlib.h>
#include <stdio.h>

// Declaração dos métodos
int Combina(int n, int k);

int main() {

    int total; 
    int escolha;  

    printf("Total de pessoas(k): ");
    scanf("%d", &total);

    
    printf("Numero de pessoas escolhidas(n): ");
    scanf("%d", &escolha);
    
    printf("O numero de combinacoes C(n, k) = C(%d,%d) = %d\n", total, escolha, Combina(total, escolha));
    
    return 0;
    
}

// Função para calcular combinações 
int Combina(int n, int k) {
    if (k == 0 || k == n){
        return 1;
    }    
    int resultado = 1;  
    for (int i = 0; i < k; i++) {
        resultado *= (n - i);  
        resultado /= (i + 1);  
    }
    return resultado; 
}
