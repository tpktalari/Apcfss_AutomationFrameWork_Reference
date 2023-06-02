package com.apcfss.reference;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class EnumRunner {
	public static void main(String[] args) {
		System.out.println(Severity.MEDIUM);
		
		Severity sev=Severity.CRITICAL;
		switch(sev) {
		case LOW:
			System.out.println("low lwvwl");
		case MEDIUM:
			System.out.println("medium level");
		case CRITICAL:
		System.out.println("Critical");
		}
		
		if(Severity.valueOf("CRITICAL")==Severity.CRITICAL) {
			System.out.println("comparing String and enum");
		}
		
		System.out.println("*******************");
		Severity[] a=Severity.values();
		for(Severity s:a)
		{
			System.out.println(s);
		}
		
		System.out.println("*********************");
		EnumSet<Severity> enumSet=EnumSet.of(Severity.CRITICAL,Severity.HIGH);
		System.out.println("*********************");
		
		Map<Severity, String> map=new EnumMap<Severity, String>(Severity.class);
		map.put(Severity.HIGH, "high");
		map.put(Severity.CRITICAL, "critical");
	}

}
