package chapter8;

public class GeoLocationClient {
	public static final double STASH_LAT = 34.988889;
	public static final double STASH_LONG = -106.614444;
	public static final double ABQ_LAT = 34.989978;
	public static final double ABQ_LONG = -106.614357;
	public static final double FBI_LAT = 35.131281;
	public static final double FBI_LONG = -106.61263;
	public static void main(String[] main){
		GeoLocation stash = new GeoLocation(STASH_LAT,STASH_LONG);
		GeoLocation abq = new GeoLocation(ABQ_LAT,ABQ_LONG);
		GeoLocation fbi = new GeoLocation(FBI_LAT,FBI_LONG);
		System.out.println("Distance in miles between:");
		System.out.println("stash/studio = " + abq.distanceFrom(stash));
		System.out.println("stash/fbi = " + fbi.distanceFrom(stash));
	}
}
