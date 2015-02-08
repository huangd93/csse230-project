
public class PlacesDaoFactory {
	
	public PlacesDao placesDaoSingleton;
	
	public PlacesDao getPlacesDaoSingleton(){
		return this.placesDaoSingleton;
	}
	
	public void setPlacesDaoSingleton(PlacesDao newSingleton){
		this.placesDaoSingleton = newSingleton;
	}

}
