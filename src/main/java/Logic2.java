public class Logic2 {
    // We want to make a row of bricks that is goal inches long. We have a number of small bricks (1 inch each) and big
    // bricks (5 inches each). Return true if it is possible to make the goal by choosing from the given bricks. This
    // is a little harder than it looks and can be done without any loops.
    public boolean makeBricks(int small, int big, int goal) {
        for (int i = 0; i <= small; i++) {
            int bricksSmall = i * 1;
            int brickBig = (goal - i * 1)/5;
            if ((goal - i * 1)%5 == 0) {
                if ((brickBig * 5 + bricksSmall) == goal && brickBig <= big) return true;
            }
        }
        return false;
    }

    // Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values,
    // it does not count towards the sum.
    public int loneSum(int a, int b, int c) {
        if ( a == b && b == c) return 0;
        int sum = a;
        if (a != b) sum += b;
        else sum -= a;
        if (c != a) {
            if (c != b) {
                sum +=c;
            } else sum -= b;
        } else sum -= a;
        return sum;
    }

    // Given 3 int values, a b c, return their sum. However, if one of the values is 13 then it does not count towards
    // the sum and values to its right do not count. So for example, if b is 13, then both b and c do not count.
    public int luckySum(int a, int b, int c) {
        if (a == 13) return 0;
        if (b == 13) return a;
        if (c == 13) return a + b;
        return a + b + c;
    }
}
