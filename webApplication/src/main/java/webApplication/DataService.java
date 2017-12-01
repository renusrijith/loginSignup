package webApplication;

public interface DataService {
	
	
	
public boolean isUserNameAvailable(String user);
public boolean addUser(User user);
public User loginUser(String username,String password);
}
