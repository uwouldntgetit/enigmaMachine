package algorithm;

public class Main{
	public static void main(String args[]){
		ArrayList<EnigmaSpecifications>  list = new ArrayList<>();
		list.add(EnigmaSpecifications.ROTOR_I);
		int[] startPositions = new int[list.size()];

		for(int i = 0; i < startPositons.length; i++){
			startPositions[i] = 3;
		}

		Machine m = new Machine(list, startPositions);
		String msg = m.processMessage("ciao");

		System.out.println(msg);
		msg = m.processMessage(msg);
		System.out.println(msg);
	}
}
