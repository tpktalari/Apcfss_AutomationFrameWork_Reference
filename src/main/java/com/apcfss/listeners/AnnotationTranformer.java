package com.apcfss.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.apcfss.utils.DataProviderUtil;

public class AnnotationTranformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getDataKeyValue");
		annotation.setDataProviderClass(DataProviderUtil.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

}
