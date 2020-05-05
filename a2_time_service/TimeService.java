package a2_time_service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {

    private static void sendMessage(String message, BufferedWriter writer) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }

    public static void startService(int port) {
        Boolean exit = false;
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                sendMessage("time service", writer);

                while (!exit) {
                    String call = reader.readLine();

                    if (call == null)
                        break;

                    switch (call) {
                        case "time":
                            sendMessage(Clock.time(), writer);
                            break;
                        case "date":
                            sendMessage(Clock.date(), writer);
                            break;
                        default:
                            exit = true;
                            break;
                    }
                }

                socket.close();
            }

        } catch (Exception e) {
            System.out.print(e);
        }
    }
}