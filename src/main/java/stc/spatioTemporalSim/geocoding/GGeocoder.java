package stc.spatioTemporalSim.geocoding;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.Bounds;
import com.google.maps.model.GeocodingResult;

import stc.spatioTemporalSim.geometry.Bbox;

public class GGeocoder {
	private final static String api_key = "AIzaSyC6aL3RLqWncHnnMUexRZozP6aHNtQzzrc";
	private static GeoApiContext context = 
			new GeoApiContext().setApiKey(api_key);
	
	public Bbox getBbox(String placeName) throws Exception
	{
		GeocodingResult[] results =  GeocodingApi.geocode(context, placeName).await();
		Bounds bounds = results[0].geometry.viewport;
		double top = bounds.northeast.lat;
		double bottom = bounds.southwest.lat;
		double right = bounds.northeast.lng;
		double left = bounds.southwest.lng;
		return new Bbox(top, bottom, right, left);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GeocodingResult[] results =  GeocodingApi.geocode(context, "atlantic ocean").await();
		System.out.println(results[0].formattedAddress);
	}

}
