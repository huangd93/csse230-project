
public class PlacesDaoFactory {
	
	private static PlacesDao placesDaoSingleton;
	
	private PlacesDaoFactory() {}
	
	/**
	 * A singleton factory pattern for PlacesDao.
	 * Use like:
	 * PlacesDaoInterface o = PlacesDaoFactory.getPlacesDaoSingleton();
	 * @return
	 */
	public static PlacesDao getPlacesDaoSingleton(){
		if(placesDaoSingleton == null) {
			placesDaoSingleton = new PlacesDao();
		}
		return PlacesDaoFactory.placesDaoSingleton;
	}
}
