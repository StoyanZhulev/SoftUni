package app.logger;

public abstract class BaseLogger implements Handler{
    private Handler successor;

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }

    protected void passToSuccessor(LogType type , String message){
        if(this.successor != null){
            this.successor.handle(type , message);
        }
    }
}
