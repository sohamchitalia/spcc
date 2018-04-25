import java.util.*;
import java.io.*;

public class codeGen {
	public static void main(String[] args) {
		int i,j,n;
		System.out.println("Enter no of statements");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String[] eq = new String[n];
		int regno = 0 ;
		System.out.println("enter the equations");
		for(i=0;i<n;i++)
		{
			eq[i] = sc.next();
		}
		for(i=0;i<n;i++) {
			regno = genCode(eq[i], regno);
		}

	}
	private static int genCode(String eq, int regno) {
		int flag = checkType(eq);
		String op = "";
		int opIndex=0,eqIndex;
		int len = eq.length();
		if(flag==0) {
			eqIndex = eq.indexOf("=");
			//eqn type = 3ac
			if(eq.contains("*")) {
				op = "MUL";
				opIndex = eq.indexOf("*");
			}
			else if(eq.contains("/")) {
				op = "DIV";
				opIndex = eq.indexOf("/");
			}
			else if(eq.contains("+")) {
				op = "ADD";
				opIndex = eq.indexOf("+");
			}
			else if(eq.contains("-")) {
				op = "SUB";
				opIndex = eq.indexOf("-");
			}
			System.out.println("MOV R" + regno + " , " + eq.substring(opIndex+1,len-1));
			System.out.println("MOV R" + (regno+1) + " , " + eq.substring(eqIndex+1,opIndex));
			System.out.println(op + " R" + regno + " ,R" + (regno + 1));
			System.out.println("MOV " + eq.substring(0,eqIndex) + " ,R" + regno);
			regno = regno + 2;
			return regno;
		}
		else {
			eqIndex = eq.indexOf("=");
			System.out.println("MOV R" + regno + " , " + eq.substring(eqIndex+1,len-1));
			System.out.println("MOV " +  eq.substring(0,eqIndex) + " ,R"  + regno);
			regno = regno + 1;
			return regno;
		}
	}

	private static int checkType(String line) {
        if(line.contains("*") || line.contains("/") ||line.contains("+") ||line.contains("-")) {
        	return 0; //implies eqn type is 3ac
        }
        return 1; //implies eqn type is direct assignment
	}
}

/*
OUTPUT:
C:\Users\Niti123\Desktop\coding\spcc>javac codeGen.java
C:\Users\Niti123\Desktop\coding\spcc>java codeGen
Enter no of statements
2
enter the equations
ter=ge+tb;
a=jk;
MOV R0 , tb
MOV R1 , ge
ADD R0 ,R1
MOV ter ,R0
MOV R2 , jk
MOV a ,R2
C:\Users\Niti123\Desktop\coding\spcc>java codeGen
Enter no of statements
3
enter the equations
a=b*t1;
d=g;
e=r-y;
MOV R0 , t1
MOV R1 , b
MUL R0 ,R1
MOV a ,R0
MOV R2 , g
MOV d ,R2
MOV R3 , y
MOV R4 , r
SUB R3 ,R4
MOV e ,R3
*/