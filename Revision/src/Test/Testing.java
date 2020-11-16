package Test;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		/*				//ALERT
		driver.navigate().to("http://www.leafground.com/home.html");
		driver.findElement(By.xpath("//a[@class='wp-categories-link maxheight']//img[@alt='Alert']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Alert Box')]")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText().indexOf("I"));
		System.out.println(alert.getText().lastIndexOf("x"));
		System.out.println(alert.getText().codePointCount(alert.getText().indexOf("I"), alert.getText().lastIndexOf("x")));
		System.out.println(alert.getText().length());
		for(int i=0;i<alert.getText().length();i++) 
		{
			char vla=alert.getText().charAt(i);
			String str=Character.toString(vla);
			System.out.println(str);
		}
		alert.accept();
		WebElement check=driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]"));
		System.out.println(check.getText());
		check.click();
		alert.dismiss();
		WebElement check1=driver.findElement(By.xpath("//button[contains(text(),'Prompt Box')]"));
		check1.click();
		//check1.sendKeys("abdul");
		//alert.sendKeys("abdul");
		alert.dismiss();
		WebElement check2=driver.findElement(By.xpath("//button[contains(text(),'Line Breaks?')]"));
		check2.click();
		alert.accept();
		WebElement check3=driver.findElement(By.xpath("//button[contains(text(),'Sweet Alert')]"));
		check3.click();
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		driver.close();
        
        
        //FRames
		driver.get("http://www.leafground.com/pages/frame.html");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		//	driver.switchTo().frame(0);
		driver.switchTo().frame();		
		WebElement ele=driver.findElement(By.xpath("//button[@id='Click']"));
		ele.click();
		System.out.println(ele.getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);		
		int size1 = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size1);
		driver.switchTo().frame(0);
		WebElement ele1=driver.findElement(By.xpath("//button[@id='Click1']"));
		ele1.click();
		System.out.println(ele1.getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);		
		int size2 = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size2);
		
	
	   //Window Handle
		driver.navigate().to("http://www.leafground.com/pages/Window.html");
		//driver.findElement(By.xpath("//button[@id='home']")).click();
		//driver.findElement(By.xpath("//button[@onclick='openWindows()']")).click();
		driver.findElement(By.xpath("//button[@style='background-color:lightgreen']")).click();
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		
		Set<String> child=driver.getWindowHandles();
		System.out.println(child);
		
		for(String str:child)
		{
			if(!str.equals(parent)) {
			driver.switchTo().window(str);
			driver.close();
			}
		}
		/*String win=driver.getWindowHandle();
		System.out.println(win);
		Set<String> wind=driver.getWindowHandles();
		System.out.println(wind);
		System.out.println(wind.size());
		
		for(String str:wind) {
			if(!str.equals(win)) {
				driver.switchTo().window(str);
				driver.close();
			}
		}
		
			for(int i=0;i<wind.size();i++) {
			if(!win.equals(wind)) {
				driver.switchTo().window(Integer.toString(i));
			    driver.close();
			}
		}
		
		
		//Wait
		
		driver.navigate().to("http://www.leafground.com/pages/Window.html");
		WebElement ele=driver.findElement(By.xpath("//button[@style='background-color:lightblue']"));
		ele.click();
		//ExplicityWait
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@style='background-color:lightblue']")));
		Set<String> child2=driver.getWindowHandles();
		System.out.println(child2);
		//fluentWait
		Wait<WebElement> wait1=new FluentWait<WebElement>(ele)
				.withTimeout(5,TimeUnit.SECONDS)
				.pollingEvery(2,TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		//ExplicityWait
		driver.get("http://www.leafground.com/pages/disapper.html");
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn']")));
		String str=driver.findElement(By.xpath("//div[@id='show']//strong[normalize-space(text())='I know you can do it! Button is disappeared!']")).getText();
		System.out.println(str);
		driver.quit();
		
		driver.get("http://www.leafground.com/pages/appear.html");
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'We are five friends here')]")));
		String str=driver.findElement(By.xpath("//*[contains(text(),'We are five friends here')]")).getText();
		System.out.println(str);
		driver.quit();
		
		driver.get("http://www.leafground.com/pages/TextChange.html");
		WebDriverWait wait=new WebDriverWait(driver,30);//timeout exception
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btn']")));
		driver.findElement(By.xpath("//button[@id='btn']")).click();
		Alert alr=driver.switchTo().alert();
		alr.accept();//how to check alert is displayed
	*/
		//Table
		/*		driver.get("http://www.leafground.com/pages/table.html");
		java.util.List<WebElement>column=driver.findElements(By.xpath("//table[@id='table_id']//th"));
		System.out.println(column.size());
		java.util.List<WebElement>row=driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		System.out.println(row.size());
		WebElement pv=driver.findElement(By.xpath("//tr[@class='even']//td[normalize-space(text())='Learn to interact with Elements']//following::td[1]"));
		System.out.println(pv.getText());
	    
List<WebElement> progress=driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		
		ArrayList<Integer> prog=new ArrayList<Integer>();
		
		for(WebElement ele:progress)
		{
			String s=ele.getText().replace("%", "");
			int a=Integer.parseInt(s);
			prog.add(a);
		}
		
		System.out.println(prog);
		int minValue=Collections.min(prog);
		System.out.println(minValue);
		
		String min=Integer.toString(minValue);
		
	    WebElement minChkBox=driver.findElement(By.xpath("//td[text()='"+min+"%']//following::td[1]//input"));
	    minChkBox.click();
		
	    
	    java.util.List<WebElement>row1=driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		System.out.println(row1.size());
		ArrayList<String> val=new ArrayList<String>();
		for(int i=0;i<row1.size();i++) 
		{
			System.out.println(row1.get(i).getText());
			
		    val.add(row1.get(i).getText());
		    System.out.println(val);
		}
		System.out.println(val);
		
		
		for(int i=2;i<=row.size();i++)
		{
			WebElement pvi=driver.findElement(By.xpath("//table[@id='table_id']//tr[i]//td[2]"));
			System.out.println(pvi.getText());
			
		}
		
		driver.get("http://www.leafground.com/pages/sorttable.html");
		 java.util.List<WebElement>row1=driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		// Thread.sleep(5000);
		// WebDriverWait wait=new WebDriverWait(driver,5);
		// wait.until(ExpectedConditions.visibilityOf(driver.findElements(By.xpath("(//th[@class=\"sorting\"])[1]"))));
		 driver.findElement(By.xpath("(//th[@class=\"sorting\"])[1]")).click();
		 java.util.List<WebElement>row2=driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		 ArrayList<String> valu=new ArrayList<String>();
		 ArrayList<String> value=new ArrayList<String>();
		 TreeSet<String> az=new TreeSet<String>();
		 for(WebElement ele:row1) 
		 {
			 String st=ele.getText();
			 valu.add(st);
			 az.add(st);
		 }
		 System.out.println(valu);
		 System.out.println(az);
		 Collections.sort(valu);
		 System.out.println(valu);
		 for(WebElement ele1:row2) 
		 {
			 String st1=ele1.getText();
			 value.add(st1);
		 }
		 System.out.println(value);
		 if(Collections.disjoint(valu, value)) 
		 {
			 System.out.println("name validation not successful");
		 }	else 
		 {
			 System.out.println("name validation successful");
		 }		
 */		
		
		driver.get("http://www.leafground.com/pages/frame.html");
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		//	driver.switchTo().frame(0);
		driver.switchTo().frame(0);		
		WebElement ele=driver.findElement(By.xpath("//button[@id='Click']"));
		ele.click();
		Point poi=ele.getLocation();
	    System.out.println(poi.getX());
	   System.out.println(poi.getY());
	    
	}
         
}
