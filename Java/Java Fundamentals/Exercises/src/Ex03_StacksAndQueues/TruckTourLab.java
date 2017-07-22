package Ex03_StacksAndQueues;

import java.util.Scanner;

public class TruckTourLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int startIndex = 0;
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int petrol = scanner.nextInt();
            int distance = scanner.nextInt();

            sum = petrol - distance;
            if(sum < 0){
                startIndex = startIndex + i;
            }else{

            }
        }
    }
}
