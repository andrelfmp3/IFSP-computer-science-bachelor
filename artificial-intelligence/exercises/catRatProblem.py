import tkinter as tk
import math

x_cat = 0
y_cat = 0

dim = 25  # dimensão de cada

x_rat = 400
y_rat = 300

contadorGato = 0

def calculaDistanciaEuclidiana():
    distanciaEuclidiana = round(math.sqrt(((x_cat - x_rat) ** 2) + ((y_cat - y_rat) ** 2)), 4)
    if distanciaEuclidiana > 10:
        print(f"\nA distancia euclidiana é {distanciaEuclidiana} e o gato não perseguirá o rato (maior que 10)" )
    else:
        print(f"\nA distancia euclidiana é {distanciaEuclidiana} e o gato persequirá o rato (menor que 10)")

def calculaDistanciaXeY():
    distanciaX = abs(x_cat - x_rat)
    print(f"A distancia X gato e rato é {distanciaX}")
    distanciaY = abs(y_cat - y_rat)
    print(f"A distancia Y gato e rato é {distanciaY}")

def exibirCaminhoGatoRato(): # apenas desenhar caminho, linha reta entre pontos. apagar a anterior
    canvas.create_line(x_cat + 20, y_cat + 20, x_rat + 20, y_rat + 20, fill="white")
    

def drawCat():
    canvas.delete("cat")
    canvas.create_oval(x_cat, y_cat, x_cat+dim, y_cat+dim, fill="yellow", outline="yellow", tags="cat")

def drawRat():
    canvas.delete("rat")
    canvas.create_oval(x_rat, y_rat, x_rat+dim, y_rat+dim, fill="red", outline="red", tags="rat")

def moveCat():
    global x_cat
    if x_cat <= 500-dim:
        x_cat += 5

def moveRat():
    import random as rand
    x_rand = rand.randint(-10, 10)
    y_rand = rand.randint(-10, 10)
    global x_rat, y_rat
    x_rat += x_rand
    y_rat += y_rand

def play():
    """Desenha e move os objetos na tela"""
    drawCat()
    drawRat()
    moveRat()
    moveCat()
    exibirCaminhoGatoRato()
    calculaDistanciaEuclidiana()
    calculaDistanciaXeY()
    root.after(1000, play)  # Chama novamente após 1000ms. ALTERADO PARA MAIOR LEGIBILIDADE


if __name__ == "__main__":    
    
    root = tk.Tk()
    root.title("Agent")
    canvas = tk.Canvas(root, width=500, height=500, bg="black")
    canvas.pack()
    play()
    root.mainloop()
