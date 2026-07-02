import java.util.ArrayList;
import java.util.List;

public class JoyStick_260701 {
    public int solution(String name) {
        int answer = 0;

        int length = name.length();
        int move = length - 1;

        for (int i = 0; i < length; i++) {
            /// 아스키 코드로 변환하여 A로부터 얼마나 전환해야되는지 확인 후 모든 전환 횟수 더하기
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            /// 좌/우 조작
            int next = i + 1;

            /// 연속된 A 탐색
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            /// 진행 방향 고민
            move = Math.min(move, i * 2 + length - next); // 오른쪽으로 i까지 갔다가 다시 돌아와서, 뒤쪽으로 가는 경우
            move = Math.min(move, (length - next) * 2 + i); // 왼쪽으로 뒤쪽부터 갔다가 다시 돌아와서, 오른쪽 i까지 가는 경우
        }

        answer += move;

        return answer;
    }

    public static void main(String[] args) {
        JoyStick_260701 sol = new JoyStick_260701();
        System.out.println(sol.solution("JEROEN"));
        System.out.println(sol.solution("JAN"));
        System.out.println(sol.solution("JNA"));
    }
}
