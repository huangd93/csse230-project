
public class PlacesDaoFactory {
	
	public static PlacesDao placesDaoSingleton;
	
	public PlacesDao getPlacesDaoSingleton(){
		if(placesDaoSingleton == null) {
			placesDaoSingleton = new PlacesDao();
		}
		return PlacesDaoFactory.placesDaoSingleton;
	}
}
