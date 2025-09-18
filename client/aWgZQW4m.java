package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class aWgZQW4m {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2207);
        String req = "B22DCDT172;aWgZQW4m";
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(req);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        int k = dis.readInt();
        System.out.println("k:" + k);
        String r = dis.readUTF();
        System.out.println(r);
        String[] s = r.split(",");
        // Scanner sc = new Scanner(System.in);
        // String[] s = sc.nextLine().split(",");
        String res = "";
        int l = 0;
        ArrayList<String> str = new ArrayList<>();
        for (String x : s) {
            str.add(x);
            l++;

            if (l == k) {
                Collections.reverse(str);
                for (String y : str) {
                    res += y + ",";
                }
                str.clear();
                // System.out.println(res);
                l = 0;

            }
            // System.out.println(x);
        }
        if (!str.isEmpty()) {
            Collections.reverse(str);
            for (String x : str) {
                res += x + ",";
            }
        }
        StringBuilder tmp = new StringBuilder(res);
        tmp.deleteCharAt(res.length() - 1);
        System.out.println(tmp.toString());
        dos.writeUTF(tmp.toString());

        dos.close();
        dis.close();
        client.close();
    }
}