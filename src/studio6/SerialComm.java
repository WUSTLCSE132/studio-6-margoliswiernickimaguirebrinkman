package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug; // Indicator of "debugging mode"

	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		debug = false; // Default is to NOT be in debug mode
	}

	// TODO: Add writeByte() method that you created in Studio 5

	public void writeByte(String b) {
		try {
			if (debug == false) {
				for (int i = 0; i < b.length(); ++i) {
					port.writeByte((byte) b.charAt(i));
				}
			}
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public boolean available() throws SerialPortException{ 
		if (port.getInputBufferBytesCount() > 0){
			return true; 
		}
		else return false; 
	}
	public byte readByte() throws SerialPortException{
		byte b[] = {}; 
		b = port.readBytes(1);	
		if(debug == true){
			System.out.println("0x" + String.format("%2x ", b[0]));
		}
		return b[0]; 
	}
}

// TODO: Add writeByte() method from Studio 5

// TODO: Add available() method

// TODO: Add readByte() method

// TODO: Add a main() method
