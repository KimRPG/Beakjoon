package 못푼문제.p1018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer row=s.nextInt(); //가로
        Integer column=s.nextInt(); //세로

        List<List<String>> chess = new ArrayList<>();
        for (int i = 0; i < column; i++) {
            List<String> chessColumn = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                chessColumn.add(s.next());
            }
            chess.add(chessColumn);
        }

    }
}
