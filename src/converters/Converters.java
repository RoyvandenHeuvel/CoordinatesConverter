package converters;

import static converters.DMSConverter.decimalToDMS;
import static converters.DecimalConverter.DMSToDecimal;
import static converters.RDConverter.ConvertToLatLong;


public class Converters {

    public static void main(String[] args) {
        double latitude = 64.606;
        double longitude = -20.596;
        
        double rdx = 103161;
        double rdy = 487740;
        
        String[] DMSLatitude = decimalToDMS(latitude);
        String[] DMSLongitude = decimalToDMS(longitude);
        
        double decimalLat = DMSToDecimal("N", Double.parseDouble(DMSLatitude[0]), Double.parseDouble(DMSLatitude[1]), Double.parseDouble(DMSLatitude[2]));
        double decimalLong = DMSToDecimal("N", Double.parseDouble(DMSLongitude[0]), Double.parseDouble(DMSLongitude[1]), Double.parseDouble(DMSLongitude[2]));
        
        double[] latlon = ConvertToLatLong(rdx, rdy);
        
        System.out.println("Latitudes:" + latitude + " DMSLatitude:"+ " D" + DMSLatitude[0] + " M " + DMSLatitude[1]+ " S " + DMSLatitude[2] + " Decimal Latitude:" + decimalLat);
        System.out.println("Longitudes: " + longitude + " DMSLongitude:"+ " D" + DMSLongitude[0]+ " M " + DMSLongitude[1]+ " S " + DMSLongitude[2] + " Decimal Longitude:" + decimalLong);
        System.out.println("Latitude from RD: " + latlon[0]);
        System.out.println("Longitude from RD: " + latlon[1]);
    }
    
}
