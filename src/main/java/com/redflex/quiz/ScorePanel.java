package com.redflex.quiz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ScorePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private final String team;
	public ScorePanel(String team) {
		this.team = team;
		init();
	}
	
	private JTextField name = new JTextField();
	private JTextField score = new JTextField("0");
	private JButton plusBig = new JButton("+ 10");
	private JButton plusSmall = new JButton("+ 5");
	
	public void init() {
		setLayout(new MigLayout("insets 0","[grow, fill]5[grow, fill]","[40::,fill]"));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(),
				BorderFactory.createEmptyBorder(10,10,10,10)
		));

		add(name);
		add(score, "wrap");
		add(plusBig);
		add(plusSmall);
		
		name.setText("Team " + team);
		name.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		name.setForeground(Color.GRAY);
		name.setBackground( getBackground() );
		
		score.setHorizontalAlignment(JTextField.CENTER);
		
		plusBig.addActionListener( (e)->{
			int points = Integer.parseInt(score.getText());
			points += 10;
			score.setText( ""+points );
		} );
		plusSmall.addActionListener( (e)->{
			int points = Integer.parseInt(score.getText());
			points += 5;
			score.setText( ""+points );
		} );
		
		Font font = getFont().deriveFont(30f);
		name.setFont(font);
		score.setFont(font);
		//plusBig.setFont(font);
		//plusSmall.setFont(font);
	}
}
