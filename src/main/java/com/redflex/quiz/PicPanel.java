package com.redflex.quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileFilter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class PicPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PicPanel(File topicFolder) {
		pics = topicFolder.listFiles(new FileFilter() {
		    @Override
		    public boolean accept(File file) {
		        return file.isFile() && !file.getName().startsWith(".");
		    }
		});
		for(File pic:pics) {
			System.out.println(" :: " + pic.getName());
		}
		System.out.println();
		init();
	}
	
	private File[] pics = null;
	private int curPicIdx = -1;
	private long showClickID = 0l;
	
	private JPanel actionBar = new JPanel(new MigLayout("","[][200::, fill]20[grow]10[]15[]10[]","[40::,fill]"));
	private JLabel picture = new JLabel();
	private JLabel answer = new JLabel();
	private JButton showAnswer = new JButton("Show answer");
	private JButton showClose = new JButton("Show");
	private JLabel status = new JLabel();
	private JButton next = new JButton("Next >>");
	public void init() {
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		setBorder(BorderFactory.createEtchedBorder());
		
		add(picture, BorderLayout.CENTER);
		add(actionBar, BorderLayout.SOUTH);

		actionBar.add(new JLabel("Answer: "));
		actionBar.add(answer);
		actionBar.add(showAnswer);
		actionBar.add(status);
		actionBar.add(next);
		actionBar.add(showClose);
		
		showPic();
		
		//picture.setBorder(BorderFactory.createLineBorder(Color.red));
		Font font = getFont().deriveFont(40f);
		answer.setFont(font);
		picture.setHorizontalAlignment(JTextField.CENTER);
		
		showAnswer.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
		showClose.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
		next.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
		
		answer.setVisible(false);
		showAnswer.addActionListener( (e)-> {
			answer.setVisible(true);
		} );
		next.addActionListener( (e)->{
			if(curPicIdx==pics.length-1) return;
			curPicIdx++;
			status.setText("Image " + (curPicIdx+1) + " of " + (pics.length) + "."  );
			showClose.setText("Show");
		} );
		showClose.addActionListener( (e)->{
			if(showClose.getText().equals("Close")) {
				showClickID = 0L;
				answer.setVisible(false); 
				picture.setIcon( new ImageIcon());
				showClose.setText("Show");
			}else if(showClose.getText().equals("Show")){
				showPic();
				showClickID = System.currentTimeMillis();
				setTimeout( new RunnableWithID(showClickID), Main.showForSeconds()*1000);
				showClose.setText("Close");
			}
		});
	}
	
	private void showPic() {
		answer.setVisible(false);
		if(curPicIdx>=0 && curPicIdx<pics.length) {
			answer.setText( cleanName(pics[curPicIdx].getName()) );
			String image = pics[curPicIdx].getAbsolutePath();
			ImageIcon imageOri = new ImageIcon( image );
			//double newWidth = Math.min( imageOri.getIconWidth() * 1d, getWidth());
			//double newHeight = imageOri.getIconHeight() * newWidth/getWidth();  
			//ImageIcon imageIcon = new ImageIcon( imageOri.getImage().getScaledInstance((int)newWidth, (int)newHeight, Image.SCALE_DEFAULT));
			picture.setIcon( imageOri );
			
		}else {
			status.setText("No selection of " + pics.length + ".");
			answer.setText("");
			picture.setIcon( new ImageIcon());
		}
	}
	
	private String cleanName(String name) {
		if(name.indexOf(".")>=0) return name.substring(0, name.indexOf("."));
		else return name;
	}
	
	public class RunnableWithID implements Runnable{
		private long id;
		RunnableWithID(long id){
			this.id = id;
		}
		@Override
		public void run() {
			//Schedule me with Swing
			SwingUtilities.invokeLater( ()->{
				//If I am still the latest "show" call, then I will close.
				if(showClickID==id && showClose.getText().equals("Close")) {
					showClose.doClick(50);
				}
			} );
		}
	}
	
	public static void setTimeout(Runnable inRunnable, int delay){
	    new Thread(() -> {
	    	//This anonymous runnable calls inRunnable 
	        try {
	            Thread.sleep(delay);
	            inRunnable.run();
	        }
	        catch (Exception e){
	            System.err.println(e);
	        }
	    }).start();
	}
}
