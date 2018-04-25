import java.util.*;
import java.io.*;

public class CodeOpt{

	public static void constantprop(String[] equations, int number)
	{
		String[] replacements = new String[10];
		int count = 0;
		for(int i=0; i<number; i++)
		{
			String equation = equations[i];
			if(equation.contains("^")||equation.contains("*")||equation.contains("/")||equation.contains("+")||equation.contains("-"))
			{
				for(int j=0; j<count; j=j+2)
				{
					if(equations[i].contains(replacements[j]))
					{
						equations[i] = equations[i].replaceAll(replacements[j], replacements[j+1]);
					}
				}
				System.out.println(equations[i]);
			}
			else
			{
				int equalIndex = equation.indexOf("=");
				int spaceIndex =equation.indexOf(" ");
				replacements[count] = equation.substring(spaceIndex+1, equalIndex);
				count++;
				replacements[count] = equation.substring(equalIndex+1, equation.length()-1);
				count++;
				System.out.println(equations[i]);
			}
		}
	}

	public static void codeMovement(String[] equations, int number)
	{
		//assuming it is a for statement with "i" inside..
		String[] after = new String[10];
		int count=0;
		for(int i=0; i<number; i++)
		{
			String equation = equations[i];
			if(equation.contains("i")||equation.equals("{")||equation.equals("}"))
			{
				after[count] = equation;
				count++;
			}
			else
			{
				System.out.println(equation);
			}
		}
		for(int i=0; i<count; i++)
		{
			System.out.println(after[i]);
		}
	}

	public static void main(String[] args) throws IOException
	{
		InputStreamReader r=new InputStreamReader(System.in);    
    	BufferedReader br=new BufferedReader(r);  
    	Scanner sc = new Scanner(System.in);  
		/*System.out.println("Enter number of lines of the statement.");
		int n = sc.nextInt();
		String[] statements = new String[n];
		for(int i=0; i<n; i++)
		{
			statements[i] = br.readLine();    
		}
		constantprop(statements, n);*/
		System.out.println("Enter number of lines of the statement.");
		int n = sc.nextInt();
		String[] statements = new String[n];
		for(int i=0; i<n; i++)
		{
			statements[i] = br.readLine();    
		}
		codeMovement(statements, n);
	}
}
