import cv2

imagem = cv2.imread(r'C:\Users\Samsung\Documents\GitHub\IFSP-computer-science-bachelor\computer-vision\00-ler-imagem\data\bat.jpg')


dimensoes = imagem.shape
num_elementos = imagem.size
tipo_imagem = imagem.dtype

print(f"Dimensão: {dimensoes}")
print(f"Tamanho.: {num_elementos}")
print(f"Tipo....: {tipo_imagem}")

# exibe imagem
cv2.imshow("Imagem", imagem)
cv2.waitKey(0)