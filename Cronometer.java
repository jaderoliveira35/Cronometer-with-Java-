package Cronometer;

import java.io.IOException;

public class Cronometer extends ACronometer {
    // Class methods
    public void p(String msg) {
        System.out.println(msg);
    }

    public void cls() throws InterruptedException, IOException {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }

    public void setHours(int hours) {
        super.hours = hours;
    }

    public void setRunning(int hours, int minutes, int seconds) {
        super.running = String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(seconds);
        p(this.getRunning());
    }

    public void setMinutes(int min) {
        super.minutes = min;
    }

    public void setSeconds(int sec) {
        super.seconds = sec;
    }

    public int getHours() {
        return super.hours;
    }

    public int getMinutes() {
        return super.minutes;
    }

    public int getSeconds() {
        return super.seconds;
    }

    public String getRunning() {
        return super.running;
    }

    public void startCronometer() throws InterruptedException, IOException {
        // Cronometer logic
        for (; ;) {
            Thread.sleep(1000);
            super.seconds++;

            if (this.getSeconds() == 60) {
                super.minutes++;
                this.setSeconds(0);
            }
    
            if (this.getMinutes() == 60) {
                super.hours++;
                this.setMinutes(0);
            }
    
            if (this.getHours() > 99 && this.getMinutes() == 60 && this.getSeconds() == 60) {
                this.setHours(0);
                this.setMinutes(0);
                this.setSeconds(0);

                cls();
                this.setRunning(this.getHours(), this.getMinutes(), this.getSeconds());

                break;
            }

            cls();
            this.setRunning(this.getHours(), this.getMinutes(), this.getSeconds());
        }
    }

    public void startRegressiveCronometer(int hours, int minutes, int seconds) throws InterruptedException, IOException {
        boolean run = false;

        // Check info given
        if (seconds > 59 || seconds < 0) {
            p("{X] You've entered invalid values to some option. Please check them!");
        } else if (minutes > 59 || minutes < 0) {
            p("[X] You've entered invalid values to some option. Please check them!");
        } else if (hours < 0) {
            p("[X] You've entered invalid values to some option. Please check them!");
        } else {
            this.setHours(hours);
            this.setMinutes(minutes);
            this.setSeconds(seconds);

            run = true;
        }

        // Regressive Cronometer logic
        for (; ;) {
            if (run == false) {
                break;
            } else {
                Thread.sleep(1000);
                super.seconds--;

                if (this.getSeconds() == -1) {
                    super.minutes--;
                    this.setSeconds(59);
                }

                if (this.getMinutes() == -1) {
                    super.hours--;
                    this.setMinutes(59);
                }

                if (this.getHours() == 0 && this.getMinutes() == 0 && this.getSeconds() == 0) {
                    cls();
                    this.setRunning(this.getHours(), this.getMinutes(), this.getSeconds());

                    break;
                }

                cls();
                this.setRunning(this.getHours(), this.getMinutes(), this.getSeconds());
            }
        }
    }
}
