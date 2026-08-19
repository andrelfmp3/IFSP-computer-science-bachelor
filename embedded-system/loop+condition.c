
int potPin = A0; // pin analogico

int ledPins[] = {2, 3, 4, 5, 6, 7);

int ledCount = sizeof(ledPins) / sizeof(int);

void setup(){

	for (int thisLed = 0; thisLed < ledCount; thisLed++) {
		pinMode(ledPins[thisLed], OUTPUT);
	}
	
}

void loop(){

	int potReafing = analogRead(potPin);
	int ledLevel = map(potReading, 0, 1023, 0, ledCount);
	
	for (int thisLed = 0; thisLed < ledCount; thisLed++){
		if (thisLEd < ledLEvel) {
			digitalWrite(ledPins[thisLed], HIGH);	
		} else {
			digitalWrite(ledPins[thisLed], LOW);
		}
	}


	}
}
