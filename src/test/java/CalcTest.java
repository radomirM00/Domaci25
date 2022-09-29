import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalcTest {
    private CalcPage calcPage;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().window().maximize();
        calcPage = new CalcPage(driver);
    }
    @AfterClass
    public void quit(){
        calcPage.getDriver().quit();
    }
    @AfterMethod
    public void sleep() throws InterruptedException {
        calcPage.clearInput();
        Thread.sleep(700);

    }

    @BeforeMethod
    public void clear(){
        calcPage.clearResult();
    }

    @Test
    public void addDifferentSignEquivalentValue(){
        calcPage.calcAdd(1,-1);
        String expectedResult = "0";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void addZero(){
        calcPage.calcAdd(0,1);
        String expectedResult = "1";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void addHigherMinus(){
        calcPage.calcAdd(1,-5);
        String expectedResult = "-4";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void addLowerMinus(){
        calcPage.calcAdd(5,-1);
        String expectedResult = "4";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void substractMinus(){
        calcPage.calcSubstract(2,-2);
        String expectedResult = "4";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void substractPlus(){
        calcPage.calcSubstract(-2,2);
        String expectedResult = "-4";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void substractSame(){
        calcPage.calcSubstract(1,1);
        String expectedResult = "0";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void substracZero(){
        calcPage.calcSubstract(1,0);
        String expectedResult = "1";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void substractFromZero(){
        calcPage.calcSubstract(0,1);
        String expectedResult = "-1";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void multiplyZero(){
        calcPage.calcMultiply(0,1);
        String expectedResult = "0";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void multiplyWithOneMinus(){
        calcPage.calcMultiply(5,-1);
        String expectedResult = "-5";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void multiplyWithBothMinuses(){
        calcPage.calcMultiply(-5,-1);
        String expectedResult = "5";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void multiplyZeroWithMinus(){
        calcPage.calcMultiply(0,-1);
        String expectedResult = "0";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void dividedWithZero(){
        calcPage.calcDivide(0,5);
        String expectedResult = "0";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void plusDividedByZero(){
        calcPage.calcDivide(5,0);
        String expectedResult = "";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void minusDividedByZero(){
        calcPage.calcDivide(-5,0);
        String expectedResult = "";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void plusDividedByMinus(){
        calcPage.calcDivide(10,-5);
        String expectedResult = "-2";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void minusDividedByMinus(){
        calcPage.calcDivide(-5,-5);
        String expectedResult = "1";
        String actualResult = calcPage.getAnswer().getAttribute("value");
        Assert.assertEquals(actualResult,expectedResult);
    }


}
