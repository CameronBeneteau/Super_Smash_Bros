/**
 * @(#)GamePanel.java
 *
 *
 * @author 
 * @version 1.00 2018/4/28
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.*;

public class GamePanel extends JPanel {
	
	private boolean[] keys;
	private Integer moveNumber;
	private Rectangle basePlatform, platform1, platform2, platform3;
	private Rectangle basePlatform2, basePlatform3, basePlatform4;
	private Rectangle player1Left, player1Right;
	private Rectangle player1Rect, player2Rect, player2Left, player2Right;
	private Polygon basePoly, basePoly2, basePoly3, basePoly4;
	private Image mainBack, mainText, p1win, p2win;
	private Image map1, map2, map3, map4, moveImage, heart, small1, small2, small3, small4, title;
	private Player player1, player2;
	private double frame1, frame2 = 0;
	private String screen, map, type1, type2, direction1, direction2;
	private boolean attack1, attack2 = false;
	private Image[] moveRight1, moveLeft1, jumpRight1, jumpLeft1, standRight1, standLeft1, attackRight1, attackRight11, attackRight111, attackLeft1, attackLeft11, attackLeft111;
	private Image[] moveRight2, moveLeft2, jumpRight2, jumpLeft2, standRight2, standLeft2, attackRight2, attackRight22, attackRight222, attackLeft2, attackLeft22, attackLeft222;
	private int random1, random2;
	private double invincible1, invincible2;	
	
	public GamePanel(){
		keys = new boolean [KeyEvent.KEY_LAST+1];
		mainBack = new ImageIcon("mainBack.jpg").getImage();
		title = new ImageIcon("instructo.jpg").getImage();
		mainText = new ImageIcon("mainText.png").getImage();
		mainText = mainText.getScaledInstance(600, 450,Image.SCALE_SMOOTH);
		p1win = new ImageIcon("p1win.png").getImage();
		p1win = p1win.getScaledInstance(1000, 180,Image.SCALE_SMOOTH);
		p2win = new ImageIcon("p2win.png").getImage();
		p2win = p2win.getScaledInstance(1000, 180,Image.SCALE_SMOOTH);
		map1 = new ImageIcon("map1.jpg").getImage();
       	map2 = new ImageIcon("map2.jpg").getImage();
       	map3 = new ImageIcon("map3.png").getImage();
       	map4 = new ImageIcon("map4.jpg").getImage();
       	map4 = map4.getScaledInstance(1300, 800,Image.SCALE_SMOOTH);
       	map2 = map2.getScaledInstance(1500, 1000,Image.SCALE_SMOOTH);
       	small1 = map1.getScaledInstance(355, 200,Image.SCALE_SMOOTH);
       	small2 = map2.getScaledInstance(355, 200,Image.SCALE_SMOOTH);
       	small3 = map3.getScaledInstance(355, 200,Image.SCALE_SMOOTH);
       	small4 = map4.getScaledInstance(355, 200, Image.SCALE_SMOOTH);
        heart = new ImageIcon("heart.png").getImage();
        heart = heart.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
		player1 = new Player(300, 350);
        player2 = new Player(970, 350);

		basePoly = new Polygon();
		basePoly.addPoint(200, 520);
		basePoly.addPoint(400, 700);
		basePoly.addPoint(900, 700);
		basePoly.addPoint(1070, 520);
		basePoly2 = new Polygon();
		basePoly2.addPoint(200, 500);
		basePoly2.addPoint(400, 750);
		basePoly2.addPoint(900, 750);
		basePoly2.addPoint(1070, 500);
		basePoly3 = new Polygon();
		basePoly3.addPoint(285, 500);
		basePoly3.addPoint(400, 750);
		basePoly3.addPoint(900, 750);
		basePoly3.addPoint(1045, 500);
		basePoly4 = new Polygon();
		basePoly4.addPoint(200, 550);
		basePoly4.addPoint(400, 800);
		basePoly4.addPoint(900, 800);
		basePoly4.addPoint(1095, 550);
		
		screen = "menu";
		map = "";
		direction1 = "right";
		direction2 = "left";
		type1 = "ground";
		type2 = "ground";
		
		moveRight1 = new Image[6];
		moveRight1[0] = new ImageIcon("guy/guyRunRight/guy001.png").getImage();
		moveRight1[1] = new ImageIcon("guy/guyRunRight/guy002.png").getImage();
		moveRight1[2] = new ImageIcon("guy/guyRunRight/guy003.png").getImage();
		moveRight1[3] = new ImageIcon("guy/guyRunRight/guy004.png").getImage();
		moveRight1[4] = new ImageIcon("guy/guyRunRight/guy005.png").getImage();
		moveRight1[5] = new ImageIcon("guy/guyRunRight/guy006.png").getImage();
		
		moveLeft1 = new Image[6];
		moveLeft1[0] = new ImageIcon("guy/guyRunLeft/guy001.png").getImage();
		moveLeft1[1] = new ImageIcon("guy/guyRunLeft/guy002.png").getImage();
		moveLeft1[2] = new ImageIcon("guy/guyRunLeft/guy003.png").getImage();
		moveLeft1[3] = new ImageIcon("guy/guyRunLeft/guy004.png").getImage();
		moveLeft1[4] = new ImageIcon("guy/guyRunLeft/guy005.png").getImage();
		moveLeft1[5] = new ImageIcon("guy/guyRunLeft/guy006.png").getImage();
		
		jumpRight1 = new Image[1];
		jumpRight1[0] = new ImageIcon("guy/guyJumpRight/guy001.png").getImage();
		
		jumpLeft1 = new Image[1];
		jumpLeft1[0] = new ImageIcon("guy/guyJumpLeft/guy001.png").getImage();
		
		standRight1 = new Image[4];
		standRight1[0] = new ImageIcon("guy/guyStandRight/guy001.png").getImage();
		standRight1[1] = new ImageIcon("guy/guyStandRight/guy002.png").getImage();
		standRight1[2] = new ImageIcon("guy/guyStandRight/guy003.png").getImage();
		standRight1[3] = new ImageIcon("guy/guyStandRight/guy004.png").getImage();
		
		standLeft1 = new Image[4];
		standLeft1[0] = new ImageIcon("guy/guyStandLeft/guy001.png").getImage();
		standLeft1[1] = new ImageIcon("guy/guyStandLeft/guy002.png").getImage();
		standLeft1[2] = new ImageIcon("guy/guyStandLeft/guy003.png").getImage();
		standLeft1[3] = new ImageIcon("guy/guyStandLeft/guy004.png").getImage();
		
		attackRight1 = new Image[4];
		attackRight1[0] = new ImageIcon("guy/guyAttackRight/guy001.png").getImage();
		attackRight1[1] = new ImageIcon("guy/guyAttackRight/guy002.png").getImage();
		attackRight1[2] = new ImageIcon("guy/guyAttackRight/guy003.png").getImage();
		attackRight1[3] = new ImageIcon("guy/guyAttackRight/guy004.png").getImage();

		attackRight11 = new Image[4];
		attackRight11[0] = new ImageIcon("guy/guyAttackRight/guy005.png").getImage();
		attackRight11[1] = new ImageIcon("guy/guyAttackRight/guy006.png").getImage();
		attackRight11[2] = new ImageIcon("guy/guyAttackRight/guy007.png").getImage();
		attackRight11[3] = new ImageIcon("guy/guyAttackRight/guy008.png").getImage();

		attackRight111 = new Image[4];
		attackRight111[0] = new ImageIcon("guy/guyAttackRight/guy009.png").getImage();
		attackRight111[1] = new ImageIcon("guy/guyAttackRight/guy010.png").getImage();
		attackRight111[2] = new ImageIcon("guy/guyAttackRight/guy011.png").getImage();
		attackRight111[3] = new ImageIcon("guy/guyAttackRight/guy012.png").getImage();

		attackLeft1 = new Image[4];
		attackLeft1[0] = new ImageIcon("guy/guyAttackLeft/guy001.png").getImage();
		attackLeft1[1] = new ImageIcon("guy/guyAttackLeft/guy002.png").getImage();
		attackLeft1[2] = new ImageIcon("guy/guyAttackLeft/guy003.png").getImage();
		attackLeft1[3] = new ImageIcon("guy/guyAttackLeft/guy004.png").getImage();

		attackLeft11 = new Image[4];
		attackLeft11[0] = new ImageIcon("guy/guyAttackLeft/guy005.png").getImage();
		attackLeft11[1] = new ImageIcon("guy/guyAttackLeft/guy006.png").getImage();
		attackLeft11[2] = new ImageIcon("guy/guyAttackLeft/guy007.png").getImage();
		attackLeft11[3] = new ImageIcon("guy/guyAttackLeft/guy008.png").getImage();

		attackLeft111 = new Image[4];
		attackLeft111[0] = new ImageIcon("guy/guyAttackLeft/guy009.png").getImage();
		attackLeft111[1] = new ImageIcon("guy/guyAttackLeft/guy010.png").getImage();
		attackLeft111[2] = new ImageIcon("guy/guyAttackLeft/guy011.png").getImage();
		attackLeft111[3] = new ImageIcon("guy/guyAttackLeft/guy012.png").getImage();
		////////////////////////////////////////////////////////////////////////////////////////////
		moveRight2 = new Image[6];
		moveRight2[0] = new ImageIcon("mega/megaRunRight/mega001.png").getImage();
		moveRight2[1] = new ImageIcon("mega/megaRunRight/mega002.png").getImage();
		moveRight2[2] = new ImageIcon("mega/megaRunRight/mega003.png").getImage();
		moveRight2[3] = new ImageIcon("mega/megaRunRight/mega004.png").getImage();
		moveRight2[4] = new ImageIcon("mega/megaRunRight/mega005.png").getImage();
		moveRight2[5] = new ImageIcon("mega/megaRunRight/mega006.png").getImage();

		moveLeft2 = new Image[6];
		moveLeft2[0] = new ImageIcon("mega/megaRunLeft/mega001.png").getImage();
		moveLeft2[1] = new ImageIcon("mega/megaRunLeft/mega002.png").getImage();
		moveLeft2[2] = new ImageIcon("mega/megaRunLeft/mega003.png").getImage();
		moveLeft2[3] = new ImageIcon("mega/megaRunLeft/mega004.png").getImage();
		moveLeft2[4] = new ImageIcon("mega/megaRunLeft/mega005.png").getImage();
		moveLeft2[5] = new ImageIcon("mega/megaRunLeft/mega006.png").getImage();

		jumpRight2 = new Image[1];
		jumpRight2[0] = new ImageIcon("mega/megaJumpRight/mega001.png").getImage();

		jumpLeft2 = new Image[1];
		jumpLeft2[0] = new ImageIcon("mega/megaJumpLeft/mega001.png").getImage();

		standRight2 = new Image[4];
		standRight2[0] = new ImageIcon("mega/megaStandRight/mega001.png").getImage();
		standRight2[1] = new ImageIcon("mega/megaStandRight/mega002.png").getImage();
		standRight2[2] = new ImageIcon("mega/megaStandRight/mega003.png").getImage();
		standRight2[3] = new ImageIcon("mega/megaStandRight/mega004.png").getImage();

		standLeft2 = new Image[4];
		standLeft2[0] = new ImageIcon("mega/megaStandLeft/mega001.png").getImage();
		standLeft2[1] = new ImageIcon("mega/megaStandLeft/mega002.png").getImage();
		standLeft2[2] = new ImageIcon("mega/megaStandLeft/mega003.png").getImage();
		standLeft2[3] = new ImageIcon("mega/megaStandLeft/mega004.png").getImage();

		attackRight2 = new Image[4];
		attackRight2[0] = new ImageIcon("mega/megaAttackRight/mega001.png").getImage();
		attackRight2[1] = new ImageIcon("mega/megaAttackRight/mega002.png").getImage();
		attackRight2[2] = new ImageIcon("mega/megaAttackRight/mega003.png").getImage();
		attackRight2[3] = new ImageIcon("mega/megaAttackRight/mega004.png").getImage();

		attackRight22 = new Image[4];
		attackRight22[0] = new ImageIcon("mega/megaAttackRight/mega005.png").getImage();
		attackRight22[1] = new ImageIcon("mega/megaAttackRight/mega006.png").getImage();
		attackRight22[2] = new ImageIcon("mega/megaAttackRight/mega007.png").getImage();
		attackRight22[3] = new ImageIcon("mega/megaAttackRight/mega008.png").getImage();

		attackRight222 = new Image[4];
		attackRight222[0] = new ImageIcon("mega/megaAttackRight/mega009.png").getImage();
		attackRight222[1] = new ImageIcon("mega/megaAttackRight/mega010.png").getImage();
		attackRight222[2] = new ImageIcon("mega/megaAttackRight/mega011.png").getImage();
		attackRight222[3] = new ImageIcon("mega/megaAttackRight/mega012.png").getImage();

		attackLeft2 = new Image[4];
		attackLeft2[0] = new ImageIcon("mega/megaAttackLeft/mega001.png").getImage();
		attackLeft2[1] = new ImageIcon("mega/megaAttackLeft/mega002.png").getImage();
		attackLeft2[2] = new ImageIcon("mega/megaAttackLeft/mega003.png").getImage();
		attackLeft2[3] = new ImageIcon("mega/megaAttackLeft/mega004.png").getImage();

		attackLeft22 = new Image[4];
		attackLeft22[0] = new ImageIcon("mega/megaAttackLeft/mega005.png").getImage();
		attackLeft22[1] = new ImageIcon("mega/megaAttackLeft/mega006.png").getImage();
		attackLeft22[2] = new ImageIcon("mega/megaAttackLeft/mega007.png").getImage();
		attackLeft22[3] = new ImageIcon("mega/megaAttackLeft/mega008.png").getImage();

		attackLeft222 = new Image[4];
		attackLeft222[0] = new ImageIcon("mega/megaAttackLeft/mega009.png").getImage();
		attackLeft222[1] = new ImageIcon("mega/megaAttackLeft/mega010.png").getImage();
		attackLeft222[2] = new ImageIcon("mega/megaAttackLeft/mega011.png").getImage();
		attackLeft222[3] = new ImageIcon("mega/megaAttackLeft/mega012.png").getImage();
	}
	  
	public void setKey(int k, boolean v) {
    	keys[k] = v;
    }
	
    public void refresh(){
    	Random random = new Random();
    	if (screen.equals("menu")){
    		if (keys[KeyEvent.VK_ENTER]){
    			screen = "instructions";
    		}
    	}
    	if (screen.equals("instructions")){
    		if (keys[KeyEvent.VK_SPACE]){
    			screen = "mapChoose";
    		}
    	}
    	if (screen.equals("mapChoose")){
    		if (keys[KeyEvent.VK_1]){
    			screen = "game";
    			map = "map1";
    		}
    		if (keys[KeyEvent.VK_2]){
    			screen = "game";
    			map = "map2";
    		}
    		if (keys[KeyEvent.VK_3]){
    			screen = "game";
    			map = "map3";
    		}
    		if (keys[KeyEvent.VK_4]){
    			screen = "game";
    			map = "map4";
    		}
    	}
    	if (screen.equals("game")){
	    	basePlatform = new Rectangle(165, 510, 955, 10);
	    	basePlatform2 = new Rectangle(170, 485, 940, 10);
	    	basePlatform3 = new Rectangle(230, 485, 850, 10);
	    	basePlatform4 = new Rectangle(160, 540, 975, 10);
			platform1 = new Rectangle(527, 223, 230, 15);
			platform2 = new Rectangle(270, 365, 230, 15);
			platform3 = new Rectangle(790, 365, 230, 15);
			
	    	player1Rect = new Rectangle(player1.getX(), player1.getY(), 50, 58);
	    	player1Left = new Rectangle(player1.getX() - 20, player1.getY(), 50, 58);
	    	player1Right = new Rectangle(player1.getX() + 20, player1.getY(), 50, 58);

	    	player2Rect = new Rectangle(player2.getX(), player2.getY(), 50, 58);
	    	player2Left = new Rectangle(player2.getX() - 20, player2.getY(), 50, 58);
	    	player2Right = new Rectangle(player2.getX() + 20, player2.getY(), 50, 58);
	    	//////////////////////////////////////////////////////////////////////////
	    	if (!type1.equals("attacking")){
		    	if (map.equals("map1")){
			        if (basePlatform.contains(player1.getX(), player1.getY() + 58) || basePlatform.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.resetJump();
			            type1 = "ground";
			        }
			        else if (platform1.contains(player1.getX(), player1.getY() + 58) || platform1.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.resetJump();
			            type1 = "ground";
			        }
			        else if (platform2.contains(player1.getX(), player1.getY() + 58) || platform2.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.resetJump();
			            type1 = "ground";
			        }
			        else if (platform3.contains(player1.getX(), player1.getY() + 58) || platform3.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.resetJump();
			            type1 = "ground";
			        }
			        else if (basePoly.contains(player1.getX(), player1.getY()) || basePoly.contains(player1.getX() + 50, player1.getY()) || basePoly.contains(player1.getX(), player1.getY() + 58) || basePoly.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.stop();
			            player1.fall();
			        }
			        else{
			            player1.fall();
			            type1 = "air";
			        }
		    	}
		    	//////////////////////////////////////////////////////////////////////////
		    	else if (map.equals("map2")){
		    		if (basePlatform2.contains(player1.getX(), player1.getY() + 58) || basePlatform2.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.resetJump();
			            type1 = "ground";
			        }
			        else if (basePoly2.contains(player1.getX(), player1.getY()) || basePoly2.contains(player1.getX() + 50, player1.getY()) || basePoly2.contains(player1.getX(), player1.getY() + 58) || basePoly2.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.stop();
			            player1.fall();
			        }
			        else{
			            player1.fall();
			            type1 = "air";
			        }
			   	}
		    	//////////////////////////////////////////////////////////////////////////
		    	else if (map.equals("map3")){
		    		if (basePlatform3.contains(player1.getX(), player1.getY() + 58) || basePlatform3.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.resetJump();
			            type1 = "ground";
			        }
			        else if (basePoly3.contains(player1.getX(), player1.getY()) || basePoly3.contains(player1.getX() + 50, player1.getY()) || basePoly3.contains(player1.getX(), player1.getY() + 58) || basePoly3.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.stop();
			            player1.fall();
			        }
			        else{
			            player1.fall();
			            type1 = "air";
			        }
		    	}
		    	//////////////////////////////////////////////////////////////////////////
		    	else if (map.equals("map4")){
		    		if (basePlatform4.contains(player1.getX(), player1.getY() + 58) || basePlatform4.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.resetJump();
			            type1 = "ground";
			        }
			        else if (basePoly4.contains(player1.getX(), player1.getY()) || basePoly4.contains(player1.getX() + 50, player1.getY()) || basePoly4.contains(player1.getX(), player1.getY() + 58) || basePoly4.contains(player1.getX() + 50, player1.getY() + 58)){
			            player1.stop();
			            player1.fall();
			        }
			        else{
			            player1.fall();
			            type1 = "air";
			        }
		    	}
	    	}
	    	//////////////////////////////////////////////////////////////////////////
	    	if (!type2.equals("attacking")){
		    	if (map.equals("map1")){
		    		if (basePlatform.contains(player2.getX(), player2.getY() + 58) || basePlatform.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.resetJump();
			            type2 = "ground";
			        }
			        else if (platform1.contains(player2.getX(), player2.getY() + 58) || platform1.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.resetJump();
			            type2 = "ground";
			        }
			        else if (platform2.contains(player2.getX(), player2.getY() + 58) || platform2.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.resetJump();
			            type2 = "ground";
			        }
			        else if (platform3.contains(player2.getX(), player2.getY() + 58) || platform3.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.resetJump();
			            type2 = "ground";
			        }
			        else if (basePoly.contains(player2.getX(), player2.getY()) || basePoly.contains(player2.getX() + 50, player2.getY()) || basePoly.contains(player2.getX(), player2.getY() + 58) || basePoly.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.stop();
			            player2.fall();
			        }
			        else{
			            player2.fall();
			            type2 = "air";
			        }
		    	}
		    	else if (map.equals("map2")){
		    		if (basePlatform2.contains(player2.getX(), player2.getY() + 58) || basePlatform2.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.resetJump();
			            type2 = "ground";
			        }
			        else if (basePoly2.contains(player2.getX(), player2.getY()) || basePoly2.contains(player2.getX() + 50, player2.getY()) || basePoly2.contains(player2.getX(), player2.getY() + 58) || basePoly2.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.stop();
			            player2.fall();
			        }
			        else{
			            player2.fall();
			            type2 = "air";
			        }
		    	}
		    	else if (map.equals("map3")){
			        if (basePlatform3.contains(player2.getX(), player2.getY() + 58) || basePlatform3.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.resetJump();
			            type2 = "ground";
			        }
			        else if (basePoly3.contains(player2.getX(), player2.getY()) || basePoly3.contains(player2.getX() + 50, player2.getY()) || basePoly3.contains(player2.getX(), player2.getY() + 58) || basePoly3.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.stop();
			            player2.fall();
			        }
			        else{
			            player2.fall();
			            type2 = "air";
			        }
		    	}
		    	else if (map.equals("map4")){
		    		if (basePlatform4.contains(player2.getX(), player2.getY() + 58) || basePlatform4.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.resetJump();
			            type2 = "ground";
			        }
			        else if (basePoly4.contains(player2.getX(), player2.getY()) || basePoly4.contains(player2.getX() + 50, player2.getY()) || basePoly4.contains(player2.getX(), player2.getY() + 58) || basePoly4.contains(player2.getX() + 50, player2.getY() + 58)){
			            player2.stop();
			            player2.fall();
			        }
			        else{
			            player2.fall();
			            type2 = "air";
			        }
		    	}
	    	}
	    	//////////////////////////////////////////////////////////////////////////
	    	if (keys[KeyEvent.VK_V]){
	    		if (!type1.equals("air")){
	    			type1 = "attacking";
	    			random1 = random.nextInt(3) + 1;
	    		}
	    	}
	    	if (!type1.equals("attacking")){
		    	if (keys[KeyEvent.VK_W]){
		    		if (player1.getJump() == false && player1.getJumpCount() < 2){
		    			player1.jump();
		    			type1 = "air";
		    			if (direction1.equals("right")){
		    				direction1 = "right";
		    			}
		    			if (direction1.equals("left")){
		    				direction1 = "left";
		    			}
		    			
		    		}
		    	}
		    	if (keys[KeyEvent.VK_S]){
			    	if (!basePlatform.contains(player1.getX(), player1.getY() + 58) && !type1.equals("air") || !basePlatform.contains(player1.getX() + 50, player1.getY() + 58) && !type1.equals("air")){
			        	if (map.equals("map1")){
			        		player1.maxJumpCount();
			        		player1.fall();
			       		 }
			    	}
			    }
			    if (keys[KeyEvent.VK_A]){
			    	direction1 = "left";
			    	if (!type1.equals("air")){
			    		type1 = "run";
			    	}
			    	player1.moveLeft();
			    }
			   	if (keys[KeyEvent.VK_D]){
			        direction1 = "right";
			       	if (!type1.equals("air")){
			    		type1 = "run";
			    	}
			        player1.moveRight();
			    }
			}
	    	//////////////////////////////////////////////////////////////////////////
	    	if (keys[KeyEvent.VK_PERIOD]){
	    		if (!type2.equals("air")){
	    			type2 = "attacking";
	    			random2 = random.nextInt(3) + 1;
	    		}
	    	}
	    	if (!type2.equals("attacking")){
		    	if (keys[KeyEvent.VK_UP]){
		    		if (player2.getJump() == false && player2.getJumpCount() < 2){
		    			player2.jump();
		    			type2 = "air";
		    			if (direction2.equals("right")){
		    				direction2 = "right";
		    			}
		    			if (direction2.equals("left")){
		    				direction2 = "left";
		    			}
		    		}
		    	}
		    	if (keys[KeyEvent.VK_DOWN]){
		    		if (map.equals("map1")){
			    		if (!basePlatform.contains(player2.getX(), player2.getY() + 58) && !type2.equals("air") || !basePlatform.contains(player2.getX() + 50, player2.getY() + 58) && !type2.equals("air")){
			        		player2.maxJumpCount();
			        		player2.fall();
			        	}  
			        }        
			    }
		    	if (keys[KeyEvent.VK_LEFT]){
			    	direction2 = "left";
			    	if (!type2.equals("air")){
			    		type2 = "run";
			    	}
			    	player2.moveLeft();
			    }
			   	if (keys[KeyEvent.VK_RIGHT]){
			        direction2 = "right";
			       	if (!type2.equals("air")){
			    		type2 = "run";
			    	}
			        player2.moveRight();
			    }
			}
	    	//////////////////////////////////////////////////////////////////////////
	        if (player1.getJump() == true){
	            player1.jump();
	        }
	        if (type1.equals("attacking")){
	        	if (frame1 > 3){ 
	        		type1 = "ground";      		
	            	frame1 = 0;
	            }
	            else{
	            	frame1 += 0.1;
	            }
	        }
	        else if (type1.equals("ground")){
	        	if (frame1 > 3){        		
	            	frame1 = 0;
	            }
	            else{
	            	frame1 += 0.07;
	            }
	        }
	        else if (type1.equals("run")){
	        	if (frame1 > 5){
	            	frame1 = 0;
	            }
	            else{
	            	frame1 += 0.1;
	            }	
	        }
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        if (player2.getJump() == true){
	            player2.jump();
	        }
	        if (type2.equals("attacking")){
	        	if (frame2 > 3){ 
	        		type2 = "ground";      		
	            	frame2 = 0;
	            }
	            else{
	            	frame2 += 0.07;
	            }
	        }
	        else if (type2.equals("ground")){
	        	if (frame2 > 3){        		
	            	frame2 = 0;
	            }
	            else{
	            	frame2 += 0.07;
	            }
	        }
	        else if (type2.equals("run")){
	        	if (frame2 > 5){
	            	frame2 = 0;
	            }
	            else{
	            	frame2 += 0.15;
	            }	
	        }
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        if (invincible1 > 10){
	        	if (direction2.equals("right") && type2.equals("attacking") && player1Rect.intersects(player2Right)){
	        		player1.takeDamage();
	        	}
	        	else{
	        		if (direction2.equals("left") && type2.equals("attacking") && player1Rect.intersects(player2Left)){
						player1.takeDamage();
	        		}
	        	}
		    }
		    if (invincible2 > 10){
		        if (direction1.equals("right") && type1.equals("attacking") && player2Rect.intersects(player1Right)){
	        		player2.takeDamage();
	        	}
	        	else{
	        		if (direction1.equals("left") && type1.equals("attacking") && player2Rect.intersects(player1Left)){
						player2.takeDamage();
	        		}
	        	}
		    }
	        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        if (player1.getHp() <= 0){
	        	player1.loseLife();
	        	if (player1.getLives() == 0){
	        		screen = "player2win";
	        	}
	        	else{
		        	player1.reset();
		        	invincible1 = 0;
		        }
	        }
	        if (player1.getY() > 800){
	        	player1.kill();
	        	invincible1 = 0;
	        }
	        if (player2.getHp() <= 0){
	        	player2.loseLife();
	        	if (player2.getLives() == 0){
	        		screen = "player1win";
	        	}
	        	else{
		        	player2.reset();
		        	invincible2 = 0;
		        }
	        }
	        if (player2.getY() > 800){
	        	player2.kill();
	        	invincible2 = 0;
	        }
	        invincible1 += 0.05;
	        invincible2 += 0.05;
    	}
    	if (screen.equals("player1win")){
    		if (keys[KeyEvent.VK_ESCAPE]){
    			player1.resetAll();
    			player2.resetAll();
    			screen = "menu";
    		}
    	}
    	if (screen.equals("player2win")){
    		if (keys[KeyEvent.VK_ESCAPE]){
    			player1.resetAll();
    			player2.resetAll();
    			screen = "menu";
    		}
    	}
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(new Color(255, 255, 255));
        if (screen.equals("menu")){
        	g.drawImage(mainBack, 0, 0, this);
        	g.drawImage(mainText, 360, 100, this);
        	g.setFont(new Font("Earth Orbiter", Font.PLAIN, 30));
        	g.drawString("Cameron Beneteau & Luka David", 10, 30);
        	g.setFont(new Font("Earth Orbiter", Font.PLAIN, 55));
        	g.drawString("Press ENTER to start", 330, 640);
        }
        if (screen.equals("instructions")){
        	g.drawImage(title, 0, -4, this);
        	g.setFont(new Font("Earth Orbiter", Font.PLAIN, 50));
        	//g.drawString("Instructions", 550, 80);
        	g.drawString("Press SPACE to continue", 490, 630);
        	//g.setFont(new Font("Felix Tiling", Font.PLAIN, 25));
        	//g.drawString("This is a battle to the death! Each person gets 3 lives for the match.", 50, 200);
        	//g.drawString("The first person to defeat their opponent 3 times wins!", 50, 250);
        	//g.drawString("The controls are as follows:", 50, 350);
        	//g.drawString("Player 1: WASD to move and V to attack", 50, 400);
        	//g.drawString("Player 2: Arrow Keys to move and '.' to attack", 50, 450);
        }
        if (screen.equals("mapChoose")){
        	g.drawImage(mainBack, 0, 0, this);
        	g.setFont(new Font("Earth Orbiter", Font.PLAIN, 50));
        	g.drawString("Choose Your Map", 420, 80);
        	g.setFont(new Font("Earth Orbiter", Font.PLAIN, 30));
        	g.drawImage(small1, 220, 150, this);
        	g.drawImage(small2, 700, 150, this);
        	g.drawImage(small3, 220, 450, this);
        	g.drawImage(small4, 700, 450, this);
        	g.drawString("Press 1", 240, 380);
        	g.drawString("Press 2", 720, 380);
        	g.drawString("Press 3", 240, 680);
        	g.drawString("Press 4", 720, 680);
        }
        if (screen.equals("game")){
        	if (map.equals("map1")){
	        	g.drawImage(map1, -300, -200, this);

	       		g.setColor(new Color(0, 0, 0));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
	        	//g2.draw(basePoly);
	        	//g2.draw(basePlatform);
	    	    //g2.draw(platform1);
	  	      	//g2.draw(platform2);
	  	      	//g2.draw(platform3);
        	}
        	else if (map.equals("map2")){
        		g.drawImage(map2, -100, -100, this);

	       		g.setColor(new Color(255, 105, 0));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform2);
        		//g2.draw(basePoly2);
        	}
        	else if (map.equals("map3")){
        		g.drawImage(map3, -300, -100, this);

        		g.setColor(new Color(255, 255, 255));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform3);
        		//g2.draw(basePoly3);
        	}
        	else if (map.equals("map4")){
        		g.drawImage(map4, 0, 0, this);
        		
	       		g.setColor(new Color(255, 255, 255));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform4);
        		//g2.draw(basePoly4);
 		}
	        
	        //g2.drawRect(player1.getX(), player1.getY(), 50, 58);
	       	//g2.draw(player1Left);
	       	//g2.draw(player1Right);

	        //g2.drawRect(player2.getX(), player2.getY(), 50, 58);
	        //g2.draw(player2Left);
	       	//g2.draw(player2Right);
	        
	        for (int i = 0; i < player1.getLives(); i++){
	        	g.drawImage(heart, 30 + i * 65 , 50 , this);
	        }
	        for (int i = 0; i < player2.getLives(); i++){
	        	g.drawImage(heart, 1080 + i * 65 , 50 , this);
	        }

	        if (direction1.equals("right") && type1.equals("run")){
	        	g.drawImage(moveRight1[(int) frame1], player1.getX(), player1.getY() + 10, this);
	        }
	        else if (direction1.equals("left") && type1.equals("run")){
	        	g.drawImage(moveLeft1[(int) frame1], player1.getX(), player1.getY() + 10, this);
	        }
	        else if (direction1.equals("right") && type1.equals("air")){
	        	g.drawImage(jumpRight1[0], player1.getX(), player1.getY(), this);
	        }
	        else if (direction1.equals("left") && type1.equals("air")){
	        	g.drawImage(jumpLeft1[0], player1.getX(), player1.getY(), this);
	        }
	        else if (direction1.equals("right") && type1.equals("ground")){
	        	g.drawImage(standRight1[(int) frame1], player1.getX(), player1.getY(), this);
	        }
	        else if (direction1.equals("left") && type1.equals("ground")){
	        	g.drawImage(standLeft1[(int) frame1], player1.getX(), player1.getY(), this);
	        }
	        else if (direction1.equals("right") && type1.equals("attacking")){
	        	if (random1 == 1){
	        		g.drawImage(attackRight1[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        	if (random1 == 2){
	        		g.drawImage(attackRight11[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        	else{
	        		g.drawImage(attackRight111[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        }
	        else if (direction1.equals("left") && type1.equals("attacking")){
	        	if (random1 == 1){
	        		g.drawImage(attackLeft1[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        	if (random1 == 2){
	        		g.drawImage(attackLeft11[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        	else{
	        		g.drawImage(attackLeft111[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        }
	        ///////////////////////////////////////////////////////////////////////////////////////
	        if (direction2.equals("right") && type2.equals("run")){
	        	g.drawImage(moveRight2[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        }
	        else if (direction2.equals("left") && type2.equals("run")){
	        	g.drawImage(moveLeft2[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        }
	        else if (direction2.equals("right") && type2.equals("air")){
	        	g.drawImage(jumpRight2[0], player2.getX(), player2.getY(), this);
	        }
	        else if (direction2.equals("left") && type2.equals("air")){
	        	g.drawImage(jumpLeft2[0], player2.getX(), player2.getY(), this);
	       	}
	        else if (direction2.equals("right") && type2.equals("ground")){
	        	g.drawImage(standRight2[(int) frame2], player2.getX(), player2.getY() - 5, this);
	        }
	        else if (direction2.equals("left") && type2.equals("ground")){
	        	g.drawImage(standLeft2[(int) frame2], player2.getX(), player2.getY() - 5, this);
	        }
	        else if (direction2.equals("right") && type2.equals("attacking")){
	        	if (random2 == 1){
	        		g.drawImage(attackRight2[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        	if (random2 == 2){
	        		g.drawImage(attackRight22[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        	else{
	        		g.drawImage(attackRight222[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        }
	        else if (direction2.equals("left") && type2.equals("attacking")){
	        	if (random2 == 1){
	        		g.drawImage(attackLeft2[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        	if (random2 == 2){
	        		g.drawImage(attackLeft22[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        	else{
	        		g.drawImage(attackLeft222[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        }
	        g.setColor(new Color(255, 255, 255));
	        if (invincible1 < 10){
	        	g.fillRect(player1.getX() + 10, player1.getY() - 10, 30, 5);
	        }
	        if (invincible2 < 10){
	        	g.fillRect(player2.getX() + 10, player2.getY() - 10, 30, 5);
	        }
        }
        if (screen.equals("player1win")){
        	if (map.equals("map1")){
	        	g.drawImage(map1, -300, -200, this);

	       		g.setColor(new Color(0, 0, 0));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
	        	//g2.draw(basePoly);
	        	//g2.draw(basePlatform);
	    	    //g2.draw(platform1);
	  	      	//g2.draw(platform2);
	  	      	//g2.draw(platform3);
        	}
        	else if (map.equals("map2")){
        		g.drawImage(map2, -100, -100, this);

	       		g.setColor(new Color(255, 105, 0));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform2);
        		//g2.draw(basePoly2);
        	}
        	else if (map.equals("map3")){
        		g.drawImage(map3, -300, -100, this);

        		g.setColor(new Color(255, 255, 255));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform3);
        		//g2.draw(basePoly3);
        	}
        	else if (map.equals("map4")){
        		g.drawImage(map4, 0, 0, this);
        		
	       		g.setColor(new Color(255, 255, 255));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform4);
        		//g2.draw(basePoly4);
        	}
        	for (int i = 0; i < player1.getLives(); i++){
	        	g.drawImage(heart, 30 + i * 65 , 50 , this);
	        }
	        for (int i = 0; i < player2.getLives(); i++){
	        	g.drawImage(heart, 1080 + i * 65 , 50 , this);
	        }
	        if (direction1.equals("right") && type1.equals("run")){
	        	g.drawImage(moveRight1[(int) frame1], player1.getX(), player1.getY() + 10, this);
	        }
	        else if (direction1.equals("left") && type1.equals("run")){
	        	g.drawImage(moveLeft1[(int) frame1], player1.getX(), player1.getY() + 10, this);
	        }
	        else if (direction1.equals("right") && type1.equals("air")){
	        	g.drawImage(jumpRight1[0], player1.getX(), player1.getY(), this);
	        }
	        else if (direction1.equals("left") && type1.equals("air")){
	        	g.drawImage(jumpLeft1[0], player1.getX(), player1.getY(), this);
	        }
	        else if (direction1.equals("right") && type1.equals("ground")){
	        	g.drawImage(standRight1[(int) frame1], player1.getX(), player1.getY(), this);
	        }
	        else if (direction1.equals("left") && type1.equals("ground")){
	        	g.drawImage(standLeft1[(int) frame1], player1.getX(), player1.getY(), this);
	        }
	        else if (direction1.equals("right") && type1.equals("attacking")){
	        	if (random1 == 1){
	        		g.drawImage(attackRight1[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        	if (random1 == 2){
	        		g.drawImage(attackRight11[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        	else{
	        		g.drawImage(attackRight111[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        }
	        else if (direction1.equals("left") && type1.equals("attacking")){
	        	if (random1 == 1){
	        		g.drawImage(attackLeft1[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        	if (random1 == 2){
	        		g.drawImage(attackLeft11[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        	else{
	        		g.drawImage(attackLeft111[(int) frame1], player1.getX(), player1.getY(), this);
	        	}
	        }
        	g.drawImage(p1win, 650 - p1win.getWidth(null) / 2, 200, this);
        	g.setColor(new Color(255, 255, 255));
        	g.setFont(new Font("Earth Orbiter", Font.PLAIN, 50));
        	g.drawString("Press ESCAPE to go to the main menu ", 90, 420);
        }
        if (screen.equals("player2win")){
        	if (map.equals("map1")){
	        	g.drawImage(map1, -300, -200, this);

	       		g.setColor(new Color(0, 0, 0));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
	        	//g2.draw(basePoly);
	        	//g2.draw(basePlatform);
	    	    //g2.draw(platform1);
	  	      	//g2.draw(platform2);
	  	      	//g2.draw(platform3);
        	}
        	else if (map.equals("map2")){
        		g.drawImage(map2, -100, -100, this);

	       		g.setColor(new Color(255, 105, 0));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform2);
        		//g2.draw(basePoly2);
        	}
        	else if (map.equals("map3")){
        		g.drawImage(map3, -300, -100, this);

        		g.setColor(new Color(255, 255, 255));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform3);
        		//g2.draw(basePoly3);
        	}
        	else if (map.equals("map4")){
        		g.drawImage(map4, 0, 0, this);
        		
	       		g.setColor(new Color(255, 255, 255));

		        g.setFont(new Font("Felix Tiling", Font.PLAIN, 33));
		        g.drawString("Player One: ", 10, 35);
		        g.drawString(Integer.toString(player1.getHp()), 185, 35);
		        g.drawString("Player Two: ", 1060, 35);
		        g.drawString(Integer.toString(player2.getHp()), 1235, 35);
        		//g2.draw(basePlatform4);
        		//g2.draw(basePoly4);
        	}
        	for (int i = 0; i < player1.getLives(); i++){
	        	g.drawImage(heart, 30 + i * 65 , 50 , this);
	        }
	        for (int i = 0; i < player2.getLives(); i++){
	        	g.drawImage(heart, 1080 + i * 65 , 50 , this);
	        }
	        if (direction2.equals("right") && type2.equals("run")){
	        	g.drawImage(moveRight2[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        }
	        else if (direction2.equals("left") && type2.equals("run")){
	        	g.drawImage(moveLeft2[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        }
	        else if (direction2.equals("right") && type2.equals("air")){
	        	g.drawImage(jumpRight2[0], player2.getX(), player2.getY(), this);
	        }
	        else if (direction2.equals("left") && type2.equals("air")){
	        	g.drawImage(jumpLeft2[0], player2.getX(), player2.getY(), this);
	       	}
	        else if (direction2.equals("right") && type2.equals("ground")){
	        	g.drawImage(standRight2[(int) frame2], player2.getX(), player2.getY() - 5, this);
	        }
	        else if (direction2.equals("left") && type2.equals("ground")){
	        	g.drawImage(standLeft2[(int) frame2], player2.getX(), player2.getY() - 5, this);
	        }
	        else if (direction2.equals("right") && type2.equals("attacking")){
	        	if (random2 == 1){
	        		g.drawImage(attackRight2[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        	if (random2 == 2){
	        		g.drawImage(attackRight22[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        	else{
	        		g.drawImage(attackRight222[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        }
	        else if (direction2.equals("left") && type2.equals("attacking")){
	        	if (random2 == 1){
	        		g.drawImage(attackLeft2[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        	if (random2 == 2){
	        		g.drawImage(attackLeft22[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        	else{
	        		g.drawImage(attackLeft222[(int) frame2], player2.getX(), player2.getY() + 15, this);
	        	}
	        }
			g.drawImage(p2win, 650 - p2win.getWidth(null) / 2, 200, this);
			g.setColor(new Color(255, 255, 255));
        	g.setFont(new Font("Earth Orbiter", Font.PLAIN, 50));
        	g.drawString("Press ESCAPE to go to the main menu ", 90, 420);
        }
	}
}