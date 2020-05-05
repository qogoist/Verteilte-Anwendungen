package a1_1_eieruhr;

class Main {
    public static void main(String[] args) {
        eieruhr(5, "Testing!");
        eieruhr(10, "Longer Test");
    }

    public static void eieruhr(int s, String message) {
        EieruhrThread t = new EieruhrThread(s, message);
        t.start();
    }
}