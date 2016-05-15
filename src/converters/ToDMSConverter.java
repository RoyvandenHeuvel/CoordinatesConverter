package converters;

import static converters.ToDecimalConverter.RijksdriehoekToDecimal;
import java.util.ArrayList;
import java.util.List;

public class ToDMSConverter {
// Input a double latitude or longitude in the decimal format
// e.g. -79.982195

    public static String[] decimalToDMS(double coord) {
        String output[], degrees, minutes, seconds;

        // gets the modulus the coordinate divided by one (MOD1).
        // in other words gets all the numbers after the decimal point.
        // e.g. mod := -79.982195 % 1 == 0.982195 
        //
        // next get the integer part of the coord. On other words the whole number part.
        // e.g. intPart := -79
        double mod = coord % 1;
        int intPart = (int) coord;

        //set degrees to the value of intPart
        //e.g. degrees := "-79"
        degrees = String.valueOf(intPart);

        // next times the MOD1 of degrees by 60 so we can find the integer part for minutes.
        // get the MOD1 of the new coord to find the numbers after the decimal point.
        // e.g. coord :=  0.982195 * 60 == 58.9317
        //	mod   := 58.9317 % 1    == 0.9317
        //
        // next get the value of the integer part of the coord.
        // e.g. intPart := 58
        coord = mod * 60;
        mod = coord % 1;
        intPart = (int) coord;
        if (intPart < 0) {
            // Convert number to positive if it's negative.
            intPart *= -1;
        }

        // set minutes to the value of intPart.
        // e.g. minutes = "58"
        minutes = String.valueOf(intPart);

        //do the same again for minutes
        //e.g. coord := 0.9317 * 60 == 55.902
        //e.g. intPart := 55
        coord = mod * 60;
        intPart = (int) coord;
        if (intPart < 0) {
            // Convert number to positive if it's negative.
            intPart *= -1;
        }

        // set seconds to the value of intPart.
        // e.g. seconds = "55"
        seconds = String.valueOf(intPart);

        
        output = new String[3];
        output[0] = degrees;
        output[1] = minutes;
        output[2] = seconds;

        
        return output;
    }
    
    public static ArrayList RijksdriehoekToDMS(double[] inputRdxRdy){
              
        double[] decimalXY = RijksdriehoekToDecimal(inputRdxRdy[0], inputRdxRdy[1]);
        
        String[] DMSX = decimalToDMS(decimalXY[0]);
        String[] DMSY = decimalToDMS(decimalXY[1]);
        
        ArrayList output = new ArrayList();
        
        output.add(DMSX);
        output.add(DMSY);
        
        return output;
    }
    
}
