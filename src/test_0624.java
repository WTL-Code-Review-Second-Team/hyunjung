import java.util.ArrayList;
import java.util.Arrays;

public class test_0624 {
        public int[] solution(int[] answers) {
            int[] answer = {};
            // 1번 -> 1,2,3,4,5 length : 5
            // 2번 -> 2,1,2,3,2,4,2,5 length : 8
            // 3번 -> 3,3,1,1,2,2,4,4,5,5 length : 10

            int[] result = new int[]{dum1_check(answers), dum2_check(answers), dum3_check(answers)};
            //System.out.println(Arrays.toString(result));
            int max = 0;
            for(int v : result){
                max = Math.max(max, v);
            }
            int j = 0;
            ArrayList<Integer> final_list = new ArrayList<>();
            for(int i = 0; i<result.length; i++){
                if(result[i] == max){
                    final_list.add(i + 1);
                }
            }
            answer = final_list.stream().mapToInt(i -> i).toArray();
            return answer;
        }

        public int dum1_check(int[] list){
            int count = 0;
            int[] dum1 = new int[]{1,2,3,4,5};
            for(int i = 0; i < list.length; i++){
                if(list[i] == dum1[i % 5]){
                    count++;
                }
            }
            // System.out.println("dum1 정답 개수 : " + count);
            return count;
        }

        public int dum2_check(int[] list){
            int count = 0;
            int[] dum2 = new int[]{2,1,2,3,2,4,2,5};
            for(int i = 0; i < list.length; i++){
                if(list[i] == dum2[i % 8]){
                    count++;
                }
            }
            // System.out.println("dum2 정답 개수 : " + count);
            return count;
        }

        public int dum3_check(int[] list){
            int count = 0;
            int[] dum3 = new int[]{3,3,1,1,2,2,4,4,5,5};
            for(int i = 0; i < list.length; i++){
                if(list[i] == dum3[i % 10]){
                    count++;
                }
            }
            // System.out.println("dum3 정답 개수 : " + count);
            return count;
        }

    public static void main(String[] args){
        test_0624 sol = new test_0624();
        int[] test1 = {1,2,3,4,5};
        int[] test2 = {1,3,2,4,2};
        System.out.println(Arrays.toString(sol.solution(test1)));
        System.out.println(Arrays.toString(sol.solution(test2)));
    }
}
