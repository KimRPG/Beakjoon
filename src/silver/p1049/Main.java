package silver.p1049;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList linePackage = new ArrayList<>();
        ArrayList lineOne = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        Integer brokenLine=s.nextInt();
        Integer brand=s.nextInt();
        for (int i = 0; i < brand; i++) {
            Integer linePackagePrice = s.nextInt();
            Integer lineOnePrice = s.nextInt();
            linePackage.add(linePackagePrice);
            lineOne.add(lineOnePrice);
        }
        Integer packageMin = (Integer) Collections.min(linePackage);
        Integer oneMin = (Integer) Collections.min(lineOne);
//         one * broken / package * broken/6 + one * broken%6 / package * ((broken/6)+1)
        Integer packageNum = brokenLine / 6;
        Integer oneNum = brokenLine % 6;

        List price = new ArrayList<>();
        price.add((packageMin * packageNum)+(oneMin*oneNum));
        price.add((packageMin * (packageNum + 1)));
        price.add(oneMin * brokenLine);
        Integer priceMin = (Integer) Collections.min(price);
        System.out.println(priceMin);
    }
}
