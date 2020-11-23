package a4_https_client;

public class Main {
    public static void main(String[] args) {
        // HttpsClient.getToConsole("https://www.bundestag.de/presse");
        // System.out.println(HttpsClient.urlExists("https://www.goadfaogle.de"));
        System.out.println(HttpsClient.getWebsite("https://www.bundestag.de/presse"));
    }
}