package algorithms;

/**
 * 997. Find the Town Judge
 * https://leetcode.com/problems/find-the-town-judge/
 * Difficulty : Easy
 * Related Topics : Graph
 *
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * Example 2:
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * Example 3:
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * Example 4:
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * Example 5:
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= N <= 1000
 * 0 <= trust.length <= 10^4
 * trust[i].length == 2
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 * created by cenkc on 8/10/2020
 */
public class FindTheTownJudge {

    public static void main(String[] args) {

/*
        Input: N = 1, trust = []
        Output: 1
        Input: N = 2, trust = [[1,2]]
        Output: 2
        Input: N = 3, trust = [[1,3],[2,3]]
        Output: 3
        Input: N = 3, trust = [[1,3],[2,3],[3,1]]
        Output: -1
        Input: N = 3, trust = [[1,2],[2,3]]
        Output: -1
        Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
        Output: 3
*/
        int N = 3;
        int[][] trust = new int[][] {
                {1, 3},
                {2, 3}
        };
        FindTheTownJudge townJudge = new FindTheTownJudge();
        System.out.println(townJudge.findJudge(N, trust));
    }

    /**
     * Runtime: 3 ms, faster than 90.90% of Java online submissions for Find the Town Judge.
     * Memory Usage: 47.1 MB, less than 76.55% of Java online submissions for Find the Town Judge.
     *
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1]; // because N starts from 1
        for (int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (count[i] == N-1) { // everyone trusts the judge, except the judge himself
                return i;
            }
        }
        return -1;
    }
}
