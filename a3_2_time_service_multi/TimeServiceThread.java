package a3_2_time_service_multi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TimeServiceThread extends Thread {

    private Socket socket;

    public TimeServiceThread(Socket socket) {
        this.socket = socket;
    }

    private void sendMessage(String message, BufferedWriter writer) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }

    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            sendMessage("time service", writer);

            Boolean exit = false;

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
        } catch (Exception e) {
        }
    }

}