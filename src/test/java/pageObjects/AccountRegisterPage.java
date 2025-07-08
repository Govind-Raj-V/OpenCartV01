package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage{
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="firstname") WebElement txtFirstName;
	@FindBy(name="lastname") WebElement txtlastName;
	@FindBy(name="email") WebElement txtEmail;
	@FindBy(name="telephone") WebElement txtTelephone;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(name="confirm") WebElement txtConfirmPwd;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement rdo_Btn_01;
	@FindBy(xpath="//label[normalize-space()='No']") WebElement rdo_Btn_02;
	@FindBy(name="agree") WebElement Pri_Pol_Checkbox;
	@FindBy(xpath="//input[@value='Continue']") WebElement continue_Btn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmationMsg;
	@FindBy(linkText="Continue") WebElement conformMsg_continue_Btn;
	
	public void setFirstName(String Fname) {
		txtFirstName.sendKeys(Fname);
	}
	
	public void setLastName(String Lname) {
		txtlastName.sendKeys(Lname);
	}
	
	public void setEmail(String EmailId) {
		txtEmail.sendKeys(EmailId);
	}
	
	public void settelephoneNo(String telephoneNo) {
		txtTelephone.sendKeys(telephoneNo);
	}
	
	public void setpassword(String Pwd) {
		txtPassword.sendKeys(Pwd);
	}
	
	public void setConfirmPwd(String CrmPassword) {
		txtConfirmPwd.sendKeys(CrmPassword);
	}
	public void clickYes() {
		rdo_Btn_01.click();
	}
	
	public void clickNo() {
		rdo_Btn_02.click();
	}
	
	public void clickAgree() {
		Pri_Pol_Checkbox.click();
	}
	
	public void clickContinue() {
		continue_Btn.click();
	}
	
	public String checkConfirmationMsg() {
		String Msg=confirmationMsg.getText(); 
		return Msg;
	}
	
	public void clickConformBtn() {
		conformMsg_continue_Btn.click();
	}
}
