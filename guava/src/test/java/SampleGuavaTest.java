package com.ray.demo.guava;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Ray on 16/2/29.
 */
public class SampleGuavaTest {

    @Test
    public void testAdd() throws Exception {
        assertEquals(3, SampleGuava.add(1, 2));
    }
}