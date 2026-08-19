int LedRedPin = 5;
int LedYellowPin = 4;
int LedGreenPing = 3;
int LedWhitePin = 2;

void toggleLed(int LEDPin){ # nao acabadao
	digitalWrite(LEDpin, !digitalRead(LEDPin)
}

void setup(){
	Serial.begin(9600);
	
	pinMode(LEDRedPin, OUTPUT);
	pinMode(LEDYellowPin, OUTPUT);
	pinMode(LEDGreenPin, OUTPUT);
	pinMode(LEDRWhitePin, OUTPUT);

}

void loop(){
	if(Serial.available() > 0)
	{
	
	int inByte = Serial.read();
	
	switch (inByte){
		case 'r':
			toggleLed(LEDRedPin);
			break;
		case 'y':
			toggleLed(LEDYellowPin);
			break;
		case 'g':
			toggleLed(LEDGreenPin);
			break;
		case 'w':
			toggleLed(LEDWhitePin);
			break;
		default:
			toggleLed(LEDRedPin);
			toggleLed(LEDYellowPin);
			toggleLed(LEDGreenPin);
			toggleLed(LEDWhitePin);
			break;
	}
}
