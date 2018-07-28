package org.Guru99.Module;

import org.Guru99.Config.Config;
import org.Guru99.pageobjects.CellphonePage;

public class CellphoneModule {

	CellphonePage cp=new CellphonePage(Config.driver);
	
	public String CellPrice(){
		
		String CellPrice = cp.Price.getText();
		return CellPrice;
		
		
	}
	
}
