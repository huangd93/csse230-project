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
		yggdrasil.linkGates();
		

		new StartUpGUI();
	}

}