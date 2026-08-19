
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





intensidade

int pinoLED = 10;
int potPin = A0;

void setup(){
	
	
	pinMode(pinoLED, OUTPUT);
	

}
void loop(){
	int potReading = analogRead(potPin);

	int intensidade = map(potReading, 0, 1023, 0, 255);

	analogWrite(pinoLED, intensidade);
	}















int verd = 2;
int ama = 3;
int ver = 4;
int portLDR = A0;

void setup(){
	
	pinMode(verd, OUTPUT);
	pinMode(ama, OUTPUT);
	pinMode(ver, OUTPUT);

}

void loop(){
	int analogValue;

	analogValue = analogRead(portLDR);
	// ligar 

	digitalWrite(verd, HIGH);
	if(analogValue < 600){
		
		digitalWrite(verd, LOW);
		digitalWrite(ama, HIGH);
		delay(1000);
		digitalWrite(ama, LOW);
		digitalWrite(ver, HIGH);
		delay(3000);

		digitalWrite(ver, LOW);
		while(analogValue < 600){
		digitalWrite(verd, HIGH);
		}
	}
	}
