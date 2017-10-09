const int buttonPin = 2;
int buttonState;
unsigned long lastDebounceTime = 0;  // the last time the output pin was toggled
unsigned long debounceDelay = 150;
unsigned long currentTime; 
int num;
unsigned long nextSecond; 
int seconds = 0 ;
void buttonPressed() {
  if(currentTime > lastDebounceTime){
    num++;
    Serial.print("Push #: "); 
    Serial.println(num);
    lastDebounceTime = currentTime + debounceDelay; 
  }
  
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, FALLING);
  Serial.begin(9600);
}

void loop() {
currentTime = millis(); 
 
if(currentTime > nextSecond){
 seconds += 1; 
  Serial.println(seconds);
  nextSecond += 1000;  
}
}
