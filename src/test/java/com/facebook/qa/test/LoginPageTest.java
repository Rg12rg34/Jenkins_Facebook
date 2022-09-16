package com.facebook.qa.test;
import com.facebook.qa.util.testutil;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;


import java.io.FileNotFoundException;



public class LoginPageTest extends TestBase{
    testutil testUtil;
    String sheetName = "Sheet1";
    Logger log = Logger.getLogger(LoginPageTest.class);
    LoginPage loginpage;
    HomePage homepage;

    // call super class constuctor means TestBase constructor
    public LoginPageTest() throws FileNotFoundException {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        loginpage = new LoginPage();
        homepage=new HomePage();
    }

//    @Test(priority = 1)
//    public void LoginPageTitleTest()
//    {
//        String title = loginpage.ValidateLoginPageTittle();
//        Assert.assertEquals(title,"Facebook – log in or sign up");
//    }
////    @DataProvider
//    public Object[][] getLoginTestData() {
//        Object data[][] = testutil.getTestData(sheetName);
//        return data;
//    }
//
//    @Test(dataProvider = "getLoginTestData")
//    public void multipleLoginTest(String userName, String password) throws InterruptedException {
//        homepage = loginpage.loginMultipleAccounts(userName, password);
//        Thread.sleep(3000);
//        log.info("login successful with username: " + userName);
//    }
    @Test(priority = 1)
    public void FB_logoTest()
    {
        boolean flag = loginpage.ValidateFB_Image();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void loginTest()
    {
        homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}