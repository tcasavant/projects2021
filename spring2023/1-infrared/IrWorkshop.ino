#include <IRremote.hpp>

// Define pins for sending and receiving
const int RECV_PIN = 2;

const int SEND_PIN = 3;

void setup(){
  Serial.begin(115200);

  // Begin sending and receiving
  IrReceiver.begin(RECV_PIN, ENABLE_LED_FEEDBACK);
  IrSender.begin(SEND_PIN);
  
}


// Define address and command for sending data
uint16_t address = 0x1;
uint8_t command = 0x1;

void loop(){

  // Send command
  IrSender.sendNEC(address, command, 0);
  delay(1000);
  

  // Decode received data if there is any
  if (IrReceiver.decode()){

    // Uncomment this line to print address, command, and protocol of received data
    // Also see the IRremote SimpleReceiver example code to do this
    //IrReceiver.printIRResultShort(&Serial);

    // Check if received command is equal to the sent command
    if (IrReceiver.decodedIRData.command == command){
      Serial.println("Command received");
    }
    else{
      Serial.println("Different command received");
    }
    
    // Begin receiving again
    IrReceiver.resume();
  }
  // Else if no data was received, begin receiving again
  else{
    Serial.println("No data received");
    IrReceiver.resume();
  }
  
}
