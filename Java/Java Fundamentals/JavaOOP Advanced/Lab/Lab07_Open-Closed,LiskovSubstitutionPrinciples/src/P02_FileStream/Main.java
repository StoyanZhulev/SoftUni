package P02_FileStream;

public class Main {
    public static void main(String[] args) {
        StreamProgressInfo info = new StreamProgressInfo(new File(2048, 512, "Java file"));
        System.out.println(info.calculateCurrentPercent());

    }
}
