import java.util.ArrayList;


public enum Realm {
	Asgard, Jotunheim, Niflheim, Vanaheim, Alfheim, Midgard, Svartalfheim, Nidavellir, Muspelheim;

	private Place gate;
	
	Realm() {
		this.gate = null;
	}
	
	public void setGate(Place p) {
		this.gate = p;
	}
	
	public Place getGate() {
		return this.gate;
	}
	
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