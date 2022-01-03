package com.ar.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtils {
	
	public Object[][] readfromExcel(String FilePath,String SheetName) throws IOException, EncryptedDocumentException, InvalidFormatException
	{
		FileInputStream fis = new FileInputStream(FilePath);		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s =wb.getSheet(SheetName);
		int rownum = s.getLastRowNum();
		int Columnnum = s.getRow(0).getLastCellNum();
		Object[][] testdata = new Object[rownum][Columnnum] ;
		for(int i=0;i<rownum;i++)
		{
			for(int j=0;j<Columnnum;j++)
			{			
				testdata[i][j]=s.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return testdata;
	}

}
