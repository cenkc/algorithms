package lessons.timecomplexity;

/**
 * Frog Jump (FrogJmp)
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 * Difficulty : Easy
 * Related Topics : Time Complexity
 *
 * created by cenkc on 4/5/2020
 */
public class FrogJmp {

    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;

        FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(X, Y, D));
    }

    public int solution(int X, int Y, int D) {
        int distance = Y - X;
        int jumpCount = distance / D;
        if (distance % D != 0) {
            jumpCount = jumpCount + 1;
        }
        return jumpCount;
    }
}
