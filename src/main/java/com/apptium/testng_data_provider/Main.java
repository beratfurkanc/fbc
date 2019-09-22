package com.apptium.testng_data_provider;


import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Main {

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { TestNG_DataProvider.class });
        testng.addListener(tla);
        testng.run();
    }
}
