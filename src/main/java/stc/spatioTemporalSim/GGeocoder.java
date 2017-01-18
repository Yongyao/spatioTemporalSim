package stc.spatioTemporalSim;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class GGeocoder {
	private final static String api_key = "AIzaSyC6aL3RLqWncHnnMUexRZozP6aHNtQzzrc";
	private static GeoApiContext context = 
			new GeoApiContext().setApiKey(api_key);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GeocodingResult[] results =  GeocodingApi.geocode(context, "atlantic ocean").await();
		System.out.println(results[0].geometry.bounds);

	}

}
