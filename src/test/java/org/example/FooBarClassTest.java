package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FooBarClassTest {

    @Test
    public void testUniqueIntegerInput() {
        FooBarClass fooBar = new FooBarClass();
        String actual = fooBar.FooBar("1,2,3,4,5");
        assertEquals("1,2,foo,4,bar", actual);
    }

    @Test
    public void testNullInput() {
        FooBarClass fooBar = new FooBarClass();
        assertThrows(IllegalArgumentException.class, () -> fooBar.FooBar(null));
    }


    @Test
    public void testEmptyInput() {
        FooBarClass fooBar = new FooBarClass();
        assertThrows(IllegalArgumentException.class, () -> fooBar.FooBar(""));
    }


    @Test
    public void testNonIntegerInput() {
        FooBarClass fooBar = new FooBarClass();
        String actual = fooBar.FooBar("abc");
        assertEquals("\n This input value is not an expected integer: abc \n", actual);
    }


    @Test
    public void testDuplicateIntegerValues() {
        FooBarClass fooBar = new FooBarClass();
        String actual = fooBar.FooBar("1,2,3,12,3,5,5,45,60");
        assertEquals("1,2,foo,foo,foo-copy,bar,bar-copy,foobar,foobar", actual);
    }


    @Test
    public void testNegativeNumbers() {
        FooBarClass fooBar = new FooBarClass();
        String actual = fooBar.FooBar("-3,5,-15");
        assertEquals("foo,bar,foobar", actual);
    }


    @Test
    public void testDuplicateNegativeNumbers() {
        FooBarClass fooBar = new FooBarClass();
        String actual = fooBar.FooBar("-3,5,-15,-3,5,-15,1,-1,-1");
        assertEquals("foo,bar,foobar,foo-copy,bar-copy,foobar-copy,1,-1,-1-copy", actual);
    }


}