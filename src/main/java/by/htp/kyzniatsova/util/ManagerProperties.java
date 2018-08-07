package by.htp.kyzniatsova.util;

import java.util.ResourceBundle;

public class ManagerProperties {
	
private static final ResourceBundle rb;

	static {
		rb = ResourceBundle.getBundle("config");
	}

	public static String getDriver() {
		return rb.getString("web.driver");
	}
	
	public static String getPath() {
		return rb.getString("web.path");
	}
}
