package net.upgenix.pages;

import net.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage {

    public CreateProductsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy()
    public WebElement productNameField;
}