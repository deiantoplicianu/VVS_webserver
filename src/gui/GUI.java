package gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;

import src.ConfigManager;
import src.Configuration;
import src.MyWebServer;
import src.WebServer;

import javax.swing.*;

public class GUI {
	
//	private boolean startState = true;
//	private boolean maintenanceState = true;
//	private boolean stopState = true;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JButton startServerButton;
    private JButton maintenanceServerButton;
    private JButton stopServerButton;
    public static String text;
//    WebServer server = new WebServer();
    
	
	public GUI() {
		
		frame = new JFrame();
		startServerButton = new JButton("Start server");
//		startServerButton.addActionListener(this);
		startServerButton.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e)
	        {
	            //start action logic here
	        	
	        	text = "running";
	        	
	        	label.setText("Server is running on port 8080 ");

	        }
	    });
		maintenanceServerButton = new JButton("Start maintenance for the server");
//		maintenanceServerButton.addActionListener(this);
		maintenanceServerButton.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e)
	        {
	            //start action logic here
	        	
	        	text = "maintenance";
	        	
	        	label.setText("Server is in maintenance ");
	        	
	        }
	    });
		stopServerButton = new JButton("Stop server");
//		stopServerButton.addActionListener(this);
		stopServerButton.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e)
	        {
	            //start action logic here
	        	text = "stopped";
	        	
	        	label.setText("Server is stopped ");
	        }
	    });
		label = new JLabel("Server is not running");
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder( 300, 300, 300, 300));
		panel.setLayout(new GridLayout(0,1));
		panel.add(startServerButton);
		panel.add(maintenanceServerButton);
		panel.add(stopServerButton);
		panel.add(label);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("VVS Project GUI");
		frame.pack();
		frame.setVisible(true);
		
		 
	}

	public static void main(String[] args) {	
		new GUI();
		

	}
}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//		while(true) {
//			
//		if(startState == true) {
//			label.setText("Server is running ");
//			startState = false;
//			break;
//		}
//		
//		else if(maintenanceState == true) {
//			label.setText("Server is running on maintenance");
//			maintenanceState = false;
//			break;
//		}
//		
//		else {
//			label.setText("Server stopped");
//			stopState = false;
//			break;
//		}
//		
//		}
//	} 
	
	
