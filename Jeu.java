package miniProjet;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;


public class Jeu extends JFrame{

	static Graphics g;
	static int x=575;
	static int  score=0;
	static int vitesse =10;
	static int level=1;
	static int nombreObjet=1;
	static int sang = 10;
	static int longeur = 120;
	static int z=1;
	
	MouveObjet ob1 = new MouveObjet(menu.fe);
	MouveObjet ob2 = new MouveObjet(menu.bo);
	MouveObjet ob3 = new MouveObjet(menu.ve);
	MouveObjet ob4 = new MouveObjet(menu.ba);
	MouveObjet ob5 = new MouveObjet(menu.fe);
	MouveObjet ob6 = new MouveObjet(menu.bo);
	MouveObjet ob7 = new MouveObjet(menu.ve);
	MouveObjet ob8 = new MouveObjet(menu.ba);
	
	Image imageFe = Toolkit.getDefaultToolkit().getImage("C:\\Users\\youne\\eclipse-workspace\\javas6\\src\\miniProjet\\imageFe.jpeg");
	Image imagePo = Toolkit.getDefaultToolkit().getImage("C:\\Users\\youne\\eclipse-workspace\\javas6\\src\\miniProjet\\imagePo.jpg");
	Image imageBo = Toolkit.getDefaultToolkit().getImage("C:\\Users\\youne\\eclipse-workspace\\javas6\\src\\miniProjet\\imageBo.jpeg");
	Image imageVe = Toolkit.getDefaultToolkit().getImage("C:\\Users\\youne\\eclipse-workspace\\javas6\\src\\miniProjet\\imageVe.jpg");
	Image imageBa = Toolkit.getDefaultToolkit().getImage("C:\\Users\\youne\\eclipse-workspace\\javas6\\src\\miniProjet\\imageBa.jpeg");

	
	static JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JLabel lab1 = new JLabel("Votre score");
	JLabel lab2 = new JLabel("Level");
	JLabel lab3 = new JLabel("Sang");
	TextField scor = new TextField(String.valueOf(score));
	TextField leve = new TextField(String.valueOf(level));
	TextField san = new TextField(String.valueOf(sang));
 	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//g.drawRect(x,740,longeur,50);
		g.drawImage(imagePo, x,740 ,longeur,50, this);

		/*g.drawRect(ob1.posMouvRect,ob1.k,ob1.taille,ob1.taille);
		g.drawRect(ob2.posMouvRect,ob2.k,ob2.taille,ob2.taille);
		g.drawRect(ob3.posMouvRect,ob3.k,ob3.taille,ob3.taille);
		g.drawRect(ob4.posMouvRect,ob4.k,ob4.taille,ob4.taille);
		g.drawRect(ob5.posMouvRect,ob5.k,ob5.taille,ob5.taille);
		g.drawRect(ob6.posMouvRect,ob6.k,ob6.taille,ob6.taille);
		g.drawRect(ob7.posMouvRect,ob7.k,ob7.taille,ob7.taille);
		g.drawRect(ob8.posMouvRect,ob8.k,ob8.taille,ob8.taille);*/
		
		
		g.drawImage(imageFe, ob1.posMouvRect,ob1.k ,ob1.taille,ob1.taille, null);
		g.drawImage(imageFe, ob5.posMouvRect,ob5.k ,ob5.taille,ob5.taille, null);
		g.drawImage(imageBo, ob2.posMouvRect,ob2.k ,ob2.taille,ob2.taille, null);
		g.drawImage(imageBo, ob6.posMouvRect,ob6.k ,ob6.taille,ob6.taille, null);
		g.drawImage(imageVe, ob3.posMouvRect,ob3.k ,ob3.taille,ob3.taille, null);
		g.drawImage(imageVe, ob7.posMouvRect,ob7.k ,ob7.taille,ob7.taille, null);
		g.drawImage(imageBa, ob4.posMouvRect,ob4.k ,ob4.taille,ob4.taille, null);
		g.drawImage(imageBa, ob8.posMouvRect,ob8.k ,ob8.taille,ob8.taille, null);
		
		
		scor.setText(String.valueOf(score));
		leve.setText(String.valueOf(level));
		san.setText(String.valueOf(sang));
	}
	
	
	public Jeu() {
		
		setSize(1210,800);
		
		pan1.setFocusable(true);
		pan1.setBackground(Color.white);
		add(pan1);
		g = pan1.getGraphics();
		pan1.setSize(1200,800);
		
		pan1.add(lab1); //lab1.setBounds(1000,10,200,30);
		pan1.add(scor);
		pan1.add(lab2);
		pan1.add(leve);
		pan1.add(lab3);
		pan1.add(san);
		
		pan1.addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {}
			public void mouseDragged(MouseEvent e) {
				x=e.getX();
				if(x<10) {
					x=10;
				}
				if(x>1145) {
					x=1150;
				}
				//repaint();
			}
		});
		
		Thread ob11 =new Thread(ob1);
		//ob11.start();
		
		Thread ob22 =new Thread(ob2);
		//ob22.start();
		
		
		Thread ob33 =new Thread(ob3);
		//ob33.start();
		
		
		Thread ob44 =new Thread(ob4);
		//ob44.start();
		
		
		Thread ob55 =new Thread(ob5);
		//ob44.start();
		
		
		Thread ob66 =new Thread(ob6);
		//ob44.start();
		
		
		Thread ob77 =new Thread(ob7);
		//ob44.start();
		
		
		Thread ob88 =new Thread(ob8);
		//ob44.start();
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
            @Override
            public void run() {
                repaint();
                if(sang == 0) {
                	Jeu.this.windowClosed();
                }
            }
        };
        TimerTask tasks = new TimerTask() {
        	@Override
        	public void run() {
        		if(z==1) {
        			ob11.start();
        			z++;
        		}else {
	        		if(z==2) {
	        			ob22.start();
	        			z++;
	        		}else {
		        		if(z==3) {
		        			ob33.start();
		        			z++;
		        		}else {
			        		if(z==4) {
			        			ob44.start();
			        			z++;
			        		}else {
			        			if(z==5) {
			            			ob55.start();
			            			z++;
			            		}else {
			    	        		if(z==6) {
			    	        			ob66.start();
			    	        			z++;
			    	        		}else {
			    		        		if(z==7) {
			    		        			ob77.start();
			    		        			z++;
			    		        		}else {
			    			        		if(z==8) {
			    			        			ob88.start();
			    			        			z++;
			    			        		}
			    		        		}
			    	        		}
			            		}
			        		}
		        		}
	        		}
        		}
        	}
        };
        timer.scheduleAtFixedRate(task, 0, 1);
        timer.scheduleAtFixedRate(tasks, 0, 1000);
        
        this.addWindowListener
        (
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Jeu.this.windowClosed();
                }
            }
        );
	}
	static void windowClosed() {
	    	
	    	// TODO: Check if it is safe to close the application
	    	
	        // Exit application.
			//ob11.interrupt();
	        System.exit(0);
	}
	/*public static void main(String [] args) {
		Jeu j = new Jeu();
		j.setTitle("Jeu");
		j.setLocationRelativeTo(null);
		j.setLayout(null);
		j.setVisible(true);
	}*/
}
