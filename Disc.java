
public class Disc 
{
	private int size;
	private Disc nextDisc;
	
	public Disc(int size)
	{
		this.size = size;
		this.nextDisc = null;
	}

	public String toString()
	{
		return "" + this.size + "(" + super.toString() + ")";
	}
	
	public Disc getNextDisc() 
	{
		return nextDisc;
	}

	public void setNextDisc(Disc nextDisc) 
	{
		this.nextDisc = nextDisc;
	}

	public int getSize() 
	{
		return size;
	}
}
