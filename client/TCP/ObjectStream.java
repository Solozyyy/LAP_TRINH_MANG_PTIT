package client.TCP;

import TCP.Customer;
import java.net.*;
import java.io.*;

/**
 *
 * @author Admin
 */
public class ObjectStream {

    public static String chTen(String s) {
        String res = "";
        String[] tmp = s.split(" ");
        res += tmp[tmp.length - 1].toUpperCase() + ", ";
        for (int i = 0; i < tmp.length - 1; ++i) {
            res += Character.toUpperCase(tmp[i].charAt(0));
            res += tmp[i].substring(1, tmp[i].length()).toLowerCase() + " ";
        }
        StringBuilder sb = new StringBuilder(res);
        sb.deleteCharAt(res.length() - 1);
        return sb.toString();
    }

    public static String chNgay(String s) {
        String res = "";
        String[] tmp = s.split("\\-");
        res += tmp[1] + "/" + tmp[0] + "/" + tmp[2];
        return res;
    }

    public static String chCode(String s) {
        String[] tmp = s.split(" ");
        String res = "";
        for (int i = 0; i < tmp.length - 1; ++i) {
            res += tmp[i].charAt(0);
        }
        res += tmp[tmp.length - 1];
        return res;
    }

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("203.162.10.109", 2209);
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        String req = "B22DCDT172;5vwHYJkp";
        oos.writeObject(req);
        oos.flush();

        Customer c = (Customer) ois.readObject();
        String tmp = c.name.toLowerCase();
        c.name = chTen(c.name);
        c.dayOfBirth = chNgay(c.dayOfBirth);
        c.userName = chCode(tmp);
        System.out.println(c);
        oos.writeObject(c);
        ois.close();
        oos.close();
        client.close();
    }
}
