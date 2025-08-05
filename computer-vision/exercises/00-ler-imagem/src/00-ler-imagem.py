import cv2

imagem = cv2.imread(r'C:\Users\Samsung\Documents\GitHub\IFSP-computer-science-bachelor\computer-vision\opencv\data\bat.jpg')


dimensoes = imagem.shape
num_elementos = imagem.size
tipo_imagem = imagem.dtype

print(f"Dimensão: {dimensoes}")
print(f"Tamanho.: {num_elementos}")
print(f"Tipo....: {tipo_imagem}")

# exibe imagem
cv2.imshow("Imagem", imagem)
cv2.waitKey(0)

# acessando um pixel
pixel = imagem[20, 30] # [b g r] => (3,)

(b, g, r) = imagem[20, 30] # 3 variáveis

blue = imagem[20, 30, 0] # canal 0
green = imagem[20, 30, 1] # canal 1
red = imagem[20, 30, 2] # canal 2

# alterando o valor de um pixel
imagem[20,30] = (0, 0, 255)
imagem[20, 30, 0] = 100 # [y, x, canal]

# obter um trecho da imagem
topo_superior = imagem[0:50, 0:50] # Python, Numpy