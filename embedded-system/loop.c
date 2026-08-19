void setup(){

	for (int pin = 5; pin < 11; pin++) {
		pinMode(pin, OUTPUT);
	}
	
}

void loop(){
	for(int i = 5; i < 11; i++){
			digitalWrite(i, HIGH);
			delay(100);
			digitalWrite(i, LOW);
	}
	for(int i = 9; i >=5 ; i--){
			digitalWrite(i, HIGH);
			delay(100);
			digitalWrite(i, LOW);
	}
}
