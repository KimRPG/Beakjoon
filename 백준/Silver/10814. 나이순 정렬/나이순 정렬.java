import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Member> queue = new PriorityQueue<>((o1, o2) ->
        {
            if (o1.age == o2.age) {
                return o1.id - o2.id;
            }
            return o1.age - o2.age;
        }
                );
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            queue.add(new Member(age, name, i));
        }

        while (!queue.isEmpty()){
            Member member = queue.poll();
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb);


    }

    public static class Member{
        int age;
        String name;
        int id;

        public Member(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }

    }
}
