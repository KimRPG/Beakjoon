import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
       
        List<Long> answerList = new ArrayList<>();
        for(long number : numbers){
            if(number % 2 == 0){
                answerList.add(number+1);
            }
            else{
                answerList.add(oddFunction(number));
            }
        }
        long[] answer = new long[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public long oddFunction(long number){
        long temp = number;
        long check = 1;
                
        while((temp & 1) == 1) {
            temp >>= 1;
            check <<= 1;
        }
                
        return number + check - (check / 2);
    }
}

// f(x) = x보다는 큰데 x와 비트가 1~2개 다른 수들 중에서 제일 작은수이다.
// f(2) = 3 
// f(x) = return 값을 구하면 된다

//만약 2로 나뉘어 진다면 그것은 그냥 +1 하면 될 거 같다
// 2로 나뉘어지지 않을 때가 문제이다.
// 0111111 이렇게 있을 텐데 이때에는 2개가 최선임
// 1011111 이게 최선임

// 100011
// 100101

//뒤에서부터 진행하면서 1이 아닌걸 찾을 때까지 진행후 
