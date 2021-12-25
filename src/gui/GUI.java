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
	
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JButton startServerButton;
    private JButton maintenanceServerButton;
    private JButton stopServerButton;
    public static String text;
    
	
	public GUI() {
		
		frame = new JFrame();
		startServerButton = new JButton("Start server");
		startServerButton.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e)
	        {
	        	
	        	text = "running";	        	
	        	label.setText("Server is running on port 8080 ");

	        }
	    });
		maintenanceServerButton = new JButton("Start maintenance for the server");
		maintenanceServerButton.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e)
	        {
	        	
	        	text = "maintenance";	        	
	        	label.setText("Server is in maintenance ");
	        	
	        }
	    });
		stopServerButton = new JButton("Stop server");
		stopServerButton.addActionListener(new ActionListener() 
	    {
	        @Override
	        public void actionPerformed(ActionEvent e)
	        {
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
		frame.setTitle("WebServer GUI");
		frame.pack();
		frame.setVisible(true);
		
		 
	}

	public static void main(String[] args) {	
		new GUI();
		

	}
}
	
