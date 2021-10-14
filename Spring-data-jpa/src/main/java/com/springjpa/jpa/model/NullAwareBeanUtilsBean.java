package com.springjpa.jpa.model;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

public class NullAwareBeanUtilsBean extends BeanUtils{

	public void copyProperties(Object dest, String name, Object value) throws BeansException {
		 if (value == null)
	            return;
	}
}
