package Pr01_Logger.controllers.files;

import Pr01_Logger.contracts.File;

public class LogFile implements File {
    private StringBuilder sb;

    public LogFile(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void write(String message){
        this.sb.append(message);
    }

    @Override
    public int getSize(){
        int sum = 0;
        for (char c : this.sb.toString().toCharArray()) {
            if (Character.isLetter(c)) {
                sum += (int)c;
            }
        }
        return sum;
    }
}
