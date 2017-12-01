package webApplication;

public class UserValidationService {
	
	public boolean isValidUser(String user,String password)
	{
		
		if(user.equals("renuraj") && password.equals("iasuner"))
			return true;
		return false;
		
	}
	
	

}
