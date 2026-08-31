#include "DHT.h"

#define DHTPIN A1 // variavel que a biblioteca espera
#define DHTTYPE DHT11 // tipo do sensor

DHT dht(DHTPIN, DHTTYPE); //instancia um objeto dht para ser ultilizado

void setup()
{
  Serial.begin(9600);
  delay(1000);
  Serial.println("Inicializando o Sensor DHT");
  dht.begin();
}


void loop(){
  float h = dht.readHumidity();
  float t = dht.readTemperature();

  if(isnan(t) || isnan(h)){
    Serial.println("Failed to read from DHT");
  }

  else{
    Serial.print("Umidade: ");
    Serial.print(h);
    Serial.print(" ");
    Serial.print("Temperatura: ");
    Serial.print(t);
    Serial.println(" C");
  }

  delay(3000);
}