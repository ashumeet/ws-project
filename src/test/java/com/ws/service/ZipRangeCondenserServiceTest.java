package com.ws.service;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ZipRangeCondenserServiceTest {

    private ZipRangeCondenserService service;

    @Before
    public void init() {
        service = new ZipRangeCondenserService();
    }

    @Test
    public void test1Success() throws Exception {
        String output = service.condenseRange("[94133,94133] [94200,94299] [94600,94699]");
        assertEquals("[94133,94133] [94200,94299] [94600,94699]", output);
    }

    @Test
    public void test2Success() throws Exception {
        String output = service.condenseRange("[94133,94133] [94200,94299] [94226,94399]");
        assertEquals("[94133,94133] [94200,94399]", output);
    }

    @Test
    public void test3Success() throws Exception {
        String output = service.condenseRange("[10,40] [50,60] [35,55] [90,100]");
        assertEquals("[10,60] [90,100]", output);
    }

    @Test(expected = Exception.class)
    public void test4Failure() throws Exception  {
        service.condenseRange("{123} {234,234}");
    }
}
