
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Almosafer extends Parameters {

	@BeforeTest
	public void BeforeTest() {
		// Select a random URL [the difference between URLs in language]
		driver.get(URLS[random_url]);
	}

	@Test(priority = 1)
	public void check_the_website_default_currency() {

		// Find the Default currency in the Website
		WebElement Actual_currency = driver.findElement(By.className("sc-eAKXzc"));

		// Verify if the currency is SAR
		Assert.assertEquals(Actual_currency.getText(), Expected_currency, "The default currency is not SAR");

	}

	@Test(priority = 2)
	public void check_contact_numbers() {

		// Find the contact numbers on the website
		WebElement Contact_Number = driver.findElement(By.cssSelector(
				"#__next > footer > div.sc-jqIZGH.hSQIME > div > div > div > div > div.sc-iCwjlJ.jnzbqU > div:nth-child(1) > div > h4"));
		// Verify if the contact numbers are correct
		Assert.assertEquals(Contact_Number.getText(), Expected_contact_Number);

	}

	@Test(priority = 3)
	public void check_the_Qitaf_logo() {
		// Find the "qitaf" logo in the footer
		WebElement Logo = driver.findElement(By.className("sc-bdVaJa"));
		// Verify if the logo is displayed using assertion
		Assert.assertTrue(Logo.isDisplayed());

	}

	@Test(priority = 4)
	public void hotels_search_tab() {

		// Find the hotels search tab

		WebElement hotels_tab = driver.findElement(By.xpath("//*[@id='uncontrolled-tab-example-tab-hotels']"));

		// Verify if Hotels search tab is not selected by default

		Assert.assertFalse(hotels_tab.isSelected(), "Hotels search tab is selected by default");

	}

	@Test(priority = 5)
	public void Random_lang_selected() throws InterruptedException {
		int randomindex = rand.nextInt(0, 1);
		List<WebElement> lang = driver.findElements(By.className("sc-bfYoXt"));
		for (int i = 0; i <= randomindex; i++) {
			lang.get(i).click();

		}
		String new_lang = driver.findElement(By.className("sc-bfYoXt")).getText();
		Assert.assertTrue(new_lang.equals(Arbic_lang) || new_lang.equals(eng_lang));

	}

	@Test(priority = 6)
	public void hotel_search_tab() {
		WebElement hotels_tab = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]/div"));
		hotels_tab.click();
		WebElement Current_lang = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a"));
		if (Current_lang.getText().equals(eng_lang)) {
			int indexloc = rand.nextInt(0, 2);
			WebElement location_field = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			location_field.sendKeys(arabic_loc[indexloc]);
		} else if (Current_lang.getText().equals(Arbic_lang)) {

			int indexloc = rand.nextInt(0, 3);
			WebElement location_field = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			location_field.sendKeys(english_loc[indexloc]);
		}
		// Click on the first result from auto complete list

		WebElement firstResult = driver.findElement(By.cssSelector(
				"#uncontrolled-tab-example-tabpane-hotels > div > div.sc-1vkdpp9-0.cTLJQi > div > div.sc-dxgOiQ.hTjMfW.sc-1vkdpp9-2.kxpSys.HotelSearchBox__DestinationAutoComplete.col-md-4 > div > div > div > div > input"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		firstResult.click();
	}

	@Test(priority = 7)
	public void Room_specifications() {
		// create list to put all option of room
		WebElement Room_specifications = driver.findElement(
				By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[3]/div/select"));

		List<WebElement> Room_options = Room_specifications.findElements(By.tagName("option"));

		// select randomly between room options
		int index_room_option = rand.nextInt(0, Room_options.size() - 1);
		Room_options.get(index_room_option).click();
// click  on search button
		WebElement Search_Button = driver.findElement(
				By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[4]/button/span"));
		Search_Button.click();
	}

	@Test(priority = 8)

	public void check_the_website_default_language() {
		driver.get(Defualt_URL);
		// Find the Default language in the website
		WebElement Actual = driver.findElement(By.className("sc-bfYoXt"));
		// Verify if the Default language is English
		Assert.assertEquals(Actual.getText(), eng_lang, "the default lang is arabic");
	}

	@AfterTest
	public void myAfterTest() {
		Assert.assertAll();

	}

}
