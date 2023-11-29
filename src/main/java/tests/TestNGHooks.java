package tests;

import org.testng.annotations.*;

public class TestNGHooks {
    /**
     * BeforeSuite
     * BeforeTest
     * BeforeMethod
     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite!");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("\tBefore test!");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\tBefore class!");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\tBefore medthod!");
    }

    @Test
    public void test1(){
        System.out.println("\t\t\t\tTest Method1");
    }

    @Test
    public void test2(){
        System.out.println("\t\t\t\tTest Method2");
    }


}
