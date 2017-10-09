package studio6;

import java.io.IOException;

import jssc.SerialPortException;
import studio6.SerialComm;

public class MainForStudio6 {

	public static void main(String[] args) throws IOException, SerialPortException {
		// TODO Auto-generated method stub
		SerialComm port = new SerialComm ("/dev/cu.usbserial-DN02B9TV");
while(true){ 
	byte b;
	if(port.available()){
		b = port.readByte();
		System.out.print((char) b);
	}
}
	
	
	}

}
