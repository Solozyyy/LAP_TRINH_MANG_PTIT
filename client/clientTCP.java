package client;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class clientTCP {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("192.168.1.15", 2207);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        dos.writeInt(a);
        dos.writeInt(b);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int sum = dis.readInt();
        System.out.println("sum: " + sum);
    }
}
