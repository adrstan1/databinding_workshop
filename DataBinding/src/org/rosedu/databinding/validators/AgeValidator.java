package org.rosedu.databinding.validators;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

public class AgeValidator implements IValidator {
	@Override
	public IStatus validate(Object value) {
		if (value instanceof Integer) {
			Integer age = (Integer)value;
			if (age < 0) {
				return ValidationStatus.error("Age cannot be negative");
			}
			if (age < 18) {
				return ValidationStatus.error("Under-age customers not allowed");
			}
			if (age > 80) {
				return ValidationStatus.error("Too old to be our customer");
			}
			return ValidationStatus.ok();
		} 
		return ValidationStatus.error("Invalid age, not a number");
	}

}
