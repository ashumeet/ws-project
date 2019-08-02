package com.ws.model;

/**
 * Data structure for single range
 */
public class Range {

    /**
     * Start of the range
     */
    private final Integer start;

    /**
     * End of the range
     */
    private final Integer end;

    /**
     * Constructor for Range
     * @param start
     * @param end
     */
    public Range(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Getter for start
     * @return Integer
     */
    public Integer getStart() {
        return start;
    }

    /**
     * Getter for end
     * @return Integer
     */
    public Integer getEnd() {
        return end;
    }
}
