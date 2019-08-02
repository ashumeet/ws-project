package com.ws.service;

import com.ws.model.Range;

/**
 * Class to include static code
 */
public class ZipRangeCondenserHelper {

    /**
     * Method to validate the input
     * @param input
     * @return Boolean
     */
    public static Boolean validInput(String input){
        if(input == null) return false;
        String[] args = input.split(" ");
        for(int i=0; i< args.length; i++){
            if(!args[i].matches("\\[[\\d]+,[\\d]+\\]")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to get Range bean from string
     * @param range
     * @return Range
     */
    public static Range getRangeFromString(String range){
        String[] ran = range.split(",");
        return new Range(Integer.parseInt(ran[0].substring(1)), Integer.parseInt(ran[1].substring(0, ran[1].length()-1)));
    }
}
