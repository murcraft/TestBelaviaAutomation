package by.htp.kyzniatsova.util;

import java.util.ResourceBundle;

public class ManagerProperties {
	
private static final ResourceBundle rb;
//public static final String wb_driver;
//public static final String wb_p;

	static {
		rb = ResourceBundle.getBundle("config");
	}
	
//	static {
//		wb_d = rb.getString("web.driver");
//	}
//	
//	static {
//		wb_p = rb.getString("web.path");
//	}
	
	public static String getDriver() {
		return rb.getString("web.driver");
	}
	
	public static String getPath() {
		return rb.getString("web.path");
	}
}
