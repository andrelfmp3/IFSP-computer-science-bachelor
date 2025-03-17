'''
8. Faça o algoritmo para calcular o valor a ser pago pelo período de estacionamento
do automóvel (PAG). O usuário entra com os seguintes dados: hora (HE) e minuto (ME) de
entrada, hora (HS) e minuto (MS) de saída. Sabe-se que este estacionamento cobra R$ 4,00,
mas calcula as frações de hora também. Por exemplo, se a pessoa ficar 1 hora e quinze minutos,
pagará R$ 5,00 (R$ 4,00 pela hora e R$ 1,00 pelos quinze minutos).
'''

he = float(input("Hora de entrada: "))
me = float(input("Minuto de entrada: "))
hs = float(input("Hora de saída: "))
ms = float(input("Minuto de saída: "))

em = he * 60 + me # entrada em minutos totais
sm = hs * 60 + ms # saida em minutos totais

totalMinutos = (sm - em) * 0.06 # 4 / 60, "reais por minuto"

print(f"Total a se gastar aproximado: {totalMinutos}")

