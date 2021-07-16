package seleniumgluecode;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {
	
	WebDriver driver;
	
	By signInBtn = By.xpath("//a[@id='LoginLink']/font");
	By usernameTxt = By.id("uid");
	By passwordTxt = By.id("passw");
	By loginBtn = By.xpath("//input[@name='btnSubmit']");
	By transFundsLink = By.id("MenuHyperLink3");
	By fromAccountSelect = By.id("fromAccount");
	By toAccountSelect = By.id("toAccount");
	By amountTxt = By.id("transferAmount");
	By transferBtn = By.id("transfer");
	By text = By.xpath("//span[@id='_ctl0__ctl0_Content_Main_postResp']/span");
	
	@Given("^Ingresar al sitio$")
	public void ingresar_al_sitio() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.testfire.net/index.jsp");
	}

	@When("^Hace click sobre el boton sign up$")
	public void hace_click_sobre_el_bot_n_sign_up() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(signInBtn).click();
	}

	@When("^Ingresa el usuario \"([^\"]*)\"$")
	public void ingresa_el_usuario(String user) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(usernameTxt).sendKeys(user);
	}

	@When("^Ingresa la clave \"([^\"]*)\"$")
	public void ingresa_la_clave(String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(passwordTxt).sendKeys(password);
	    driver.findElement(loginBtn).click();
	}

	@When("^Selecciona la opcion Tranfer Funds$")
	public void selecciona_la_opcion_Tranfer_Funds() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(transFundsLink).click();
	}

	@When("^Selecciona from account \"([^\"]*)\"$")
	public void selecciona_from_account(String fromAccount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(fromAccountSelect).click();
	    driver.findElement(fromAccountSelect).sendKeys(fromAccount);
	    driver.findElement(fromAccountSelect).click();
	}

	@When("^Ingresa to account \"([^\"]*)\"$")
	public void ingresa_to_account(String toAccount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(toAccountSelect).click();
	    driver.findElement(toAccountSelect).sendKeys(toAccount);
	    driver.findElement(toAccountSelect).click();
	}

	@When("^Ingresa el monto a transferir \"([^\"]*)\"$")
	public void ingresa_el_monto_a_transferir(String amount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(amountTxt).sendKeys(amount);
	}

	@When("^hace click sobre boton transferir$")
	public void hace_click_sobre_boton_transferir() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(transferBtn).click();
	}

	@Then("^Se observa la tranferencia exitosa$")
	public void se_observa_la_tranferencia_exitosa() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String aux;
		aux = driver.findElement(text).getText();
		
		String loQueQuieroBuscar = "was successfully transferred";
	
		boolean resultado = aux.contains(loQueQuieroBuscar);
		
		assertTrue(resultado);
		
		driver.close();
	    
	}
	

}
