package chapter8;

public class PlaceInformation {
	
	private String name;
	private String address;
	private String tag;
	private double latitude;
	private double longitude;
	public PlaceInformation(String name, String address, String tag, double latitude, double longitude){
		this.name = name;
		this.address = address;
		this.tag = tag;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getTag() {
		return tag;
	}
	@Override
	public String toString() {
		return "PlaceInformation [name=" + name + ", address=" + address
				+ ", tag=" + tag + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	public double distanceFrom(GeoLocation spot){
		GeoLocation s1 = new GeoLocation(this.latitude, this.longitude);
		return s1.distanceFrom(spot);
	}
	
}
