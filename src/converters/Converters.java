package converters;

import static converters.ToDMSConverter.decimalToDMS;
import static converters.ToDecimalConverter.DMSToDecimal;
import static converters.ToDecimalConverter.RijksdriehoekToDecimal;
import static converters.ToRDConverter.DecimalToRijksdriehoek;


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
        
        double[] latlon = RijksdriehoekToDecimal(rdx, rdy);
        double[] rdxrdy = DecimalToRijksdriehoek(latlon[0], latlon[1]);
        
        System.out.println("Latitudes:" + latitude + "\n DMS Latitude:"+ " D" + DMSLatitude[0] + " M " + DMSLatitude[1]+ " S " + DMSLatitude[2] + "\n Decimal Latitude:" + decimalLat);
        System.out.println("Longitudes: " + longitude + "\n DMS Longitude:"+ " D" + DMSLongitude[0]+ " M " + DMSLongitude[1]+ " S " + DMSLongitude[2] + "\n Decimal Longitude:" + decimalLong);
        System.out.println("Latitude from RD: " + latlon[0]);
        System.out.println("Longitude from RD: " + latlon[1]);
        System.out.println("RD from latitude: " + rdxrdy[0]);
        System.out.println("RD from longitude: " + rdxrdy[1]);
        
    }
    
}
