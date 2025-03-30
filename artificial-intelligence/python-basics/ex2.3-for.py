'''
Exiba os seguintes valores na tela:
a. 0 1 2 3 4 5 6 7 8 9 10
b. 10 9 8 7 6 5 4 3 2 1
c. 0 1 4 9 16 25 36 49 64 81 100
d. 1 2 3 4 5 10 20 30 40 50
'''

fruits = ["apple", "banana", "cherry"]
for x in fruits: # x = valor de cada coisa na lista
  print(x)
  
print()
  
letras = ["a", "b", "c", "ad", "ea"]
newlist = [x for x in letras if "a" in x]  
print(newlist)

for i in range(11): 
    print(i, end=" ")
print()

for i in range(11,0,-1): 
    print(i, end=" ")
print()
    
for i in range(11):  
    print(i**2, end=" ")  # Imprime o quadrado de i (similar ao proposto)
print()

for i in range(11):  # De 1 a 10
    print(i*5, end=" ")  # Imprime o múltiplo de 5 (similar ao proposto)

     
