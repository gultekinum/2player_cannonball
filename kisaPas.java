
//  Created by umut gültekin on 7.04.2019.
//  Copyright © 2019 umut gültekin. All rights reserved.


package kisaPas;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class kisaPas implements WindowListener{

	Frame f;
	kanvas k;
	
	kisaPas(){
		f=new Frame();
		f.setSize(1200, 900);
		k=new kanvas();
		f.addWindowListener(this);
		f.add(k);
		f.setVisible(true);
		f.setResizable(false);
	}
	
	class kanvas extends Canvas implements KeyListener{
		
		Color lightblue=new Color(0,253,253);
		int x1,y1,x2,y2,xtop,ytop,dy1,dy2,dxtop,dytop;
		int random;
		ImageIcon alev1;
		ImageIcon alev2;
		ImageIcon alev3;
		ImageIcon alev4;
		ImageIcon alev5;
		ImageIcon alev6;
		ImageIcon arka;
		int skor1=0;
		int skor2=0;
		int kontrol=0;
		int count=10;
		int kontrol2=0;
		int kontrol3=0;
		int kontrol4=0;
		int kontrol5=0;
		kanvas(){
			arka=new ImageIcon("/Users/umutgultekin/Downloads/marcel-kolbenschlag-fireworld-background-04-small.jpg");
			
			alev1=new ImageIcon("/Users/umutgultekin/Downloads/960d4d65d4b5cf55a06e8ea25ed8748d kopyası 2.png");
			alev2=new ImageIcon("/Users/umutgultekin/Downloads/960d4d65d4b5cf55a06e8ea25ed8748d.png");
			alev3=new ImageIcon("/Users/umutgultekin/Downloads/960d4d65d4b5cf55a06e8ea25ed8748d kopyası 4.png");
			alev4=new ImageIcon("/Users/umutgultekin/Downloads/960d4d65d4b5cf55a06e8ea25ed8748d kopyası 5.png");
			alev5=new ImageIcon("/Users/umutgultekin/Downloads/960d4d65d4b5cf55a06e8ea25ed8748d kopyası.png");
			alev6=new ImageIcon("/Users/umutgultekin/Downloads/960d4d65d4b5cf55a06e8ea25ed8748d.png");
			x1=100;
			y1=400;
			x2=1090;
			y2=400;
			xtop=610;
			ytop=480;
			
			dy1=0;dy2=0;
		
			
			
			setBackground(lightblue);
			addKeyListener(this);
		}
		
		public void paint(Graphics p) {
			while(kontrol5==0) {
				random=(int)(Math.toRadians(Math.random()*180+60));
				
				dxtop=(int)(5*Math.cos(random));
				dytop=(int)(5*Math.sin(random));
				
				kontrol5=1;
				if(Math.abs(dxtop)<=1) {
					kontrol5=0;
				}
				if(Math.abs(dytop)<=1) {
					kontrol5=0;
				}
			}
			
			if(kontrol3==0) {
				
				p.drawImage(arka.getImage(), 0, 0, 1200, 800, this);
				p.setFont(new Font("NewTimes",Font.ROMAN_BASELINE,40));
				
				
				p.setColor(Color.white);
				if(kontrol4<100) {
					p.drawString("PRESS SPACE", 500, 400);
					p.setFont(new Font("kk",Font.ROMAN_BASELINE,15));
					p.drawString("or anything else",550 ,420);
				}
				if(kontrol4==160) {
					kontrol4=0;
				}
				p.setFont(new Font("NewYork",Font.PLAIN,40));
				p.drawString(""+skor1, 100, 100);
				p.drawString(""+skor2, 1000, 100);
				
			
				p.fillRect(x1, y1, 10, 200);
				p.fillRect(x2, y2, 10, 200);
				
				p.setColor(Color.black);
				p.fillOval(xtop, ytop, 20, 20);
				
			}else {
				p.drawImage(arka.getImage(), 0, 0, 1200, 800, this);
			
				
				p.setColor(Color.white);
				p.fillRect(x1, y1, 10, 200);
				p.fillRect(x2, y2, 10, 200);
			
				p.setFont(new Font("NewYork",Font.PLAIN,40));
				p.drawString(""+skor1, 100, 100);
				p.drawString(""+skor2, 1000, 100);
			
		
			if(count<=20) {
				p.drawImage(alev1.getImage(), xtop-15, ytop-25, 50, 50, this);
				
			}
			if(count>20 && count<=40) {
				p.drawImage(alev2.getImage(), xtop-15, ytop-25, 50, 50, this);
			}
			if(count>40 && count<=60) {
				p.drawImage(alev3.getImage(),xtop-15, ytop-25, 50, 50, this);
			}
			if(count>60 && count<=80) {
				p.drawImage(alev4.getImage(), xtop-15, ytop-25, 50, 50, this);
			}
			if(count>80 && count<=100) {
				p.drawImage(alev5.getImage(), xtop-15, ytop-25, 50, 50, this);
			}
			if(count>100 && count<=120) {
				p.drawImage(alev6.getImage(), xtop-15, ytop-25, 50, 50, this);
				count=0;
			}
			p.setColor(Color.black);
			p.fillOval(xtop, ytop, 20, 20);
			
		
			
			if(ytop>=780 || ytop<=0) {
				dytop=-dytop;
			}
			if(ytop>=y1 && ytop<=y1+200 && xtop<=x1+15 && xtop>x1) {
				if(kontrol2==0) {
					
					dxtop=-dxtop;
					dxtop++;
					kontrol2=1;
				}
				
			}
			if(ytop>=y2 && ytop<=y2+200 && xtop+20>x2 && xtop<=x2+10)  {
				if(kontrol2==0) {
				dxtop=-dxtop;
				dxtop--;
					kontrol2=1;
				}
				
				
			}
			
			
			
			
			if(xtop>1180 ) {
				if(kontrol==0) {
					skor1++;
					kontrol=1;
					kontrol3=0;
					kontrol5=0;
				}
				
				xtop=610;
				ytop=480;
				random=(int)(Math.toRadians(Math.random()*180+60));
				dxtop=(int)(5*Math.cos(random));
				dytop=(int)(5*Math.sin(random));
			}
			
			if(xtop<0 ) {
				if(kontrol==0) {
					skor2++;
					kontrol=1;
					kontrol3=0;
					kontrol5=0;
				}
				
				xtop=610;
				ytop=480;
				random=(int)(Math.toRadians(Math.random()*180+60));
				dxtop=(int)(5*Math.cos(random));
				dytop=(int)(5*Math.sin(random));
			}
			
			
			
	
			if(y1>=600 || y1<=0 ) {
				if(dy1>0 && y1>=600) {
					dy1=0;
				}
				if(dy1<0 && y1<=0) {
					dy1=0;
				}
			}
			if(y2>=600 || y2<=0 ) {
				if(dy2>0 && y2>=600) {
					dy2=0;
				}
				if(dy2<0 && y2<=0) {
					dy2=0;
				}
			}
			
			xtop=(int)(xtop+dxtop);
			ytop=(int)(ytop+dytop);
			
			y1=dy1+y1;
			y2=dy2+y2;
			
			
			kontrol2=0;
			count=count+5;
			kontrol=0;
			}
			
			try {
				Thread.sleep(10);
			}
			catch(Exception o) {
				
			}
			kontrol4=kontrol4+10;
			repaint();
		}
		
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_A) {
				dy1=-5;
				kontrol3=1;
			}
			if(e.getKeyCode()==KeyEvent.VK_Z) {
				dy1=5;
				kontrol3=1;
			}
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				dy2=-5;
				kontrol3=1;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				dy2=5;
				kontrol3=1;
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				kontrol3=1;
			
			}
		}
		public void keyReleased(KeyEvent e) {
			
			if(e.getKeyCode()==KeyEvent.VK_A) {
				dy1=0;
			}
			if(e.getKeyCode()==KeyEvent.VK_Z) {
				dy1=0;
			}
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				dy2=0;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				dy2=0;
			}
			
		}
		public void keyTyped(KeyEvent e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		kisaPas uygulama=new kisaPas();
	}
	
	public void windowClosed(WindowEvent e) {
		
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowOpened(WindowEvent e) {
		
	}
	public void windowIconified(WindowEvent e) {
		
	}
	public void windowDeiconified(WindowEvent e) {
		
	}
	public void windowActivated(WindowEvent e) {
		
	}
	public void windowDeactivated(WindowEvent e) {
		
	}
	
}



