package com.util;

import java.io.PrintWriter;

public class HtmlTemplates {
	
	public static void goBackButton(PrintWriter out){
		out.println(
				"<hr><input type='button' value='GO BACK' onclick='goBack()'>"
				+ "<script>function goBack(){ window.history.back(); }</script>"
				);
	}
	
	public static void logoutButton(PrintWriter out){
		out.println(
				"<form action=\"index.html\">\r\n" + 
				"<button type=\"submit\">Return Home</button>\r\n" + 
				"</form>"
				);
	}




			
		

}
