
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class Parameters {

	WebDriver driver = new EdgeDriver();
	SoftAssert Assert = new SoftAssert();
	Random rand = new Random();

	String[] URLS = { "Https://www.Almosafer.com/en", "Https://www.Almosafer.com/ar" };
	String Defualt_URL = "Https://www.Almosafer.com";
	int random_url = rand.nextInt(0, 2);
	String Expected_currency = "SAR";

	String Expected_contact_Number = "920000997";
	String eng_lang = "English";
	String Arbic_lang = "العربية";
	String[] arabic_loc = { "دبي", "جدة" };
	String[] english_loc = { "Dubai", "Jeddah", "Riyadh" };

}
