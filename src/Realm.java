import java.util.ArrayList;

/**
 * Realm enum containing all nine realms. Each realm also stores a gate Place that connects it to other realms.
 * Since this is in the world of the Nine Realms, these will always be all nine realms and remains static, thus
 * it can be implemented as an enum. Each enum also stores the location of its gate to other realms
 * @author huangd
 *
 */
public enum Realm {
	Asgard, Jotunheim, Niflheim, Vanaheim, Alfheim, Midgard, Svartalfheim, Nidavellir, Muspelheim;

	private Place gate;
	
	Realm() {
		this.gate = null;
	}
	
	/**
	 * Sets the gate for the realm
	 * @param p
	 */
	public void setGate(Place p) {
		this.gate = p;
	}
	
	/**
	 * Gets the gate for the realm
	 * @return
	 */
	public Place getGate() {
		return this.gate;
	}
	
	/**
	 * Converts a string to the equivalent realm. Returns null if not valid
	 * @param n Name of realm
	 * @return Realm or null if invalid
	 */
	public static Realm stringToRealm(String n) {
		switch (n) {
		case "Asgard":
			return Realm.Asgard;
		case "Jotunheim":
			return Realm.Jotunheim;
		case "Niflheim":
			return Realm.Niflheim;
		case "Vanaheim":
			return Realm.Vanaheim;
		case "Alfheim":
			return Realm.Alfheim;
		case "Midgard":
			return Realm.Midgard;
		case "Svartalfheim":
			return Realm.Svartalfheim;
		case "Nidavellir":
			return Realm.Nidavellir;
		case "Muspelheim":
			return Realm.Muspelheim;
		default:
			return null;
		}
	}
	
	/**
	 * Returns an arrayList of all the realms
	 * @return ArrayList of all Realms
	 */
	public static ArrayList<Realm> toArrayList() {
		ArrayList<Realm> result = new ArrayList<Realm>(9);
		result.add(Asgard);
		result.add(Jotunheim);
		result.add(Niflheim);
		result.add(Vanaheim);
		result.add(Alfheim);
		result.add(Midgard);
		result.add(Svartalfheim);
		result.add(Nidavellir);
		result.add(Muspelheim);
		return result;
	}
}