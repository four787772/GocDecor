package light;

import java.util.ArrayList;


import object.*;
import util.ConnectionPool;

public interface LightFunction {
	public boolean addLight(LightObject item);

	public boolean editLight(LightObject item);

	public boolean delLight(LightObject item);

	public LightObject getLight(int id);

//	public ArrayList<LightObject> getLights(LightObject similar, int at, byte total);
	public ArrayList<LightObject> getLights(int category_id);

	public ArrayList<LightObject> getLights();
	
	public ArrayList<LightObject> getAccount();
	
	public ArrayList<LightObject> get5MaxRevenue();
	
	public ArrayList<LightObject> searchProducts(String query);

	public ConnectionPool getCP();

	public void releaseConnection();
}
