package user;

import java.util.Date;

/**
 * �û�����model��
 * @author KL
 *
 */
public class User {  
    private int userId; 
    private String userName; 
    private String userPwd;
    private String userEmail;
    private String userPhone;
    private String userSex;
    private String userCity;
    private int userStatus;//����״̬ 
    private String validateCode;//������ 
    private Date  userRegdata;//ע��ʱ�� 
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
	public Date getUserRegdata() {
		return userRegdata;
	}
	public void setUserRegdata(Date userRegdata) {
		this.userRegdata = userRegdata;
	}
    
}
