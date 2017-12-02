package befaster.solutions;

public class Sum {

    public static int sum(int x, int y) {
        if (outOfBoundaries(x) || outOfBoundaries(y))
            throw new IllegalArgumentException();
        return x + y;
    }

    private static boolean outOfBoundaries(int x) {
        return x < 0 || x > 100;
    }
}