package client.UDP;

import java.net.*;

public class XOUpPF8g {

    public static String chuanHoa(String s) {
        String tmp = "";
        tmp += Character.toUpperCase(s.charAt(0));
        for (int i = 1; i < s.toCharArray().length; ++i) {
            tmp += Character.toLowerCase(s.charAt(i));
        }
        tmp += " ";
        return tmp;
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket();
        byte[] req = ";B22DCDT172;XOUpPF8g".getBytes();

        DatagramPacket dp1 = new DatagramPacket(req, 0, req.length,
                InetAddress.getByName("203.162.10.109"), 2208);
        client.send(dp1);

        byte[] res = new byte[4096];
        DatagramPacket dp2 = new DatagramPacket(res, 0, res.length,
                InetAddress.getByName("203.162.10.109"), 2208);

        client.receive(dp2);

        String s = new String(dp2.getData()).trim();
        String[] tmp = s.split(";");
        String id = tmp[0];

        String[] words = tmp[1].split(" ");
        String str = "";
        for (String x : words) {
            str += chuanHoa(x);
        }
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(str.length() - 1);
        String solve = id + ";" + sb.toString();
        System.out.println(solve);

        DatagramPacket dp3 = new DatagramPacket(solve.getBytes(), 0, solve.getBytes().length,
                InetAddress.getByName("203.162.10.109"), 2208);

        client.send(dp3);
        client.close();
    }
}