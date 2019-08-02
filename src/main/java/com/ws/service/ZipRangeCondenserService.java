package com.ws.service;

import com.ws.model.CondensedRangeList;


public class ZipRangeCondenserService {

    public String condenseRange(String input) throws Exception {
        if(!ZipRangeCondenserHelper.validInput(input)) {
            throw new Exception("Not a Valid Input");
        }
        String[] args = input.split(" ");
        CondensedRangeList frl = new CondensedRangeList();
        for(int i=0; i< args.length; i++){
            frl.add(ZipRangeCondenserHelper.getRangeFromString(args[i]));
        }
        return frl.toString();
    }
}
