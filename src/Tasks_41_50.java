
import java.util.ArrayList;

import java.util.HashMap;


public class Tasks_41_50 {
    public static void main(String[] args) {
        System.out.println("#1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println("#2");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("E2", "H3"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("B2", "A4"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(spiderVsFly("C2", "A4"));
        System.out.println(spiderVsFly("H4", "B4"));
        System.out.println(spiderVsFly("B4", "H4"));
        System.out.println(spiderVsFly("A4", "E4"));
        System.out.println(spiderVsFly("A4", "D3"));
        System.out.println(spiderVsFly("A4", "C3"));


    }

    public static boolean sameLetterPattern(String a, String b) {
        HashMap<Character, Integer> aHash = new HashMap<>();
        HashMap<Character, Integer> bHash = new HashMap<>();

        int value = 0;

        String aPattern = "";

        for (int i = 0; i < a.length(); i++) {
            if (!aHash.containsKey(a.charAt(i))) {
                aHash.put(a.charAt(i), value);
                value++;
            }
            aPattern += aHash.get(a.charAt(i));
        }

        value = 0;

        String bPattern = "";

        for (int i = 0; i < b.length(); i++) {
            if (!bHash.containsKey(b.charAt(i))) {
                bHash.put(b.charAt(i), value);
                value++;
            }
            bPattern += bHash.get(b.charAt(i));
        }

        return aPattern.equals(bPattern);
    }

    public static String spiderVsFly(String from, String to) {

        WebPathFinder.start = new WebPoint(from);
        WebPathFinder.finish = new WebPoint(to);

        ArrayList<WebPoint> path = WebPathFinder.find();

        String[] result = new String[path.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = path.get(i).toString();
        }

        return String.join("-", result);
    }
}


class WebPoint {
    public int radial;
    public int ring;

    public WebPoint(int radial, int ring) {
        this.radial = radial;
        this.ring = ring;
    }

    public WebPoint(String string) {
        this.radial = string.charAt(0) - 65;
        this.ring = Character.getNumericValue(string.charAt(1));
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof WebPoint)) return false;
        if (this == obj) return true;
        WebPoint wp = (WebPoint) obj;
        return (this.radial == wp.radial && this.ring == wp.ring);
    }

    @Override
    public String toString() {
        return (char) (radial + 65) + String.valueOf(ring);
    }
}

class WebPathFinder {
    public static WebPoint start;
    public static WebPoint finish;

    public WebPathFinder(WebPoint a, WebPoint b) {
        start = a;
        finish = b;
    }

    public static ArrayList<WebPoint> find() {
        /* Array for keeping path */
        ArrayList<WebPoint> path = new ArrayList<>();

        /* Distance between start and finish in radials */
        int radial_dist = start.radial - finish.radial;

        /* Ring, where spider should go across radials */
        int cross_ring = 0;

        /* Clock- or counterclockwise direction spider should go between radials */
        int radial_direction;

        /* (очень сложная хрень, долго не мог понять как вычислить направление кратчайшего пути,
           оно работает, не трожь) */
        if ((radial_dist >= 0 && radial_dist <= 4) || (radial_dist <= -4))
            radial_direction = -1;
        else
            radial_direction = +1;

        /* Shortest of two arcs between start and finish */
        int shortest_arc_dist = Math.min(Math.abs(radial_dist), 8 - Math.abs(radial_dist));

        /* Path will be shorter if spider would cut across radials, but only if finish is
           no further than 2 radials */
        if (shortest_arc_dist < 3)
            cross_ring = Math.min(start.ring, finish.ring);



        /* Spider goes down to cross_ring */
        for (int i = start.ring; i >= cross_ring; i--) {

            if (i == 0)
                path.add(new WebPoint(0, 0));
            else
                path.add(new WebPoint(start.radial, i));

        }

        /* Spider cuts across radials */
        for (int i = start.radial; cross_ring != 0 && start.radial != finish.radial; i = (i + radial_direction) % 8) {

            if (i < 0)
                i += 8;

            WebPoint current = new WebPoint(i, cross_ring);

            // removes repetition
            if (!path.get(path.size() - 1).equals(current))
                path.add(current);

            if (i == finish.radial)
                break;

        }

        /* Spider goes down to finish */
        for (int i = cross_ring; i <= finish.ring; i++) {

            WebPoint current = new WebPoint(finish.radial, i);

            // removes repetition
            if (i != 0 && !path.get(path.size() - 1).equals(current))
                path.add(current);

        }

        return path;
    }


}