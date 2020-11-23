package a4_https_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HttpsClient {

    public static void getToConsole(String url) {
        try {
            Scanner scanner = new Scanner(get(url).toString());

            for (int i = 0; i < 50 && scanner.hasNextLine(); i++) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean urlExists(String s) {
        try {
            Scanner scanner = new Scanner(get(s).toString());
            String[] arr = scanner.nextLine().split(" ");

            boolean result = false;

            for (int i = 0; i < arr.length && !result; i++) {
                if (arr[i].equals("200") || arr[i].equals("OK"))
                    result = true;
            }

            return result;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static String getWebsite(String url){
        try {
            Scanner scanner = new Scanner(get(url).toString());

            String line = scanner.nextLine();
            while (!line.isEmpty()){
                line = scanner.nextLine();
            }

            scanner.useDelimiter("\\A");
            return scanner.next();
        } catch (Exception e) {
            return e.toString();
        }
    }

    private static StringBuffer get(String url) throws Exception {
        URL u = new URL(url);

        String host = u.getHost();
        int port = u.getPort();
        if (port == -1)
            port = 443; // standard https port
        String file = u.getFile();
        if (file.isEmpty())
            file = "/";

        // System.out.println(host + "; " + file + "; " + port);

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        writer.write("GET " + file + " HTTP/1.1");
        writer.newLine();
        writer.write("Host: " + host);
        writer.newLine();
        writer.write("");
        writer.newLine();
        writer.flush();

        StringBuffer str = new StringBuffer();

        String line = reader.readLine();
        while (line != null) {
            str.append(line);
            str.append(System.getProperty("line.separator"));
            line = reader.readLine();
        }

        socket.close();

        return str;
    }
}