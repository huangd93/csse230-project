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
		Point valhallaPoint = new Point(50, 40);

		ArrayList<Connection> odinConnect = new ArrayList<Connection>();
		Point odinPoint = new Point(55, 50);

		ArrayList<Connection> mntnConnect = new ArrayList<Connection>();
		Point mntnPoint = new Point(30, 30);

		ArrayList<Connection> lakeConnect = new ArrayList<Connection>();
		Point lakePoint = new Point(30, 20);

		ArrayList<Connection> seaConnect = new ArrayList<Connection>();
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
		
		//connections from valhalla
		ArrayList<Point> connectPointsVal = new ArrayList<Point>();
		connectPointsVal.add(odinPoint);
		connectPointsVal.add(mntnPoint);
		valhallaConnect.add(new Connection(odinsFortress, new Route(connectPointsVal), 30));
		valhallaConnect.add(new Connection(asgardMnts, new Route(connectPointsVal), 70));
		valhalla.setConnections(valhallaConnect);
		
		//connections from lake logur
		ArrayList<Point> connectPointsLakeLogur = new ArrayList<Point>();
		connectPointsLakeLogur.add(mntnPoint);
		lakeConnect.add(new Connection(asgardMnts, new Route(connectPointsLakeLogur), 40));
		lakeLogur.setConnections(lakeConnect);
		
		//connections from asgard mountains
		ArrayList<Point> connectPointsMounts = new ArrayList<Point>();
		connectPointsMounts.add(lakePoint);
		connectPointsMounts.add(valhallaPoint);
		connectPointsMounts.add(odinPoint);
		connectPointsMounts.add(seaPoint);
		mntnConnect.add(new Connection(lakeLogur, new Route(connectPointsMounts), 40));
		mntnConnect.add(new Connection(valhalla, new Route(connectPointsMounts), 50));	
		mntnConnect.add(new Connection(odinsFortress, new Route(connectPointsMounts), 45));
		mntnConnect.add(new Connection(seaOfMarmora, new Route(connectPointsMounts), 80));
		asgardMnts.setConnections(mntnConnect);
		
		//connections from Odin's fortress
		ArrayList<Point> connectPointsOdin = new ArrayList<Point>();
		connectPointsOdin.add(valhallaPoint);
		connectPointsOdin.add(mntnPoint);
		connectPointsOdin.add(seaPoint);
		odinConnect.add(new Connection(valhalla, new Route(connectPointsOdin), 30));
		odinConnect.add(new Connection(asgardMnts, new Route(connectPointsOdin), 45));
		odinConnect.add(new Connection(seaOfMarmora, new Route(connectPointsOdin), 70));
		odinsFortress.setConnections(odinConnect);
		
		//connections from the sea of marmora
		ArrayList<Point> connectPointsSea = new ArrayList<Point>();
		connectPointsSea.add(odinPoint);
		connectPointsSea.add(mntnPoint);
		seaConnect.add(new Connection(odinsFortress, new Route(connectPointsSea), 70));
		seaConnect.add(new Connection(asgardMnts, new Route(connectPointsSea), 80));
		seaOfMarmora.setConnections(seaConnect);

	}

	@Test
	public void createJotunheim() {
		ArrayList<Connection> riverIvingConnect = new ArrayList<Connection>();
		Point riverIvingPoint = new Point(40, 20);

		ArrayList<Connection> utgardLokiConnect = new ArrayList<Connection>();
		Point utgardLokiPoint = new Point(50, 40);

		ArrayList<Connection> mimirConnect = new ArrayList<Connection>();
		Point mimirPoint = new Point(80, 40);

		ArrayList<Connection> grioConnect = new ArrayList<Connection>();
		Point grioPoint = new Point(20, 50);

		ArrayList<Connection> mtTConnect = new ArrayList<Connection>();
		Point mtTPoint = new Point(50, 80);

		Place riverIving = new Place("The River Iving", riverIvingConnect,
				riverIvingPoint, 4, Realm.Jotunheim);

		Place utgardLokisThrone = new Place("Utgard-Loki's Throne",
				utgardLokiConnect, utgardLokiPoint, 8, Realm.Jotunheim);

		Place mimirsWell = new Place("Mimir's Well", mimirConnect, mimirPoint,
				7, Realm.Jotunheim);

		Place griotunagardar = new Place("Griotunagardar", grioConnect,
				grioPoint, 5, Realm.Jotunheim);

		Place mountThrymheim = new Place("The Mountain Thrymheim", mtTConnect,
				mtTPoint, 7, Realm.Jotunheim);
		
		t.insert(riverIving);
		t.insert(utgardLokisThrone);
		t.insert(mimirsWell);
		t.insert(griotunagardar);
		t.insert(mountThrymheim);
		
		//river iving connections
		ArrayList<Point> connectPointsIving = new ArrayList<Point>();
		connectPointsIving.add(grioPoint);
		riverIvingConnect.add(new Connection(griotunagardar, new Route(connectPointsIving), 45));
		riverIving.setConnections(riverIvingConnect);
		
		//griotunagardar connections
		ArrayList<Point> connectPointsGrio = new ArrayList<Point>();
		connectPointsGrio.add(utgardLokiPoint);
		connectPointsGrio.add(riverIvingPoint);
		grioConnect.add(new Connection(utgardLokisThrone, new Route(connectPointsGrio), 40));
		grioConnect.add(new Connection(riverIving, new Route(connectPointsGrio), 45));
		griotunagardar.setConnections(grioConnect);
		
		//utgard-lokis connections
		ArrayList<Point> connectPointsLoki = new ArrayList<Point>();
		connectPointsLoki.add(mtTPoint);
		connectPointsLoki.add(mimirPoint);
		connectPointsLoki.add(riverIvingPoint);
		connectPointsLoki.add(grioPoint);
		utgardLokiConnect.add(new Connection(mountThrymheim, new Route(connectPointsLoki), 55));
		utgardLokiConnect.add(new Connection(mimirsWell, new Route(connectPointsLoki), 70));
		utgardLokiConnect.add(new Connection(riverIving, new Route(connectPointsLoki), 50));
		utgardLokiConnect.add(new Connection(griotunagardar, new Route(connectPointsLoki), 40));
		utgardLokisThrone.setConnections(utgardLokiConnect);
		
		//mimir's well connections
		
		//mountain thrymheim connections
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
