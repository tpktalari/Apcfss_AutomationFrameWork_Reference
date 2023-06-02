package com.apcfss.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.apcfss.enums.CategoryType;

/**
 * Framework Annotation is user built annotation which is annotated on top of
 * test methods to log the author details and category details to the extent
 * report.
 * <p>
 * 
 * Runtime retention value indicate that this annotation will be available at
 * run time for reflection operations.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfss.tests
 * @see com.apcfss.enums.CategoryType
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotations {
	/**
	 * Store the authors who created the tests in String[] Mandatory to enter
	 * atleast a value
	 * 
	 * @author Pavan Kumar T
	 * @return array of authors provided in test script
	 */
	public String[] author();

	/**
	 * Stores the category in form of Enum Array. Include the possible values in
	 * {@link com.apcfss.enums.CategoryType}
	 * 
	 * @author Pavan Kumar T
	 * @return array of categories provided in test script
	 */
	public CategoryType[] category();
}
