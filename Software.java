package Cronometer;


// Imports
import java.util.Scanner;
import java.io.IOException;

public class Software {
    public static void main(String [] args) throws InterruptedException, IOException {
        // Variables' instance
        short option;
        int hours, min, sec;

        // Object's instance
        Cronometer x = new Cronometer();

        // Menu interface
        x.cls();
        System.out.println("--- [MENU] ---\n");
        System.out.println("[1] - Start progressive cronometer\n");
        System.out.println("[2] - Start regressive cronometer\n");
        System.out.println("[3] - Quit\n");

        try (Scanner prompt = new Scanner(System.in)) {
            System.out.println("[?] Your choice:");
            option = prompt.nextShort();

            switch (option) {
                case 1:
                   x.startCronometer(); 
                break;

                case 2:
                   System.out.println("[?] Enter a value to seconds:");
                   sec = prompt.nextInt();

                   System.out.println("[?] Enter a value to minutes:");
                   min = prompt.nextInt();

                   System.out.println("[?] Enter a value to hours:");
                   hours = prompt.nextInt();

                   x.startRegressiveCronometer(hours, min, sec);
                break;

                case 3:
                    x.cls();
                break;

                default: x.cls(); System.out.println("[X] Unsupported option!");
            }
        }
    }
}
