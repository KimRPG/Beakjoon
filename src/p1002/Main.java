package p1002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        double[][] r1 = new double[testCase][6];
        double[] distance1 = new double[testCase]; //r3
        double[] distance2 = new double[testCase]; //r1+r2
        double[] distance3 = new double[testCase]; //r1+r2
        for (int i = 0; i < testCase; i++) {
            for (int j = 0; j < 6; j++) {
                r1[i][j] = s.nextInt();
            }
            distance1[i] = distance(r1[i][0], r1[i][1], r1[i][3], r1[i][4]); //두점 사이의 거리
            distance2[i] = r1[i][2] + r1[i][5]; //
            distance3[i] = Math.abs(r1[i][2] - r1[i][5]) ;
        }
        for (int i = 0; i < testCase; i++) {
            if (r1[i][0] == r1[i][3] && r1[i][1] == r1[i][4]) {
                if (r1[i][2] == r1[i][5]) {
                    System.out.println(-1);
                }else {
                    System.out.println(0);
                }
            } else if (distance1[i] <= distance3[i]) {

                if(distance1[i] == distance3[i]){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            } else {
                if (distance1[i] > distance2[i]) {
                    System.out.println(0);
                } else if (distance1[i] == distance2[i]) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
        }

    }


    public static double distance(double x1, double y1, double x2, double y2) {
        double distance =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }


}
//틀린이유 : 1. double을 생각하지 못하고 int로 만 구해 내림했을 때 오류가 발생하였음
//2. 내접원과 외접원의 차이를 구하지 못하였음
