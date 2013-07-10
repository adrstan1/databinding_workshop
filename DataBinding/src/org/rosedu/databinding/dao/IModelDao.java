package org.rosedu.databinding.dao;

/**
 * An interface to be implemented by classes that needs to manipulate records. 
 */
public interface IModelDao<T> {
	public T getCurrentRecord();
	public int getCurrentRecordIndex();
	public void saveCurrentRecord(T record);
	public boolean hasNext();
	public boolean hasPrevious();
	public void moveFirst();
	public void moveNext();
	public void movePrevious();
}
