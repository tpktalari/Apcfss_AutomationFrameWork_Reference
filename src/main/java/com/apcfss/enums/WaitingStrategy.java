package com.apcfss.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before
 * operating an element.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfss.factories.ExplicitWaitFactory
 * @see com.apcfss.pages.BasePage
 */
public enum WaitingStrategy {
	CLICKABLE, PRESENCE, VISIBLE, NONE
}
