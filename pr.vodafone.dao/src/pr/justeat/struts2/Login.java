package pr.justeat.struts2;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p> Validate a user login. </p>
 */
public  class Login  extends ActionSupport {


    public String execute() throws Exception {
        System.out.println("Validating login");
		if (getUsername() == null || getPassword() == null) {
			addActionError("Compulsory to specify both username and password!");
			return INPUT;
		}
		
		if((getUsername().equals("1") && getPassword().equals("1") 
				|| (getUsername().equals("2") && getPassword().equals("2")) 
				|| (getUsername().equals("3") && getPassword().equals("3")))) {
			return SUCCESS;
		}else {
			addActionError(getText("invalid_login_details"));
            return ERROR;
		}
	}


    // ---- Username property ----

    /**
     * <p>Field to store User username.</p>
     * <p/>
     */
    private String username = null;


    /**
     * <p>Provide User username.</p>
     *
     * @return Returns the User username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>Store new User username</p>
     *
     * @param value The username to set.
     */
    public void setUsername(String value) {
        username = value;
    }

    // ---- Username property ----

    /**
     * <p>Field to store User password.</p>
     * <p/>
     */
    private String password = null;


    /**
     * <p>Provide User password.</p>
     *
     * @return Returns the User password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>Store new User password</p>
     *
     * @param value The password to set.
     */
    public void setPassword(String value) {
        password = value;
    }

}
