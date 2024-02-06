package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	public String getExcelLibrary(String sheetname, int rowNum,int cellNum) {
		String retVal=null;
		
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//testdata//Testdata.xlsx");
			Workbook wb=WorkbookFactory.create(file);
		Sheet sh=	wb.getSheet(sheetname);
		Row rw=sh.getRow(rowNum);
		Cell cel=rw.getCell(cellNum);
		retVal=cel.getStringCellValue();
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retVal;
		
	}
	
	
	public int getLastRow(String sheetname) {
		int retVal=0;
		
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//testdata//Testdata.xlsx");
			Workbook wb=WorkbookFactory.create(file);
		Sheet sh=	wb.getSheet(sheetname);
		retVal=sh.getLastRowNum();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retVal;
		
	}
	
	
	

}
