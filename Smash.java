/**
 * @(#)Smash.java
 * 
 * 
 * 
 * @version 1.00 2018/4/28
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.*;

public class Smash extends JFrame implements ActionListener, KeyListener {
	Timer myTimer;
	GamePanel game;
	int screenX = 1300;
	int screenY = 800;
    Clip clip;


    public Smash() {
    	super("Super Smash Bros Brawl");
    	setSize(screenX, screenY);
    	myTimer = new Timer (10, this);
    	myTimer.start();
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("music.wav")));
            clip.start();
        }
        catch (Exception ex){
            System.err.println("Audio file 'music.wav' not found.");
        }
    	game = new GamePanel();
    	add(game);
    	addKeyListener(this);
    	setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(game != null){
    		game.refresh();
    		game.repaint();
    	}
    }

    public void keyTyped(KeyEvent e) {}
    
    public void keyPressed(KeyEvent e) {
    	game.setKey(e.getKeyCode(), true);
    }
    
    public void keyReleased(KeyEvent e) {
    	game.setKey(e.getKeyCode(), false);
    }
    
    public static void main(String[]args) {
    	new Smash();

    }
}