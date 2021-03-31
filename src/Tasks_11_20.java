
public class Tasks_11_20 {
    public static void main(String[] args) {
        System.out.println("#1\t" + oppositeHouse(1, 3));
        System.out.println("\t" + oppositeHouse(2, 3));
        System.out.println("\t" + oppositeHouse(3, 5));
        System.out.println("\t" + oppositeHouse(5, 46));
        System.out.println("\n");
        System.out.println("#2\t" + nameShuffle("Donald Trump"));
        System.out.println("\n");
        System.out.println("#3\t" + discount(89, 20));
        System.out.println("\n");
        System.out.println("#4\t" + differenceMaxMin(new int[] {10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println("\n");
        System.out.println("#5\t"+equal(3,4,3));
        System.out.println("\t"+equal(1,1,1));
        System.out.println("\t"+equal(3,4,1));
        System.out.println("\n");
        System.out.println("#6\t"+ reverse("Hello World 123"));
        System.out.println("\n");
        System.out.println("#7\t"+ programmers(147, 33, 526));
        System.out.println("\n");
        System.out.println("#8\t" + getXO("ooxXm"));
        System.out.println("\n");
        System.out.println("#9\t" + bomb("Hey, did you think there is a BOMB?"));
        System.out.println("\t" +   bomb("There is BOOOOOMB!"));
        System.out.println("\n");
        System.out.println("#10\t"+ sameASCII("a", "a"));
        System.out.println("\t"+ sameASCII("AA", "B@"));
        System.out.println("\t"+ sameASCII("EdAbIt", "EDABIT"));
    }


    public static int oppositeHouse(int house, int street_length) {
        return street_length * 2 - house + 1;
    }

    public static String nameShuffle(String name) {
        String[] parts = name.split(" ");
        return parts[1] + " " + parts[0];
    }

    public static double discount(int price, int percent) {
        return price - (price * percent / 100d);
    }

    public static int differenceMaxMin(int[] array) {
        int max = array[0], min = array[0];
        for (int j : array) {
            if (j > max)
                max = j;
            if (j < min)
                min = j;
        }
        return max - min;
    }

    public static int equal(int a, int b, int c) {
        if (a == b || a == c) {
            if (b == c)
                return 3;
            else
                return 2;
        }
        else if (b==c)
            return 2;
        return 0;
    }
    public static String reverse(String string){
        StringBuilder reversed = new StringBuilder();
        for (int i = string.length()-1; i >=0;i-- )
            reversed.append(string.charAt(i));
        return reversed.toString();
    }
    public static int programmers(int a, int b, int c){
        int min = a, max = a;
        if (b < min) min = b;
        else if (b > max) max = b;
        if (c < min) min = c;
        else if (c > max) max = c;
        return max-min;
    }
    public static boolean getXO(String string){
        int xc = 0, oc = 0;
        for (int i=0;i<string.length();i++){
            if (string.charAt(i) == 'x' || string.charAt(i) == 'X')
                xc++;
            else if (string.charAt(i) == 'o' || string.charAt(i) == 'O')
                oc++;
        }
        return xc == oc;
    }
    public static String bomb(String string){
        for(int i = 0; i < string.length(); i++){
            if (string.charAt(i) == 'b' || string.charAt(i) == 'B' && i + 4 < string.length()){
                StringBuilder test_bomb = new StringBuilder("b");
                for (int j = i+1; j < i + 4; j++){
                    test_bomb.append(string.charAt(j));
                }
                if (test_bomb.toString().equalsIgnoreCase("bomb"))
                    return "DUCK!";
            }
        }
        return "Relax, there's no bomb.";
    }
    public static boolean sameASCII(String first, String second){
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i<first.length(); i++)
            sum1 += first.charAt(i);
        for (int i = 0; i<second.length(); i++)
            sum2 += second.charAt(i);
        return sum1 == sum2;
    }
}