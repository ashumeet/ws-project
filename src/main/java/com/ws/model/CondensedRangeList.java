package com.ws.model;

import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 * Data structure for list of Range
 */
public class CondensedRangeList {

    /**
     * Instance to save list of Range internally
     */
    private LinkedList<Range> ranges;

    /**
     * Constructor for CondensedRangeList
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
            Range current = ranges.get(n);
            if(range.getEnd()+1 < current.getStart()) {
                ranges.add(n, range);
                normalizeRangeList();
                return;
            } else if (range.getStart()+1 > current.getEnd()) {
                continue;
            }
            ranges.set(n, new Range(Integer.min(range.getStart(), current.getStart()), Integer.max(range.getEnd(), current.getEnd())));
            normalizeRangeList();
            return;
        }
        ranges.add(range);
        normalizeRangeList();
    }

    /**
     * Code to normalized list after ever new addition
     */
    private void normalizeRangeList() {
        Stack<Integer> delete = new Stack<>();
        AtomicReference<Boolean> didNormalized = new AtomicReference<>(false);
        IntStream.range(1, ranges.size()).forEach(n -> {
            if(ranges.get(n-1).getEnd() >= ranges.get(n).getStart()) {
                delete.push(n-1);
                ranges.set(n, new Range(ranges.get(n-1).getStart(), ranges.get(n).getEnd()));
                didNormalized.set(true);
            }
        });
        while (!delete.empty()) ranges.remove((int) delete.pop());
        if (didNormalized.get()) normalizeRangeList();
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
     * To string method for CondensedRangeList
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ranges.forEach(r -> sb.append("[").append(r.getStart()).append(",").append(r.getEnd()).append("] "));
        return sb.toString().trim();
    }
}
