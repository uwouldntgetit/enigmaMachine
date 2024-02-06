package algorithm;

/* How a rotor works:
 * - it has a specific order of the letters
 * */

public class Rotor {
	private int[] letterOrder;

	
	public void rotateForward(){
		int first = letterOrder[0];

		for(int i = 25; i > 0; i--){
			letterOrder[i - 1] = arr[i];
		}
		arr[25] = first;
	}

	public int encrypt(int c){
		try {
			return arr[c];
		}
		catch (IndexOutOfBoundsException e){
		}
			return -1;
		}
	}

}
