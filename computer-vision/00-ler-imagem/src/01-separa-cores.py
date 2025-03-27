import cv2
import matplotlib.pyplot as plt

imagem = cv2.imread(r'C:\Users\Samsung\Documents\GitHub\IFSP-computer-science-bachelor\computer-vision\opencv\data\bat.jpg')

blue, green, red = cv2.split(imagem)

imagens = [imagem, blue, green, red]
rotulos = ["original", "blue", "green", "red"]

fig, eixo = plt.subplots(2,2) # cria uma grade 2x2
fig.canvas.manager.set_window_title("Exemplo de split")

# eixo.ravel() transforma a grade em um array 1D
for ex, img, rotulo in zip(eixo.ravel(), imagens, rotulos):
    
    ex.imshow(img) # exibe imagem usando matplotlib
    ex.set_xticks([])
    ex.set_yticks([])
    ex.set_xlabel(rotulo, fontsize=10)

plt.tight_layout() # ajusta layout, evita sobreposição
plt.show()