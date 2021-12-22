package src;

import exceptions.PortOutOfBoundException;
import exceptions.UsedPortException;
import gui.GUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertArrayEquals;

public class MyWebServer extends Thread{

    protected Socket clientSocket;
    
    static Scanner myObj = new Scanner(System.in); 
    
    

    public static void main(String[] args) throws IOException {
        GUI.main(null);
    	
    	ConfigManager configManager = new ConfigManager(new Configuration());
    	

        try {
            ServerSocket serverConnect = new ServerSocket(configManager.getPort());
            System.out.println("Server started.\nListening for connections on port : " + configManager.getPort());

            while (true) {
                
            	WebServer myServer = new WebServer(serverConnect.accept(), configManager);      	
                configManager.setState(GUI.text);

                if (Configuration.verbose) {
                    System.out.println("Connecton opened. (" + new Date() + ")");
                }

                Thread thread = new Thread(myServer);
                thread.start();
            }

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }

	

}
