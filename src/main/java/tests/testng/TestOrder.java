package tests.testng;

import org.testng.annotations.Test;

public class TestOrder {

    @Test (priority = 1)
    public void test1(){
        System.out.println("Test A");
    }

    @Test(dependsOnMethods = "test1" )
    public void test2(){
        System.out.println("Test B");
    }
}
