package com.epam.geometry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

    private ConeDataValidator coneDataValidator;

    @Before
    public void setUp() {
        coneDataValidator = new ConeDataValidator();
    }

    @Test
    public void testValidateWhenTrue() {
        //given
        String testLine = "1.0 2.0 3.0 12.0 5.5";
        //when
        boolean actualResult = coneDataValidator.validate(testLine);
        //then
        Assert.assertTrue(actualResult);

    }

    @Test
    public void testValidateWhenFalse_invalidValues() {
        //given
        String testLine = "1.0 2.0f 3.0 12.0 5.5";
        //when
        boolean actualResult = coneDataValidator.validate(testLine);
        //then
        Assert.assertFalse(actualResult);
    }

    @Test
    public void testValidateWhenFalse_notEnoughInfo() {
        //given
        String testLine = "1.0 2.0 3.0 5.0";
        //when
        boolean actualResult = coneDataValidator.validate(testLine);
        //then
        Assert.assertFalse(actualResult);
    }

    @Test
    public void testValidateWhenFalse_whenNull() {
        //when
        boolean actualResult = coneDataValidator.validate(null);
        //then
        Assert.assertFalse(actualResult);
    }
}
