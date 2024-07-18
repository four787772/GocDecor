package QLcustomer;

import java.util.ArrayList;

import object.CustomerObject;
import util.ConnectionPool;

public interface CustomerFunction {
	public boolean addCustomer(CustomerObject item);

    public boolean editCustomer(CustomerObject item);

    public boolean delCustomer(CustomerObject item);

    public CustomerObject getCustomer(int id);

    public CustomerObject getCustomer(String Customername, String password);

    public ArrayList<CustomerObject> getCustomers(CustomerObject similar, int at, byte total);

    public ArrayList<CustomerObject> getAccount();


    public ConnectionPool getCP();

    public void releaseConnection();

}
