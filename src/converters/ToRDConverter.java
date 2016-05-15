package converters;

import static converters.ToDMSConverter.decimalToDMS;
import static converters.ToDecimalConverter.DMSToDecimal;

public class ToRDConverter {

    public static double[] DMSToRijksdriehoek(double[] inputXY){
        
        String[] xCoord = decimalToDMS(inputXY[0]);
        String[] yCoord = decimalToDMS(inputXY[1]);
        
        double doubleXCoord = DMSToDecimal("N", Double.parseDouble(xCoord[0]), Double.parseDouble(xCoord[1]), Double.parseDouble(xCoord[2]));
        double doubleYCoord = DMSToDecimal("N", Double.parseDouble(yCoord[0]), Double.parseDouble(yCoord[1]), Double.parseDouble(yCoord[2]));
        
        double[] rdxrdy = DecimalToRijksdriehoek(doubleXCoord, doubleYCoord);
        
        return rdxrdy;
    }
    
    

    public static double[] DecimalToRijksdriehoek(double wgs84_lattitude, double wgs84_longitude) {

        int referenceRdX = 155000;
        int referenceRdY = 463000;


        double referenceWgs84X = 52.15517;
        double referenceWgs84Y = 5.387206;

        double[][] Rpq = new double[4][5];

        Rpq[0][1] = 190094.945;
        Rpq[1][1] = -11832.228;
        Rpq[2][1] = -114.221;
        Rpq[0][3] = -32.391;
        Rpq[1][0] = -0.705;
        Rpq[3][1] = -2.340;
        Rpq[0][2] = -0.008;
        Rpq[1][3] = -0.608;
        Rpq[2][3] = 0.148;

        double[][] Spq = new double[4][5];
        Spq[0][1] = 0.433;
        Spq[0][2] = 3638.893;
        Spq[0][4] = 0.092;
        Spq[1][0] = 309056.544;
        Spq[2][0] = 73.077;
        Spq[1][2] = -157.984;
        Spq[3][0] = 59.788;
        Spq[2][2] = -6.439;
        Spq[1][1] = -0.032;
        Spq[1][4] = -0.054;

        double d_lattitude = (0.36 * (wgs84_lattitude - referenceWgs84X));
        double d_longitude = (0.36 * (wgs84_longitude - referenceWgs84Y));


        double calc_latt = 0;
        double calc_long = 0;

        for (int p = 0; p < 4; p++) {
            for (int q = 0; q < 5; q++) {
                calc_latt += Rpq[p] [q] * Math.pow(d_lattitude, p) * Math.pow(d_longitude, q);
                calc_long += Spq[p] [q] * Math.pow(d_lattitude, p) * Math.pow(d_longitude, q);
            }
        }

        double rd_x_coordinate = (referenceRdX + calc_latt);
        double rd_y_coordinate = (referenceRdY + calc_long);
        
        double[] output = new double[2];
        output[0] = rd_x_coordinate;
        output[1] = rd_y_coordinate;

        return output;
    }
}
