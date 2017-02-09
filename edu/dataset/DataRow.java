
/**
 * @author Chaitrali Jayantilal Doshi
 * Assignment No: 4
 * Date: 2016.11.09
 * Class Name: DataRow
 *
 */
package edu.dataset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The DataRow class is used to hold a row of data similar to a row in an excel
 * sheet. This class uses an ArrayList of Strings to represent the columns in a
 * row. If the column exists but there is no value, an empty String is used.
 */
public class DataRow implements Serializable {
	/**
	 * Version id for writing this object to file
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The row of data. The list of values in the row.
	 */
	private List<String> rowValues;

	/**
	 * The parent Dataset to which this DataRow belongs to
	 */
	private DataSet parentDataSet;

	/**
	 * Default constructor. Initializes an empty list for rowValues
	 */
	public DataRow() {
		this.rowValues = new ArrayList<String>();
	}

	/**
	 * Copy constructor. Copies the values from the other data row to this one.
	 * 
	 * @param otherDataRow
	 *            The data row to be copied
	 */
	public DataRow(DataRow otherDataRow) {
		this();
		this.rowValues.addAll(otherDataRow.rowValues);
	}

	/**
	 * Constructor that takes a String array as column values
	 * 
	 * @param rowValues
	 *            The values for each column in the row
	 */

	public DataRow(String[] rowValues) {
		this();
		this.rowValues.addAll(Arrays.asList(rowValues));
	}

	/**
	 * Constructor than takes a String list as column values
	 * 
	 * @param rowValues
	 *            The values for each column in the row
	 */
	public DataRow(List<String> rowValues) {
		this.rowValues = rowValues;
	}

	/**
	 * Constructor than takes a String as column values/ The String is assumed
	 * to be a comma separated list of values.
	 * 
	 * @param rowValues
	 *            The values for each column in the row
	 */
	public DataRow(String rowValues) {
		this(rowValues.split(","));
	}

	/**
	 * Gets the parent dataset
	 * 
	 * @return parentDataSet
	 */
	protected DataSet getParentDataSet() {
		return parentDataSet;
	}

	/**
	 * Sets the parent DataSet for this DataRow
	 * 
	 * @param parentDataSet
	 *            The parent DataSet
	 */
	//changed to public from protected
	public void setParentDataSet(DataSet parentDataSet) {
		this.parentDataSet = parentDataSet;
	}

	/**
	 * Returns the row values
	 * 
	 * @return rowValues
	 */
	public List<String> getRowValues() {
		return this.rowValues;
	}

	/**
	 * Sets row values
	 * 
	 * @param rowValues
	 */
	public void setRowValues(List<String> rowValues) {
		this.rowValues = rowValues;
	}

	/**
	 * Sets rowValues to the values of the array of Strings.
	 * 
	 * @param newRowValues
	 *            Array of Strings representing the row values
	 */
	public void setRowValues(String[] newRowValues) {
		for (int i = 0; i < newRowValues.length; i++) {
			if (i < this.rowValues.size()) {
				this.rowValues.set(i, newRowValues[i]);
			} else {
				this.rowValues.add(i, newRowValues[i]);
			}
		}
	}

	/**
	 * Returns the row values as a String array
	 * 
	 * @return The array of values
	 */

	public String[] getRowStringArrayValues() {
		return this.rowValues.toArray(new String[this.rowValues.size()]);
	}

	/**
	 * Sets the value at the specified column index to the new value
	 * 
	 * @param index
	 *            The index of the column for this row
	 * @param newValue
	 *            The new value to set this row/column to
	 */

	public void setRowValue(int index, String newValue) {
		this.rowValues.set(index, newValue);
	}

	/**
	 * Adds a column to this row at the specified index. The value of the column
	 * is an empty String.
	 * 
	 * @param index
	 *            The column index
	 */

	public void addColumn(int index) {
		this.rowValues.add(index, new String());
	}

	/**
	 * Adds a column to the end of the row with the new value specified
	 * 
	 * @param value
	 *            The value of the column
	 */

	public void addColumn(String value) {
		this.rowValues.add(value);
	}

	/**
	 * Adds a column to this row at the specified index with the specified value
	 * 
	 * @param index
	 *            The column index
	 * @param value
	 *            The value of the column
	 */

	public void addColumn(int index, String value) {
		this.rowValues.add(index, value);
	}

	/**
	 * Removes the column at the specified index
	 * 
	 * @param index
	 *            The column index
	 * @return Returns the value of the column
	 */
	public String removeColumn(int index) {
		return this.rowValues.remove(index);
	}

	/**
	 * Returns the value at the specified index
	 * 
	 * @param index
	 *            The column index
	 * @return The column value
	 */

	public String getColumn(int index) {
		return this.rowValues.get(index);
	}

	/**
	 * Returns the columns values as a List of Strings. The indices of the
	 * columns to include are specified by the index array.
	 * 
	 * @param index
	 *            The array of column indices to include
	 * @return A list of values for the specified columns
	 */

	public List<String> getColumnList(int[] index) {
		List<String> columnList = new ArrayList<String>();
		for (int i : index) {
			columnList.add(this.rowValues.get(i));
		}
		return columnList;
	}

	/**
	 * Returns the number of columns
	 * 
	 * @return The number of columns
	 */

	public int getColumns() {
		return this.rowValues.size();
	}

	/**
	 * Removes white space for all values in the row
	 */
	public void trimAllSpace() {
		
		// This will remove white spaces within every String element
		for (int i = 0; i < this.rowValues.size(); i++) {
			this.rowValues.set(i, this.rowValues.get(i).replaceAll(" ", ""));
		}	
	}

	/**
	 * Returns a comma separates list of values for the row data
	 */

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.rowValues.size() - 1; i++) {
			builder.append(rowValues.get(i));
			builder.append(",");
		}
		builder.append(rowValues.get(this.rowValues.size() - 1));
		return builder.toString();
	}

	/**
	 * Determines if two DataRows are equal. Only compares the rowValues field.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;

		if (!(obj instanceof DataRow))
			return false;

		DataRow other = (DataRow) obj;
		
		if (this.rowValues == null || other.rowValues == null) {
			return false;
		} else if (this.rowValues.size() != other.rowValues.size()) {
			return false;
		} else {
			for (int i = 0; i < this.rowValues.size(); i++) {
				if (!(this.rowValues.get(i).equals(other.rowValues.get(i)))) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rowValues == null) ? 0 : rowValues.hashCode());
		return result;
	}
}