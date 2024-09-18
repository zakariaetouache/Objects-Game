package miniProjet;
import java.util.*;

public class Randomm {

	static int random(int min, int max) {
		Random rand = new Random();
		int randomNumber = rand.nextInt((max - min)+1)+min;
		return randomNumber;
	}
	
}
