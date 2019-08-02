package com.ws.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Data structure for list of Range
 */
public class CondensedRangeList {

    /**
     * Instance to save list of Range internally
     */
    private List<com.ws.model.Range> ranges;

    /**
     * Constructor for FinalRangeList
     */
    public CondensedRangeList(){
        ranges = new LinkedList<Range>();
    }

    /**
     * Method to add Range to the internal list
     * @param range
     */
    public void add(Range range){
        if(isNotValid(range)) return;
        if(ranges.size() == 0) {
            ranges.add(range);
            return;
        }
        for(int n = 0; n < ranges.size(); n++) {
            Range c = ranges.get(n);
            if(range.getEnd()+1 < c.getStart()) {
                ranges.add(n, range);
                return;
            } else if (range.getStart()+1 > c.getEnd()) {
                continue;
            }
            ranges.set(n, new Range(Integer.min(range.getStart(), c.getStart()), Integer.max(range.getEnd(), c.getEnd())));
            return;
        }
        ranges.add(range);
    }

    /**
     * Method to validate the range passed to be added
     * @param range
     * @return Boolean
     */
    private Boolean isNotValid(Range range){
        if(range == null) return true;
        if(range.getStart()> range.getEnd()) return true;
        return false;
    }

    /**
     * To string method for FinalRangeList
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ranges.forEach(r -> sb.append("[").append(r.getStart()).append(",").append(r.getEnd()).append("] "));
        return sb.toString();
    }
}
