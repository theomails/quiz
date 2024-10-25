package com.redflex.quiz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DirsPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public DirsPanel() {
		init();
	}
	
	private File root = new File("."); //("/Users/theodore.r/Documents/emojis/emojis");
	private JTabbedPane folders = new JTabbedPane();
	public void init() {
		setLayout(new BorderLayout());
		add(folders, BorderLayout.CENTER);
		
		File[] topics = getDirectories();
		for(File topic:topics) {
			System.out.println("Showing topic: " + topic);
			folders.addTab(topic.getName(), new PicPanel(topic));
		}
	}
	
	private File[] getDirectories() {
		File[] directories = root.listFiles(new FileFilter() {
		    @Override
		    public boolean accept(File file) {
		        return file.isDirectory()  && !file.getName().startsWith(".");
		    }
		});
		
		return directories;
	}
}
