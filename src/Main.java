/**
 * @author Isaiah Smith, Emily Richardson and David Huang
 */
public class Main {

	/**
	 * @param args
	 * 
	 * 
	 */
	public static void main(String[] args) {

		// Begin creation
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
		// This has to occur after the realm gates have been set
		yggdrasil.linkGates();
		

		new StartUpGUI();
	}

}