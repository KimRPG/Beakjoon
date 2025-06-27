import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = 0;
        double total = 0;
        for (int i = 0; i < 20; i++) {
            String[] st = br.readLine().split(" ");
            double credit = Double.parseDouble(st[1]);
            String grade = st[2];
            double gradeF = 0;
            if (grade.equals("A+")) {
                gradeF = 4.5;
            } else if (grade.equals("A0")) {
                gradeF = 4.0;
            }else if (grade.equals("B+")) {
                gradeF = 3.5;
            }else if (grade.equals("B0")) {
                gradeF = 3.0;
            }else if (grade.equals("C+")) {
                gradeF = 2.5;
            }else if (grade.equals("C0")) {
                gradeF = 2.0;
            }else if (grade.equals("D+")) {
                gradeF = 1.5;
            }else if (grade.equals("D0")) {
                gradeF = 1.0;
            } else if (grade.equals("P")) {
                continue;
            }
            a += gradeF * credit;
            total += credit;
        }
        System.out.println(a / total);
    }

}