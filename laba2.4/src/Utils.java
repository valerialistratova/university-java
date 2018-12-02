import javafx.util.Pair;

import java.util.*;

public class Utils {
    public HashSet<Dot> fillDots(int length) {
        HashSet<Dot> res = new HashSet<Dot>(length);
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            res.add(new Dot(r.nextInt(30), r.nextInt(30)));
        }
        return res;
    }
}
