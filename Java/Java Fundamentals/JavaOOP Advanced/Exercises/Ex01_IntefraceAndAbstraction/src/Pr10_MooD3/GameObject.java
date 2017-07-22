package Pr10_MooD3;

public abstract class GameObject<T> implements Entity{
    private String userName;
    private String hashedPassword;
    private int level;
    private T specialPoints;

    protected GameObject(String userName, int level, T specialPoints) {
        this.setUserName(userName);
        this.setLevel(level);
        this.setSpecialPoints(specialPoints);
    }

   // protected abstract void setSpecialPoints(T points);


    private void setUserName(String userName) {
        this.userName = userName;
    }

    protected void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    protected void setSpecialPoints(T specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    protected T getSpecialPoints(){
        return this.specialPoints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\"%s\" | \"%s\" -> %s%n", this.getUsername(), this.getHashedPassword(), this.getClass().getSimpleName()));
        return sb.toString();
    }
}
