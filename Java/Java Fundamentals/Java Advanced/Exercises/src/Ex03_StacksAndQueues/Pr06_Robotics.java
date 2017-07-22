package Ex03_StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Pr06_Robotics {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] robotsLine = reader.readLine().split(";");
            ArrayList<Robot> robots = new ArrayList<>();

            addRobots(robotsLine, robots);

            String[] startTime = reader.readLine().split(":");
            long startSeconds = Integer.parseInt(startTime[0]) * 60 * 60 + Integer.parseInt(startTime[1]) * 60 + Integer.parseInt(startTime[2]);

            Deque<String> products = new ArrayDeque<>();

            long currentSeconds = startSeconds;

            String product = reader.readLine();

            while (!product.equals("End")) {
                products.add(product);
                product = reader.readLine();
            }

            while (!products.isEmpty()) {
                currentSeconds++;

                String currentProduct = products.poll();
                boolean productIsProcessed = false;


                for (Robot robot : robots) {

                    if (robot.isProcessingProduct()) {
                        robot.setTimeCurrentProductIsProcessed(robot.getTimeCurrentProductIsProcessed() - 1);
                        if (robot.getTimeCurrentProductIsProcessed() <= 0) {

                            robot.setProcessingProduct(false);
                            robot.setTimeCurrentProductIsProcessed(null);
                        }
                    }

                    if (!robot.isProcessingProduct() && !currentProduct.equals("none")) {
                        robot.setProcessingProduct(true);
                        robot.setTimeCurrentProductIsProcessed(robot.getProcessingTime());
                        productIsProcessed = true;

                        String currentTime = getCurrentTime(currentSeconds);

                        System.out.printf("%s - %s %s", robot.getName(), currentProduct, currentTime);
                    }

                    if (productIsProcessed) {
                        currentProduct = "none";
                    }
                }

                if (!productIsProcessed) {
                    products.add(currentProduct);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void addRobots(String[] robotsLine, ArrayList<Robot> robots) {
        for (int i = 0; i < robotsLine.length; i++) {
            String[] robotInfo = robotsLine[i].split("-");
            String name = robotInfo[0];
            long processingTime = Long.parseLong(robotInfo[1]);

            Robot robot = new Robot(name, processingTime);
            robots.add(robot);
        }
    }


    private static String getCurrentTime(long currentSeconds) {
        long hours = ((int) (currentSeconds / 3600)) % 24;
        long remainder = currentSeconds % 3600;
        long minutes = remainder / 60;
        long seconds = remainder % 60;

        String currentTime = String.format("[%02d:%02d:%02d]%n", hours, minutes, seconds);

        return currentTime;
    }

    public static class Robot {
        String name;

        long processingTime;

        boolean processingProduct;

        Long timeCurrentProductIsProcessed;

        public Robot(String name, long proccessingTime) {
            this.name = name;
            this.processingTime = proccessingTime;
            this.processingProduct = false;
            this.timeCurrentProductIsProcessed = null;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getProcessingTime() {
            return processingTime;
        }

        public void setProcessingTime(long processingTime) {
            this.processingTime = processingTime;
        }

        public boolean isProcessingProduct() {
            return processingProduct;
        }

        public void setProcessingProduct(boolean processingProduct) {
            this.processingProduct = processingProduct;
        }

        public Long getTimeCurrentProductIsProcessed() {
            return timeCurrentProductIsProcessed;
        }

        public void setTimeCurrentProductIsProcessed(Long timeCurrentProductIsProcessed) {
            this.timeCurrentProductIsProcessed = timeCurrentProductIsProcessed;
        }
    }
}
