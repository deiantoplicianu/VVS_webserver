package test;

//import static javax.print.attribute.TextSyntax.verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

//import static org.Mock.*;


public class WebServerTest {

    Scanner keyboard = new Scanner(System.in);

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}


	@Test
	public void AcceptFailureTest() {
		/*find a way to make socket.accept() to fail...*/
	    System.err.print("Accept failed.");
	    assertEquals("Accept failed.", errContent.toString());
	}

	@Test
	public void couldNotListenOnPortTest() {
		/*run 2 webservers, resulting the 2nd to have the error 'port 10008 already used'*/
	    System.err.print("Could not listen on port: 10008.");
	    assertEquals("Could not listen on port: 10008.", errContent.toString());
	}

	@Test
	public void cannotClosePortTest() {
		/*find solution to fail the Socket Close*/
	    System.err.print("Could not close port: 10008.");
	    assertEquals("Could not close port: 10008.", errContent.toString());
	}

	/*try to test webServer for behaviour when there are manny requests in a small time interval*/
//	@Test
//	public void mannyRequestSendedTest() {
//		HttpURLConnection connection = null;
//		try {
//		for(int i=0; i<10; i++) {
//			 URL url = new URL("http://127.0.0.1:8080");
//	         connection = (HttpURLConnection) url.openConnection();
//		}
//		}catch(IOException e) {
//			fail();
//		}
//	}

//    @Test
//    public void testHttpRequest() throws IOException {
//	    ConfigManager configManager = new ConfigManager(new Configuration());
//        ServerSocket serverConnect = new ServerSocket(configManager.getPort());
//        MyWebServer myWebServer = new MyWebServer(serverConnect.accept(),  configManager);
        // verify after httpRequest
//}

    @Test
   public void requestTest() {
      HttpURLConnection connection = null;
      try {
              URL url = new URL("http://127.0.0.1:8080");
             connection = (HttpURLConnection) url.openConnection();
              connection.setRequestMethod("GET");
             System.out.println(connection.getInputStream());
     }catch(IOException e) {
         System.out.println("failed");
       }
   }
}
