package client.RMI;

import RMI.CharacterService;
import java.rmi.Naming;

public class RMIChar {
    public static void main(String[] args) throws Exception {
        CharacterService service = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        String res = (String) service.requestCharacter("B22DCDT172", "FA6UdQcO");
        System.out.println(res);
        String ans = "";
        int k = res.length() % 7;
        System.out.println(k);
        for (Character c : res.toCharArray()) {
            if (Character.isUpperCase(c))
                ans += (char) ((c - 'A' - k + 26) % 26 + 'A');
            else
                ans += (char) ((c - 'a' - k + 26) % 26 + 'a');
        }
        System.out.println(ans);
        service.submitCharacter("B22DCDT172", "FA6UdQcO", ans);
    }
}
