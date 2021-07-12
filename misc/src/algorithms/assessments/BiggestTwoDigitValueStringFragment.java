package algorithms.assessments;

/**
 * https://gist.github.com/cenkc/9a9155da530de5c1c898446f29e5d643
 *
 * created by Cenk Canarslan on 2021-07-12
 */
public class BiggestTwoDigitValueStringFragment {

    public static void main(String[] args) {
        BiggestTwoDigitValueStringFragment btd = new BiggestTwoDigitValueStringFragment();
        int solution = btd.solution("50552"); // 55
//        int solution = btd.solution("10101"); /l/ 10
//        int solution = btd.solution("88"); // 88

        System.out.println("solution = " + solution);
    }

    public int solution(String S) {
        if (S.length() < 2 || S.length() > 100
                || S.charAt(0) == '0') {
            return -1;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < S.length() - 1; i++) {
            if ( ! Character.isDigit(S.charAt(i)) || ! Character.isDigit(S.charAt(i + 1))) {
                return -1;
            }
            result = Math.max(Integer.parseInt(S.substring(i, i + 2)), result);
        }
        return result;
    }
}
