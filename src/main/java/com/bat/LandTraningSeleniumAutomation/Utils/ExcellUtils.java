package com.bat.LandTraningSeleniumAutomation.Utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator; 
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bat.LandTraningSeleniumAutomation.DTO.LoginDTO;

public class ExcellUtils {

	private static FileInputStream inputstream = null;

	private static Workbook workbook = null;

	private static Sheet getSheet(int sheetno) throws IOException 
	{
		File f = new File("D:\\BAL_OCPL\\testing_file\\UserRegistrationPage.xlsx");
		inputstream = new FileInputStream(f);
		workbook = new XSSFWorkbook(inputstream);
		Sheet sheet = workbook.getSheetAt(sheetno);
		return sheet;

	}
	
	
	public static List<LoginDTO> getLoginData () throws IOException 
	{
		
		List<LoginDTO> loginData= new ArrayList<LoginDTO>();
		DataFormatter formater=new DataFormatter();
		
		Iterator<Row> rowiterator=ExcellUtils.getSheet(0).iterator();
		while(rowiterator.hasNext())
		{
			Row nextrow=rowiterator.next();
			Iterator<Cell> celliterator = nextrow.cellIterator();
			LoginDTO login=new LoginDTO();
			byte cellCounter=0;
			while(celliterator.hasNext()) 
			{
			
				Cell cell = celliterator.next(); 
				switch(cellCounter) 
				{
				case 0:
					login.setUsername(formater.formatCellValue(cell));
					cellCounter++;
					break;
				case 1:
					login.setPassword(formater.formatCellValue(cell));
					cellCounter++;
					break;
				case 2:
					login.setEmail(formater.formatCellValue(cell));
					cellCounter++;
					break;
				case 3:
					login.setMobile(formater.formatCellValue(cell));
					cellCounter++;
					break;
				case 4:
					login.setDiv(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 5:
					login.setDis(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 6:
					login.setUpa(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 7:
					login.setOffice(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 8:
					login.setDes(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 9:
					login.setUsergroup(formater.formatCellValue(cell));;
					cellCounter++;
					break;
			
				case 10:
					login.setNameEn(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 11:
					login.setNameBn(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				
				case 12:
					login.setNid(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 13:
					login.setPhone(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 14:
					login.setOffphone(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 15:
					login.setDob(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 16:
					login.setGender(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 17:
					login.setPeraddress(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 18:
					login.setPreaddress(formater.formatCellValue(cell));;;
					cellCounter++;
					break;
				case 19:
					login.setExdate(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 20:
					login.setPhoto(formater.formatCellValue(cell));;
					cellCounter++;
					break;
				case 21:
					login.setSign(formater.formatCellValue(cell));;
					break;
				}
				
			}
			loginData.add(login);
		}
		close();
		return loginData;
	}

	private static void close() throws IOException 
	{
		
		workbook.close();
		inputstream.close();
		
	}


}
	
	
