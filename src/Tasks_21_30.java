import java.util.Arrays;
import java.util.HashMap;
import static java.lang.Math.abs;


public class Tasks_21_30 {
    public static void main(String[] args){

        HashMap<String, Integer> testMap = new HashMap<>() {{
            put("Nice", 942208);
            put("Abu Dhabi", 1582816);
            put("Vatican City", 572);
            put("Naples", 2186853);
            put("Manila", 13923452);
            put("Jakarta", 10770487);

        }};
        System.out.println("#1");
        System.out.println(millionsRounding(testMap));
        System.out.println("\n");
        System.out.println("#2");
        System.out.println(Arrays.toString(otherSides(1)));
        System.out.println(Arrays.toString(otherSides(12)));
        System.out.println(Arrays.toString(otherSides(2)));
        System.out.println(Arrays.toString(otherSides(3)));
        System.out.println("\n");
        System.out.println("#3");
        System.out.println(rockPaperScissors("rock", "paper"));
        System.out.println(rockPaperScissors("paper", "rock"));
        System.out.println(rockPaperScissors("paper", "scissors"));
        System.out.println(rockPaperScissors("scissors", "scissors"));
        System.out.println(rockPaperScissors("scissors", "paper"));
        System.out.println("\n");
        System.out.println("#4");
        System.out.println(warOfNumbers(new int[] {2, 8, 7, 5}));
        System.out.println(warOfNumbers(new int[] {12, 90, 75}));
        System.out.println(warOfNumbers(new int[] {5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}));
        System.out.println("\n");
        System.out.println("#5");
        System.out.println(reverseCase("Happy Birthday"));
        System.out.println("\n");
        System.out.println("#6");
        System.out.println(inatorInator("Shrink"));
        System.out.println(inatorInator("EvilClone"));
        System.out.println("\n");
        System.out.println("#7");
        System.out.println(doesBrickFit(1,1,1,1,1));
        System.out.println(doesBrickFit(1,2,1,1,1));
        System.out.println(doesBrickFit(1,2,2,1,1));
        System.out.println("\n");
        System.out.println("#8");
        System.out.println(totalDistance(70.0, 7.0, 0, false));
        System.out.println(totalDistance(36.1, 8.6, 3, true));
        System.out.println("\n");
        System.out.println("#9");
        System.out.println(average( new int[] {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println("\n");
        System.out.println("#10");
        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));

    }

    public static HashMap<String, Integer> millionsRounding(HashMap<String, Integer> inDict){
        HashMap<String, Integer> outDict = new HashMap<>();
        for (String key : inDict.keySet()) {
            outDict.put(key, (int) Math.round(inDict.get(key) / 1000000d)*1000000);
        }
        return outDict;
    }

    public static double[] otherSides(int smallSide){
        return new double[] {smallSide*2, Math.round(smallSide*Math.sqrt(3)*100)/100d};
    }

    public static String rockPaperScissors(String p1, String p2) {
        if (p1.equals(p2))
            return "НИЧЬЯ";

        int win;
        if (p1.equals("rock")) {
            if (p2.equals("scissors"))
                win = 1;
            else
                win = 2;
        } else if (p1.equals("paper")) {
            if (p2.equals("rock"))
                win = 1;
            else
                win = 2;
        } else {
            if (p2.equals("paper"))
                win = 1;
            else
                win = 2;
        }
        return String.format("Игрок %d выигрывает", win);
    }
    public static int warOfNumbers(int[] numset){
        int difference = 0;
        for (int num : numset){
            if (num % 2 == 0)
                difference += num;
            else
                difference -= num;
        }
        return abs(difference);
    }
    public static String reverseCase(String input){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            if (Character.isUpperCase(input.charAt(i)))
                result.append(Character.toLowerCase(input.charAt(i)));
            else
                result.append(Character.toUpperCase(input.charAt(i)));
        }
        return result.toString();
    }
    public static String inatorInator(String word){
        String vowels = "iyeuoa";
        String result = new String(word);
        if (vowels.indexOf(word.charAt(word.length()-1)) != -1){
            result += '-';
        }
        result += "inator " + word.length() + "000";
        return result;
    }
    public static boolean doesBrickFit(int a, int b, int c, int w, int h){
        if ((a <= w && b <= h) || (a <= h && b <= w))
            return true;
        else if ((b <= w && c <= h) || (b <= h && c <= w))
            return true;
        else if ((a <= w && c <= h) || (a <= h && c <= w))
            return true;
        return false;
    }
    public static double totalDistance(double fuel, double rate, int passengers, boolean conditioner){
        rate += rate*5/100*passengers;
        if (conditioner)
            rate += rate*10/100;
        return fuel / rate * 100;
    }
    public static double average(int[] numList){
        double avg = 0;
        for (int num : numList){
            avg += num;
        }
        return avg/numList.length;
    }
    public static boolean parityAnalysis(int num){
        int sum = 0;
        int remains = num;
        while (remains != 0){
            sum += remains%10;
            remains /= 10;
        }
        return (num % 2 == sum % 2);
    }
}