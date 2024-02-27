package Testdata.DataDriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class ReadExcel {
    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;

    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ashwi\\Downloads\\chromedriver-win64 (1) - Copy\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
		driver.get("http://www.facebook.com/");
		driver.manage().window().maximize();
		
	// Import excel sheet
	File src = new File("C:\\Users\\ashwi\\eclipse-workspace\\DataDriven\\TestData.xlsx");
	// load the file
	FileInputStream fis = new FileInputStream(src);
	// load the work book

	workbook = new XSSFWorkbook(fis);
	// access the sheet from the work book
	sheet = workbook.getSheetAt(0);
	for (int i = 1; i<=sheet.getLastRowNum(); i++) {
		// import the data from email
		cell = sheet.getRow(i).getCell(0);
		driver.findElement(By.xpath("//input[@name = 'email']")).clear();
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(cell.getStringCellValue());

		// import the data for the password 

		cell = sheet.getRow(i).getCell(1);
		driver.findElement(By.xpath("//input[@id = 'pass']")).clear();
		driver.findElement(By.xpath("//input[@id = 'pass']")).sendKeys(cell.getStringCellValue());

	}}
}