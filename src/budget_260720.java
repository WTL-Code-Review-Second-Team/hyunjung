import java.util.Arrays;

public class budget_260720 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        int[] arr = d;
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            int max = 0;
            int limit = budget;
            for (int j = i; j >= 0; j--) {
                if (limit - arr[j] >= 0) {
                    limit = limit - arr[j];
                    max++;
                }
            }
            answer = Math.max(answer, max);
        }

        return answer;
    }

    public static void main(String[] args) {
        budget_260720 sol = new budget_260720();
        System.out.println(sol.solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(sol.solution(new int[]{2, 2, 3, 3}, 10));
    }
}
