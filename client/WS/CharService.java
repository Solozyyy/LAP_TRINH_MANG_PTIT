package client.WS;

import java.util.ArrayList;
import java.util.List;

public class CharService {

    public static String pascal(String s) {
        String[] tmp = s.split(" ");
        String ans = "";
        for (String x : tmp) {
            ans += Character.toUpperCase(x.charAt(0));
            ans += x.substring(1, x.length()).toLowerCase();
        }
        return ans;
    }

    public static String camelcase(String s) {
        String[] tmp = s.split(" ");
        String ans = "";
        ans += tmp[0].toLowerCase();
        for (int i = 1; i < tmp.length; ++i) {
            ans += Character.toUpperCase(tmp[i].charAt(0));
            ans += tmp[i].substring(1, tmp[i].length()).toLowerCase();
        }
        return ans;
    }

    public static String snakecase(String s) {
        String[] tmp = s.split(" ");
        String ans = "";
        for (String x : tmp) {
            ans += x.toLowerCase() + "_";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();

        String res = port.requestString("B22DCDT172", "9eUMuHdc");
        System.out.println(res);

        List<String> data = new ArrayList<>();
        data.add(pascal(res));
        data.add(camelcase(res));
        data.add(snakecase(res));

        port.submitCharacterStringArray("B22DCDT172", "9eUMuHdc", data);
    }
}
