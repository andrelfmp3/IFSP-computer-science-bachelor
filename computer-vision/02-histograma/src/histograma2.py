import cv2
import numpy as np
import matplotlib.pyplot as plt

# Carregar as imagens em escala de cinza
imagem1 = cv2.imread(r'C:\Users\Samsung\Documents\GitHub\IFSP-computer-science-bachelor\computer-vision\02-histograma\data\imagem1.jpg', cv2.IMREAD_GRAYSCALE)
imagem2 = cv2.imread(r'C:\Users\Samsung\Documents\GitHub\IFSP-computer-science-bachelor\computer-vision\02-histograma\data\imagem2.jpg', cv2.IMREAD_GRAYSCALE)

# Calcular os histogramas das imagens originais
histograma1_original = cv2.calcHist([imagem1], [0], None, [256], [0, 256])
histograma2_original = cv2.calcHist([imagem2], [0], None, [256], [0, 256])

# Equalizar as imagens
imagem1_eq = cv2.equalizeHist(imagem1)
imagem2_eq = cv2.equalizeHist(imagem2)

histograma1_eq = cv2.calcHist([imagem1_eq], [0], None, [256], [0, 256])
histograma2_eq = cv2.calcHist([imagem2_eq], [0], None, [256], [0, 256])

# Plotar os histogramas
plt.figure()

plt.title("Comparação de Histogramas")
plt.xlabel("Intensidade do Pixel")
plt.ylabel("Número de Pixels")

# Histogramas originais
plt.plot(histograma1_original, color='red', label='Imagem 1 Original')
plt.plot(histograma2_original, color='blue', label='Imagem 2 Original')

# Histogramas equalizados
plt.plot(histograma1_eq, color='orange', label='Imagem 1 Equalizada')
plt.plot(histograma2_eq, color='purple', label='Imagem 2 Equalizada')

plt.legend()
plt.show()
