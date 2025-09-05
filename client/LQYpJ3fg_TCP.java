package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.DataInput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LQYpJ3fg_TCP {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        socket.setSoTimeout(6000);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();
        // byte[] buffSend = str.getBytes();
        // dos.writeUTF(str);
        // System.out.println(str);

        // DataInputStream dis = new DataInputStream(socket.getInputStream());
        writer.write("B15DCCN999;EC4F899B");
        writer.newLine();
        writer.flush();
        // byte[] eduByte = String.join(" ", eduList).getBytes();
        // dos.write(eduByte);
        String resList = reader.readLine();
        System.out.println(resList);

        socket.close();
    }
}
