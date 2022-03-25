package com.leetcode.Two_City_Scheduling;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. Two City Scheduling
 * https://leetcode.com/problems/two-city-scheduling/
 *
 * A company is planning to interview 2n people.
 * Given the array costs where costs[i] = [aCosti, bCosti],
 * the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
 *
 * Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
 *
 * Example 1:
 * Input: costs = [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 * Example 2:
 * Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
 * Output: 1859
 *
 * Example 3:
 * Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
 * Output: 3086
 *
 *
 * Constraints:
 * 2 * n == costs.length
 * 2 <= costs.length <= 100
 * costs.length is even.
 * 1 <= aCosti, bCosti <= 1000
 *
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // How much money can we save if we fly a person to A instead of B?
        // To save money, we should
        //   1) fly the person with the max saving to A
        //   2) fly the person with the min saving to B

        // сортируем по убыванию разницы между стоимостью полёта человека в А и В
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[1] - o2[0]) - (o1[1] - o1[0]);
            }
        });

        int minimumCost = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; ++i) {
            minimumCost += costs[i][0] + costs[i + n][1];
        }

        return minimumCost;
    }
}

class Main {
    public static void main(String[] args) {
        var result = new Solution().twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}});
        assert result == 110;

        var result2 = new Solution().twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}});
        assert result2 == 1859;
    }
}
