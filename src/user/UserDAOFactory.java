package user;

/**
 * DAO������
 * @author KL
 *
 */
public class UserDAOFactory {
	
	public static IUserDAO getIUserDAOInstance() throws Exception{
		return new UserDAOProxy();
	}
	
}
