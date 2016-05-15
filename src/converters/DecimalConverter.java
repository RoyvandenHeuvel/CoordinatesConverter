package converters;


public class DecimalConverter {
    /*
	* Conversion DMS to decimal 
	*
	* Input: latitude or longitude in the DMS format ( example: W 79° 58' 55.903")
	* Return: latitude or longitude in decimal format   
	* hemisphereOUmeridien => {W,E,S,N}
	*
     */
    public static double DMSToDecimal(String hemisphereOUmeridien, double degres, double minutes, double secondes) {
        double LatOrLon = 0;
        double signe = 1.0;

        if ((hemisphereOUmeridien.equals("W")) || (hemisphereOUmeridien.equals("S"))) {
            signe = -1.0;
        }
        LatOrLon = signe * (Math.floor(degres) + Math.floor(minutes) / 60.0 + secondes / 3600.0);

        return (LatOrLon);
    }
}
