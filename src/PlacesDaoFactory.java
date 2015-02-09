
public class PlacesDaoFactory {
	
	private static PlacesDao placesDaoSingleton;
	
	public PlacesDao getPlacesDaoSingleton(){
		if(placesDaoSingleton == null) {
			placesDaoSingleton = new PlacesDao();
		}
		return PlacesDaoFactory.placesDaoSingleton;
	}
}
