package dhariwal;

import java.util.ArrayList;

public class Total {
	ArrayList<String> Bill = new ArrayList<String>();
	
	//Getters and Setters
	public ArrayList<String> getBill() {
		return Bill;
	}

	public void setBill(ArrayList<String> bill) {
		Bill = bill;
	}

	public ArrayList<String> raseed (String c) //raseed = another name for reciept in Hindi
	{
		Bill.add(c);
		return Bill;
	}
	
	public int size() //returns size of array
	{
		int x = 0;
		x = Bill.size();
		return x;
	}
	
	public String get(int x)
	{
		String y = new String();
		y = Bill.get(x);
		return y;
	}
}
