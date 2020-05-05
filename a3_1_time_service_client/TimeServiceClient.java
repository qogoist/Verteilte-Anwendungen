package a3_1_time_service_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TimeServiceClient {

    public static String dateFromServer(String ip, int port) {
        return communicate("date", ip, port);

    }

    public static String timeFromServer(String ip, int port) {
        return communicate("time", ip, port);
    }

    private static String communicate(String message, String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String answer = reader.readLine(); // required, otherwise this function always returns "time server"

            writer.write(message);
            writer.newLine();
            writer.flush();

            answer = reader.readLine();

            socket.close();

            return answer;
        } catch (Exception e) {
            return e.toString();
        }
    }
}