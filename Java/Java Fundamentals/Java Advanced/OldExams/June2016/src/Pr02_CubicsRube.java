//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.math.BigInteger;
//
//public class Pr02_CubicsRube {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String dimensions = (reader.readLine());
//        BigInteger cellsNotChanged = new BigInteger(dimensions);
//        BigInteger dim = new BigInteger(dimensions);
//        cellsNotChanged = cellsNotChanged.multiply(cellsNotChanged).multiply(cellsNotChanged);
//        BigInteger sum = BigInteger.ZERO;
//        while (true) {
//            String input = reader.readLine();
//            if ("Analyze".equals(input)) {
//                break;
//            }
//
//            String[] line = input.split(" ");
//            BigInteger pointX = new BigInteger(line[0]);
//            BigInteger pointY = new BigInteger(line[1]);
//            BigInteger pointZ = new BigInteger(line[2]);
//            BigInteger particles = new BigInteger(line[3]);
//
//
//            if ((((pointX).compareTo(BigInteger.ZERO) == 0 || (pointX).compareTo(BigInteger.ZERO) == 1)
//                    && pointX.compareTo(dim) == -1)
//                    && ((pointY.compareTo(BigInteger.ZERO) == 0 || pointY.compareTo(BigInteger.ZERO) == 1)
//                    && pointY.compareTo(dim) == -1)
//                    && ((pointZ.compareTo(BigInteger.ZERO) == 0 || pointZ.compareTo(BigInteger.ZERO) == 1)
//                    && pointZ.compareTo(dim) == -1)) {
//
//                if (!(pointX.compareTo(BigInteger.ZERO) == 0 && pointY.compareTo(BigInteger.ZERO) == 0)) {
//
//                    cellsNotChanged = cellsNotChanged.subtract(BigInteger.ONE);
//                    sum = sum.add(particles);
//                }
//
//            }
//
//        }
//
//        System.out.println(sum);
//        System.out.println(cellsNotChanged);
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Pr02_CubicsRube {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        long dimensions = Integer.parseInt(reader.readLine());
        long cellsNotChanged = dimensions * dimensions * dimensions;
        long sum = 0;
        while (true) {
            String input = reader.readLine();
            if ("Analyze".equals(input)) {
                break;
            }

            long[] nums = Arrays.stream(input.split(" ")).mapToLong(Long::parseLong).toArray();
            long pointX = nums[0];
            long pointY = nums[1];
            long pointZ = nums[2];
            long particle = nums[3];

            if (0 <= pointX && pointX < dimensions
                    && 0 <= pointY && pointY < dimensions
                    && 0 <= pointZ && pointZ < dimensions) {

                if (!(pointX == 0 && pointY == 0)) {

                    if(particle != 0){
                        cellsNotChanged -= 1;
                    }
                    sum += particle;
                }
            }

        }

        System.out.println(sum);
        System.out.println(cellsNotChanged);
    }
}
