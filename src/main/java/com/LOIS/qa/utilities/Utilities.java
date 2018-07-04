package com.LOIS.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.LOIS.qa.base.testbase;

public class Utilities extends testbase {
	
	
	//Take Screenshot in wordFile
	public static void screenPrint(String pagename,String name1) throws Exception, IOException{
		
		 p=doc.createParagraph();
		 r=p.createRun();

		

		
		src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\Screenshot\\"+name1+".png"));
		
		pic = new FileInputStream(".\\Screenshot\\"+name1+".png");

		r.addBreak();
		r.setText(pagename);
		r.addBreak();
		r.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG,".\\Screenshot\\"+name1+".png" , Units.toEMU(400), Units.toEMU(400));

		out = new FileOutputStream(".\\Screenshot\\images.docx");
		doc.write(out);
		
		
		
	}

}
