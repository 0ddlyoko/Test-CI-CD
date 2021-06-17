package me.oddlyoko.testcicd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMyClass {

    @Test
    @DisplayName("Test getA()")
    void testGetA() {
        MyClass myClass = new MyClass();
        assertEquals(42, myClass.getA());
    }
}
