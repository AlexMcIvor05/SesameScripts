#include <Servo.h>
#include <AFMotor.h>

Servo myservo;  // create Servo object to control a servo
AF_Stepper motor(48, 1);

int currentPos = 0;    // variable to store the servo position
int pos = 0;
char receivedChar;
boolean newData = false;

void setup() {
    myservo.attach(9);  // attaches the servo on pin 9 to the Servo object
    Serial.begin(9600);

    motor.setSpeed(10);  // 10 rpm   

}

void loop() {
    recvOneChar();
    showNewData();
    
}

void recvOneChar() {
    if (Serial.available() > 0) {
        receivedChar = Serial.read();
        newData = true;
    }
}


void showNewData() {

  if(newData == true){
    //serial.print(receivedChar);
    if(receivedChar == char('d')){
      currentPos = myservo.read();
      for (pos = currentPos ; pos <= currentPos+20; pos += 1) { // goes from 0 degrees to 180 degrees
      // in steps of 1 degree
      if(pos == 90){
        return;
      }
       myservo.write(pos);              // tell servo to go to position in variable 'pos'
       delay(10);                       // waits 15 ms for the servo to reach the position
      }
    }
    if(receivedChar == char('u')){
      currentPos = myservo.read();

      for (pos = currentPos ; pos >= currentPos-20; pos -= 1) { // goes from 0 degrees to 180 degrees
      // in steps of 1 degree
      if(pos == 0){
        return;
      }
       myservo.write(pos);              // tell servo to go to position in variable 'pos'
       delay(10);                       // waits 15 ms for the servo to reach the position
      }
    }
  
    if(receivedChar == char('l')){
        motor.step(10, FORWARD, MICROSTEP); 

    }
    if(receivedChar == char('r')){
        motor.step(10, BACKWARD, MICROSTEP); 

    }
    newData = false;
    receivedChar = NULL;
  }
}