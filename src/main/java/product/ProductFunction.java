package product;

import java.util.ArrayList;

import object.DealObject;
import util.ConnectionPool;

public interface ProductFunction {
	public boolean addDeal(DealObject item);

    public boolean editDeal(DealObject item);

    public boolean delDeal(DealObject item);

    public DealObject getDeal(int id);

    public ArrayList<DealObject> getAccount();


    public ConnectionPool getCP();

    public void releaseConnection();

}
