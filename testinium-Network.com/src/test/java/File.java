import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import java.time.Duration;
import java.util.List;


public class File {

    WebDriver driver;

    @Test
    @Order(1)

    public void Testing() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.network.com.tr/");
        System.out.println("- Network Web Sitesi Açıldı.");

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        System.out.println("- Network Web Sitesi Çerezleri Kabul Edildi.");
        Thread.sleep(2000);

        driver.findElement(By.name("searchKey")).sendKeys("Ceket");
        System.out.println("- Arama Sekmesinde Ceket Aratıldı.");
        Thread.sleep(2000);

        driver.findElement(By.className("sgm-search-show-all")).click();
        System.out.println("- Tümünü Gör Butonuna Tıklandı.");
        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,17500)");
        System.out.println("- Daha Fazla Göster'e Kadar Scroll Yapıldı.");
        Thread.sleep(3000);

        driver.findElement(By.className("relative")).click();
        System.out.println("- Daha Fazla Göster Butonuna Tıklandı.");
        Thread.sleep(2000);

        String URL = driver.getCurrentUrl();
        String actualURL = "https://www.network.com.tr/search?searchKey=Ceket";
        Assert.assertNotEquals(URL, actualURL);
        // Tıklanmadan önceki URL ile tıklandıktan sonra ki URL'in eşit olmamasının kontrolü
        System.out.println("- URL kontrol edildi.");

        driver.findElement(By.linkText("Lacivert Ekose Desenli Ceket")).click();
        System.out.println("- İndirimli Ceket Seçildi.");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for='size_54/6N']")).click();
        System.out.println("- Beden Seçimi Yapıldı.");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(@class,'addToCart')]")).click();
        System.out.println("- Sepete Eklendi.");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class='header__basketSummary']//a[@href='/cart']")).click();
        System.out.println("- Sepete Gidildi.");
        Thread.sleep(2000);

        // Ürüne ait beden ve fiyat bilgisinin sepette doğru geldiği kontrol edilir.

         // String productSize = driver.findElement(By.xpath("//label[@for='size_54/6N']")).getText();
         // String cartProductSize = driver.findElement(By.xpath("//div[@class='cartItem__info']//span[@class='cartItem__attrValue']")).getText();
         // Assert.assertEquals(productSize, cartProductSize);


        // Sepete eklen ürünün eski fiyatının indirimli fiyatından büyük olduğu kontrol ettirilir.

         String oldPrice = driver.findElement(By.xpath("//div[@class='cartItem__prices']//span[@class='cartItem__price -old -labelPrice']")).getText();
         String salePrice = driver.findElement(By.xpath("//div[@class='cartItem__prices']//span[@class='cartItem__price -sale']")).getText();
         Assert.assertNotEquals(oldPrice,salePrice);

        driver.findElement(By.xpath("//div[@class='summary']//button[contains(@class,'continueButton')]")).click();
        System.out.println("- Devam Et Butonuna Tıklandı.");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("serdar.yurt7@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("sRdR61__!");
        Thread.sleep(2000);


        driver.findElement(By.xpath("//div[@class='footerCheckout__bottom']//a[@href='/']")).click();
        System.out.println("- Network Logosuna Tıklandı.");
        Thread.sleep(2000);

        // driver.findElement(By.xpath("//svg[@class='header__icon -shoppingBag'] //use[xlink:href='#shopping-bag']")).click();

        // driver.findElement(By.className("js-basket-trigger")).click();

        System.out.println("- Test Bitti");
        driver.quit();
    }

}
