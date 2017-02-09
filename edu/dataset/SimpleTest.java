package edu.dataset;
/**
 * @author Chaitrali Jayantilal Doshi
 * Assignment No: 5
 * Date: 2016.11.23
 * Class Name: SimpleTest
 *
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.dataset.DataSet;
import edu.dataset.DataTypes;

public class SimpleTest
{
	public static void main(String args[])
	{
		String[] headerRow1 = {"Color", "Number1", "Animal", "Number2"};

		DataSet ds1 = new DataSet();
		ds1.setHeaderRow(headerRow1);

		ds1.addDataRow("red,5,cat,4");
		ds1.addDataRow("red,3,cat,4");
		ds1.addDataRow("blue,9,dog,1");
		ds1.addDataRow("green,7,bear,2");
		ds1.addDataRow("green,1,donkey,4");
		ds1.addDataRow("black,2,tiger,6");
		ds1.addDataRow("orange,9,lizard,3");


		String[] headerRow2 = {"Color", "Number1", "Animal", "Number2"};

		DataSet ds2 = new DataSet();
		ds2.setHeaderRow(headerRow2);
		ds2.setTitle("ds2");

		ds2.addDataRow("red ,5,cat,4");
		ds2.addDataRow("red,3,cat,4");
		ds2.addDataRow("blue,9,dog,1");
		ds2.addDataRow("green,7,bear,2");
		ds2.addDataRow("green,1,donkey,4");
		ds2.addDataRow("black,2,tiger,6");
		ds2.addDataRow("orange,9,lizard,3");
		
		DataSet d = new DataSet(ds2);
		d.addDataRow("Color,Number1,Animal,Number2");
		d.setCellValue(1,1,"7");
		System.out.println(d);

		System.out.println("XXXX");

		ds1.sort(0, DataTypes.STRING);
		System.out.println(ds1);

		System.out.println("XXXX");

		ds1.sort(1, DataTypes.INTEGER);
		System.out.println(ds1);

		System.out.println("XXXX");

		//System.out.println(ds1.equals(ds2));
		
		
        CompareProperties compareProperties = new CompareProperties();
		
		compareProperties.setComparableIndex(0);
		compareProperties.setComparableType(DataTypes.STRING);
		compareProperties.setSameParent(true);
		compareProperties.setAscending(true);
		DataRowComparator d2 = new DataRowComparator(compareProperties);
		
		System.out.println(d2.compare(ds1.getDataRow(1), ds1.getDataRow(1)));
		
	}
}