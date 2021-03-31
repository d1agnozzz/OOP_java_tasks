public class Tasks_1_10 {

    public static void main(String[] args) {

        // 1
        System.out.printf("minutesToSeconds(5) : %d%n", minutesToSeconds(5));
        System.out.printf("minutesToSeconds(3) : %d%n", minutesToSeconds(3));
        System.out.printf("minutesToSeconds(2) : %d%n", minutesToSeconds(2));
        System.out.println();

        // 2
        System.out.printf("points(13,12) : %d%n", points(13, 12));
        System.out.printf("points(17,12) : %d%n", points(17, 12));
        System.out.printf("points(38,8) : %d%n", points(38, 8));
        System.out.println();

        // 3
        System.out.printf("footballPoints(3, 4, 2) : %d%n", footballPoints(3, 4, 2));
        System.out.printf("footballPoints(5, 0, 2) : %d%n", footballPoints(5, 0, 2));
        System.out.printf("footballPoints(0, 0, 1) : %d%n", footballPoints(0, 0, 1));
        System.out.println();

        // 4
        System.out.printf("divisibleBy5(5) : %b%n", divisibleBy5(5));
        System.out.printf("divisibleBy5(-55) : %b%n", divisibleBy5(-55));
        System.out.printf("divisibleBy5(37) : %b%n", divisibleBy5(37));
        System.out.println();

        // 5
        System.out.printf("and(true, false) : %b%n", and(true, false));
        System.out.printf("and(true, true) : %b%n", and(true, true));
        System.out.printf("and(false, true) : %b%n", and(false, true));
        System.out.printf("and(false, false) : %b%n", and(false, false));
        System.out.println();

        // 6
        System.out.printf("howManyWalls(54, 1, 43) : %d%n", howManyWalls(54, 1, 43));
        System.out.printf("howManyWalls(46, 5, 4) : %d%n", howManyWalls(46, 5, 4));
        System.out.printf("howManyWalls(100, 4, 5) : %d%n", howManyWalls(100, 4, 5));
        System.out.printf("howManyWalls(10, 15, 12) : %d%n", howManyWalls(10, 15, 12));
        System.out.printf("howManyWalls(41, 3, 6) : %d%n", howManyWalls(41, 3, 6));
        System.out.println();

        // 7
        System.out.printf("squared(5): %d%n", Challenge.squared(5));
        System.out.printf("squared(9): %d%n", Challenge.squared(9));
        System.out.printf("squared(100): %d%n", Challenge.squared(100));
        System.out.println();

        // 8
        System.out.printf("profitableGamble(0.2, 50, 9) : %b%n", profitableGamble(0.2, 50, 9));
        System.out.printf("profitableGamble(0.9, 1, 2) : %b%n", profitableGamble(0.9, 1, 2));
        System.out.printf("profitableGamble(0.9, 3, 2) : %b%n", profitableGamble(0.9, 3, 2));
        System.out.println();

        // 9
        System.out.printf("frames(1, 1) : %d%n", framesPerMinute(1, 1));
        System.out.printf("frames(10, 1) : %d%n", framesPerMinute(10, 1));
        System.out.printf("frames(10, 25) : %d%n", framesPerMinute(10, 25));
        System.out.println();

        // 10
        System.out.printf("mod(5, 2) : %d%n", mod(5, 2));
        System.out.printf("mod(218, 5) : %d%n", mod(218, 5));
        System.out.printf("mod(6, 3) : %d%n", mod(6, 3));
        System.out.println();

    }


    public static int minutesToSeconds(int minutes) {
        return minutes * 60;
    }

    public static int points(int doubles, int triples) {
        return doubles * 2 + triples * 3;
    }

    public static int footballPoints(int wins, int draws, int defeats) {
        return wins * 3 + draws * 1 + defeats * 0;
    }

    public static boolean divisibleBy5(int number) {
        return number % 5 == 0;

    }

    public static boolean and(boolean a, boolean b) {
        return a && b;

    }

    public static int howManyWalls(int n, int w, int h) {
        return n / w * h;
    }

    public static boolean profitableGamble(double prob, int prize, int pay) {
        return prob * prize > pay;
    }

    public static int framesPerMinute(int framesPerSecond, int minutes) {
        return framesPerSecond * 60 * minutes;
    }

    public static int mod(int a, int b) {
        int remains = a;
        while (remains - b >= 0) {
            remains -= b;
        }
        return remains;
    }
}

class Challenge {
    public static int squared(int b) {
        return b * b; // исходный -- return a*a
    }
}