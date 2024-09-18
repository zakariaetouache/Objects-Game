package miniProjet;

class MouveObjet implements  Runnable{

    int posMouvRect = Randomm.random(30,1140);
    boolean incScoreBool = true;
    boolean l;
    int k,i;
    int taille=Randomm.random(4,5)*10;
    
    MouveObjet(boolean l){
		this.l=l;
	}
    
	void suprrimer() {
		k=0;
		i=0;
		if(l) {
			decSang();
		}
		incScoreBool=true;
		posMouvRect=Randomm.random(30,1140);
		taille=Randomm.random(4,5)*10;
		Jeu.nombreObjet++;
		if(incLevel()) {
			//Thread.sleep(2000);
			//Jeu.z=1;
		}
		//Thread.sleep(2000);
	}

	void incScore() {
		if(k+taille>=740 && k<=790) {
			if(posMouvRect>=Jeu.x && posMouvRect<=(Jeu.x + Jeu.longeur)) {
				if(!l) {
					Jeu.windowClosed();
				}
				Jeu.score+=taille/Jeu.vitesse;
				incScoreBool = false;
				suprrimer();
			}
		}
	}
	
	boolean  incLevel() {
		if(Jeu.nombreObjet>=10) {
			if(Jeu.score>=(100000)/(Jeu.vitesse*Jeu.vitesse*Jeu.vitesse)) {
				Jeu.level++;
				//Jeu.nombreObjet=0;
				Jeu.vitesse--;
				Jeu.longeur+=10;
				//ob11.Thread.sleep(2000);
				return true;
			}
		}
		return false;
	}
	
	void decSang() {
		if(incScoreBool) {
			Jeu.sang--;
			//System.out.println(incScoreBool);
			//Jeu.incScoreBool=false;
			//System.out.println(incScoreBool);
		}
	}
	
	public void run() {
		synchronized(this) {
			try {
			//Thread.sleep(Randomm.random(200,6000));
			
				for(i=0;i<=800;i++) {
					k=i;
					incScore();
					if(k>790) {
						suprrimer();
					}
					//System.out.println(i);
					Thread.sleep(Jeu.vitesse);
					//System.out.println(Thread.currentThread().getName().toString());
				}
			}catch(Exception e) {}
		}
	}
}
