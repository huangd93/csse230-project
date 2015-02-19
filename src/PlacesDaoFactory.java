
/**
 * A Singleton factory pattern to make sure all access is to the same DAO
 * @author huangd
 *
 */
public class PlacesDaoFactory {
	
	private static PlacesDao placesDaoSingleton;
	
	/**
	 * Made to prevent initialization
	 */
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
