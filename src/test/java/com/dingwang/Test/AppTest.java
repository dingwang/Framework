package com.dingwang.Test;

import java.lang.reflect.Field;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import sun.misc.Unsafe;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private static final int    _1MB               = 1024 * 1024;

    private static final String productArrayString = "10016,10017,10026,10065,10069,10071,10072,";

    /**
     * Create the test case
     * 
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     * 
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public void testApp() throws IllegalArgumentException, IllegalAccessException {
        assertTrue(true);
        String str = "10072";
        System.out.println(productArrayString.indexOf("10"));
    }

    public void TestChar() throws IllegalArgumentException, IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
