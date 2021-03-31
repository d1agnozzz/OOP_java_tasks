import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Tasks_31_40 {
    public static void main(String[] args) {
        System.out.println("#1");
        System.out.println(sevenBoom(new int[] {1,2,3,4,5,6,7}));
        System.out.println(sevenBoom(new int[] {8,6,33,100}));
        System.out.println("\n");
        System.out.println("#2");
        System.out.println(cons(new int[]{5, 3, 4, 1, 6, 8, 2}));
        System.out.println("\n");
        System.out.println("#3");
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println("\n");
        System.out.println("#4");
        System.out.println(noYelling("What went wrong????????"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println(noYelling("Sentence ends with dot."));
        System.out.println("\n");
        System.out.println("#5");
        System.out.println(xPronounce("Inside the box was a xylophone"));
        System.out.println(xPronounce("OMG x box unboxing video x D"));
        System.out.println("\n");
        System.out.println("#6");
        System.out.println(largestGap(new int[]{9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        System.out.println(largestGap(new int[]{14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7}));
        System.out.println("\n");
        System.out.println("#7");
        System.out.println(reversedDelta(832));
        System.out.println(reversedDelta(51));
        System.out.println(reversedDelta(1));
        System.out.println(reversedDelta(149));
        System.out.println("\n");
        System.out.println("#8");
        System.out.println(commonLastVowel("Watch thE characters dance!"));
        System.out.println(commonLastVowel("OOI UUI EEI AAI"));
        System.out.println("\n");
        System.out.println("#9");
        System.out.println(memeSum(26,39));
        System.out.println(memeSum(122,81));
        System.out.println(memeSum(1222,30277));
        System.out.println("\n");
        System.out.println("#10");
        System.out.println(unrepeated("Hello world"));


    }

    public static String sevenBoom(int[] array) {
        for (int num : array) {
            if (num == 7)
                return "Boom!";
        }
        return "there is no 7 in the array";
    }

    public static boolean cons(int[] array) {
        int[] sorted = array.clone();
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 1; j < sorted.length - i; j++) {
                if (sorted[j] < sorted[j - 1]) {
                    sorted[j] += sorted[j - 1];
                    sorted[j - 1] = sorted[j] - sorted[j - 1];
                    sorted[j] -= sorted[j - 1];
                }
            }
        }
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i - 1] + 1)
                return false;
        }
        return true;
    }

    public static String unmix(String mixed) {
        StringBuilder unmixed = new StringBuilder();
        for (int i = 0; i < mixed.length() - 1; i += 2) {
            unmixed.append(mixed.charAt(i + 1));
            unmixed.append(mixed.charAt(i));
        }
        return unmixed.toString();
    }

    public static String noYelling(String str) {
        if (str.endsWith("?") || str.endsWith("!")) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) != '?' && sb.charAt(i) != '!') {
                    return sb.substring(0, i + 2);
                }
            }
        }
        return str;
    }

    public static String xPronounce(String str) {
        String[] strarr = str.split(" ");
        for (int i = 0; i < strarr.length; i++) {
            if (strarr[i].equals("x"))
                strarr[i] = "ecks";
            else if (strarr[i].startsWith("x")) {
                strarr[i] = strarr[i].replaceFirst("x", "z");
            }
            strarr[i] = strarr[i].replace("x", "cks");
        }
        return String.join(" ", strarr);
    }

    public static int largestGap(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int maxGap = 0;
        for (int i = 0; i < sorted.length - 1; i++) {
            if (abs(sorted[i] - sorted[i + 1]) > maxGap) {
                maxGap = abs(sorted[i] - sorted[i + 1]);
            }
        }
        return maxGap;
    }

    public static int reversedDelta(Integer num) {
        StringBuilder strnum = new StringBuilder(num.toString());
        StringBuilder revnum = new StringBuilder(strnum);
        revnum.reverse();
        int delta = num - Integer.parseInt(revnum.toString());
        if (delta > 0)
            return delta;
        return 0;
    }

    public static char commonLastVowel(String str) {
        StringBuilder foundVowels = new StringBuilder();

        Character[] vowels = new Character[]{'e', 'y', 'u', 'i', 'o', 'a'};
        HashMap<Character, Integer> vowelsMap = new HashMap<>();

        // filling map with vowels[] keys and zero values
        for (Character ch : vowels) {
            vowelsMap.put(ch, 0);
        }

        // preparing regexp
        Pattern pattern = Pattern.compile("[eyuioaEYUIOA]\\b");
        Matcher matcher = pattern.matcher(str);

        // applying regexp
        while (matcher.find()) {
            foundVowels.append(str.substring(matcher.start(), matcher.end()));
        }

        // updating map values
        for (int i = 0; i < foundVowels.length(); i++) {
            vowelsMap.put(Character.toLowerCase(foundVowels.charAt(i)), vowelsMap.get(Character.toLowerCase(foundVowels.charAt(i))) + 1);
        }

        // finding key associating with max value
        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : vowelsMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
        }

        return maxEntry.getKey();
    }
    public static int memeSum(int term1, int term2){
        String str1 = String.valueOf(term1);
        String str2 = String.valueOf(term2);

        int maxLen = max(str1.length(), str2.length());

        int[] digs1 = new int[maxLen];
        int[] digs2 = new int[maxLen];

        int shift1 = maxLen-str1.length();
        int shift2 = maxLen-str2.length();

        // filling arrays
        for(int i = 0; i < digs1.length-shift1; i++){
            digs1[i+shift1] = Character.getNumericValue(str1.charAt(i));
        }

        for(int i = 0; i < digs2.length-shift2; i++){
            digs2[i+shift2] = Character.getNumericValue(str2.charAt(i));
        }

        // summing arrays
        for (int i = 0; i < maxLen; i++){
            digs2[i] = digs1[i]+digs2[i];
        }

        // concat array
        StringBuilder sumstr = new StringBuilder();
        for (int num : digs2){
            sumstr.append(num);
        }
        return Integer.parseInt(sumstr.toString());
    }
    public static String unrepeated(String str){
        String letters = "";
        StringBuilder unrepeated = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (!letters.contains(String.valueOf(str.charAt(i)).toLowerCase())){
                unrepeated.append(str.charAt(i));
                letters += Character.toLowerCase(str.charAt(i));
            }
        }
        return unrepeated.toString();
    }
}
