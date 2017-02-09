/**
 * @author Chaitrali Jayantilal Doshi
 * Assignment No: 5
 * Date: 2016.11.23
 * Class Name: CompareProperties
 *
 */
package edu.dataset;

import java.io.Serializable;

/**
 * This class is used to hold all the properties used when comparing DataRows
 */
public class CompareProperties implements Serializable
{
	/**
	 * Version id for writing this object to file
	 */
	private static final long serialVersionUID = 1L;
	
	//Column index to compare
	private int comparableIndex;
	
	//Data type to compare
	private DataTypes comparableType;
	
	//Whether or not the rows should be sorted in ascending order
	private boolean ascending;
	
	//Whether or not the comparison should check if the data rows are from the same parent
	private boolean sameParent;

	/**
	 * Default constructor
	 * Sets comparableIndex = -1
	 * Sets comparableType = DataTypes.STRING;
	 * Sets ascending = true
	 * Sets sameParent = false
	 */
	public CompareProperties() {
		super();
		this.comparableIndex = -1;
		this.comparableType = DataTypes.STRING;
		this.ascending = true;
		this.sameParent = false;
	}

	
	/**
	 * Copy Constructor
	 * 
	 * @param compareProperties
	 */
	public CompareProperties(CompareProperties compareProperties){
		this.comparableIndex = compareProperties.comparableIndex;
		this.comparableType = compareProperties.comparableType;
		this.ascending = compareProperties.ascending;
		this.sameParent = compareProperties.sameParent;
	}


	/**
	 * Returns the comparable index
	 * 
	 * @return comparableIndex
	 */

	public int getComparableIndex() {
		return comparableIndex;
	}
	
	/**
	 * Sets the comparable index
	 * 
	 * @param comparableIndex The column index to compare
	 */
	
	public void setComparableIndex(int comparableIndex) {
		this.comparableIndex = comparableIndex;
	}
	
	/**
	 * Returns the comparable type
	 * 
	 * @return
	 */
	public DataTypes getComparableType() {
		return comparableType;
	}


	/**
	 * Sets the comparable type
	 * 
	 * @param comparableType
	 */
	public void setComparableType(DataTypes comparableType) {
		this.comparableType = comparableType;
	}

	/**
	 * Returns the ascending value
	 * 
	 * @return
	 */
	public boolean isAscending() {
		return ascending;
	}

	/**
	 * Sets the ascending value
	 * 
	 * @param ascending
	 */
	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	/**
	 * Returns the sameParent value
	 * 
	 * @return
	 */
	public boolean isSameParent() {
		return sameParent;
	}

	/**
	 * Sets the sameParent value
	 * 
	 * @param sameParent
	 */
	public void setSameParent(boolean sameParent) {
		this.sameParent = sameParent;
	}
	
}