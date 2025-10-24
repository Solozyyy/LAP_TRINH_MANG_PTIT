package client.DSA;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BienThien {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("203.162.10.109", 2207);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(",");
        int cnt = 0, c = 0, check = 0;
        int t = Integer.parseInt(tmp[1]) - Integer.parseInt(tmp[0]);
        cnt += Math.abs(Integer.parseInt(tmp[1]) - Integer.parseInt(tmp[0]));
        if (t < 0) {
            check = -1;
        } else if (t > 0) {
            check = 1;
        }
        for (int i = 2; i < tmp.length; ++i) {
            int t1 = Integer.parseInt(tmp[i]) - Integer.parseInt(tmp[i - 1]);
            System.out.println(t1 + " " + cnt);
            cnt += Math.abs(t1);
            if (t1 < 0 && check > 0) {
                check = -1;
                c++;
            } else if (t1 > 0 && check < 0) {
                check = 1;
                c++;
            }
        }
        System.out.println(cnt);
        System.out.println(c);
    }
}
