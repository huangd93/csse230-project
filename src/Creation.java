import java.util.ArrayList;

import org.junit.Test;

/**
 * 
 * This will actually create Yggdrasil and waypoints. If we don't need this at
 * the moment, the code will be useful later
 * 
 * 
 * @author richarel
 * 
 */
public class Creation {

	PlacesTree t = new PlacesTree();

	@Test
	public void createAsgard() {
		ArrayList<Connection> valhallaConnect = new ArrayList<Connection>();
		ArrayList<Place> valhallaNeighbors = new ArrayList<Place>();
		Point valhallaPoint = new Point(50, 40);

		ArrayList<Connection> odinConnect = new ArrayList<Connection>();
		ArrayList<Place> odinNeighbors = new ArrayList<Place>();
		Point odinPoint = new Point(55, 50);

		ArrayList<Connection> mntnConnect = new ArrayList<Connection>();
		ArrayList<Place> mntnNeighbors = new ArrayList<Place>();
		Point mntnPoint = new Point(30, 30);

		ArrayList<Connection> lakeConnect = new ArrayList<Connection>();
		ArrayList<Place> lakeNeighbors = new ArrayList<Place>();
		Point lakePoint = new Point(30, 20);

		ArrayList<Connection> seaConnect = new ArrayList<Connection>();
		ArrayList<Place> seaNeighbors = new ArrayList<Place>();
		Point seaPoint = new Point(30, 80);

		Place valhalla = new Place("Valhalla", valhallaConnect, valhallaPoint,
				9, Realm.Asgard);

		Place odinsFortress = new Place("Odin's Fortress", odinConnect,
				odinPoint, 8, Realm.Asgard);

		Place asgardMnts = new Place("Asgard Mountains", mntnConnect,
				mntnPoint, 5, Realm.Asgard);

		Place lakeLogur = new Place("Lake Logur", lakeConnect, lakePoint, 5,
				Realm.Asgard);

		Place seaOfMarmora = new Place("Sea of Marmora", seaConnect, seaPoint,
				4, Realm.Asgard);

		t.insert(valhalla);
		t.insert(odinsFortress);
		t.insert(asgardMnts);
		t.insert(lakeLogur);
		t.insert(seaOfMarmora);

		valhallaNeighbors.add(odinsFortress);
		valhallaNeighbors.add(asgardMnts);
		valhalla.setNeighbors(valhallaNeighbors);

		odinNeighbors.add(valhalla);
		odinNeighbors.add(asgardMnts);
		odinNeighbors.add(seaOfMarmora);
		odinsFortress.setNeighbors(odinNeighbors);

		mntnNeighbors.add(lakeLogur);
		mntnNeighbors.add(valhalla);
		mntnNeighbors.add(odinsFortress);
		mntnNeighbors.add(seaOfMarmora);
		asgardMnts.setNeighbors(mntnNeighbors);

		lakeNeighbors.add(asgardMnts);
		lakeLogur.setNeighbors(lakeNeighbors);

		seaNeighbors.add(odinsFortress);
		seaNeighbors.add(asgardMnts);
		seaOfMarmora.setNeighbors(seaNeighbors);

	}

	@Test
	public void createJotunheim() {
		
		ArrayList<Connection> riverIvingConnect = new ArrayList<Connection>();
		ArrayList<Place> riverIvingNeighbors = new ArrayList<Place>();
		Point riverIvingPoint = new Point(40, 20);

		ArrayList<Connection> utgardLokiConnect = new ArrayList<Connection>();
		ArrayList<Place> utgardLokiNeighbors = new ArrayList<Place>();
		Point utgardLokiPoint = new Point(50, 40);

		ArrayList<Connection> mimirConnect = new ArrayList<Connection>();
		ArrayList<Place> mimirNeighbors = new ArrayList<Place>();
		Point mimirPoint = new Point(80, 40);
		
		//continue here

		Place riverIving = new Place("The River Iving", riverIvingConnect,
				riverIvingPoint, 4, Realm.Jotunheim);

		Place utgardLokisThrone = new Place("Utgard-Loki's Throne",
				utgardLokiConnect, utgardLokiPoint, 8, Realm.Jotunheim);

		Place mimirsWell = new Place("Mimir's Well", mimirConnect, mimirPoint,
				7, Realm.Jotunheim);

	}

	@Test
	public void createNiflheim() {

	}

	@Test
	public void createVanaheim() {

	}

	@Test
	public void createAlfheim() {

	}

	@Test
	public void createMidgard() {

	}

	@Test
	public void createSvartalfheim() {

	}

	@Test
	public void createNidavellir() {

	}

	@Test
	public void createMuspelheim() {

	}
}
