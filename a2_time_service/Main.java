package a2_time_service;

public class Main {
    public static void main(String[] args) {
        while (true) {
            TimeService.startService(75);
        }
    }

    // Ergebnis zu Aufgabe B) Verbindung von anderem Computer funktioniert.

    // Ergebnis zu Aufgabe C) Es kann nur eine Verbindung gleichzeitig hergestellt
    // werden, da der Server nur auf einem Thread ausgeführt wird.
}