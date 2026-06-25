import java.util.*;

public class tangerine_0623 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int v : tangerine){
            if(map.containsKey(v)){
                map.put(v, map.get(v) + 1) ;
            }
            else{
                map.put(v, 1);
            }

        }

        int max = k;

        List<Integer> valueList = new ArrayList<>(map.values());
        valueList.sort(Collections.reverseOrder());
//        System.out.println(valueList);

//        while(max > 0){
//            int max_now = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
//            System.out.println("위치 : " + max_now + " / 값 : " + map.get(max_now));
//            if(max - map.get(max_now) < 0) {
//                map.remove(max_now);
//            }
//            else{
        for(int v: valueList){

                max -= v;
//                map.remove(max_now);
                answer++;
                if(max <= 0){
                    break;
                }
            //}
        }

        return answer;
    }

    public static void main(String[] args){
        tangerine_0623 sol = new tangerine_0623();
        int[] test1 = {1, 3, 2, 5, 4, 5, 2, 3};
        int[] test2 = {1, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(sol.solution(6, test1));
        System.out.println(sol.solution(4, test1));
        System.out.println(sol.solution(2, test2));
    }
}
