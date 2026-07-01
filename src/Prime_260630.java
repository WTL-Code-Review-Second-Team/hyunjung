import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prime_260630 {
    public static class Solution{
        int answer = 0;

        public void dfs(Set resultList, String numbers, boolean[] visited, String current) {
            /// 새로운 것을 찾았으면 추가 -> 이 과정에서 중복이 제거됨
            if (!current.isEmpty()) {
                int nowNum = Integer.parseInt(current);
                if (!resultList.contains(nowNum)) {
                    resultList.add(nowNum);
                    boolean isPrime = true;
                    if(nowNum == 0 || nowNum == 1){
                        isPrime = false;
                    }
                    else{
                        for (int i = 3; i < nowNum; i++) {
                            if (nowNum % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }

                    if (isPrime) {
                        answer++;
                    }
                }
            }

            /// 탐색 시작
            for (int i = 0; i < numbers.length(); i++) {
                /// 이미 방문한 곳이라면 패스
                if (visited[i]) {
                    continue;
                }

                visited[i] = true;
                /// 이전 방문 숫자 + 현재 방문 숫자 표현
                dfs(resultList, numbers, visited, current + numbers.charAt(i));
                visited[i] = false;
            }
        }

        public int solution(String numbers){
            Set<Integer> result = new HashSet<>();
            boolean[] visited = new boolean[numbers.length()];
            answer = 0;

            dfs(result, numbers, visited, "");
            System.out.println(result);
            System.out.println(answer);
            return result.size();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("17");
        sol.solution("011");
        sol.solution("12345");
    }
}
