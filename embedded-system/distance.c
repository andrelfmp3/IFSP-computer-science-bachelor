int trigPin = 4;
int echoPin = 5;

int led = 2;

void setup() {
  Serial.begin(9600);

  pinMode(led, OUTPUT);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
}

void loop() {
  float distanceCentimeters;
  int pulseLenMicroseconds;

  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);

  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  pulseLenMicroseconds = pulseIn(echoPin, HIGH);

  distanceCentimeters = pulseLenMicroseconds / 29.387 / 2;

  Serial.print("Distancia: ");
  Serial.print(distanceCentimeters);
  Serial.println(" cm");

  if (distanceCentimeters > 0 && distanceCentimeters < 75) {

    int velocidade = map(distanceCentimeters, 1, 75, 50, 500);

    digitalWrite(led, HIGH);
    delay(velocidade);

    digitalWrite(led, LOW);
    delay(velocidade);

  } else {
    digitalWrite(led, LOW);
    delay(100);
  }
}
