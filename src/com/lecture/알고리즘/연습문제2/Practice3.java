package com.lecture.알고리즘.연습문제2;

import java.util.Arrays;

public class Practice3 {
    public static int solution(int[] weights) {

        Arrays.sort(weights);

        int cur = 0;
        for (int i = 0; i < weights.length; i++) {
            if (cur + 1 < weights[i]) { // 그리디하게 품
                break;
            }

            cur += weights[i];
        }
        return cur + 1;
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {6, 1, 2, 3, 1, 7, 30};
        System.out.println(solution(weights));
    }
}

