package a3_2_time_service_multi;

import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {
    public static void startService(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                TimeServiceThread t = new TimeServiceThread(socket);
                t.start();
            }
        } catch (Exception e){
        }
    }
}