package a1_1_eieruhr;

public class EieruhrThread extends Thread {

    private int s;
    private String message;

    public EieruhrThread(int s, String message) {
        this.s = s;
        this.message = message;
    }

    public void run() {
        for (int i = s; i > 0; i--) {
            System.out.println(message + ": " + i + " seconds remaining.");
            schlafen(1);
        }
        
        System.out.println(message);
    }

    public static void schlafen(int m) {
        try {
            Thread.sleep(1000 * m);
        } catch (InterruptedException t) {
        }
    }
}