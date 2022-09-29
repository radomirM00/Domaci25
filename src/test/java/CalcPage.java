import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CalcPage extends BasePage{
    private WebElement input1 = getDriver().findElement(By.id("number1Field"));
    private WebElement input2 = getDriver().findElement(By.id("number2Field"));
    private WebElement calcBtn = getDriver().findElement(By.id("calculateButton"));
    private WebElement clearBtn = getDriver().findElement(By.id("clearButton"));

    private WebElement answer = getDriver().findElement(By.id("numberAnswerField"));


    public WebElement getAnswer() {
        return answer;
    }

    public CalcPage(WebDriver driver){
        super(driver);
    }

    public WebElement getInput1() {
        return input1;
    }

    public void setInput1(WebElement input1) {
        this.input1 = input1;
    }

    public WebElement getInput2() {
        return input2;
    }

    public void setInput2(WebElement input2) {
        this.input2 = input2;
    }

    public WebElement getCalcBtn() {
        return calcBtn;
    }

    public void setCalcBtn(WebElement calcBtn) {
        this.calcBtn = calcBtn;
    }

    public WebElement getClearBtn() {
        return clearBtn;
    }

    public void setClearBtn(WebElement clearBtn) {
        this.clearBtn = clearBtn;
    }

    public void calcAdd(int num1, int num2){
        scrollDown();
        input1.sendKeys(num1+"");
        input2.sendKeys(num2+"");
        calcBtn.click();
    }

    public void calcSubstract(int num1, int num2){
        scrollDown();
        Select operation = new Select(getDriver().findElement(By.id("selectOperationDropdown")));
        operation.selectByValue("1");
        input1.sendKeys(num1+"");
        input2.sendKeys(num2+"");
        calcBtn.click();
    }

    public void calcMultiply(int num1, int num2){
        scrollDown();
        Select operation = new Select(getDriver().findElement(By.id("selectOperationDropdown")));
        operation.selectByValue("2");
        input1.sendKeys(num1+"");
        input2.sendKeys(num2+"");
        calcBtn.click();
    }

    public void calcDivide(int num1, int num2){
        scrollDown();
        Select operation = new Select(getDriver().findElement(By.id("selectOperationDropdown")));
        operation.selectByValue("3");
        input1.sendKeys(num1+"");
        input2.sendKeys(num2+"");
        calcBtn.click();
    }

    public void scrollDown(){
        Actions action = new Actions(getDriver());
        action.scrollToElement(clearBtn);
    }

    public void clearInput(){
        input1.clear();
        input2.clear();
    }
    public void clearResult(){
        clearBtn.click();
    }

    public void refreshPage(){
        getDriver().navigate().refresh();

    }


}
