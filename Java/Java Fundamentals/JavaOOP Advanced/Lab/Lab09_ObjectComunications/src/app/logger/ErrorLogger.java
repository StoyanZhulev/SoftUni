package app.logger;

public class ErrorLogger extends BaseLogger{

    private Handler successor;

    @Override
    public void handle(LogType type, String message) {
        if(type == LogType.ERROR || type == LogType.MAGIC){
            System.out.println(type.name() + ": " + message);
        }else{
            super.passToSuccessor(type, message);
        }
    }

}
