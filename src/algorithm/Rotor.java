package algorithm;

/* How a rotor works:
 * - it has a specific order of the letters
 * */

public class Rotor {
	private int[] letterOrder;
	public static final int ROTOR_LENGTH = 26;

	
	public Rotor(int[] letterOrder) {
		this.letterOrder = new int[ROTOR_LENGTH];
		for(int i = 0; i < ROTOR_LENGTH; i++) {
			this.letterOrder[i] = letterOrder[i];
		}
	}
	
	public void rotateForward(){
		int first = letterOrder[0];

		for(int i = 25; i > 0; i--){
			letterOrder[i - 1] = letterOrder[i];
		}
		letterOrder[25] = first;
	}

	public int encrypt(int c){
		try {
			return letterOrder[c];
		}
		catch (IndexOutOfBoundsException e){
			return -1;
		}
	}

}
