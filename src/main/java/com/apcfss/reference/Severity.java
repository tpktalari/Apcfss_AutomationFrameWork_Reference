package com.apcfss.reference;

public enum Severity {
	HIGH(5), LOW(2), MEDIUM(1), CRITICAL(0);
	private int fixinghours;
	private Severity(int hours) {
		fixinghours=hours;
	}
}
