package cn.edu.tju.rico.model.entity;

import java.util.Date;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.user_id
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.username
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.user_group
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private Integer userGroup;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.email
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.password
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.register_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private Date registerTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.register_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String registerIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.last_login_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private Date lastLoginTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.last_login_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String lastLoginIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.login_count
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private Integer loginCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.reset_key
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String resetKey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.reset_pwd
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String resetPwd;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.error_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private Date errorTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.error_count
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private Integer errorCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.error_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String errorIp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.activation
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private Boolean activation;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.activation_code
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	private String activationCode;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.user_id
	 * @return  the value of sys_user.user_id
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.user_id
	 * @param userId  the value for sys_user.user_id
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.username
	 * @return  the value of sys_user.username
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.username
	 * @param username  the value for sys_user.username
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.user_group
	 * @return  the value of sys_user.user_group
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public Integer getUserGroup() {
		return userGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.user_group
	 * @param userGroup  the value for sys_user.user_group
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setUserGroup(Integer userGroup) {
		this.userGroup = userGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.email
	 * @return  the value of sys_user.email
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.email
	 * @param email  the value for sys_user.email
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.password
	 * @return  the value of sys_user.password
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.password
	 * @param password  the value for sys_user.password
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.register_time
	 * @return  the value of sys_user.register_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.register_time
	 * @param registerTime  the value for sys_user.register_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.register_ip
	 * @return  the value of sys_user.register_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getRegisterIp() {
		return registerIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.register_ip
	 * @param registerIp  the value for sys_user.register_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp == null ? null : registerIp.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.last_login_time
	 * @return  the value of sys_user.last_login_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.last_login_time
	 * @param lastLoginTime  the value for sys_user.last_login_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.last_login_ip
	 * @return  the value of sys_user.last_login_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.last_login_ip
	 * @param lastLoginIp  the value for sys_user.last_login_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.login_count
	 * @return  the value of sys_user.login_count
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public Integer getLoginCount() {
		return loginCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.login_count
	 * @param loginCount  the value for sys_user.login_count
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.reset_key
	 * @return  the value of sys_user.reset_key
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getResetKey() {
		return resetKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.reset_key
	 * @param resetKey  the value for sys_user.reset_key
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setResetKey(String resetKey) {
		this.resetKey = resetKey == null ? null : resetKey.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.reset_pwd
	 * @return  the value of sys_user.reset_pwd
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getResetPwd() {
		return resetPwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.reset_pwd
	 * @param resetPwd  the value for sys_user.reset_pwd
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setResetPwd(String resetPwd) {
		this.resetPwd = resetPwd == null ? null : resetPwd.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.error_time
	 * @return  the value of sys_user.error_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public Date getErrorTime() {
		return errorTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.error_time
	 * @param errorTime  the value for sys_user.error_time
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.error_count
	 * @return  the value of sys_user.error_count
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public Integer getErrorCount() {
		return errorCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.error_count
	 * @param errorCount  the value for sys_user.error_count
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.error_ip
	 * @return  the value of sys_user.error_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getErrorIp() {
		return errorIp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.error_ip
	 * @param errorIp  the value for sys_user.error_ip
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setErrorIp(String errorIp) {
		this.errorIp = errorIp == null ? null : errorIp.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.activation
	 * @return  the value of sys_user.activation
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public Boolean getActivation() {
		return activation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.activation
	 * @param activation  the value for sys_user.activation
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setActivation(Boolean activation) {
		this.activation = activation;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.activation_code
	 * @return  the value of sys_user.activation_code
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public String getActivationCode() {
		return activationCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.activation_code
	 * @param activationCode  the value for sys_user.activation_code
	 * @mbg.generated  Thu May 18 08:17:09 CST 2017
	 */
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode == null ? null : activationCode.trim();
	}
}