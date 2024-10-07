package api.endpoints;

public class Routes {
	// base URL
	 public static String base_url="https://reqres.in/api";
	 // Create URL
	 public static String post_url=base_url+"users";
	
	 
	 
	 // get pathParameters
	 public static String get_url=base_url+"/users/{id}";
	 //getAll
	 public static String get_Allurl=base_url+"/users";
	 
	 
	 
	 
	 // put pathParameters
	 public static String put_url=base_url+"/users/{id}";
	 // delete pathParameters
	 public static String delete_url=base_url+"/users/{id}";
}
