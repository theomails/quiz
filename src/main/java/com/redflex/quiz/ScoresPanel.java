package com.redflex.quiz;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class ScoresPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	

	private ScorePanel a = new ScorePanel("A");
	private ScorePanel b = new ScorePanel("B");
	private ScorePanel c = new ScorePanel("C");
	private ScorePanel d = new ScorePanel("D");
	private ScorePanel e = new ScorePanel("E");
	
	public ScoresPanel() {
		init();
	}
	
	public void init() {
		setLayout(new MigLayout("","[grow, fill]10[grow, fill]10[grow, fill]10[grow, fill]10[grow, fill]","[]"));
		setBorder(BorderFactory.createEtchedBorder());
		
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
	}
}
