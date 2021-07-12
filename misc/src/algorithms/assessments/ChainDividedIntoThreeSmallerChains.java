package algorithms.assessments;

/**
 * https://gist.github.com/cenkc/9a9155da530de5c1c898446f29e5d643
 *
 * created by Cenk Canarslan on 2021-07-11
 */
public class ChainDividedIntoThreeSmallerChains {

    public static void main(String[] args) {
        ChainDividedIntoThreeSmallerChains cdit = new ChainDividedIntoThreeSmallerChains();
        int[] A = {5, 2, 4, 6, 3, 7};
        int solution = cdit.solution(A);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] A) {
        if (A.length < 5 || A.length > 100000) {
            return -1;
        }

        int minCost = Integer.MAX_VALUE;
        int MIN_LINK = 1;
        int NUM_LINKS = 3;
        for (int P = MIN_LINK; P < A.length - NUM_LINKS; P++) {
            for (int Q = P + 2; Q < A.length - MIN_LINK; Q++) {
                minCost = Math.min(minCost, (A[P] + A[Q]));
            }
        }
        return minCost;
    }
}
