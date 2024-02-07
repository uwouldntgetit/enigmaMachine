package algorithm;

import java.util.ArrayList;

public class Machine {
	private ArrayList<Rotor> rotorList;
	private Rotor reflector;
	private int numLettersProcessed;

	public Machine(List<EnigmaSpecifications> listSpecs, int[] arrStartingPos){
		int arr[];
		for(int i = 0; i < arrStartingPos.length; i++){

			arr = Rotor.fromCharToInt(getRotorCombination(listSpecs.get(i)));
			rotorList.add(new Rotor(arr, arrStartingPos[i]));
		}
		char[] change = getRotorCombination(EnigmaSpecifications.REFLECTOR_A);
		reflector = new Rotor(Rotor.fromCharToInt(change));
	}

	// in this first version there's only one rotor and one reflector and the rotor is turned
	// on every letter
	public String processMessage(String message){
		char[] arrMessage = message.toString;
		StringBuilder toReturn = new StringBuilder();

		for(int i = 0; i < arrMessage.length; i++){
			char encrypted = arrMessage[i];

			for(Rotor r : rotorList){
				encrypted = r.encrypt(encrypted);
			}

			encrypted = reflector.encrypt(encrypted);

			for(Rotor r : rotorList.reversed()){
				encrypted = r.encrypt(encrypted);
				r.rotateForward();
			}
			
			toReturn.append(encrypted);
		}

		return toReturn.toString();
	}

	// public void setBackToStart();

	public String getRotorCombination(EnigmaSpecification spec){
		switch(spec){

			case ROTORC_I: return "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
			case ROTORC_II: return "AJDKSIRUXBLHWTMCQGZNPYFVOE";
			case ROTORC_III: return "BDFHJLCPRTXVZNYEIWGAKMUSQO";
			case ROTORC_IV: return "ESOVPZJAYQUIRHXLNFTGKDCMWB";
			case ROTORC_V: return "VZBRGITYUPSDNHLXAWMJQOFECK";
			case ROTORC_VI: return "JPGVOUMFYQBENHZRDKASXLICTW";
			case ROTORC_VII: return "NZJHGRCXMYSWBOUFAIVLPEKQDT";
			case ROTORC_VIII: return  "FKQHTLXOCBJSPDZRAMEWNIUYGV";
			case REFLECTOR_A: return "EJMZALYXVBWFCRQUONTSPIKHGD";
			case REFLECTOR_B: return "YRUHQSLDPXNGOKMIEBFZCWVJAT";
			case REFLECTOR_C: return "EJMZALYXVBWFCRQUONTSPIKHGD";
		}
	}
}



class Rotor {
	private int[] letterOrder;
	public static final int ROTOR_LENGTH = 26;
	public final int startingPosition;

	
	public Rotor(int[] letterOrder, int startingPosition) {
		this.letterOrder = new int[ROTOR_LENGTH];
		for(int i = 0; i < ROTOR_LENGTH; i++) {
			this.letterOrder[i] = letterOrder[i];
		}
		this.startingPosition = startingPosition;

		while(startingPosition > 0){
			rotateForward();
			startingPosition--;
		}
	}

	/*public Rotor(String rotorOrder, int startingPosition){
		int[] arr = fromCharToInt(rotorOrder.toUpperCase().toCharArray());
		this(arr, startingPosition);
	}*/
	
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

	public static int[] fromCharToInt(char[] arr){
		int[] toReturn = new int[arr.length];

		for(int i = 0; i < arr.length; i++){
			toReturn[i] =  arr[i] - 65;
		}

		return toReturn;
	}
}
