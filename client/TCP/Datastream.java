package client.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Datastream {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("203.162.10.109", 2207);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String req = "B22DCDT172;omU6m3yv";
        dos.writeUTF(req);

        int n = dis.readInt();
        System.out.println(n);

        String res = "";
        while (n != 0) {
            res += n % 2;
            n /= 2;
        }
        StringBuilder sb = new StringBuilder(res);
        sb.reverse();
        System.out.println(sb.toString());
        dos.writeUTF(sb.toString());
        dis.close();
        dos.close();
        client.close();
    }
}
