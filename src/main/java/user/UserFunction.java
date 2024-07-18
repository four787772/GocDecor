package user;

import java.util.ArrayList;

import object.UserObject;
import util.ConnectionPool;

public interface UserFunction {
	public boolean addUser(UserObject item);

    public boolean editUser(UserObject item);

    public boolean delUser(UserObject item);

    public UserObject getUser(int id);

    public UserObject getUser(String username, String password);

    public ArrayList<UserObject> getUsers(UserObject similar, int at, byte total);

    public ArrayList<UserObject> getAccount();


    public ConnectionPool getCP();

    public void releaseConnection();

}
