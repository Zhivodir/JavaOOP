package les11.hw.task2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 16.11.2016.
 */
public class Server
{
    private int numAsk = 0;

    public Server() {
    }

    public static void main(String[] args) {
        String answer = getInfoAboutSystem();
        int port = 20000;
        try (ServerSocket soc = new ServerSocket(port)) {
            for (;;) {
                Socket socket = soc.accept();
                Client client = new Client(socket, answer);

                InputStream sin = socket.getInputStream();
                OutputStream sout = socket.getOutputStream();
            }
        } catch (IOException e) {
            System.out.println("Error to server Socket Open!!!");
        }
    }

    public static String getInfoAboutSystem(){
        StringBuilder sb = new StringBuilder();
        sb.append("OS name:" + System.getProperty("os.name") + System.lineSeparator());
        sb.append("OS arch.:" + System.getProperty("os.arch") + System.lineSeparator());
        sb.append("Available processors (cores): " + Runtime.getRuntime().availableProcessors() + System.lineSeparator());
        sb.append("JDK version:" + System.getProperty("java.specification.version") + System.lineSeparator());
        sb.append("Free memory (bytes): " + Runtime.getRuntime().freeMemory() + System.lineSeparator());
        /* This will return Long.MAX_VALUE if there is no preset limit */
        long maxMemory = Runtime.getRuntime().maxMemory();
        /* Maximum amount of memory the JVM will attempt to use */
        sb.append("Maximum memory (bytes): " + (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory) + System.lineSeparator());
        sb.append("Total memory available to JVM (bytes): " + Runtime.getRuntime().totalMemory() + System.lineSeparator());
        return sb.toString();
    }
}

