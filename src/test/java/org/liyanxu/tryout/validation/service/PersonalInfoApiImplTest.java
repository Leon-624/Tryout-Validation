package org.liyanxu.tryout.validation.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.liyanxu.tryout.validation.api.PersonalInfoApi;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class PersonalInfoApiImplTest {

    private static Validator validator;

    private PersonalInfoApi api;

    @BeforeClass
    public static void setupClass() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void setup() {
        api = new PersonalInfoApiImpl(validator);
    }

    @Test
    public void testValid() {
        api.setPerson(TestData.getValidPerson());
    }

    @Test
    public void testNullArg1() {
        api.setPerson(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArg2() {
        api.setPersonNotNull(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPerson() {
        api.setPerson(TestData.getInvalidPersonWithValidCar());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidPersonWithInvalidCar() {
        api.setPerson(TestData.getValidPersonWithInvalidCar());
    }

}
