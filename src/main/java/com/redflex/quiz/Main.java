package com.redflex.quiz;

import com.formdev.flatlaf.FlatIntelliJLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());
		} catch (Exception e) {
			System.err.println("Failed to initialize FlatLaf look and feel");
			e.printStackTrace();
		}

		Main main = new Main();
		main.init();
	}
	
	private ScoresPanel scores = new ScoresPanel();
	private DirsPanel display = new DirsPanel();
	public void init() {
		setLayout(new MigLayout("","[grow, fill]","[][grow, fill]"));
		add(scores, "wrap");
		add(display);
				
		setSize(new Dimension(1000,700));
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		
		setTitle("Quiz - Build your own Picture quiz!");
		requestFocusInWindow();
		

	    addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent we) {
	        int result = JOptionPane.showConfirmDialog(Main.this,
	            "Do you want to Exit ?", "Exit Confirmation : ",
	            JOptionPane.YES_NO_OPTION);
	        if (result == JOptionPane.YES_OPTION)
	          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        else if (result == JOptionPane.NO_OPTION)
	          setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	      }
	    });
	}
	
	public static int showForSeconds() {
		return 10;
	}
}
