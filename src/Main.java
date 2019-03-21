import java.util.Scanner;

public class Main
{
	Scanner sc = new Scanner(System.in);
	String reader;
	
	public static void main(String[] args)
	{
		Main m = new Main();
		
		int items = m.ReadInt("How many items?");
		
		if (items <= 0)
		{
			System.out.println("Must be greater than 0");
			return;
		}
		
		int vmax = 0, vmin = 0;
		double wmax = 0, wmin = 0;
		boolean isLesser = true;
		
		while (isLesser)
		{
			vmax = m.ReadInt("Maximum value range:");
			vmin = m.ReadInt("Minumum value range:");
			
			if (vmax > vmin)
			{
				isLesser = false;
			}
			else
			{
				System.out.println("Maximum value must be greater than minimum");
			}
		}
		
		if (vmax <= 0)
		{
			System.out.println("Must be greater than 0");
			return;
		}
		if (vmin <= 0)
		{
			System.out.println("Must be greater than 0");
			return;
		}
		
		isLesser = true;
		while (isLesser)
		{
			wmax = m.ReadDouble("Maximum weight range:");
			wmin = m.ReadDouble("Minimum weight range:");
			
			if (wmax > wmin)
			{
				isLesser = false;
			}
			else
			{
				System.out.println("Maximum value must be greater than minimum");
			}
		}
		
		if (wmax <= 0)
		{
			System.out.println("Must be greater than 0");
			return;
		}
		if (wmin <= 0)
		{
			System.out.println("Must be greater than 0");
			return;
		}
		double alfa = m.ReadDouble("Alfa value:");

		if (alfa <= 0)
		{
			System.out.println("Must be greater than 0");
			return;
		}
		
		//System.out.println(String.format("%s %s %s %s %s %s %s %s", sufix, instances, items, vmax, vmin, wmax, wmin, alfa));
		Generator g = new Generator(items, vmax, vmin, wmax, wmin, alfa);
		
		System.out.println("Ready");
	}
	
	public double ReadDouble(String question)
	{
		reader = "";
		while (!this.isDouble(reader))
		{
			System.out.println(question);
			reader = sc.nextLine();
		}
		
		return new Double(reader);
	}
	
	public int ReadInt(String question)
	{
		reader = "";
		while (!this.isInteger(reader))
		{
			System.out.println(question);
			reader = sc.nextLine();
		}
		
		return new Integer(reader);
	}
	
	public boolean isDouble(String str)
	{
		try
		{
			double d = Double.parseDouble(str);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
	
	public boolean isInteger(String str)
	{
		try
		{
			Integer i = Integer.parseInt(str);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
}
