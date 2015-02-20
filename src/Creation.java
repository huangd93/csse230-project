import java.util.ArrayList;

/**
 * 
 * This will create Yggdrasil and waypoints, etc.
 * 
 * 
 * @author richarel
 * 
 */
public class Creation {

	PlacesDaoInterface t = PlacesDaoFactory.getPlacesDaoSingleton();
	ArrayList<Place> asgardPlaces = new ArrayList<Place>();
	ArrayList<Place> jotunheimPlaces = new ArrayList<Place>();
	ArrayList<Place> niflheimPlaces = new ArrayList<Place>();
	ArrayList<Place> vanaheimPlaces = new ArrayList<Place>();
	ArrayList<Place> alfheimPlaces = new ArrayList<Place>();
	ArrayList<Place> midgardPlaces = new ArrayList<Place>();
	ArrayList<Place> svartalfheimPlaces = new ArrayList<Place>();
	ArrayList<Place> nidavellirPlaces = new ArrayList<Place>();
	ArrayList<Place> muspelheimPlaces = new ArrayList<Place>();

	public void createAsgard() {
		ArrayList<Connection> valhallaConnect = new ArrayList<Connection>();
		Point valhallaPoint = new Point(790, 70);

		ArrayList<Connection> odinConnect = new ArrayList<Connection>();
		Point odinPoint = new Point(729, 89);

		ArrayList<Connection> mntnConnect = new ArrayList<Connection>();
		Point mntnPoint = new Point(620, 60);

		ArrayList<Connection> lakeConnect = new ArrayList<Connection>();
		Point lakePoint = new Point(680, 100);

		ArrayList<Connection> seaConnect = new ArrayList<Connection>();
		Point seaPoint = new Point(830, 80);

		Place valhalla = new Place("Valhalla", valhallaConnect, valhallaPoint,
				9, Realm.Asgard);

		Place odinsFortress = new Place("Odin's Fortress", odinConnect,
				odinPoint, 8, Realm.Asgard); // this is where the realms connect to Asgard

		Place asgardMnts = new Place("Asgard Mountains", mntnConnect,
				mntnPoint, 5, Realm.Asgard);

		Place lakeLogur = new Place("Lake Logur", lakeConnect, lakePoint, 5,
				Realm.Asgard);

		Place seaOfMarmora = new Place("Sea of Marmora", seaConnect, seaPoint,
				4, Realm.Asgard);
		
		Realm.Asgard.setGate(odinsFortress);
		
		asgardPlaces.add(valhalla);
		asgardPlaces.add(seaOfMarmora);
		asgardPlaces.add(lakeLogur);
		asgardPlaces.add(asgardMnts);
		asgardPlaces.add(odinsFortress);

		t.insert(valhalla);
		t.insert(odinsFortress);
		t.insert(asgardMnts);
		t.insert(lakeLogur);
		t.insert(seaOfMarmora);

		// connections from valhalla
		ArrayList<Point> connectPointsValToOdin = new ArrayList<Point>();
		connectPointsValToOdin.add(valhallaPoint); 
		connectPointsValToOdin.add(new Point(790, 80));
		connectPointsValToOdin.add(new Point(810, 70));
		connectPointsValToOdin.add(odinPoint);
		ArrayList<Point> connectPointsValToMnts = new ArrayList<Point>();
		connectPointsValToMnts.add(valhallaPoint);
		connectPointsValToMnts.add(mntnPoint);
		valhallaConnect.add(new Connection(odinsFortress, new Route(
				connectPointsValToOdin), 30));
		valhallaConnect.add(new Connection(asgardMnts, new Route(
				connectPointsValToMnts), 70));
		valhalla.setConnections(valhallaConnect);

		// connections from lake logur
		ArrayList<Point> connectPointsLakeLogur = new ArrayList<Point>();
		connectPointsLakeLogur.add(lakePoint);
		connectPointsLakeLogur.add(new Point(650, 80));
		connectPointsLakeLogur.add(mntnPoint);
		lakeConnect.add(new Connection(asgardMnts, new Route(
				connectPointsLakeLogur), 40));
		lakeLogur.setConnections(lakeConnect);

		// connections from asgard mountains
		ArrayList<Point> connectPointsMountsToLake = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToVal = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToOdin = new ArrayList<Point>();
		ArrayList<Point> connectPointsMountsToSea = new ArrayList<Point>();
		connectPointsMountsToLake.add(mntnPoint);
		connectPointsMountsToVal.add(mntnPoint);
		connectPointsMountsToOdin.add(mntnPoint);
		connectPointsMountsToSea.add(mntnPoint);
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
		connectPointsOdinToVal.add(odinPoint);
		connectPointsOdinToVal.add(new Point(810, 70));
		connectPointsOdinToVal.add(new Point(790, 80));
		connectPointsOdinToMnts.add(odinPoint);
		connectPointsOdinToSea.add(odinPoint);
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
		connectPointsSeaToOdin.add(seaPoint);
		connectPointsSeaToMntn.add(seaPoint);
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
		Point riverIvingPoint = new Point(610, 350);

		ArrayList<Connection> utgardLokiConnect = new ArrayList<Connection>();
		Point utgardLokiPoint = new Point(632, 388);

		ArrayList<Connection> mimirConnect = new ArrayList<Connection>();
		Point mimirPoint = new Point(690, 370);

		ArrayList<Connection> grioConnect = new ArrayList<Connection>();
		Point grioPoint = new Point(565, 365);

		ArrayList<Connection> mtTConnect = new ArrayList<Connection>();
		Point mtTPoint = new Point(635, 460);

		Place riverIving = new Place("The River Iving", riverIvingConnect,
				riverIvingPoint, 4, Realm.Jotunheim);

		Place utgardLokisThrone = new Place("Utgard-Loki's Throne",
				utgardLokiConnect, utgardLokiPoint, 8, Realm.Jotunheim);

		Place mimirsWell = new Place("Mimir's Well", mimirConnect, mimirPoint,
				7, Realm.Jotunheim); //this is where the realms connect to Utgard

		Place griotunagardar = new Place("Griotunagardar", grioConnect,
				grioPoint, 5, Realm.Jotunheim);

		Place mountThrymheim = new Place("The Mountain Thrymheim", mtTConnect,
				mtTPoint, 7, Realm.Jotunheim);
		
		Realm.Jotunheim.setGate(mimirsWell);
		
		jotunheimPlaces.add(riverIving);
		jotunheimPlaces.add(utgardLokisThrone);
		jotunheimPlaces.add(mountThrymheim);
		jotunheimPlaces.add(mimirsWell);
		jotunheimPlaces.add(griotunagardar);

		t.insert(riverIving);
		t.insert(utgardLokisThrone);
		t.insert(mimirsWell);
		t.insert(griotunagardar);
		t.insert(mountThrymheim);

		// river iving connections
		ArrayList<Point> connectPointsIvingToGrio = new ArrayList<Point>();
		ArrayList<Point> connectPointsIvingToLoki = new ArrayList<Point>();
		ArrayList<Point> connectPointsIvingToMimir = new ArrayList<Point>();
		connectPointsIvingToGrio.add(riverIvingPoint);
		connectPointsIvingToGrio.add(new Point(600, 320));
		connectPointsIvingToGrio.add(new Point(580, 355));
		connectPointsIvingToLoki.add(riverIvingPoint);
		connectPointsIvingToMimir.add(riverIvingPoint);
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
		connectPointsGrioToLoki.add(grioPoint);
		connectPointsGrioToRiver.add(grioPoint);
		connectPointsGrioToRiver.add(new Point(580, 355));
		connectPointsGrioToRiver.add(new Point(600, 320));
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
		connectPointsLokiToThrymheim.add(utgardLokiPoint);
		connectPointsLokiToMimir.add(utgardLokiPoint);
		connectPointsLokiToMimir.add(new Point(670, 400));
		connectPointsLokiToMimir.add(new Point(660, 380));
		connectPointsLokiToRiver.add(utgardLokiPoint);
		connectPointsLokiToGrio.add(utgardLokiPoint);
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
		connectPointsMimirToLoki.add(mimirPoint);
		connectPointsMimirToLoki.add(new Point(660, 380));
		connectPointsMimirToLoki.add(new Point(670, 400));
		connectPointsMimirToRiver.add(mimirPoint);
		connectPointsMimirToLoki.add(utgardLokiPoint);
		connectPointsMimirToRiver.add(riverIvingPoint);
		mimirConnect.add(new Connection(utgardLokisThrone, new Route(
				connectPointsMimirToLoki), 70));
		mimirConnect.add(new Connection(riverIving, new Route(
				connectPointsMimirToRiver), 90));
		mimirsWell.setConnections(mimirConnect);

		// mountain thrymheim connections
		ArrayList<Point> connectPointsThrymheim = new ArrayList<Point>();
		connectPointsThrymheim.add(mtTPoint);
		connectPointsThrymheim.add(utgardLokiPoint);
		mtTConnect.add(new Connection(utgardLokisThrone, new Route(
				connectPointsThrymheim), 55));
		mountThrymheim.setConnections(mtTConnect);
	}

	
	public void createNiflheim() {

		ArrayList<Connection> plainsConnect = new ArrayList<Connection>();
		Point plainPoint = new Point(480, 510);

		ArrayList<Connection> fimbulthulConnect = new ArrayList<Connection>();
		Point fimbulthulPoint = new Point(480, 610);

		ArrayList<Connection> riverEliyagarConnect = new ArrayList<Connection>();
		Point riverEliyagarPoint = new Point(560, 505);

		ArrayList<Connection> hvergelmirConnect = new ArrayList<Connection>();
		Point hvergelmirPoint = new Point(460, 570);

		ArrayList<Connection> helheimConnect = new ArrayList<Connection>();
		Point helheimPoint = new Point(530, 580);

		Place plainsOfGin = new Place("The Plains of Ginnungagap",
				plainsConnect, plainPoint, 3, Realm.Niflheim);

		Place fimbulthul = new Place("Fimbulthul", fimbulthulConnect,
				fimbulthulPoint, 6, Realm.Niflheim);

		Place riverEliyagar = new Place("The River Eliyagar",
				riverEliyagarConnect, riverEliyagarPoint, 4, Realm.Niflheim);

		Place hvergelmir = new Place("The Spring Hvergelmir", // this is where the realms connect to Niflheim
				hvergelmirConnect, hvergelmirPoint, 8, Realm.Niflheim);

		Place helheim = new Place("Helheim (Hel's Throne)", helheimConnect,
				helheimPoint, 9, Realm.Niflheim);
		
		Realm.Niflheim.setGate(hvergelmir);
		
		niflheimPlaces.add(plainsOfGin);
		niflheimPlaces.add(fimbulthul);
		niflheimPlaces.add(riverEliyagar);
		niflheimPlaces.add(hvergelmir);
		niflheimPlaces.add(helheim);

		t.insert(plainsOfGin);
		t.insert(fimbulthul);
		t.insert(riverEliyagar);
		t.insert(hvergelmir);
		t.insert(helheim);

		// plains of ginnungagap connections
		ArrayList<Point> connectPointsGinToRiver = new ArrayList<Point>();
		ArrayList<Point> connectPointsGinToFimbulthul = new ArrayList<Point>();
		ArrayList<Point> connectPointsGinToHvergelmir = new ArrayList<Point>();
		connectPointsGinToRiver.add(plainPoint);
		connectPointsGinToFimbulthul.add(plainPoint);
		connectPointsGinToHvergelmir.add(plainPoint);
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
		connectPointsFimbulthulToRiver.add(fimbulthulPoint);
		connectPointsFimbulthulToGin.add(fimbulthulPoint);
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
		connectPointsRiverToPlains.add(riverEliyagarPoint);
		connectPointsRiverToFimbulthul.add(riverEliyagarPoint);
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
		connectHverToPlains.add(hvergelmirPoint);
		connectHverToHelheim.add(hvergelmirPoint);
		connectHverToHelheim.add(new Point(500, 575));
		connectHverToHelheim.add(new Point(505, 560));
		connectHverToPlains.add(plainPoint);
		connectHverToHelheim.add(helheimPoint);
		hvergelmirConnect.add(new Connection(plainsOfGin, new Route(
				connectHverToPlains), 90));
		hvergelmirConnect.add(new Connection(helheim, new Route(
				connectHverToHelheim), 60));
		hvergelmir.setConnections(hvergelmirConnect);

		// helheim connections
		ArrayList<Point> connectHelheimToHver = new ArrayList<Point>();
		connectHelheimToHver.add(helheimPoint);
		connectHelheimToHver.add(new Point(505, 560));
		connectHelheimToHver.add(new Point(500, 575));
		connectHelheimToHver.add(hvergelmirPoint);
		helheimConnect.add(new Connection(hvergelmir, new Route(
				connectHelheimToHver), 60));
		helheim.setConnections(helheimConnect);

	}

	
	public void createVanaheim() {

		ArrayList<Connection> njordConnect = new ArrayList<Connection>();
		Point njordPoint = new Point(250, 80);

		ArrayList<Connection> donRiverConnect = new ArrayList<Connection>();
		Point donPoint = new Point(140, 80);

		ArrayList<Connection> eigMtnConnect = new ArrayList<Connection>();
		Point eigMtnPoint = new Point(260, 130);

		ArrayList<Connection> pictishConnect = new ArrayList<Connection>();
		Point pictishPoint = new Point(270, 160);

		ArrayList<Connection> forestVanirConnect = new ArrayList<Connection>();
		Point forestPoint = new Point(110, 140);

		Place njord = new Place("The Home Of Njord", njordConnect, njordPoint,
				7, Realm.Vanaheim);

		Place donRiver = new Place("Don River", donRiverConnect, donPoint, 4,
				Realm.Vanaheim);  // this is where the realms connect to Vanaheim

		Place eiglopianMnt = new Place("Eiglopian Mountains", eigMtnConnect,
				eigMtnPoint, 5, Realm.Vanaheim);

		Place pictishWilderness = new Place("The Pictish Wilderness",
				pictishConnect, pictishPoint, 6, Realm.Vanaheim);

		Place forestOfVanir = new Place("The Forests of Vanir",
				forestVanirConnect, forestPoint, 5, Realm.Vanaheim);
		
		Realm.Vanaheim.setGate(donRiver);
		
		vanaheimPlaces.add(njord);
		vanaheimPlaces.add(donRiver);
		vanaheimPlaces.add(eiglopianMnt);
		vanaheimPlaces.add(pictishWilderness);
		vanaheimPlaces.add(forestOfVanir);

		t.insert(njord);
		t.insert(donRiver);
		t.insert(eiglopianMnt);
		t.insert(pictishWilderness);
		t.insert(forestOfVanir);

		// njord connections
		ArrayList<Point> connectNjordToDonRiver = new ArrayList<Point>();
		connectNjordToDonRiver.add(njordPoint);
		connectNjordToDonRiver.add(new Point(200, 90));
		connectNjordToDonRiver.add(donPoint);
		njordConnect.add(new Connection(donRiver, new Route(
				connectNjordToDonRiver), 50));
		njord.setConnections(njordConnect);

		// don River connections
		ArrayList<Point> connectRiverToNjord = new ArrayList<Point>();
		ArrayList<Point> connectRiverToMtn = new ArrayList<Point>();
		ArrayList<Point> connectRiverToForest = new ArrayList<Point>();
		connectRiverToNjord.add(donPoint);
		connectNjordToDonRiver.add(new Point(200, 90));
		connectRiverToMtn.add(donPoint);
		connectRiverToForest.add(donPoint);
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
		connectMtnToRiver.add(eigMtnPoint);
		connectMtnToForest.add(eigMtnPoint);
		connectMtnToPictish.add(eigMtnPoint);
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
		connectWildToForest.add(pictishPoint);
		connectWildToForest.add(new Point(200, 150));
		connectWildToForest.add(new Point(180, 170));
		connectWildToMtn.add(pictishPoint);
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
		connectForestToRiver.add(forestPoint);
		connectForestToMtn.add(forestPoint);
		connectForestToWild.add(forestPoint);
		connectForestToWild.add(new Point(180, 170));
		connectForestToWild.add(new Point(200, 150));
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
		Point freyrPoint = new Point(610, 245);

		ArrayList<Connection> geffenConnect = new ArrayList<Connection>();
		Point geffenPoint = new Point(670, 270);

		ArrayList<Connection> canolbarthConnect = new ArrayList<Connection>();
		Point canolbarthPoint = new Point(550, 230);

		Place freyr = new Place("Freyr's Throne", freyrConnect, freyrPoint, 8,
				Realm.Alfheim);

		Place geffen = new Place("Geffen", geffenConnect, geffenPoint, 6,
				Realm.Alfheim);

		Place canolbarth = new Place("Canolbarth Forest", canolbarthConnect,
				canolbarthPoint, 7, Realm.Alfheim); // this is where the realms connect to Alfheim
		
		Realm.Alfheim.setGate(canolbarth);
		
		alfheimPlaces.add(freyr);
		alfheimPlaces.add(geffen);
		alfheimPlaces.add(canolbarth);

		t.insert(freyr);
		t.insert(geffen);
		t.insert(canolbarth);

		// freyr connections
		ArrayList<Point> connectFreyrToGeffen = new ArrayList<Point>();
		ArrayList<Point> connectFreyrToForest = new ArrayList<Point>();
		connectFreyrToGeffen.add(freyrPoint);
		connectFreyrToGeffen.add(new Point(650, 250));
		connectFreyrToForest.add(freyrPoint);
		connectFreyrToGeffen.add(geffenPoint);
		connectFreyrToForest.add(canolbarthPoint);
		freyrConnect.add(new Connection(geffen,
				new Route(connectFreyrToGeffen), 50));
		freyrConnect.add(new Connection(canolbarth, new Route(
				connectFreyrToForest), 90));
		freyr.setConnections(freyrConnect);

		// geffen connections
		ArrayList<Point> connectGeffenToFreyr = new ArrayList<Point>();
		connectGeffenToFreyr.add(geffenPoint);
		connectGeffenToFreyr.add(new Point(650, 250));
		connectGeffenToFreyr.add(freyrPoint);
		geffenConnect.add(new Connection(freyr,
				new Route(connectGeffenToFreyr), 50));
		geffen.setConnections(geffenConnect);

		// canolbarth connections
		ArrayList<Point> connectForestToFreyr = new ArrayList<Point>();
		connectForestToFreyr.add(canolbarthPoint);
		connectForestToFreyr.add(freyrPoint);
		canolbarthConnect.add(new Connection(freyr, new Route(
				connectForestToFreyr), 90));
		canolbarth.setConnections(canolbarthConnect);

	}

	
	public void createMidgard() {

		ArrayList<Connection> nycConnect = new ArrayList<Connection>();
		Point nycPoint = new Point(240, 300);

		ArrayList<Connection> dcConnect = new ArrayList<Connection>();
		Point dcPoint = new Point(235, 330);

		ArrayList<Connection> wheatonConnect = new ArrayList<Connection>();
		Point wheatonPoint = new Point(215, 280);
		
		ArrayList<Connection> antiguoConnect = new ArrayList<Connection>();
		Point antiguoPoint = new Point(200, 310);

		ArrayList<Connection> londonConnect = new ArrayList<Connection>();
		Point londonPoint = new Point(350, 300);

		Place nyc = new Place("New York, New York", nycConnect, nycPoint, 9,
				Realm.Midgard);

		Place dc = new Place("Washington, D.C.", dcConnect, dcPoint, 9,
				Realm.Midgard);

		Place wheaton = new Place("Wheaton, New Jersey", wheatonConnect,
				wheatonPoint, 6, Realm.Midgard);

		Place antiguo = new Place("Puente Antiguo, New Mexico", antiguoConnect,
				antiguoPoint, 7, Realm.Midgard);

		Place london = new Place("London, England", londonConnect, londonPoint,
				9, Realm.Midgard);  // this is where the realms connect to Midgard

		t.insert(nyc);
		t.insert(dc);
		t.insert(wheaton);
		t.insert(antiguo);
		t.insert(london);
		
		midgardPlaces.add(nyc);
		midgardPlaces.add(dc);
		midgardPlaces.add(wheaton);
		midgardPlaces.add(antiguo);
		midgardPlaces.add(london);
		
		Realm.Midgard.setGate(london);

		// nyc connections
		ArrayList<Point> connectNYCtoLondon = new ArrayList<Point>();
		ArrayList<Point> connectNYCtoNJ = new ArrayList<Point>();
		ArrayList<Point> connectNYCtoDC = new ArrayList<Point>();
		ArrayList<Point> connectNYCtoNM = new ArrayList<Point>();
		connectNYCtoLondon.add(nycPoint);
		connectNYCtoNJ.add(nycPoint);
		connectNYCtoDC.add(nycPoint);
		connectNYCtoNM.add(nycPoint);
		connectNYCtoNM.add(new Point(220, 290));
		connectNYCtoNM.add(new Point(230, 320));
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
		connectNJtoNYC.add(wheatonPoint);
		connectNJtoDC.add(wheatonPoint);
		connectNJtoDC.add(new Point(220, 350));
		connectNJtoDC.add(new Point(200, 320));
		connectNJtoNM.add(wheatonPoint);
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
		connectDCtoNYC.add(dcPoint);
		connectDCtoNJ.add(dcPoint);
		connectDCtoNJ.add(new Point(220, 350));
		connectDCtoNJ.add(new Point(200, 320));
		connectDCtoNM.add(dcPoint);
		connectDCtoLondon.add(dcPoint);
		connectDCtoNYC.add(nycPoint);
		connectDCtoNJ.add(wheatonPoint);
		connectDCtoNM.add(antiguoPoint);
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
		connectNMtoNYC.add(antiguoPoint);
		connectNMtoNYC.add(new Point(220, 290));
		connectNMtoNYC.add(new Point(230, 320));
		connectNMtoNJ.add(antiguoPoint);
		connectNMtoDC.add(antiguoPoint);
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
		connectLondonToNYC.add(londonPoint);
		connectLondonToDC.add(londonPoint);
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
		Point malekithPoint = new Point(140, 460);

		ArrayList<Connection> unseelieConnect = new ArrayList<Connection>();
		Point unseeliePoint = new Point(120, 500);

		ArrayList<Connection> byrgirConnect = new ArrayList<Connection>();
		Point byrgirPoint = new Point(180, 520);

		ArrayList<Connection> blackConnect = new ArrayList<Connection>();
		Point blackPoint = new Point(300, 620);

		ArrayList<Connection> aurvangarConnect = new ArrayList<Connection>();
		Point aurvangarPoint = new Point(140, 570);

		Place malekith = new Place("The Domain of Malekith", malekithConnect,
				malekithPoint, 9, Realm.Svartalfheim);

		Place unseelieCourt = new Place("The Unseelie Court", unseelieConnect,
				unseeliePoint, 4, Realm.Svartalfheim);

		Place byrgir = new Place("Byrgir", byrgirConnect, byrgirPoint, 6,
				Realm.Svartalfheim);

		Place blackForest = new Place("The Black Forest", blackConnect,
				blackPoint, 7, Realm.Svartalfheim);  // this is where the realms connect to Svartalfheim

		Place aurvangar = new Place("Aurvangar", aurvangarConnect,
				aurvangarPoint, 5, Realm.Svartalfheim);
		
		Realm.Svartalfheim.setGate(blackForest);

		t.insert(malekith);
		t.insert(unseelieCourt);
		t.insert(byrgir);
		t.insert(blackForest);
		t.insert(aurvangar);
		
		svartalfheimPlaces.add(malekith);
		svartalfheimPlaces.add(unseelieCourt);
		svartalfheimPlaces.add(blackForest);
		svartalfheimPlaces.add(byrgir);
		svartalfheimPlaces.add(aurvangar);

		// malekith connections
		ArrayList<Point> connectMalekithToUnseelie = new ArrayList<Point>();
		connectMalekithToUnseelie.add(malekithPoint);
		connectMalekithToUnseelie.add(new Point(130, 480));
		connectMalekithToUnseelie.add(unseeliePoint);
		malekithConnect.add(new Connection(unseelieCourt, new Route(
				connectMalekithToUnseelie), 20));
		malekith.setConnections(malekithConnect);

		// unseelie court connections
		ArrayList<Point> connectUnseelieToMalekith = new ArrayList<Point>();
		ArrayList<Point> connectUnseelieToBrygir = new ArrayList<Point>();
		ArrayList<Point> connectUnseelieToAurvangar = new ArrayList<Point>();
		connectUnseelieToMalekith.add(unseeliePoint);
		connectUnseelieToMalekith.add(new Point(130, 480));
		connectUnseelieToBrygir.add(unseeliePoint);
		connectUnseelieToAurvangar.add(unseeliePoint);
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
		connectByrgirToUnseelie.add(byrgirPoint);
		connectByrgirToForest.add(byrgirPoint);
		connectByrgirToForest.add(new Point(250, 580));
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
		connectForestToByrgir.add(blackPoint);
		connectForestToByrgir.add(new Point(250, 580));
		connectForestToAurvangar.add(blackPoint);
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
		connectAurvangarToForest.add(aurvangarPoint);
		connectAurvangarToUnseelie.add(aurvangarPoint);
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
		Point hreidmarPoint = new Point(770, 340);

		ArrayList<Connection> durinConnect = new ArrayList<Connection>();
		Point durinPoint = new Point(880, 360);

		ArrayList<Connection> dvalinConnect = new ArrayList<Connection>();
		Point dvalinPoint = new Point(870, 390);

		ArrayList<Connection> darkFieldConnect = new ArrayList<Connection>();
		Point darkFieldPoint = new Point(750, 330);

		ArrayList<Connection> furnaceConnect = new ArrayList<Connection>();
		Point furnacePoint = new Point(840, 280);

		Place hreidmar = new Place("Hreidmar's Kingdom", hreidmarConnect,
				hreidmarPoint, 9, Realm.Nidavellir); // this is where the realms connect to Nidavellir

		Place durin = new Place("Durin's Hall", durinConnect, durinPoint, 4,
				Realm.Nidavellir);

		Place dvalin = new Place("Dvalin's Hall", dvalinConnect, dvalinPoint,
				4, Realm.Nidavellir);

		Place darkFields = new Place("The Dark Fields", darkFieldConnect,
				darkFieldPoint, 5, Realm.Nidavellir);

		Place furnaces = new Place("The Furnaces of Nidavellir",
				furnaceConnect, furnacePoint, 10, Realm.Nidavellir);
		
		Realm.Nidavellir.setGate(hreidmar);

		t.insert(hreidmar);
		t.insert(durin);
		t.insert(dvalin);
		t.insert(darkFields);
		t.insert(furnaces);
		
		nidavellirPlaces.add(hreidmar);
		nidavellirPlaces.add(durin);
		nidavellirPlaces.add(dvalin);
		nidavellirPlaces.add(darkFields);
		nidavellirPlaces.add(furnaces);

		// hreidmar connections
		ArrayList<Point> connectHreidmarToDurin = new ArrayList<Point>();
		ArrayList<Point> connectHreidmarToFields = new ArrayList<Point>();
		connectHreidmarToDurin.add(hreidmarPoint);
		connectHreidmarToDurin.add(new Point(820, 350));
		connectHreidmarToFields.add(hreidmarPoint);
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
		connectDurinToHreidmar.add(durinPoint);
		connectDurinToHreidmar.add(new Point(820, 350));
		connectDurinToDvalin.add(durinPoint);
		connectDurinToFields.add(durinPoint);
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
		connectDvalinToDurin.add(dvalinPoint);
		connectDvalinToFields.add(dvalinPoint);
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
		connectFieldsToHreidmar.add(darkFieldPoint);
		connectFieldsToDurin.add(darkFieldPoint);
		connectFieldsToDvalin.add(darkFieldPoint);
		connectFieldsToFurnaces.add(darkFieldPoint);
		connectFieldsToFurnaces.add(new Point(820, 320));
		connectFieldsToFurnaces.add(new Point(800, 300));
		connectFieldsToFurnaces.add(new Point(770, 290));
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
		connectFurnacesToFields.add(furnacePoint);
		connectFurnacesToFields.add(new Point(770, 290));
		connectFurnacesToFields.add(new Point(800, 300));
		connectFurnacesToFields.add(new Point(820, 320));
		connectFurnacesToFields.add(darkFieldPoint);
		furnaceConnect.add(new Connection(darkFields, new Route(
				connectFurnacesToFields), 55));
		furnaces.setConnections(furnaceConnect);

	}

	
	public void createMuspelheim() {

		ArrayList<Connection> plainsConnect = new ArrayList<Connection>();
		Point plainsPoint = new Point(680, 600);

		ArrayList<Connection> surturConnect = new ArrayList<Connection>();
		Point surturPoint = new Point(760, 630);

		ArrayList<Connection> sinmoreConnect = new ArrayList<Connection>();
		Point sinmorePoint = new Point(800, 590);

		Place burningPlains = new Place("The Burning Plains of Surt",
				plainsConnect, plainsPoint, 4, Realm.Muspelheim);

		Place surtursKingdom = new Place("Surtur's Kingdom", surturConnect,
				surturPoint, 8, Realm.Muspelheim); // this is where the realms connect to Muspelheim

		Place sinmoreHall = new Place("Sinmore Hall", sinmoreConnect,
				sinmorePoint, 6, Realm.Muspelheim);
		
		Realm.Muspelheim.setGate(surtursKingdom);
		
		muspelheimPlaces.add(burningPlains);
		muspelheimPlaces.add(surtursKingdom);
		muspelheimPlaces.add(sinmoreHall);
		
		t.insert(burningPlains);
		t.insert(surtursKingdom);
		t.insert(sinmoreHall);
		
		//burning plains connections
		ArrayList<Point> connectPlainsToSurtur = new ArrayList<Point>();
		connectPlainsToSurtur.add(plainsPoint);
		connectPlainsToSurtur.add(new Point(710, 615));
		connectPlainsToSurtur.add(new Point(700, 600));
		connectPlainsToSurtur.add(surturPoint);
		plainsConnect.add(new Connection(surtursKingdom, new Route(
				connectPlainsToSurtur), 90));
		burningPlains.setConnections(plainsConnect);
		
		//surturs connections
		ArrayList<Point> connectSurtToPlains = new ArrayList<Point>();
		ArrayList<Point> connectSurtToSinmore = new ArrayList<Point>();
		connectSurtToPlains.add(surturPoint);
		connectPlainsToSurtur.add(new Point(700, 600));
		connectPlainsToSurtur.add(new Point(710, 615));
		connectSurtToSinmore.add(surturPoint);
		connectSurtToPlains.add(plainsPoint);
		connectSurtToSinmore.add(sinmorePoint);
		surturConnect.add(new Connection(burningPlains, new Route(connectSurtToPlains), 90));
		surturConnect.add(new Connection(sinmoreHall, new Route(connectSurtToSinmore), 30));
		surtursKingdom.setConnections(surturConnect);
		
		//sinmores connections
		ArrayList<Point> connectSinmoreToSurt = new ArrayList<Point>();
		connectSinmoreToSurt.add(sinmorePoint);
		connectSinmoreToSurt.add(surturPoint);
		sinmoreConnect.add(new Connection(surtursKingdom, new Route(connectSinmoreToSurt), 30));
		sinmoreHall.setConnections(sinmoreConnect);
	}
	
	public void linkGates() {
		// Vanaheim
		ArrayList<Point> VanaheimToAsgardRoute = new ArrayList<Point>();
		VanaheimToAsgardRoute.add(Realm.Vanaheim.getGate().getPoint());
		VanaheimToAsgardRoute.add(Realm.Asgard.getGate().getPoint());
		Realm.Vanaheim.getGate().addConection(new Connection(Realm.Asgard.getGate(), new Route(VanaheimToAsgardRoute), 200));

		ArrayList<Point> VanaheimToMidgardRoute = new ArrayList<Point>();
		VanaheimToMidgardRoute.add(Realm.Vanaheim.getGate().getPoint());
		VanaheimToMidgardRoute.add(Realm.Midgard.getGate().getPoint());
		Realm.Vanaheim.getGate().addConection(new Connection(Realm.Midgard.getGate(), new Route(VanaheimToMidgardRoute), 200));
		
		// Asgard
		ArrayList<Point> AsgardToVanaheimRoute = new ArrayList<Point>();
		AsgardToVanaheimRoute.add(Realm.Asgard.getGate().getPoint());
		AsgardToVanaheimRoute.add(Realm.Vanaheim.getGate().getPoint());
		Realm.Asgard.getGate().addConection(new Connection(Realm.Vanaheim.getGate(), new Route(AsgardToVanaheimRoute), 200));

		ArrayList<Point> AsgardToAlfheimRoute = new ArrayList<Point>();
		AsgardToAlfheimRoute.add(Realm.Asgard.getGate().getPoint());
		AsgardToAlfheimRoute.add(Realm.Alfheim.getGate().getPoint());
		Realm.Asgard.getGate().addConection(new Connection(Realm.Alfheim.getGate(), new Route(AsgardToAlfheimRoute), 200));

		ArrayList<Point> AsgardToMidgardRoute = new ArrayList<Point>();
		AsgardToMidgardRoute.add(Realm.Asgard.getGate().getPoint());
		AsgardToMidgardRoute.add(Realm.Midgard.getGate().getPoint());
		Realm.Asgard.getGate().addConection(new Connection(Realm.Midgard.getGate(), new Route(AsgardToMidgardRoute), 200));

		ArrayList<Point> AsgardToJotunheimRoute = new ArrayList<Point>();
		AsgardToJotunheimRoute.add(Realm.Asgard.getGate().getPoint());
		AsgardToJotunheimRoute.add(Realm.Jotunheim.getGate().getPoint());
		Realm.Asgard.getGate().addConection(new Connection(Realm.Jotunheim.getGate(), new Route(AsgardToJotunheimRoute), 200));

		ArrayList<Point> AsgardToNidavellirRoute = new ArrayList<Point>();
		AsgardToNidavellirRoute.add(Realm.Asgard.getGate().getPoint());
		AsgardToNidavellirRoute.add(Realm.Nidavellir.getGate().getPoint());
		Realm.Asgard.getGate().addConection(new Connection(Realm.Nidavellir.getGate(), new Route(AsgardToNidavellirRoute), 200));
		
		// Svartalfheim
		ArrayList<Point> SvartalfheimToMidgard = new ArrayList<Point>();
		SvartalfheimToMidgard.add(Realm.Svartalfheim.getGate().getPoint());
		SvartalfheimToMidgard.add(Realm.Midgard.getGate().getPoint());
		Realm.Svartalfheim.getGate().addConection(new Connection(Realm.Midgard.getGate(), new Route(SvartalfheimToMidgard), 200));

		ArrayList<Point> SvartalfheimToNiffleheim = new ArrayList<Point>();
		SvartalfheimToNiffleheim.add(Realm.Svartalfheim.getGate().getPoint());
		SvartalfheimToNiffleheim.add(Realm.Niflheim.getGate().getPoint());
		Realm.Svartalfheim.getGate().addConection(new Connection(Realm.Niflheim.getGate(), new Route(SvartalfheimToNiffleheim), 200));
		
		// Alfheim
		ArrayList<Point> AlfheimToAsgard = new ArrayList<Point>();
		AlfheimToAsgard.add(Realm.Alfheim.getGate().getPoint());
		AlfheimToAsgard.add(Realm.Asgard.getGate().getPoint());
		Realm.Alfheim.getGate().addConection(new Connection(Realm.Asgard.getGate(), new Route(AlfheimToAsgard), 200));

		ArrayList<Point> AlfheimToJotunheim = new ArrayList<Point>();
		AlfheimToJotunheim.add(Realm.Alfheim.getGate().getPoint());
		AlfheimToJotunheim.add(Realm.Jotunheim.getGate().getPoint());
		Realm.Alfheim.getGate().addConection(new Connection(Realm.Jotunheim.getGate(), new Route(AlfheimToJotunheim), 200));
		
		// Midgard
		ArrayList<Point> MidgardToAsgard = new ArrayList<Point>();
		MidgardToAsgard.add(Realm.Midgard.getGate().getPoint());
		MidgardToAsgard.add(Realm.Asgard.getGate().getPoint());
		Realm.Midgard.getGate().addConection(new Connection(Realm.Asgard.getGate(), new Route(MidgardToAsgard), 200));

		ArrayList<Point> MidgardToVanaheim = new ArrayList<Point>();
		MidgardToVanaheim.add(Realm.Midgard.getGate().getPoint());
		MidgardToVanaheim.add(Realm.Vanaheim.getGate().getPoint());
		Realm.Midgard.getGate().addConection(new Connection(Realm.Vanaheim.getGate(), new Route(MidgardToVanaheim), 200));

		ArrayList<Point> MidgardToSvartalfheim = new ArrayList<Point>();
		MidgardToSvartalfheim.add(Realm.Midgard.getGate().getPoint());
		MidgardToSvartalfheim.add(Realm.Svartalfheim.getGate().getPoint());
		Realm.Midgard.getGate().addConection(new Connection(Realm.Svartalfheim.getGate(), new Route(MidgardToSvartalfheim), 200));

		ArrayList<Point> MidgardToNiflheim = new ArrayList<Point>();
		MidgardToNiflheim.add(Realm.Midgard.getGate().getPoint());
		MidgardToNiflheim.add(Realm.Niflheim.getGate().getPoint());
		Realm.Midgard.getGate().addConection(new Connection(Realm.Niflheim.getGate(), new Route(MidgardToNiflheim), 200));
		
		// Jotunheim
		ArrayList<Point> JotunheimToAlfheim = new ArrayList<Point>();
		JotunheimToAlfheim.add(Realm.Jotunheim.getGate().getPoint());
		JotunheimToAlfheim.add(Realm.Alfheim.getGate().getPoint());
		Realm.Jotunheim.getGate().addConection(new Connection(Realm.Alfheim.getGate(), new Route(JotunheimToAlfheim), 200));

		ArrayList<Point> JotunheimToAsgard = new ArrayList<Point>();
		JotunheimToAsgard.add(Realm.Jotunheim.getGate().getPoint());
		JotunheimToAsgard.add(Realm.Asgard.getGate().getPoint());
		Realm.Jotunheim.getGate().addConection(new Connection(Realm.Asgard.getGate(), new Route(JotunheimToAsgard), 200));

		ArrayList<Point> JotunheimToNidavellir = new ArrayList<Point>();
		JotunheimToNidavellir.add(Realm.Jotunheim.getGate().getPoint());
		JotunheimToNidavellir.add(Realm.Nidavellir.getGate().getPoint());
		Realm.Jotunheim.getGate().addConection(new Connection(Realm.Nidavellir.getGate(), new Route(JotunheimToNidavellir), 200));

		ArrayList<Point> JotunheimToMuspelheim = new ArrayList<Point>();
		JotunheimToMuspelheim.add(Realm.Jotunheim.getGate().getPoint());
		JotunheimToMuspelheim.add(Realm.Muspelheim.getGate().getPoint());
		Realm.Jotunheim.getGate().addConection(new Connection(Realm.Muspelheim.getGate(), new Route(JotunheimToMuspelheim), 200));
		
		// Nidavellir
		ArrayList<Point> NidavellirToAsgard = new ArrayList<Point>();
		NidavellirToAsgard.add(Realm.Nidavellir.getGate().getPoint());
		NidavellirToAsgard.add(Realm.Asgard.getGate().getPoint());
		Realm.Nidavellir.getGate().addConection(new Connection(Realm.Asgard.getGate(), new Route(NidavellirToAsgard), 200));

		ArrayList<Point> NidavellirToJotunheim = new ArrayList<Point>();
		NidavellirToJotunheim.add(Realm.Nidavellir.getGate().getPoint());
		NidavellirToJotunheim.add(Realm.Jotunheim.getGate().getPoint());
		Realm.Nidavellir.getGate().addConection(new Connection(Realm.Jotunheim.getGate(), new Route(NidavellirToJotunheim), 200));

		ArrayList<Point> NidavellirToMuspelheim = new ArrayList<Point>();
		NidavellirToMuspelheim.add(Realm.Nidavellir.getGate().getPoint());
		NidavellirToMuspelheim.add(Realm.Muspelheim.getGate().getPoint());
		Realm.Nidavellir.getGate().addConection(new Connection(Realm.Muspelheim.getGate(), new Route(NidavellirToMuspelheim), 200));
		
		// Niflheim
		ArrayList<Point> NiflheimToSvartalfheim = new ArrayList<Point>();
		NiflheimToSvartalfheim.add(Realm.Niflheim.getGate().getPoint());
		NiflheimToSvartalfheim.add(Realm.Svartalfheim.getGate().getPoint());
		Realm.Niflheim.getGate().addConection(new Connection(Realm.Svartalfheim.getGate(), new Route(NiflheimToSvartalfheim), 200));

		ArrayList<Point> NiflheimToMidgard = new ArrayList<Point>();
		NiflheimToMidgard.add(Realm.Niflheim.getGate().getPoint());
		NiflheimToMidgard.add(Realm.Midgard.getGate().getPoint());
		Realm.Niflheim.getGate().addConection(new Connection(Realm.Midgard.getGate(), new Route(NiflheimToMidgard), 200));
		
		// Muspelheim
		ArrayList<Point> MuspelheimToNiflheim = new ArrayList<Point>();
		MuspelheimToNiflheim.add(Realm.Muspelheim.getGate().getPoint());
		MuspelheimToNiflheim.add(Realm.Niflheim.getGate().getPoint());
		Realm.Muspelheim.getGate().addConection(new Connection(Realm.Niflheim.getGate(), new Route(MuspelheimToNiflheim), 200));

		ArrayList<Point> MuspelheimToJotunheim = new ArrayList<Point>();
		MuspelheimToJotunheim.add(Realm.Muspelheim.getGate().getPoint());
		MuspelheimToJotunheim.add(Realm.Jotunheim.getGate().getPoint());
		Realm.Muspelheim.getGate().addConection(new Connection(Realm.Jotunheim.getGate(), new Route(MuspelheimToJotunheim), 200));

		ArrayList<Point> MuspelheimToNidavellir = new ArrayList<Point>();
		MuspelheimToNidavellir.add(Realm.Muspelheim.getGate().getPoint());
		MuspelheimToNidavellir.add(Realm.Nidavellir.getGate().getPoint());
		Realm.Muspelheim.getGate().addConection(new Connection(Realm.Nidavellir.getGate(), new Route(MuspelheimToNidavellir), 200));
	}
}
