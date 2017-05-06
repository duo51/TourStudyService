package user;

/**
 * DAOπ§≥ß¿‡
 * @author KL
 *
 */
public class UserDAOFactory {
	
	public static IUserDAO getIUserDAOInstance() throws Exception{
		return new UserDAOProxy();
	}
	
}
