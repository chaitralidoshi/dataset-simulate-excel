/**
 * @author Chaitrali Jayantilal Doshi
 * Assignment No: 5
 * Date: 2016.11.23
 * Class Name: DataSet
 *
 */

package edu.dataset;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The DataSet class is used to hold a DataSet containing rows and column like
 * an excel sheet. The DataSet class contains a list of rows (which holds a list
 * of columns). The header row is treated separately and is not part of the row
 * list. All data are stores as Strings, however a list of columnDataTypes is
 * used to store how the Strings should be interpreted (as int, double, etc...).
 *
 */
public class DataSet implements Serializable {
	/**
	 * Version id for writing this object to file
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The header row of the DataSet
	 */
	private DataRow headerRow;

	/**
	 * The list of Data rows for the DataSet
	 */
	private List<DataRow> dataRows;

	/**
	 * The title of the DataSet
	 */
	private String title;

	/**
	 * Default constructor. Initializes the header row using the default
	 * constructor and sets the parent to "this" Initializes an empty list of
	 * data rows and column types
	 */
	public DataSet() {
		this.headerRow = new DataRow();
		this.headerRow.setParentDataSet(this);

		this.dataRows = new ArrayList<DataRow>();

	}

	/**
	 * Copy constructor Copies the title, header row, data rows to this DataSet
	 * 
	 * @param otherDataSet
	 *            Another DataSet
	 */
	public DataSet(DataSet otherDataSet) {

		this.title = new String(otherDataSet.title);
		this.headerRow = new DataRow(otherDataSet.headerRow);

		List<DataRow> tempDataRows = new ArrayList<DataRow>();

		for (int i = 0; i < otherDataSet.dataRows.size(); i++) {
			DataRow d = new DataRow(otherDataSet.dataRows.get(i));
			d.setParentDataSet(this);
			tempDataRows.add(d);
		}
		this.dataRows = tempDataRows;

	}

	/**
	 * Returns the title of the dataset
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the title of the dataset
	 * 
	 * @param title
	 *            The new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the list of data rows
	 * 
	 * @return Returns the list of data rows
	 */
	public List<DataRow> getDataRows() {
		return this.dataRows;
	}

	/**
	 * Returns the header row
	 * 
	 * @return The header row
	 */
	public DataRow getHeaderRow() {
		return this.headerRow;
	}

	/**
	 * Sets the header row to the specified DataRow
	 * 
	 * @param headerRow
	 *            A new header row
	 */
	public void setHeaderRow(DataRow headerRow) {
		this.headerRow = headerRow;
	}

	/**
	 * Sets the header row to the values specified by a comma separated String
	 * 
	 * @param headerRow
	 *            A comma separated String of column values
	 */

	public void setHeaderRow(String headerRow) {
		this.headerRow = new DataRow(headerRow);
	}

	/**
	 * Sets the header row to the values in the String array
	 * 
	 * @param headerRow
	 *            A String array for the new header row values
	 */
	public void setHeaderRow(String[] headerRow) {
		this.headerRow = new DataRow(headerRow);
	}

	/**
	 * Sets the value of the header row at the specified index to the new value
	 * 
	 * @param columnIndex
	 *            The column index
	 * @param newValue
	 *            The new header row value
	 */
	public void setHeaderRowValue(int columnIndex, String newValue) {
		this.headerRow.setRowValue(columnIndex, newValue);
	}

	/**
	 * Adds a blank/empty DataRow to the end of this DataSet
	 */
	public void addBlankRow() {
		DataRow dataRow = new DataRow();
		dataRow.setParentDataSet(this);
		this.dataRows.add(dataRow);
	}

	/**
	 * 
	 * Adds a column after the given index, Adds a column to the header row and
	 * all the data rows accordingly
	 * 
	 * @param columnIndex
	 *            The column index
	 */

	public void addColumn(int columnIndex) {
		this.headerRow.addColumn(columnIndex + 1);
		for (DataRow dataRow : dataRows) {
			dataRow.addColumn(columnIndex + 1);
		}
	}

	/**
	 * Adds the given DataRow to the DataSet
	 * 
	 * @param dataRows
	 *            The list of DataRows to add
	 */

	public void addDataRow(DataRow dataRow) {
		dataRow.setParentDataSet(this);
		this.dataRows.add(dataRow);
	}

	/**
	 * Adds a DataRow to the DataSet given as a comma separated String of values
	 * 
	 * @param dataRowString
	 *            An comma separated String representing a DataRow
	 */
	public void addDataRow(String dataRowString) {
		DataRow dataRow = new DataRow(dataRowString);
		dataRow.setParentDataSet(this);
		this.dataRows.add(dataRow);

	}

	/**
	 * Adds a DataRow to the DataSet given as an array of Strings
	 * 
	 * @param dataRowArray
	 *            An array of Strings representing a DataRow
	 */
	public void addDataRow(String[] dataRowArray) {
		DataRow dataRow = new DataRow(dataRowArray);
		dataRow.setParentDataSet(this);
		this.dataRows.add(dataRow);
	}

	/**
	 * Returns an empty row with no parent and with the same number of columns as the header row
	 * @return
	 */
	public DataRow getBlankRow() {
		return new DataRow(new String[this.headerRow.getColumns()]);
	}

	/**
	 * Returns the list of row values for a given column including the header
	 * row
	 * 
	 * @param columnIndex
	 *            The column index
	 * @return A list of Strings row each row value
	 */
	public List<String> getColumn(int columnIndex) {
		List<String> rowValueList = new ArrayList<String>();
		
		rowValueList.add(this.headerRow.getColumn(columnIndex));
		
		for (DataRow dataRow : this.dataRows) {
			rowValueList.add(dataRow.getColumn(columnIndex));
		}
		return rowValueList;
	}

	/**
	 * Returns the list of row values for a given column not including the
	 * header row
	 * 
	 * @param columnIndex
	 *            The column index
	 * @return A list of Strings row each row value
	 */
	public List<String> getColumnWithoutHeader(int columnIndex) {
		List<String> rowValueList = new ArrayList<String>();
		
		for (DataRow dataRow : this.dataRows) {
			rowValueList.add(dataRow.getColumn(columnIndex));
		}
		return rowValueList;
	}

	/**
	 * Returns the DataRow at the specified index
	 * 
	 * @param index
	 *            The row index
	 * @return The DataRow at the given index
	 */
	public DataRow getDataRow(int index) {
		return this.dataRows.get(index);
	}

	/**
	 * Returns the value at the given row and column index
	 * 
	 * @param rowIndex
	 *            The row index
	 * @param columnIndex
	 *            The column index
	 * @return The value at the given row and column indices
	 */
	public String getDataRowValue(int rowIndex, int columnIndex) {
		return this.dataRows.get(rowIndex).getColumn(columnIndex);
	}

	/**
	 * Returns a String array of the DataRow at the specified index
	 * 
	 * @param index
	 *            The row index
	 * @return A String array of the DataRow at the given index
	 */
	public String[] getDataStringArrayRow(int index) {
		return this.dataRows.get(index).getRowStringArrayValues();
	}

	/**
	 * Returns a String representation of the DataRow at the specified index
	 * 
	 * @param index
	 *            The row index
	 * @return A String of the DataRow at the given index
	 */
	public String getDataStringRow(int index) {
		return this.dataRows.get(index).toString();
	}

	/**
	 * Returns the index of the column specified by the given column name
	 * 
	 * @param name
	 *            The name of the column
	 * @return The index of the column
	 * @throws RuntimeException
	 *             Throws an exception if no column can be found
	 */
	public int getHeaderColumnIndexByString(String name) throws java.lang.RuntimeException {
		return this.headerRow.getRowValues().indexOf(name);
	}

	/**
	 * Returns the header row value specified at the given index
	 * 
	 * @param index
	 *            The column index
	 * @return The header row value
	 */
	public String getHeaderRowValue(int index) {
		return this.headerRow.getColumn(index);
	}

	/**
	 * Returns a String array for the header row
	 * 
	 * @return A String array for the header row
	 */
	public String[] getHeaderStringArrayRow() {
		return this.headerRow.getRowStringArrayValues();
	}

	/**
	 * Returns the number of columns in the header row
	 * 
	 * @return The number of columns in the header row
	 */
	public int getNumberOfColumns() {
		return this.headerRow.getColumns();
	}

	/**
	 * Returns the number of columns in the specified row
	 * 
	 * @param rowIndex
	 *            The row index
	 * @return The number of columns for the given row
	 */
	public int getNumberOfColumns(int rowIndex) {
		return this.dataRows.get(rowIndex).getColumns();
	}

	/**
	 * Returns the number of rows
	 * 
	 * @return The number of rows
	 */
	public int getNumberOfRows() {
		return this.dataRows.size();
	}

	/**
	 * Removes the column at the specified index from the header row and all
	 * data rows
	 * 
	 * @param columnIndex
	 *            The column index to remove
	 */
	public void removeColumn(int columnIndex) {
		this.headerRow.removeColumn(columnIndex);
		for (DataRow dataRow : dataRows) {
			dataRow.removeColumn(columnIndex);
		}
	}

	/**
	 * Trims all white space for each row and column
	 */
	public void trimAllSpace() {
		for (DataRow dataRow : this.dataRows) {
			dataRow.trimAllSpace();
		}
	}

	/**
	 * Removes the DataRow at the specified index
	 * 
	 * @param index
	 *            The index of the DataRow to remove
	 */
	public void removeDataRow(int index) {
		this.dataRows.remove(index);
	}

	/**
	 * Sets the value at a given row and column index to the new specified value
	 * 
	 * @param rowIndex
	 *            The row index
	 * @param columnIndex
	 *            The column index
	 * @param newValue
	 *            The new value
	 */
	public void setCellValue(int rowIndex, int columnIndex, String newValue) {
		this.dataRows.get(rowIndex).setRowValue(columnIndex, newValue);
	}

	/**
	 * Sorts the DataSet by the given column index Calls sort(int columnIndex,
	 * DataTypes comparableType) with a default data type of STRING
	 * 
	 * @param columnIndex
	 *            The column to sort by
	 */
	public void sort(int columnIndex) {
		sort(columnIndex, DataTypes.STRING);
	}

	/**
	 * Sorts the DataSet by the given column index and data type Calls sort(int
	 * columnIndex, DataTypes comparableType, boolean sameParent) with a default
	 * same parent value of true
	 * 
	 * @param columnIndex
	 *            The column index to sort by
	 * @param comparableType
	 *            The data type to sort by
	 */
	public void sort(int columnIndex, DataTypes comparableType) {
		sort(columnIndex, comparableType, true);
	}

	/**
	 * Sorts the DataSet by the given column index and data type and same parent
	 * value Calls sort with a default ordering of true = ascending order
	 * 
	 * @param columnIndex
	 *            The column index to sort by
	 * @param comparableType
	 *            The data type to sort by
	 * @param sameParent
	 *            Whether or not to check if the data rows share the same parent
	 */
	public void sort(int columnIndex, DataTypes comparableType, boolean sameParent) {
		sort(columnIndex, comparableType, sameParent, true);
	}

	/**
	 * Sorts the dataset by creating a ComparePropoperties object and setting
	 * all the fields. Then creates a DataRowComparator object with the
	 * CompareProperties object Calls Collections.sort with the data rows and
	 * the data row comparator
	 * 
	 * @param columnIndex
	 *            The column index to sort by
	 * @param comparableType
	 *            The data type to sort by
	 * @param sameParent
	 *            Whether or not to check if the data rows share the same parent
	 * @param ascending
	 *            Whether to sort in ascending or descending order
	 */

	public void sort(int columnIndex, DataTypes comparableType, boolean sameParent, boolean ascending) {
		CompareProperties compareProperties = new CompareProperties();

		compareProperties.setComparableIndex(columnIndex);
		compareProperties.setComparableType(comparableType);
		compareProperties.setSameParent(sameParent);
		compareProperties.setAscending(ascending);

		Collections.sort(this.dataRows, new DataRowComparator(compareProperties));

	}

	/**
	 * Functions similiarly to sort(int columnIndex, DataTypes comparableType,
	 * boolean sameParent, boolean ascending) Calls Collections.sort with a sub
	 * list of data rows specified by the start and end indices
	 * 
	 * @param startIndex
	 *            Starting index to sort
	 * @param endIndex
	 *            Ending index to sort
	 * @param columnIndex
	 *            The column index to sort by
	 * @param comparableType
	 *            The data type to sort by
	 * @param sameParent
	 *            Whether or not to check if the data rows share the same parent
	 * @param ascending
	 *            Whether to sort in ascending or descending order
	 */

	public void sort(int startIndex, int endIndex, int columnIndex, DataTypes comparableType, boolean sameParent,
			boolean ascending) {

		CompareProperties compareProperties = new CompareProperties();

		compareProperties.setComparableIndex(columnIndex);
		compareProperties.setComparableType(comparableType);
		compareProperties.setSameParent(sameParent);
		compareProperties.setAscending(ascending);

		Collections.sort(this.dataRows.subList(startIndex, endIndex), new DataRowComparator(compareProperties));
	}

	/**
	 * Calls toString for the header row and each data row A new line is used to
	 * separate each row
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.headerRow.toString());
		
		for(DataRow dataRow :this.dataRows){
			builder.append("\n");
			builder.append(dataRow.toString());
		}
		
		return builder.toString();
	}

	/**
	 * hashcode
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataRows == null) ? 0 : dataRows.hashCode());
		result = prime * result + ((headerRow == null) ? 0 : headerRow.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	
	/**
	 * Determines if the object is equal to this DataSet
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DataSet)) {
			return false;
		}
		DataSet other = (DataSet) obj;
		if (this.dataRows == null) {
			if (other.dataRows != null) {
				return false;
			}
		} else if (!dataRows.equals(other.dataRows)) {
			return false;
		}
		if (headerRow == null) {
			if (other.headerRow != null) {
				return false;
			}
		} else if (!headerRow.equals(other.headerRow)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
}