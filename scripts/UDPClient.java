/*
	Java client with UDP socket to request server to change message to
	all upper case characters
	
	C:\....> javac UDPClient.java
	C:\....> java UDPClient
*/
import java.io.*;
import java.net.*;

public class UDPClient {
	public static void main(String args[]) {
		DatagramSocket clientSocket = null;
		int port = 12000; // in case port 12000 is already used by another server
		String sentence;
		BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));

		try {
			clientSocket = new DatagramSocket();
			InetAddress host = InetAddress.getByName("localhost");

			while (true) {
				// get input and send the packet
				System.out.println("\nInput lowercase sentence:\n");
				sentence = (String) cin.readLine();
				byte[] b = sentence.getBytes();
				DatagramPacket dp = new DatagramPacket(b, b.length, host, port);
				clientSocket.send(dp);

				// now receive reply
				byte[] buffer = new byte[65536];
				DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
				clientSocket.receive(reply);
				byte[] data = reply.getData();
				sentence = new String(data, 0, reply.getLength());
				System.out.println(sentence);
			}
		} catch (IOException e) {
			System.err.println("IOException " + e);
		}
	}
}
