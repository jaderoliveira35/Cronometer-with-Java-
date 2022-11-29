package Cronometer;

import java.io.IOException;

public interface ICronometer {
    // Interface commands
    public void p(String msg);
    public void cls() throws InterruptedException, IOException;
    public void setHours(int hours);
    public void setMinutes(int min);
    public void setSeconds(int sec);
    public int getHours();
    public int getMinutes();
    public int getSeconds();
    public void startCronometer() throws InterruptedException, IOException;
    public void startRegressiveCronometer(int hours, int min, int sec) throws InterruptedException, IOException;
    public void setRunning(int hours, int minutes, int seconds);
    public String getRunning();
}
