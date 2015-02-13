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
		ArrayList<Point> connectPointsValToOdin = new ArrayList<Point>();
		connectPointsValToOdin.add(odinPoint);
		ArrayList<Point> connectPointsValToMnts = new ArrayList<Point>();
		connectPointsValToMnts.add(mntnPoint);
		valhallaConnect.add(new Connection(odinsFortress, new Route(connectPointsValToOdin), 30));
		valhallaConnect.add(new Connection(asgardMnts, new Route(connectPointsValToMnts), 70));
		valhalla.setConnections(valhallaConnect);
		
		//connections from lake logur
		ArrayList<Point> connectPointsLakeLogur = new ArrayList<Point>();
		connectPointsLakeLogur.add(mntnPoint);
		lakeConnect.add(new Connection(asgardMnts, new Route(connectPointsLakeLogur), 40));
		lakeLogur.setConnections(lakeConnect);
		
		//connections from asgard mountains
		ArrayList<Point> connectPointsMountsToLake = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToVal = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToOdin = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToSea = new ArrayList<Point>();
		connectPointsMountsToLake.add(lakePoint);
		connectPointsMountsToVal.add(valhallaPoint);
		connectPointsMountsToOdin.add(odinPoint);
		connectPointsMountsToSea.add(seaPoint);
		mntnConnect.add(new Connection(lakeLogur, new Route(connectPointsMountsToLake), 40));
		mntnConnect.add(new Connection(valhalla, new Route(connectPointsMountsToVal), 50));	
		mntnConnect.add(new Connection(odinsFortress, new Route(connectPointsMountsToOdin), 45));
		mntnConnect.add(new Connection(seaOfMarmora, new Route(connectPointsMountsToSea), 80));
		asgardMnts.setConnections(mntnConnect);
		
		//connections from Odin's fortress
		ArrayList<Point> connectPointsOdinToVal = new ArrayList<Point>();
		ArrayList<Point> connectPointsOdinToMnts = new ArrayList<Point>();
		ArrayList<Point> connectPointsOdinToSea = new ArrayList<Point>();
		connectPointsOdinToVal.add(valhallaPoint);
		connectPointsOdinToMnts.add(mntnPoint);
		connectPointsOdinToSea.add(seaPoint);
		odinConnect.add(new Connection(valhalla, new Route(connectPointsOdinToVal), 30));
		odinConnect.add(new Connection(asgardMnts, new Route(connectPointsOdinToMnts), 45));
		odinConnect.add(new Connection(seaOfMarmora, new Route(connectPointsOdinToSea), 70));
		odinsFortress.setConnections(odinConnect);
		
		//connections from the sea of marmora
		ArrayList<Point> connectPointsSeaToOdin = new ArrayList<Point>();
		ArrayList<Point> connectPointsSeaToMntn = new ArrayList<Point>();
		connectPointsSeaToOdin.add(odinPoint);
		connectPointsSeaToMntn.add(mntnPoint);
		seaConnect.add(new Connection(odinsFortress, new Route(connectPointsSeaToOdin), 70));
		seaConnect.add(new Connection(asgardMnts, new Route(connectPointsSeaToMntn), 80));
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
		ArrayList<Point> connectPointsIvingToGrio = new ArrayList<Point>();
		ArrayList<Point> connectPointsIvingToLoki = new ArrayList<Point>();
		ArrayList<Point> connectPointsIvingToMimir = new ArrayList<Point>();
		connectPointsIvingToGrio.add(grioPoint);
		connectPointsIvingToLoki.add(utgardLokiPoint);
		connectPointsIvingToMimir.add(mimirPoint);
		riverIvingConnect.add(new Connection(griotunagardar, new Route(connectPointsIvingToGrio), 45));
		riverIvingConnect.add(new Connection(utgardLokisThrone, new Route(connectPointsIvingToLoki), 50));
		riverIvingConnect.add(new Connection(mimirsWell, new Route(connectPointsIvingToMimir), 90));
		riverIving.setConnections(riverIvingConnect);
		
		//griotunagardar connections
		ArrayList<Point> connectPointsGrioToLoki = new ArrayList<Point>();
		ArrayList<Point> connectPointsGrioToRiver = new ArrayList<Point>();
		connectPointsGrioToLoki.add(utgardLokiPoint);
		connectPointsGrioToRiver.add(riverIvingPoint);
		grioConnect.add(new Connection(utgardLokisThrone, new Route(connectPointsGrioToLoki), 40));
		grioConnect.add(new Connection(riverIving, new Route(connectPointsGrioToRiver), 45));
		griotunagardar.setConnections(grioConnect);
		
		//utgard-lokis connections
		ArrayList<Point> connectPointsLokiToThrymheim = new ArrayList<Point>();
		ArrayList<Point> connectPointsLokiToMimir = new ArrayList<Point>();
		ArrayList<Point> connectPointsLokiToRiver = new ArrayList<Point>();
		ArrayList<Point> connectPointsLokiToGrio = new ArrayList<Point>();
		connectPointsLokiToThrymheim.add(mtTPoint);
		connectPointsLokiToMimir.add(mimirPoint);
		connectPointsLokiToRiver.add(riverIvingPoint);
		connectPointsLokiToGrio.add(grioPoint);
		utgardLokiConnect.add(new Connection(mountThrymheim, new Route(connectPointsLokiToThrymheim), 55));
		utgardLokiConnect.add(new Connection(mimirsWell, new Route(connectPointsLokiToMimir), 70));
		utgardLokiConnect.add(new Connection(riverIving, new Route(connectPointsLokiToRiver), 50));
		utgardLokiConnect.add(new Connection(griotunagardar, new Route(connectPointsLokiToGrio), 40));
		utgardLokisThrone.setConnections(utgardLokiConnect);
		
		//mimir's well connections
		ArrayList<Point> connectPointsMimirToLoki = new ArrayList<Point>();
		ArrayList<Point> connectPointsMimirToRiver = new ArrayList<Point>();
		connectPointsMimirToLoki.add(utgardLokiPoint);
		connectPointsMimirToRiver.add(riverIvingPoint);
		mimirConnect.add(new Connection(utgardLokisThrone, new Route(connectPointsMimirToLoki), 70));
		mimirConnect.add(new Connection(riverIving, new Route(connectPointsMimirToRiver), 90));
		mimirsWell.setConnections(mimirConnect);
		
		//mountain thrymheim connections
		ArrayList<Point> connectPointsThrymheim = new ArrayList<Point>();
		connectPointsThrymheim.add(utgardLokiPoint);
		utgardLokiConnect.add(new Connection(utgardLokisThrone, new Route(connectPointsThrymheim), 55));
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
