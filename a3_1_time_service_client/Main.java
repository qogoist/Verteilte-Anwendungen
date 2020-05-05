package a3_1_time_service_client;

public class Main {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 75;

        System.out.println("Date: " + TimeServiceClient.dateFromServer(ip, port));
        System.out.println("Time: " + TimeServiceClient.timeFromServer(ip, port));
    }
}