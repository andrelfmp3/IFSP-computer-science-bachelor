import cv2
camera = cv2.VideoCapture(0)

if not camera.isOpened():
    print("Erro: Não foi possível acessar a câmera")
    exit()

while True:
    ret, frame = camera.read()
    if not ret:
        print("Erro: Não foi possível capturar o frame")
        break

    cv2.imshow("Camera", frame)

    key = cv2.waitKey(1) & 0xFF
    if key == ord('q'):
        break
    
    frame_width = camera.get(cv2.CAP_PROP_FRAME_WIDTH)
    frame_height = camera.get(cv2.CAP_PROP_FRAME_HEIGHT)
    fps = camera.get(cv2.CAP_PROP_FPS)

    print(f"Width: {frame_height}; Height: {frame_height}; FPS: {fps}")

camera.release()
cv2.destroyAllWindows()