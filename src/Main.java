/**
 * @author Isaiah Smith
 */
public class Main {

	/**
	 * @param args
	 * 
	 * 
	 */
	public static void main(String[] args) {

		// begin creation
		Creation yggdrasil = new Creation();
		yggdrasil.createAsgard();
		yggdrasil.createAlfheim();
		yggdrasil.createJotunheim(); // aka Utgard
		yggdrasil.createMidgard();
		yggdrasil.createMuspelheim();
		yggdrasil.createNidavellir();
		yggdrasil.createNiflheim();
		yggdrasil.createSvartalfheim();
		yggdrasil.createVanaheim();
		// Now, yggdrasil.t will get you the tree in which the places are sorted by
		// rating, and then through all that goodness you can pick information
		// out of the places

		new StartUpGUI();
	}

}