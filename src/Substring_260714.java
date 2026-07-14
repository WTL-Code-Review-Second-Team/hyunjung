import java.util.*;

public class Substring_260714 {
    public int solution(String t, String p) {
        int answer = 0;

        int p_len = p.length();
        long num = Long.parseLong(p);
        for(int i = 0; i < t.length() - p_len + 1; i++){
            String subString = t.substring(i, i + p_len);
            long checkNum = Long.parseLong(subString);
            if(checkNum <= num){
                answer++;
            }
            System.out.println("subString = " + subString);
        }

        return answer;
    }

    public static void main(String[] args) {
        Substring_260714 sol = new Substring_260714();
        System.out.println(sol.solution("3141592", "271"));
        System.out.println(sol.solution("500220839878", "7"));
        System.out.println(sol.solution("10203", "15"));
        System.out.println(sol.solution("123456123456123456789", "123456123456123456"));
    }
}
