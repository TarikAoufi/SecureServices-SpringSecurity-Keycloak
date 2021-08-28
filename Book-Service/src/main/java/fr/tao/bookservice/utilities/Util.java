package fr.tao.bookservice.utilities;

public class Util {
	
	private Util() {
		throw new IllegalStateException("Utility class");
	}
	
	/* endpoints */
	public static final String ENDPOINT_BOOKMANAGERS = "/bookmanagers";
	public static final String ENDPOINT_BOOKS = "/books";
	public static final String ENDPOINT_JWT = "/jwt";
	public static final String ENDPOINT_MANAGEACCOUNT = "/manageAccount";
	public static final String ENDPOINT_LOGOUT = "/logout";
	
	/* attributes */
	public static final String ATTRIBUTE_BOOKMANAGERS = "bookmanagers";
	public static final String ATTRIBUTE_BOOKS = "books";
	public static final String ATTRIBUTE_ERRORMESSAGE = "errorMessage";
	public static final String ATTRIBUTE_ERRORS = "errors";
	public static final String ATTRIBUTE_INDEX = "index";
	public static final String ATTRIBUTE_REFERRER = "referrer";
	public static final String ATTRIBUTE_REFERRER_URI = "referrer_uri";
	public static final String ATTRIBUTE_REDIRECT = "redirect:";
	

	public static final String URL_BOOKMANAGER_SERVICE = "http://localhost:8082/bookmanagers";
	public static final String ACCESS_TOKEN_NAME = "access_token";
	public static final String HEADER_REFERER = "referer";
	public static final String MESSAGE_PERMISSION_ISSUE = "Permission-issue Error (Insufficient access rights to perform this operation)";
	
}
