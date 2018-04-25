import java.io.*;
import java.util.*;
class strengthred{
	static String input;
	static long count;
	static long temp;
	public static void main(String[] args) throws IOException{
		System.out.println("for(i=1;i<500;i++) \n Enter expression within for loop");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		String [] inputarr = input.split(" ");
		String result = inputarr[0];
		String equal = inputarr[1];
		String op1 = inputarr[2];
		String operator = inputarr[3];
		String op2 = inputarr[4];

		System.out.println("Before strength reduction \n");

		double startTime = System.nanoTime();
		long val = Integer.parseInt(op2);
		if(operator.equals("*")){
			for(int i=1;i<=500; i++)
				count = i * val;
			System.out.println(count);
		}

		if(operator.equals("^")){
			for(int i=1;i<500; i++)
				count = i ^ val;
			System.out.println(count);
		}

		double endTime = System.nanoTime();
		System.out.println("time taken = " + (endTime - startTime));


		System.out.println("After strength reduction - working \n");


			if(operator.equals("*")){ 
				System.out.println("temp = "+ op2);
				System.out.println("for(i=1;i<50;i++) {");
				System.out.println(result + " = temp");
				System.out.println("temp = "+"temp + "+ op2);
				System.out.println("} \n result");

				startTime = System.nanoTime();
				val = Integer.parseInt(op2);
				if(operator.equals("*")){
					temp = val;
					for(int i=1;i<=500; i++){
						count = temp;
						temp = temp + val;
					}

					System.out.println(count);
					endTime = System.nanoTime();
					System.out.println("time taken = " + (endTime - startTime));
				}

			}
			else{
				System.out.println("temp ="+ op2);
				System.out.println("for(i=1;i<50;i++)");
				System.out.println(result + " = temp");
				System.out.println("temp = "+"temp * "+ op2);
				System.out.println("} \n result");

				startTime = System.nanoTime();
				val = Integer.parseInt(op2);
				if(operator.equals("^")){
					temp = val;
					for(int i=1;i<500; i++){
						count = temp;
						temp = temp * val;
					}

					System.out.println(count);
					endTime = System.nanoTime();
					System.out.println("time taken = " + (endTime - startTime));
				}
			}

	}
}

/*

javac strengthred.java
sohams-MacBook-Pro:codeopt sohamjigneshchitalia$ java strengthred
for(i=1;i<500;i++) 
 Enter expression within for loop
count = i * 5
Before strength reduction 

2500
time taken = 303980.0
After strength reduction - working 

temp = 5
for(i=1;i<50;i++) {
count = temp
temp = temp + 5
} 
 result
2500
time taken = 66219.0


*/