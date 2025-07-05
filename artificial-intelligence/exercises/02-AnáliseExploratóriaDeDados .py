from ursina import *

app = Ursina()

player = Entity(model='cube', color=color.orange, scale=(1,2,1), collider='box')
ground = Entity(model='plane', scale=64, texture='grass', collider='box')

camera.parent = player
camera.position = (0, 6, -15)
camera.rotation_x = 15

speed = 5s

def update():
    move = Vec3(
        held_keys['d'] - held_keys['a'],
        0,
        held_keys['w'] - held_keys['s']
    ).normalized() * time.dt * speed

    player.position += move

app.run()
