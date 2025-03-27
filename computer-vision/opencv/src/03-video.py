import cv2
video = cv2.VideoCapture(r'C:\Users\Samsung\Documents\GitHub\IFSP-computer-science-bachelor\computer-vision\opencv\data\nirvana.mp4')

if not video.isOpened():
    print("Erro: Não foi possível acessar a câmera")
    exit()

while True:
    ret, frame = video.read()
    if not ret:
        print("Erro: Não foi possível capturar o frame")
        break

    cv2.imshow("Camera", frame)

    key = cv2.waitKey(1) & 0xFF
    if key == ord('q'):
        break
    
    frame_width = video.get(cv2.CAP_PROP_FRAME_WIDTH)
    frame_height = video.get(cv2.CAP_PROP_FRAME_HEIGHT)
    fps = video.get(cv2.CAP_PROP_FPS)

    print(f"Width: {frame_height}; Height: {frame_height}; FPS: {fps}")

video.release()
cv2.destroyAllWindows()