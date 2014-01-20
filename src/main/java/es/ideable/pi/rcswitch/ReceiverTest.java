package es.ideable.pi.rcswitch;

import com.pi4j.io.gpio.RaspiPin;

public class ReceiverTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Iniciando RCSwitch en el GPIO02...");
		RCSwitchReceiver receiver = new RCSwitchReceiver(RaspiPin.GPIO_02);
		System.out.println("RCSwitch inicializado. Esperando datos...");
		
		while (true) {
			if (receiver.available()) {
				int value = receiver.getReceivedValue();
	
				if (value == 0) {
					System.out.println("Unknown encoding");
				} else {
					System.out.print("Received ");
					System.out.print(receiver.getReceivedValue());
					System.out.print(" / ");
					System.out.print(receiver.getReceivedBitlength());
					System.out.print("bit ");
					System.out.print("Protocol: ");
					System.out.println(receiver.getReceivedProtocol());
				}
	
				receiver.resetAvailable();
			} else {
//				System.out.println("-");
			}
//	        Thread.sleep(500);
		}
	}

}
