import java.util.Scanner;

public class Tower 
{
	private Disc top;
	
	public Tower()
	{
		top = null;
	}
	public void on() throws Exception
	{
		Scanner input = new Scanner(System.in);
		Tower[] towerArray = new Tower[3];
		towerArray[0] = new Tower();
		towerArray[1] = new Tower();
		towerArray[2] = new Tower();
		towerArray[0].addDisc(new Disc(3));
		towerArray[0].addDisc(new Disc(2));
		towerArray[0].addDisc(new Disc(1));
		
		
		while(true)
		{
			//asking us to type something
			System.out.print("=> ");
			
			//goes to next line, gets rid of any spaces
			String val = input.nextLine().trim();
			
			//TYPED IN QUIT 
			//how to stop
			if(val.equalsIgnoreCase("quit"))
			{
				break;
			}
			
			//TYPED IN SHOW
			//should show the current state of the towers, you could show these one on top of another for simplicity
			else if(val.equalsIgnoreCase("show"))
			{
				for(int i = 0; i < towerArray.length; i++)
				{
					if(towerArray[i].top == null)
					{
						System.out.println("*******");
						System.out.println("Empty tower");
					}
					else
					{
						System.out.println("*******");
						Disc curr = towerArray[i].top;
						//for (int j = 0; j < towerArray.length; j++)
						while(curr != null)
						{
							System.out.println(curr.getSize());
							curr = curr.getNextDisc();
						}						
					}
					System.out.println("***" + i +"***");
				}
			}
			//TYPED IN MOVE
			//should prompt the user for the source tower index and the destination tower index and ATTEMPT to make that move  
			//If the move was legal, output "SUCCESS", otherwise output "FAILURE" and place the disc back on the source tower
			else if(val.equalsIgnoreCase("move"))
			{
				System.out.println("Move from tower #?");
				//asking us to type something
				System.out.print("=> ");
				
				//goes to next line, gets rid of any spaces
				String fromIndex = input.nextLine().trim();
				
				
				System.out.println("Move to tower #?");
				//asking us to type something
				System.out.print("=> ");
				
				//goes to next line, gets rid of any spaces
				String toIndex = input.nextLine().trim();
				
				
				if(towerArray[Integer.parseInt(toIndex)].top == null)
				{
					int temp = towerArray[Integer.parseInt(fromIndex)].removeDisc().getSize();
					towerArray[Integer.parseInt(toIndex)].addDisc(new Disc(temp));
					System.out.println("Successful Move");
				}
				else 
				{
					if(towerArray[Integer.parseInt(toIndex)].top.getSize() > towerArray[Integer.parseInt(fromIndex)].top.getSize())
					{
						int temp = towerArray[Integer.parseInt(fromIndex)].removeDisc().getSize();
						towerArray[Integer.parseInt(toIndex)].addDisc(new Disc(temp));
						System.out.println("Successful Move");
					}
					else
					{
						System.out.println("Failure to move");
					}
				}
				
			}
		}
	}
	
	public Disc peek()
	{
		return top;
	}
	
	public Disc removeDisc()
	{
		Disc nodeToReturn = top;
		if(this.top != null)
		{
			top = top.getNextDisc();
		}
		return nodeToReturn;
	}
	
	public boolean addDisc(Disc d)
	{
		//If the stack is empty, then it is automatically a legal move
		if(this.top == null)
		{
			top = d;
			return true;
		}
		else if(d.getSize() < this.peek().getSize())
		{
			d.setNextDisc(top);
			top = d;
			return true;
		}
		else 
		{
			return false;
		}
	}
}