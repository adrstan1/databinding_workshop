package org.rosedu.databinding.models.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * An abstract class to be used as a base class for Java Bean model classes.
 * It adds property change support to model classes, so that the data bindings to
 * register as listeners and be notified when the model changes.
 */
public abstract class AbstractBeanModelObject {
		private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
				this);
		
		public void addPropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(listener);
		}

		public void addPropertyChangeListener(String propertyName,
				PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName,
					listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(listener);
		}

		public void removePropertyChangeListener(String propertyName,
				PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(propertyName,
					listener);
		}

		protected void firePropertyChange(String propertyName, Object oldValue,
				Object newValue) {
			propertyChangeSupport.firePropertyChange(propertyName, oldValue,
					newValue);
		}

		protected void firePropertyChange(String propertyName, int oldValue,
				int newValue) {
			propertyChangeSupport.firePropertyChange(propertyName, oldValue,
					newValue);
		}

		protected void firePropertyChange(String propertyName,
				boolean oldValue, boolean newValue) {
			propertyChangeSupport.firePropertyChange(propertyName, oldValue,
					newValue);
		}

}

