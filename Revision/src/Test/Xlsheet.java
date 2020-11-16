package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlsheet {

	public static void main(String[] args) throws IOException {
        //How To Create a Xlsx File
		File file=new File("C:\\Users\\abdul\\Desktop\\testdata.xlsx");
		FileOutputStream fos=new FileOutputStream(file);
		
		XSSFWorkbook book=new XSSFWorkbook();
		XSSFSheet sheet=book.createSheet("Demo");
		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("Id");
		row.createCell(1).setCellValue("Name");
		CreationHelper createHelper = book.getCreationHelper();
		row.createCell(2).setCellValue(createHelper.createRichTextString("Class"));
		XSSFRow row1=sheet.createRow(1);
		row1.createCell(0).setCellValue(001);
		row1.createCell(1).setCellValue("abdul");
		row1.createCell(2).setCellValue("10th");
		book.write(fos);
		book.close();
		fos.close();
		fos.flush();
		
		
		//How to Read A Xlsx File
		//File file=new File("C:\\Users\\abdul\\eclipse-workspace\\Revision\\src\\Test\\Documents\\testdata.xlsx");	
		FileInputStream fis=new FileInputStream(file);
	    XSSFWorkbook wb=new XSSFWorkbook(fis);
	    XSSFSheet shet=wb.getSheet("Demo");
	    System.out.println(shet.getLastRowNum());
	    XSSFRow ro=shet.getRow(1);
		System.out.println(ro.getLastCellNum());
	    String name=ro.getCell(2).getStringCellValue();
	    System.out.println(name);
	    wb.close();
	    fis.close();
	
	
	}

}
