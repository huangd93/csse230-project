
public class PlacesDaoFactory {
	
	private static PlacesDao placesDaoSingleton;
	
	private PlacesDaoFactory() {}
	
	public static PlacesDao getPlacesDaoSingleton(){
		if(placesDaoSingleton == null) {
			placesDaoSingleton = new PlacesDao();
		}
		return PlacesDaoFactory.placesDaoSingleton;
	}
}
