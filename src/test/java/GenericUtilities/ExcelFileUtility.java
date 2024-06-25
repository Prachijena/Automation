package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

public String readDatafromExcl(String Sheetname,int rownum,int cellnum) throws Throwable, IOException {
	FileInputStream fise=new FileInputStream("C:\\Users\\jenap\\eclipse-workspace\\Advancedselenium\\src\\test\\resources\\Testdata.xlsx");
Workbook wb=WorkbookFactory.create(fise);
String value = wb.getSheet(Sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
return value;
}
}
