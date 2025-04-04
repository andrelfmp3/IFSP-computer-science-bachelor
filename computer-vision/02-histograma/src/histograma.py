import cv2
import numpy as np
import matplotlib.pyplot as plt

# Carregar a imagem em escala de cinza
imagemTonsCinza = cv2.imread(r'C:\Users\Samsung\Documents\GitHub\IFSP-computer-science-bachelor\computer-vision\02-histograma\data\imagem0.jpg', cv2.IMREAD_GRAYSCALE)

histograma = cv2.calcHist([imagemTonsCinza], [0], None, [256], [0, 256])

# Plotar o histograma
plt.figure()

# Cordenadas
plt.title("Histograma de Intensidade")
plt.xlabel("Intensidade do Pixel")
plt.ylabel("Número de Pixels")

plt.plot(histograma, color='red')
plt.show()
