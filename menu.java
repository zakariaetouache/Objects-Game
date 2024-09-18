package miniProjet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class menu extends JFrame implements ActionListener{
	static boolean bo=false,fe=false,ve=false,ba=false;
	 JLabel texte1 = new JLabel ("entrez votre nom :");
	 JLabel texte4 = new JLabel("entrez votre prenom :");
	 JLabel texte2 = new JLabel ("choisissez les objets  :");
	 JLabel texte3 = new JLabel ("Bienvenue sur jeux des objets !!");
	 String age;
	 static JTextField ent1 = new JTextField(15);
	 static JTextField ent2 = new JTextField(15);
	 //ButtonGroup groupe = new ButtonGroup() ;
	 JCheckBox RadB1 = new JCheckBox("plastic") ;
	 JCheckBox RadB2 = new JCheckBox("verre") ;
	 JCheckBox RadB3 = new JCheckBox("Métal") ; 
	 JCheckBox RadB4 = new JCheckBox("autre") ; 
	 JPanel p1 = new JPanel(); 
	 JPanel p2 = new JPanel();
	 JPanel p3 = new JPanel();
	 JPanel p4 = new JPanel();
	 /*String[] choix = {"enfant", "adolescent", "majeur"};
	 JList Lch = new JList(choix);
	 JComboBox Combo = new JComboBox(choix) ;*/
	 JButton jo = new JButton("Jouer"); 
	 JButton qt=new JButton("Quitter");
	 final JButton debut = new JButton("Start");
	 JFrame fen;
	public menu() {
	fen = new JFrame();
	fen.setTitle("Jeux des objets");
	fen.setBounds(150,150,700,500);
   p1.add(texte1);
   p1.add(ent1);
   p1.add(texte4);texte4.setBounds(50,100,50,50);
   p1.add(ent2);
   p1.setBackground(Color.LIGHT_GRAY);
   p1.setBounds(130, 100, 450, 100);
   p2.add(texte2);
//   p2.add(Lch);
   p2.setBackground(Color.LIGHT_GRAY);
   p2.setBounds(130, 200, 450, 100);
   p3.add(jo); //jo.setBackground(Color.cyan);
   p3.add(qt);
   p3.setBackground(Color.LIGHT_GRAY);
   p3.setBounds(130, 300, 450, 100);
   p4.add(texte3);
   p4.setBackground(Color.gray);
   p4.setBounds(130,400,450,100);
   java.awt.Font myFont1 = new java.awt.Font ("Castellar", Font.BOLD , 15 ) ; 
   texte1.setFont ( myFont1 ) ; 
   java.awt.Font myFont4 = new java.awt.Font ("Castellar", Font.BOLD , 15 ) ; 
   texte4.setFont ( myFont4 ) ;
   java.awt.Font myFont5 = new java.awt.Font ("Castellar", Font.BOLD , 15 ) ; 
   //texte1.setFont ( myFont5 ) ;
   new java.awt.Font ("Castellar", Font.BOLD , 15 ); 
   RadB1.setBackground(Color.LIGHT_GRAY);
   RadB2.setBackground(Color.LIGHT_GRAY);
   RadB3.setBackground(Color.LIGHT_GRAY);
   RadB4.setBackground(Color.LIGHT_GRAY);
   /*groupe.add(RadB1); 
	groupe.add(RadB2); 
   groupe.add(RadB3);
   groupe.add(RadB4);*/
	p2.add(RadB1); RadB1.addActionListener(this);
	p2.add(RadB2); RadB2.addActionListener(this);
	p2.add(RadB3); RadB3.addActionListener(this);
	p2.add(RadB4); RadB4.addActionListener(this);
   java.awt.Font Fontb1 = new java.awt.Font ("Engravers MT", Font.BOLD , 15 ) ; 
   jo.setFont ( Fontb1 ) ; 
   jo.setBackground(Color.lightGray);
   jo.addActionListener(this); 
   java.awt.Font Fontb2 = new java.awt.Font ("Engravers MT", Font.BOLD , 15 ) ; 
   qt.setFont ( Fontb2 ) ; 
   qt.setBackground(Color.lightGray);
   qt.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
           System.exit(0);
       }
   });
   fen.getContentPane().add(p1); p1.setBackground(Color.cyan);
   fen.getContentPane().add(p2); p2.setBackground(Color.cyan);
   fen.getContentPane().add(p3); p3.setBackground(Color.cyan);
   fen.getContentPane().add(p4); p4.setBackground(Color.cyan);
   fen.setResizable(false);
   fen.setVisible(true);
   fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //jr=new Joueur(ent1.getText(), ent2.getText(),Integer.parseInt(ent3.getText()));
	}
	public void actionPerformed(ActionEvent arg0) {
       //this.dispose();
       if(arg0.getSource().equals(RadB4)) {						//RadB4.isSelected()
    	    ba=RadB4.isSelected();
       }
       if(arg0.getSource().equals(RadB3)) {
	       	fe=RadB3.isSelected();
       }
 	  if(arg0.getSource().equals(RadB2)) {
	 		ve=RadB2.isSelected();
 	  }
	  if(arg0.getSource().equals(RadB1)) {
			bo=RadB1.isSelected();
	  }
	  if(arg0.getSource().equals(jo)) {
		  if(bo||fe||ve||ba) {
			    fen.setVisible(false);
		      	Jeu j = new Jeu();
				j.setTitle("Jeu");
				j.setLocationRelativeTo(null);
				j.setLayout(null);
				j.setVisible(true);
		  }else {
			  JOptionPane.showMessageDialog(ent1, "Veuillez cocher une case SVP", "Message d'avertissement",0); 
		  }
	  }	 
}
	 public  boolean isNumeric(String str) {
	        try {
	            Double.parseDouble(str);
	            return true;
	        } catch(NumberFormatException e){
	            return false;
	        }
	    }
	   public static void main(String[] args) {
	        
	    new menu(); 
	    }
}
