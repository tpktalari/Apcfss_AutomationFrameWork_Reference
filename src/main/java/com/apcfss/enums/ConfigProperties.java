package com.apcfss.enums;

/**
 * Enums to restrict the values used on Property files. Without using enums
 * there can be null pointer exceptions happening because of typos.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfss.utils.PropertyFileUtil
 */
public enum ConfigProperties {
	URL, URLOHRM, URLAMAZON, BROWSER, OVERRIDEREPORTS, PASSEDSTEPSSCREENSHOT, FAILEDSTEPSSCREENSHOT,
	SKIPPEDSTEPSSCREENSHOT, RETRYFAILEDTESTS,RUNMODE
}
