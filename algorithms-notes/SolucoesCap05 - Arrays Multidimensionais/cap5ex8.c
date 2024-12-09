#include <stdio.h>
#include <stdlib.h>

int main(){
    int array[100][100] = {0};
    int num;
    int linhat = (int)(sizeof(array)/sizeof(array[0]));
    int colunat = (int)(sizeof(array[0])/sizeof(array[0][0]));
    
    printf("Numero entre 1 e 100: ");
    scanf("%d", &num);
    printf("\n");

    if(num <= 0 || num >100){
        printf("Numero incorreto!");
    }else{
        for(int i = 0; i < num; i++){ 
            for(int j = i; j < num - i; j++){
                for(int k = i; k < num - i; k++){
                    array[j][k]++;
                }
            }  
        }

        for(int i = 0; i < num; i++){ 
            for(int j = 0; j < num; j++){
                if(j == num - 1){
                    printf("%3d",array[i][j]);
                    printf("\n");
                }else{
                    printf("%3d ",array[i][j]);
                }
            }  
        }

    }
    return 0;
}