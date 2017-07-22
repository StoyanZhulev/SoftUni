package Ex02_MultidimensionalArrays;


import java.util.Scanner;

public class Pr12_ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] star1 = scanner.nextLine().split(" ");
        String nameFirstStar = star1[0].toLowerCase();
        double x1 = Double.parseDouble(star1[1]);
        double y1 = Double.parseDouble(star1[2]);

        String[] star2 = scanner.nextLine().split(" ");
        String nameSecondStar = star2[0].toLowerCase();
        double x2 = Double.parseDouble(star2[1]);
        double y2 = Double.parseDouble(star2[2]);

        String[] star3 = scanner.nextLine().split(" ");
        String nameThirdStar = star3[0].toLowerCase();
        double x3 = Double.parseDouble(star3[1]);
        double y3 = Double.parseDouble(star3[2]);


        String[] normandyCoordinates = scanner.nextLine().split(" ");
        double normandyX = Double.parseDouble(normandyCoordinates[0]);
        double normandyY = Double.parseDouble(normandyCoordinates[1]);

        int turns = Integer.parseInt(scanner.nextLine());

        for (double i = normandyY; i <= normandyY + turns ; i++) {
            boolean isInsideStar1 = (normandyX >= x1 - 1) && (normandyX <= x1 + 1) && (i >= y1 - 1) && (i <= y1 + 1);
            boolean isInsideStar2 = (normandyX >= x2 - 1) && (normandyX <= x2 + 1) && (i >= y2 - 1) && (i <= y2 + 1);
            boolean isInsideStar3 = (normandyX >= x3 - 1) && (normandyX <= x3 + 1) && (i >= y3 - 1) && (i <= y3 + 1);

            if(isInsideStar1){
                System.out.println(nameFirstStar);
            }else if(isInsideStar2){
                System.out.println(nameSecondStar);
            }else if(isInsideStar3){
                System.out.println(nameThirdStar);
            }else{
                System.out.println("space");
            }
        }
    }
}
