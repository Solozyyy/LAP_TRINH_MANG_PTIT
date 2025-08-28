package client;

import java.io.DataInput;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clientUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        System.out.println("Client started");
        byte[] buff = new String("123 12323 321").getBytes();
        // send request packet
        DatagramPacket dpRequest = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"), 2207);
        client.send(dpRequest);

        // receive response packet
        byte[] buffRes = new byte[1024];
        DatagramPacket dpResponse = new DatagramPacket(buffRes, buffRes.length);
        client.receive(dpResponse);
        String strRes = new String(dpResponse.getData());
        System.out.println("Response: " + strRes);
        client.close();
    }
}
