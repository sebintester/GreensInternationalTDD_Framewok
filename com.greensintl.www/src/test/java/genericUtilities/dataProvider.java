package genericUtilities;

import org.testng.annotations.DataProvider;

public class dataProvider implements IPathConstant {
@DataProvider(name="LoginData")
public String[][] getData() throws Throwable
{
	excelUtility ex=new excelUtility();
	int totalrows = ex.getRowCount("Sheet2");
	int totalcols = ex.getCellCount("Sheet2", 1);
	
	String value[][] =new String [totalrows][totalcols];
	for(int i=1;i<=totalrows;i++)
	{
		for(int j=0;j<totalcols;j++)
		{
		value[i-1][j]=ex.getSingleDataFromExcel("sheet2", i, j);
		}
	}
	return value;
}
}