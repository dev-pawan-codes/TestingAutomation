
package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTestNG {

    @Test
    public void testAddition() {
        App app = new App();
        Assert.assertEquals(app.add(4, 6), 10);
    }
}
