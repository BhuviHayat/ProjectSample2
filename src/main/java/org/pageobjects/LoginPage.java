package org.pageobjects;

import org.base.BaseClass;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
PageFactory.initElements(driver, this);
	}

}
