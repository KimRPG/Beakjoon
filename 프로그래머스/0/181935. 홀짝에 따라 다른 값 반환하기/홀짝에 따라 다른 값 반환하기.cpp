#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    int even = 0,odd =0;
    for(int i = 1; i <= n; i++){
        if(i % 2 == 1){
            odd += i;
        }else{
            even += (i*i);
        }
    }
    return n%2==1 ? odd: even;
}