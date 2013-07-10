package org.rosedu.databinding.dao;

import java.util.ArrayList;
import java.util.List;

import org.rosedu.databinding.utils.ICloneable;

/**
 * A generic class acting as a provider for records.
 * The records are kept in memory, for simplicity.
 * A more realistic approach is to keep the records in an external
 * data source, such as a database. 
 */
public abstract class AbstractModelMemoryDao<T extends ICloneable<T>> implements IModelDao<T> {
	
	protected List<T> records = new ArrayList<T>();
	protected int currentRecordIndex = 0;
	
	@Override
	public T getCurrentRecord() {
		return records.get(currentRecordIndex).cloneObject();
	}
	
	@Override
	public int getCurrentRecordIndex() {
		return currentRecordIndex;
	}

	@Override
	public void saveCurrentRecord(T record) {
		records.set(currentRecordIndex, record.cloneObject());
	}
	
	@Override
	public boolean hasNext() {
		return currentRecordIndex < records.size() - 1;
	}
	
	@Override
	public boolean hasPrevious() {
		return currentRecordIndex > 0;
	}

	@Override
	public void moveFirst() {
		currentRecordIndex = 0;
	}

	@Override
	public void moveNext() {
		currentRecordIndex++;
	}
	
	@Override
	public void movePrevious() {
		currentRecordIndex--;
	}
}
