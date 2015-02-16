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
				odinPoint, 8, Realm.Asgard); // this is where the realms connect
												// to Asgard

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

		// connections from valhalla
		ArrayList<Point> connectPointsValToOdin = new ArrayList<Point>();
		connectPointsValToOdin.add(odinPoint);
		ArrayList<Point> connectPointsValToMnts = new ArrayList<Point>();
		connectPointsValToMnts.add(mntnPoint);
		valhallaConnect.add(new Connection(odinsFortress, new Route(
				connectPointsValToOdin), 30));
		valhallaConnect.add(new Connection(asgardMnts, new Route(
				connectPointsValToMnts), 70));
		valhalla.setConnections(valhallaConnect);

		// connections from lake logur
		ArrayList<Point> connectPointsLakeLogur = new ArrayList<Point>();
		connectPointsLakeLogur.add(mntnPoint);
		lakeConnect.add(new Connection(asgardMnts, new Route(
				connectPointsLakeLogur), 40));
		lakeLogur.setConnections(lakeConnect);

		// connections from asgard mountains
		ArrayList<Point> connectPointsMountsToLake = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToVal = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToOdin = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToSea = new ArrayList<Point>();
		connectPointsMountsToLake.add(lakePoint);
		connectPointsMountsToVal.add(valhallaPoint);
		connectPointsMountsToOdin.add(odinPoint);
		connectPointsMountsToSea.add(seaPoint);
		mntnConnect.add(new Connection(lakeLogur, new Route(
				connectPointsMountsToLake), 40));
		mntnConnect.add(new Connection(valhalla, new Route(
				connectPointsMountsToVal), 50));
		mntnConnect.add(new Connection(odinsFortress, new Route(
				connectPointsMountsToOdin), 45));
		mntnConnect.add(new Connection(seaOfMarmora, new Route(
				connectPointsMountsToSea), 80));
		asgardMnts.setConnections(mntnConnect);

		// connections from Odin's fortress
		ArrayList<Point> connectPointsOdinToVal = new ArrayList<Point>();
		ArrayList<Point> connectPointsOdinToMnts = new ArrayList<Point>();
		ArrayList<Point> connectPointsOdinToSea = new ArrayList<Point>();
		connectPointsOdinToVal.add(valhallaPoint);
		connectPointsOdinToMnts.add(mntnPoint);
		connectPointsOdinToSea.add(seaPoint);
		odinConnect.add(new Connection(valhalla, new Route(
				connectPointsOdinToVal), 30));
		odinConnect.add(new Connection(asgardMnts, new Route(
				connectPointsOdinToMnts), 45));
		odinConnect.add(new Connection(seaOfMarmora, new Route(
				connectPointsOdinToSea), 70));
		odinsFortress.setConnections(odinConnect);

		// connections from the sea of marmora
		ArrayList<Point> connectPointsSeaToOdin = new ArrayList<Point>();
		ArrayList<Point> connectPointsSeaToMntn = new ArrayList<Point>();
		connectPointsSeaToOdin.add(odinPoint);
		connectPointsSeaToMntn.add(mntnPoint);
		seaConnect.add(new Connection(odinsFortress, new Route(
				connectPointsSeaToOdin), 70));
		seaConnect.add(new Connection(asgardMnts, new Route(
				connectPointsSeaToMntn), 80));
		seaOfMarmora.setConnections(seaConnect);

	}

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
				7, Realm.Jotunheim); // this is where the realms connect to
										// Utgard

		Place griotunagardar = new Place("Griotunagardar", grioConnect,
				grioPoint, 5, Realm.Jotunheim);

		Place mountThrymheim = new Place("The Mountain Thrymheim", mtTConnect,
				mtTPoint, 7, Realm.Jotunheim);

		t.insert(riverIving);
		t.insert(utgardLokisThrone);
		t.insert(mimirsWell);
		t.insert(griotunagardar);
		t.insert(mountThrymheim);

		// river iving connections
		ArrayList<Point> connectPointsIvingToGrio = new ArrayList<Point>();
		ArrayList<Point> connectPointsIvingToLoki = new ArrayList<Point>();
		ArrayList<Point> connectPointsIvingToMimir = new ArrayList<Point>();
		connectPointsIvingToGrio.add(grioPoint);
		connectPointsIvingToLoki.add(utgardLokiPoint);
		connectPointsIvingToMimir.add(mimirPoint);
		riverIvingConnect.add(new Connection(griotunagardar, new Route(
				connectPointsIvingToGrio), 45));
		riverIvingConnect.add(new Connection(utgardLokisThrone, new Route(
				connectPointsIvingToLoki), 50));
		riverIvingConnect.add(new Connection(mimirsWell, new Route(
				connectPointsIvingToMimir), 90));
		riverIving.setConnections(riverIvingConnect);

		// griotunagardar connections
		ArrayList<Point> connectPointsGrioToLoki = new ArrayList<Point>();
		ArrayList<Point> connectPointsGrioToRiver = new ArrayList<Point>();
		connectPointsGrioToLoki.add(utgardLokiPoint);
		connectPointsGrioToRiver.add(riverIvingPoint);
		grioConnect.add(new Connection(utgardLokisThrone, new Route(
				connectPointsGrioToLoki), 40));
		grioConnect.add(new Connection(riverIving, new Route(
				connectPointsGrioToRiver), 45));
		griotunagardar.setConnections(grioConnect);

		// utgard-lokis connections
		ArrayList<Point> connectPointsLokiToThrymheim = new ArrayList<Point>();
		ArrayList<Point> connectPointsLokiToMimir = new ArrayList<Point>();
		ArrayList<Point> connectPointsLokiToRiver = new ArrayList<Point>();
		ArrayList<Point> connectPointsLokiToGrio = new ArrayList<Point>();
		connectPointsLokiToThrymheim.add(mtTPoint);
		connectPointsLokiToMimir.add(mimirPoint);
		connectPointsLokiToRiver.add(riverIvingPoint);
		connectPointsLokiToGrio.add(grioPoint);
		utgardLokiConnect.add(new Connection(mountThrymheim, new Route(
				connectPointsLokiToThrymheim), 55));
		utgardLokiConnect.add(new Connection(mimirsWell, new Route(
				connectPointsLokiToMimir), 70));
		utgardLokiConnect.add(new Connection(riverIving, new Route(
				connectPointsLokiToRiver), 50));
		utgardLokiConnect.add(new Connection(griotunagardar, new Route(
				connectPointsLokiToGrio), 40));
		utgardLokisThrone.setConnections(utgardLokiConnect);

		// mimir's well connections
		ArrayList<Point> connectPointsMimirToLoki = new ArrayList<Point>();
		ArrayList<Point> connectPointsMimirToRiver = new ArrayList<Point>();
		connectPointsMimirToLoki.add(utgardLokiPoint);
		connectPointsMimirToRiver.add(riverIvingPoint);
		mimirConnect.add(new Connection(utgardLokisThrone, new Route(
				connectPointsMimirToLoki), 70));
		mimirConnect.add(new Connection(riverIving, new Route(
				connectPointsMimirToRiver), 90));
		mimirsWell.setConnections(mimirConnect);

		// mountain thrymheim connections
		ArrayList<Point> connectPointsThrymheim = new ArrayList<Point>();
		connectPointsThrymheim.add(utgardLokiPoint);
		utgardLokiConnect.add(new Connection(utgardLokisThrone, new Route(
				connectPointsThrymheim), 55));
	}

	public void createNiflheim() {

		ArrayList<Connection> plainsConnect = new ArrayList<Connection>();
		Point plainPoint = new Point(20, 20);

		ArrayList<Connection> fimbulthulConnect = new ArrayList<Connection>();
		Point fimbulthulPoint = new Point(60, 60);

		ArrayList<Connection> riverEliyagarConnect = new ArrayList<Connection>();
		Point riverEliyagarPoint = new Point(70, 20);

		ArrayList<Connection> hvergelmirConnect = new ArrayList<Connection>();
		Point hvergelmirPoint = new Point(15, 80);

		ArrayList<Connection> helheimConnect = new ArrayList<Connection>();
		Point helheimPoint = new Point(50, 95);

		Place plainsOfGin = new Place("The Plains of Ginnungagap",
				plainsConnect, plainPoint, 3, Realm.Niflheim);

		Place fimbulthul = new Place("Fimbulthul", fimbulthulConnect,
				fimbulthulPoint, 6, Realm.Niflheim);

		Place riverEliyagar = new Place("The River Eliyagar",
				riverEliyagarConnect, riverEliyagarPoint, 4, Realm.Niflheim);

		Place hvergelmir = new Place("The Spring Hvergelmir", // this is where
																// the realms
																// connect to
																// Niflheim
				hvergelmirConnect, hvergelmirPoint, 8, Realm.Niflheim);

		Place helheim = new Place("Helheim (Hel's Throne)", helheimConnect,
				helheimPoint, 9, Realm.Niflheim);

		t.insert(plainsOfGin);
		t.insert(fimbulthul);
		t.insert(riverEliyagar);
		t.insert(hvergelmir);
		t.insert(helheim);

		// plains of ginnungagap connections
		ArrayList<Point> connectPointsGinToRiver = new ArrayList<Point>();
		ArrayList<Point> connectPointsGinToFimbulthul = new ArrayList<Point>();
		ArrayList<Point> connectPointsGinToHvergelmir = new ArrayList<Point>();
		connectPointsGinToRiver.add(riverEliyagarPoint);
		connectPointsGinToFimbulthul.add(fimbulthulPoint);
		connectPointsGinToHvergelmir.add(hvergelmirPoint);
		plainsConnect.add(new Connection(riverEliyagar, new Route(
				connectPointsGinToRiver), 70));
		plainsConnect.add(new Connection(fimbulthul, new Route(
				connectPointsGinToFimbulthul), 80));
		plainsConnect.add(new Connection(hvergelmir, new Route(
				connectPointsGinToHvergelmir), 90));
		plainsOfGin.setConnections(plainsConnect);

		// fimbulthul connections
		ArrayList<Point> connectPointsFimbulthulToRiver = new ArrayList<Point>();
		ArrayList<Point> connectPointsFimbulthulToGin = new ArrayList<Point>();
		connectPointsFimbulthulToRiver.add(riverEliyagarPoint);
		connectPointsFimbulthulToGin.add(plainPoint);
		fimbulthulConnect.add(new Connection(riverEliyagar, new Route(
				connectPointsFimbulthulToRiver), 60));
		fimbulthulConnect.add(new Connection(plainsOfGin, new Route(
				connectPointsFimbulthulToGin), 80));
		fimbulthul.setConnections(fimbulthulConnect);

		// river eliyagar connections
		ArrayList<Point> connectPointsRiverToPlains = new ArrayList<Point>();
		ArrayList<Point> connectPointsRiverToFimbulthul = new ArrayList<Point>();
		connectPointsRiverToPlains.add(plainPoint);
		connectPointsRiverToFimbulthul.add(fimbulthulPoint);
		riverEliyagarConnect.add(new Connection(plainsOfGin, new Route(
				connectPointsRiverToPlains), 70));
		riverEliyagarConnect.add(new Connection(fimbulthul, new Route(
				connectPointsRiverToFimbulthul), 60));
		riverEliyagar.setConnections(riverEliyagarConnect);

		// hvergelmir connections
		ArrayList<Point> connectHverToPlains = new ArrayList<Point>();
		ArrayList<Point> connectHverToHelheim = new ArrayList<Point>();
		connectHverToPlains.add(plainPoint);
		connectHverToHelheim.add(helheimPoint);
		hvergelmirConnect.add(new Connection(plainsOfGin, new Route(
				connectHverToPlains), 90));
		hvergelmirConnect.add(new Connection(helheim, new Route(
				connectHverToHelheim), 60));
		hvergelmir.setConnections(hvergelmirConnect);

		// helheim connections
		ArrayList<Point> connectHelheimToHver = new ArrayList<Point>();
		connectHelheimToHver.add(hvergelmirPoint);
		helheimConnect.add(new Connection(hvergelmir, new Route(
				connectHelheimToHver), 60));
		helheim.setConnections(helheimConnect);

	}

	public void createVanaheim() {

		ArrayList<Connection> njordConnect = new ArrayList<Connection>();
		Point njordPoint = new Point(70, 20);

		ArrayList<Connection> donRiverConnect = new ArrayList<Connection>();
		Point donPoint = new Point(20, 40);

		ArrayList<Connection> eigMtnConnect = new ArrayList<Connection>();
		Point eigMtnPoint = new Point(50, 50);

		ArrayList<Connection> pictishConnect = new ArrayList<Connection>();
		Point pictishPoint = new Point(55, 70);

		ArrayList<Connection> forestVanirConnect = new ArrayList<Connection>();
		Point forestPoint = new Point(10, 80);

		Place njord = new Place("The Home Of Njord", njordConnect, njordPoint,
				7, Realm.Vanaheim);

		Place donRiver = new Place("Don River", donRiverConnect, donPoint, 4,
				Realm.Vanaheim); // this is where the realms connect to Vanaheim

		Place eiglopianMnt = new Place("Eiglopian Mountains", eigMtnConnect,
				eigMtnPoint, 5, Realm.Vanaheim);

		Place pictishWilderness = new Place("The Pictish Wilderness",
				pictishConnect, pictishPoint, 6, Realm.Vanaheim);

		Place forestOfVanir = new Place("The Forests of Vanir",
				forestVanirConnect, forestPoint, 5, Realm.Vanaheim);

		t.insert(njord);
		t.insert(donRiver);
		t.insert(eiglopianMnt);
		t.insert(pictishWilderness);
		t.insert(forestOfVanir);

		// njord connections
		ArrayList<Point> connectNjordToDonRiver = new ArrayList<Point>();
		connectNjordToDonRiver.add(donPoint);
		njordConnect.add(new Connection(donRiver, new Route(
				connectNjordToDonRiver), 50));
		njord.setConnections(njordConnect);

		// don River connections
		ArrayList<Point> connectRiverToNjord = new ArrayList<Point>();
		ArrayList<Point> connectRiverToMtn = new ArrayList<Point>();
		ArrayList<Point> connectRiverToForest = new ArrayList<Point>();
		connectRiverToNjord.add(njordPoint);
		connectRiverToMtn.add(eigMtnPoint);
		connectRiverToForest.add(forestPoint);
		donRiverConnect.add(new Connection(njord,
				new Route(connectRiverToNjord), 50));
		donRiverConnect.add(new Connection(eiglopianMnt, new Route(
				connectRiverToMtn), 35));
		donRiverConnect.add(new Connection(forestOfVanir, new Route(
				connectRiverToForest), 60));
		donRiver.setConnections(donRiverConnect);

		// eiglopian mountain connections
		ArrayList<Point> connectMtnToRiver = new ArrayList<Point>();
		ArrayList<Point> connectMtnToForest = new ArrayList<Point>();
		ArrayList<Point> connectMtnToPictish = new ArrayList<Point>();
		connectMtnToRiver.add(donPoint);
		connectMtnToForest.add(forestPoint);
		connectMtnToPictish.add(pictishPoint);
		eigMtnConnect.add(new Connection(donRiver,
				new Route(connectMtnToRiver), 35));
		eigMtnConnect.add(new Connection(forestOfVanir, new Route(
				connectMtnToForest), 55));
		eigMtnConnect.add(new Connection(pictishWilderness, new Route(
				connectMtnToPictish), 30));
		eiglopianMnt.setConnections(eigMtnConnect);

		// pictish wilderness connections
		ArrayList<Point> connectWildToForest = new ArrayList<Point>();
		ArrayList<Point> connectWildToMtn = new ArrayList<Point>();
		connectWildToForest.add(forestPoint);
		connectWildToMtn.add(eigMtnPoint);
		pictishConnect.add(new Connection(forestOfVanir, new Route(
				connectWildToForest), 50));
		pictishConnect.add(new Connection(eiglopianMnt, new Route(
				connectWildToMtn), 30));
		pictishWilderness.setConnections(pictishConnect);

		// forest of vanir connections
		ArrayList<Point> connectForestToRiver = new ArrayList<Point>();
		ArrayList<Point> connectForestToMtn = new ArrayList<Point>();
		ArrayList<Point> connectForestToWild = new ArrayList<Point>();
		connectForestToRiver.add(donPoint);
		connectForestToMtn.add(eigMtnPoint);
		connectForestToWild.add(pictishPoint);
		forestVanirConnect.add(new Connection(donRiver, new Route(
				connectForestToRiver), 60));
		forestVanirConnect.add(new Connection(eiglopianMnt, new Route(
				connectForestToMtn), 55));
		forestVanirConnect.add(new Connection(pictishWilderness, new Route(
				connectForestToWild), 50));
		forestOfVanir.setConnections(forestVanirConnect);

	}

	public void createAlfheim() {

		ArrayList<Connection> freyrConnect = new ArrayList<Connection>();
		Point freyrPoint = new Point(50, 50);

		ArrayList<Connection> geffenConnect = new ArrayList<Connection>();
		Point geffenPoint = new Point(70, 70);

		ArrayList<Connection> canolbarthConnect = new ArrayList<Connection>();
		Point canolbarthPoint = new Point(20, 80);

		Place freyr = new Place("Freyr's Throne", freyrConnect, freyrPoint, 8,
				Realm.Alfheim);

		Place geffen = new Place("Geffen", geffenConnect, geffenPoint, 6,
				Realm.Alfheim);

		Place canolbarth = new Place("Canolbarth Forest", canolbarthConnect,
				canolbarthPoint, 7, Realm.Alfheim); // this is where the realms
													// connect to Alfheim

		t.insert(freyr);
		t.insert(geffen);
		t.insert(canolbarth);

		// freyr connections
		ArrayList<Point> connectFreyrToGeffen = new ArrayList<Point>();
		ArrayList<Point> connectFreyrToForest = new ArrayList<Point>();
		connectFreyrToGeffen.add(geffenPoint);
		connectFreyrToForest.add(canolbarthPoint);
		freyrConnect.add(new Connection(geffen,
				new Route(connectFreyrToGeffen), 50));
		freyrConnect.add(new Connection(canolbarth, new Route(
				connectFreyrToForest), 90));
		freyr.setConnections(freyrConnect);

		// geffen connections
		ArrayList<Point> connectGeffenToFreyr = new ArrayList<Point>();
		connectGeffenToFreyr.add(freyrPoint);
		geffenConnect.add(new Connection(freyr,
				new Route(connectGeffenToFreyr), 50));
		geffen.setConnections(geffenConnect);

		// canolbarth connections
		ArrayList<Point> connectForestToFreyr = new ArrayList<Point>();
		connectForestToFreyr.add(freyrPoint);
		canolbarthConnect.add(new Connection(freyr, new Route(
				connectForestToFreyr), 90));
		canolbarth.setConnections(canolbarthConnect);

	}

	public void createMidgard() {

		ArrayList<Connection> nycConnect = new ArrayList<Connection>();
		Point nycPoint = new Point(30, 50);

		ArrayList<Connection> dcConnect = new ArrayList<Connection>();
		Point dcPoint = new Point(30, 55);

		ArrayList<Connection> wheatonConnect = new ArrayList<Connection>();
		Point wheatonPoint = new Point(25, 45);

		ArrayList<Connection> antiguoConnect = new ArrayList<Connection>();
		Point antiguoPoint = new Point(10, 60);

		ArrayList<Connection> londonConnect = new ArrayList<Connection>();
		Point londonPoint = new Point(90, 10);

		Place nyc = new Place("New York, New York", nycConnect, nycPoint, 9,
				Realm.Midgard);

		Place dc = new Place("Washington, D.C.", dcConnect, dcPoint, 9,
				Realm.Midgard);

		Place wheaton = new Place("Wheaton, New Jersey", wheatonConnect,
				wheatonPoint, 6, Realm.Midgard);

		Place antiguo = new Place("Puente Antiguo, New Mexico", antiguoConnect,
				antiguoPoint, 7, Realm.Midgard);

		Place london = new Place("London, England", londonConnect, londonPoint,
				9, Realm.Midgard); // this is where the realms connect to
									// Midgard

		t.insert(nyc);
		t.insert(dc);
		t.insert(wheaton);
		t.insert(antiguo);
		t.insert(london);

		// nyc connections
		ArrayList<Point> connectNYCtoLondon = new ArrayList<Point>();
		ArrayList<Point> connectNYCtoNJ = new ArrayList<Point>();
		ArrayList<Point> connectNYCtoDC = new ArrayList<Point>();
		ArrayList<Point> connectNYCtoNM = new ArrayList<Point>();
		connectNYCtoLondon.add(londonPoint);
		connectNYCtoNJ.add(wheatonPoint);
		connectNYCtoDC.add(dcPoint);
		connectNYCtoNM.add(antiguoPoint);
		nycConnect.add(new Connection(london, new Route(connectNYCtoLondon),
				120));
		nycConnect.add(new Connection(wheaton, new Route(connectNYCtoNJ), 20));
		nycConnect.add(new Connection(dc, new Route(connectNYCtoDC), 10));
		nycConnect.add(new Connection(antiguo, new Route(connectNYCtoNM), 40));
		nyc.setConnections(nycConnect);

		// wheaton connections
		ArrayList<Point> connectNJtoNYC = new ArrayList<Point>();
		ArrayList<Point> connectNJtoDC = new ArrayList<Point>();
		ArrayList<Point> connectNJtoNM = new ArrayList<Point>();
		connectNJtoNYC.add(nycPoint);
		connectNJtoDC.add(dcPoint);
		connectNJtoNM.add(antiguoPoint);
		wheatonConnect.add(new Connection(nyc, new Route(connectNJtoNYC), 20));
		wheatonConnect.add(new Connection(dc, new Route(connectNJtoDC), 25));
		wheatonConnect
				.add(new Connection(antiguo, new Route(connectNJtoNM), 40));
		wheaton.setConnections(wheatonConnect);

		// dc connections
		ArrayList<Point> connectDCtoNYC = new ArrayList<Point>();
		ArrayList<Point> connectDCtoNJ = new ArrayList<Point>();
		ArrayList<Point> connectDCtoNM = new ArrayList<Point>();
		ArrayList<Point> connectDCtoLondon = new ArrayList<Point>();
		connectDCtoNYC.add(nycPoint);
		connectDCtoNJ.add(wheatonPoint);
		connectDCtoNM.add(wheatonPoint);
		connectDCtoLondon.add(londonPoint);
		dcConnect.add(new Connection(nyc, new Route(connectDCtoNYC), 10));
		dcConnect.add(new Connection(wheaton, new Route(connectDCtoNJ), 25));
		dcConnect.add(new Connection(antiguo, new Route(connectDCtoNM), 35));
		dcConnect
				.add(new Connection(london, new Route(connectDCtoLondon), 150));
		dc.setConnections(dcConnect);

		// puente antiguo connections
		ArrayList<Point> connectNMtoNYC = new ArrayList<Point>();
		ArrayList<Point> connectNMtoNJ = new ArrayList<Point>();
		ArrayList<Point> connectNMtoDC = new ArrayList<Point>();
		connectNMtoNYC.add(nycPoint);
		connectNMtoNJ.add(wheatonPoint);
		connectNMtoDC.add(dcPoint);
		antiguoConnect.add(new Connection(nyc, new Route(connectNMtoNYC), 40));
		antiguoConnect
				.add(new Connection(wheaton, new Route(connectNMtoNJ), 40));
		antiguoConnect.add(new Connection(dc, new Route(connectNMtoDC), 35));
		antiguo.setConnections(antiguoConnect);

		// london connections
		ArrayList<Point> connectLondonToNYC = new ArrayList<Point>();
		ArrayList<Point> connectLondonToDC = new ArrayList<Point>();
		connectLondonToNYC.add(nycPoint);
		connectLondonToDC.add(dcPoint);
		londonConnect.add(new Connection(nyc, new Route(connectLondonToNYC),
				120));
		londonConnect
				.add(new Connection(dc, new Route(connectLondonToDC), 150));
		london.setConnections(londonConnect);

	}

	public void createSvartalfheim() {

		ArrayList<Connection> malekithConnect = new ArrayList<Connection>();
		Point malekithPoint = new Point(20, 10);

		ArrayList<Connection> unseelieConnect = new ArrayList<Connection>();
		Point unseeliePoint = new Point(10, 30);

		ArrayList<Connection> byrgirConnect = new ArrayList<Connection>();
		Point byrgirPoint = new Point(80, 40);

		ArrayList<Connection> blackConnect = new ArrayList<Connection>();
		Point blackPoint = new Point(85, 80);

		ArrayList<Connection> aurvangarConnect = new ArrayList<Connection>();
		Point aurvangarPoint = new Point(20, 75);

		Place malekith = new Place("The Domain of Malekith", malekithConnect,
				malekithPoint, 9, Realm.Svartalfheim);

		Place unseelieCourt = new Place("The Unseelie Court", unseelieConnect,
				unseeliePoint, 4, Realm.Svartalfheim);

		Place byrgir = new Place("Byrgir", byrgirConnect, byrgirPoint, 6,
				Realm.Svartalfheim);

		Place blackForest = new Place("The Black Forest", blackConnect,
				blackPoint, 7, Realm.Svartalfheim); // this is where the realms
													// connect to Svartalfheim

		Place aurvangar = new Place("Aurvangar", aurvangarConnect,
				aurvangarPoint, 5, Realm.Svartalfheim);

		t.insert(malekith);
		t.insert(unseelieCourt);
		t.insert(byrgir);
		t.insert(blackForest);
		t.insert(aurvangar);

		// malekith connections
		ArrayList<Point> connectMalekithToUnseelie = new ArrayList<Point>();
		connectMalekithToUnseelie.add(unseeliePoint);
		malekithConnect.add(new Connection(unseelieCourt, new Route(
				connectMalekithToUnseelie), 20));
		malekith.setConnections(malekithConnect);

		// unseelie court connections
		ArrayList<Point> connectUnseelieToMalekith = new ArrayList<Point>();
		ArrayList<Point> connectUnseelieToBrygir = new ArrayList<Point>();
		ArrayList<Point> connectUnseelieToAurvangar = new ArrayList<Point>();
		connectUnseelieToMalekith.add(malekithPoint);
		connectUnseelieToBrygir.add(byrgirPoint);
		connectUnseelieToAurvangar.add(aurvangarPoint);
		unseelieConnect.add(new Connection(malekith, new Route(
				connectUnseelieToMalekith), 20));
		unseelieConnect.add(new Connection(byrgir, new Route(
				connectUnseelieToBrygir), 70));
		unseelieConnect.add(new Connection(aurvangar, new Route(
				connectUnseelieToAurvangar), 50));
		unseelieCourt.setConnections(unseelieConnect);

		// byrgir connections
		ArrayList<Point> connectByrgirToUnseelie = new ArrayList<Point>();
		ArrayList<Point> connectByrgirToForest = new ArrayList<Point>();
		connectByrgirToUnseelie.add(unseeliePoint);
		connectByrgirToForest.add(blackPoint);
		byrgirConnect.add(new Connection(unseelieCourt, new Route(
				connectByrgirToUnseelie), 70));
		byrgirConnect.add(new Connection(blackForest, new Route(
				connectByrgirToForest), 50));
		byrgir.setConnections(byrgirConnect);

		// black forest connections
		ArrayList<Point> connectForestToByrgir = new ArrayList<Point>();
		ArrayList<Point> connectForestToAurvangar = new ArrayList<Point>();
		connectForestToByrgir.add(byrgirPoint);
		connectForestToAurvangar.add(aurvangarPoint);
		blackConnect.add(new Connection(byrgir,
				new Route(connectForestToByrgir), 50));
		blackConnect.add(new Connection(aurvangar, new Route(
				connectForestToAurvangar), 60));
		blackForest.setConnections(blackConnect);

		// aurvangar connections
		ArrayList<Point> connectAurvangarToForest = new ArrayList<Point>();
		ArrayList<Point> connectAurvangarToUnseelie = new ArrayList<Point>();
		connectAurvangarToForest.add(blackPoint);
		connectAurvangarToUnseelie.add(unseeliePoint);
		aurvangarConnect.add(new Connection(blackForest, new Route(
				connectAurvangarToForest), 60));
		aurvangarConnect.add(new Connection(unseelieCourt, new Route(
				connectAurvangarToUnseelie), 50));
		aurvangar.setConnections(aurvangarConnect);

	}

	public void createNidavellir() {

		ArrayList<Connection> hreidmarConnect = new ArrayList<Connection>();
		Point hreidmarPoint = new Point(20, 30);

		ArrayList<Connection> durinConnect = new ArrayList<Connection>();
		Point durinPoint = new Point(70, 50);

		ArrayList<Connection> dvalinConnect = new ArrayList<Connection>();
		Point dvalinPoint = new Point(70, 60);

		ArrayList<Connection> darkFieldConnect = new ArrayList<Connection>();
		Point darkFieldPoint = new Point(20, 80);

		ArrayList<Connection> furnaceConnect = new ArrayList<Connection>();
		Point furnacePoint = new Point(50, 95);

		Place hreidmar = new Place("Hreidmar's Kingdom", hreidmarConnect,
				hreidmarPoint, 9, Realm.Nidavellir); // this is where the realms
														// connect to Nidavellir

		Place durin = new Place("Durin's Hall", durinConnect, durinPoint, 4,
				Realm.Nidavellir);

		Place dvalin = new Place("Dvalin's Hall", dvalinConnect, dvalinPoint,
				4, Realm.Nidavellir);

		Place darkFields = new Place("The Dark Fields", darkFieldConnect,
				darkFieldPoint, 5, Realm.Nidavellir);

		Place furnaces = new Place("The Furnaces of Nidavellir",
				furnaceConnect, furnacePoint, 10, Realm.Nidavellir);

		t.insert(hreidmar);
		t.insert(durin);
		t.insert(dvalin);
		t.insert(darkFields);
		t.insert(furnaces);

		// hreidmar connections
		ArrayList<Point> connectHreidmarToDurin = new ArrayList<Point>();
		ArrayList<Point> connectHreidmarToFields = new ArrayList<Point>();
		connectHreidmarToDurin.add(durinPoint);
		connectHreidmarToFields.add(darkFieldPoint);
		hreidmarConnect.add(new Connection(durin, new Route(
				connectHreidmarToDurin), 50));
		hreidmarConnect.add(new Connection(darkFields, new Route(
				connectHreidmarToFields), 60));
		hreidmar.setConnections(hreidmarConnect);

		// durin's connections
		ArrayList<Point> connectDurinToHreidmar = new ArrayList<Point>();
		ArrayList<Point> connectDurinToDvalin = new ArrayList<Point>();
		ArrayList<Point> connectDurinToFields = new ArrayList<Point>();
		connectDurinToHreidmar.add(hreidmarPoint);
		connectDurinToDvalin.add(dvalinPoint);
		connectDurinToFields.add(darkFieldPoint);
		durinConnect.add(new Connection(hreidmar, new Route(
				connectDurinToHreidmar), 50));
		durinConnect.add(new Connection(dvalin,
				new Route(connectDurinToDvalin), 20));
		durinConnect.add(new Connection(darkFields, new Route(
				connectDurinToFields), 60));
		durin.setConnections(durinConnect);

		// dvalin's connections
		ArrayList<Point> connectDvalinToDurin = new ArrayList<Point>();
		ArrayList<Point> connectDvalinToFields = new ArrayList<Point>();
		connectDvalinToDurin.add(durinPoint);
		connectDvalinToFields.add(darkFieldPoint);
		dvalinConnect.add(new Connection(durin,
				new Route(connectDvalinToDurin), 20));
		dvalinConnect.add(new Connection(darkFields, new Route(
				connectDvalinToFields), 50));
		dvalin.setConnections(dvalinConnect);

		// dark field connections
		ArrayList<Point> connectFieldsToHreidmar = new ArrayList<Point>();
		ArrayList<Point> connectFieldsToDurin = new ArrayList<Point>();
		ArrayList<Point> connectFieldsToDvalin = new ArrayList<Point>();
		ArrayList<Point> connectFieldsToFurnaces = new ArrayList<Point>();
		connectFieldsToHreidmar.add(hreidmarPoint);
		connectFieldsToDurin.add(durinPoint);
		connectFieldsToDvalin.add(dvalinPoint);
		connectFieldsToFurnaces.add(furnacePoint);
		darkFieldConnect.add(new Connection(hreidmar, new Route(
				connectFieldsToHreidmar), 60));
		darkFieldConnect.add(new Connection(durin, new Route(
				connectFieldsToDurin), 60));
		darkFieldConnect.add(new Connection(dvalin, new Route(
				connectFieldsToDvalin), 50));
		darkFieldConnect.add(new Connection(furnaces, new Route(
				connectFieldsToFurnaces), 55));
		darkFields.setConnections(darkFieldConnect);

		// furnaces connections
		ArrayList<Point> connectFurnacesToFields = new ArrayList<Point>();
		connectFurnacesToFields.add(darkFieldPoint);
		furnaceConnect.add(new Connection(darkFields, new Route(
				connectFurnacesToFields), 55));
		furnaces.setConnections(furnaceConnect);

	}

	public void createMuspelheim() {

		ArrayList<Connection> plainsConnect = new ArrayList<Connection>();
		Point plainsPoint = new Point(10, 40);

		ArrayList<Connection> surturConnect = new ArrayList<Connection>();
		Point surturPoint = new Point(50, 50);

		ArrayList<Connection> sinmoreConnect = new ArrayList<Connection>();
		Point sinmorePoint = new Point(60, 40);

		Place burningPlains = new Place("The Burning Plains of Surt",
				plainsConnect, plainsPoint, 4, Realm.Muspelheim);

		Place surtursKingdom = new Place("Surtur's Kingdom", surturConnect,
				surturPoint, 8, Realm.Muspelheim); // this is where the realms
													// connect to Muspelheim

		Place sinmoreHall = new Place("Sinmore Hall", sinmoreConnect,
				sinmorePoint, 6, Realm.Muspelheim);

		t.insert(burningPlains);
		t.insert(surtursKingdom);
		t.insert(sinmoreHall);

		// burning plains connections
		ArrayList<Point> connectPlainsToSurtur = new ArrayList<Point>();
		connectPlainsToSurtur.add(surturPoint);
		plainsConnect.add(new Connection(surtursKingdom, new Route(
				connectPlainsToSurtur), 90));
		burningPlains.setConnections(plainsConnect);

		// surturs connections
		ArrayList<Point> connectSurtToPlains = new ArrayList<Point>();
		ArrayList<Point> connectSurtToSinmore = new ArrayList<Point>();
		connectSurtToPlains.add(plainsPoint);
		connectSurtToSinmore.add(sinmorePoint);
		surturConnect.add(new Connection(burningPlains, new Route(
				connectSurtToPlains), 90));
		surturConnect.add(new Connection(sinmoreHall, new Route(
				connectSurtToSinmore), 30));
		surtursKingdom.setConnections(surturConnect);

		// sinmores connections
		ArrayList<Point> connectSinmoreToSurt = new ArrayList<Point>();
		connectSinmoreToSurt.add(surturPoint);
		sinmoreConnect.add(new Connection(surtursKingdom, new Route(
				connectSinmoreToSurt), 30));
		sinmoreHall.setConnections(sinmoreConnect);

	}
}
