package Lab01_JavaSyntax;

import java.math.BigInteger;
import java.util.Scanner;

public class Pr07_ProductsOfNUmbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int index = n;
        BigInteger product = new BigInteger("1");

        do {
            product = product.multiply(new BigInteger(String.valueOf(index)));
            index++;
        } while (index <= m);

        System.out.printf("product[%s..%s] = %s", n, m, product);
    }
}
