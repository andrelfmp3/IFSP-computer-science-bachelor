import random
import pandas as pd

def lancaDado(n):
    
    dado1 = 0
    dado2 = 0 
    dado3 = 0
    dado4 = 0   
    dado5 = 0
    dado6 = 0                 

    for i in range(n):
        dado = random.randint(1, 6)
        if dado == 1:
            dado1 +=1
        elif dado == 2:
            dado2 +=1   
        elif dado == 3:
            dado3 +=1
        elif dado == 4:
            dado4 +=1
        elif dado == 5:
            dado5 +=1
        elif dado == 6:
            dado6 +=1
    print(f"Dado 1: {dado1}, Probabilidade: {dado1/n}")
    print(f"Dado 2: {dado2}, Probabilidade: {dado2/n}")
    print(f"Dado 3: {dado3}, Probabilidade: {dado3/n}")
    print(f"Dado 4: {dado4}, Probabilidade: {dado4/n}")
    print(f"Dado 5: {dado5}, Probabilidade: {dado5/n}")
    print(f"Dado 6: {dado6}, Probabilidade: {dado6/n}") 
    
print("Lança dado 100 vezes: ")
lancaDado(100)

print("\n")
    
print("Lança dado 1000 vezes: ")    
lancaDado(1000) 
