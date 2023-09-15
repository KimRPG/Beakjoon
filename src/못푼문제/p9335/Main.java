package 못푼문제.p9335;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testcase = s.nextInt();

        for (int i = 0; i < testcase; i++) {
            int socialSize = s.nextInt();
            ArrayList friend = new ArrayList();
            for (int j = 0; j < socialSize; j++) {
                int friendAmount = s.nextInt();
                int[] friendOne = new int[friendAmount+1];
                friendOne[0] = j+1;
                int [] answer = new int[friendAmount+1];
                for (int k = 0; k < friendAmount; k++) {
                    answer[k] = k+1;
                    int realFriend = s.nextInt();
                    friendOne[k+1] = realFriend;
                } //친구수 끝
                friend.add(friendOne);
            } // 소셜네트워크 총 수
            //dfs 를 통해 구해야함
            int minFriends = findMinimumFriends(friend);
            System.out.println(minFriends);

            friend.clear();
        }//testcase 끝
    }

    private static int findMinimumFriends(ArrayList<int[]> friendList) {
        int minFriends = Integer.MAX_VALUE;

        for (int i = 0; i < friendList.size(); i++) {
            int[] currentNetwork = friendList.get(i);

            for (int j = 1; j < currentNetwork.length; j++) {
                boolean[] visited = new boolean[currentNetwork.length];
                int friendsNeeded = dfs(currentNetwork, visited, j);

                if (friendsNeeded < minFriends) {
                    minFriends = friendsNeeded;
                }
            }
        }

        return minFriends;
    }

    private static int dfs(int[] currentNetwork, boolean[] visited, int start) {
        visited[start] = true;
        int friendsNeeded = 0;

        for (int i = 1; i < currentNetwork.length; i++) {
            if (!visited[i] && currentNetwork[i] == start) {
                friendsNeeded++;
                friendsNeeded += dfs(currentNetwork, visited, i);
            }
        }

        return friendsNeeded;
    }
}

