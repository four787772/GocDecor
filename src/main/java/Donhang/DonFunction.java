package Donhang;
import java.util.ArrayList;

import object.DonObject;
import util.ConnectionPool;

public interface DonFunction {
	public boolean addDon(DonObject item);

    public boolean editDon(DonObject item);

    public boolean delDon(DonObject item);

    public DonObject getDon(int id);
    
    public DonObject getDonFull(int id);

    public ArrayList<DonObject> getAccount();

    public ArrayList<DonObject> getAccountFull();
    
    public ConnectionPool getCP();

    public void releaseConnection();
}
