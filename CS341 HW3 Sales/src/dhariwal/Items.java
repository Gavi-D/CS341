package dhariwal;

public class Items {
	String Item = new String();

	//Setters and Getters
	public String getItem() {
		return Item;
	}

	public void setItem(String item) {
		Item = item;
	}
	
	public String reciept(String i, String c, String q)
	{
		Item = i + "	$" + c + "	" + q + " pc(s)\n";
		return Item;
	}
	
}
