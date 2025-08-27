import random;

qntdChuva = 0
qntdChuvaRaio = 0

def preverTempo():
    
    global qntdChuva
    global qntdChuvaRaio
    
    num1 = random.randint(1,100)
    if num1 > 60:
        qntdChuva += 1
        
        num2 = random.randint(1,100)
        if num2 > 70:
            qntdChuvaRaio += 1
            
    print("Quantidade de dias apenas com chuva: ", qntdChuva - qntdChuvaRaio) 
    print("Quantidade de dias com chuva e raio: ", qntdChuvaRaio)
    print("")
            
for i in range(100000): # preve 100 dias
    preverTempo()