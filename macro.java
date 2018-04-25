import java.util.*;
import java.io.*;

class macro{
	public static void main(String args[]) throws  IOException{
				
		int mntc=0,mdtc=0,plac=0,clac=0;//counters

		String[] mntable=new String[30];
		String[] macronamelist=new String[30];
		String[] mdtable=new String[30];
		String[] platable=new String[30];
		String[] clatable=new String[30];
		String[] argsarr;
		String[] arguments;

		BufferedReader br=new BufferedReader(new FileReader("inputmacro.txt"));
		BufferedWriter mntfile =new BufferedWriter(new FileWriter("mnt.txt",true));
		BufferedWriter mdtfile =new BufferedWriter(new FileWriter("mdt.txt",true));
		BufferedWriter plafile =new BufferedWriter(new FileWriter("pla.txt",true));
		BufferedWriter clafile =new BufferedWriter(new FileWriter("cla.txt",true));

		String temp="";
		String macroname="";
		String[] linearr;
		int i,j,flagmacro=0;
		
		while((temp=br.readLine())!=null){
			
			for(i=0;i<mntc;i++){
				if(temp.contains(macronamelist[i])){
					argsarr=temp.split(" ");
					arguments=argsarr[1].split(",");
					for(j=0;j<arguments.length;j++){
						clatable[clac++]=arguments[j];
						clafile.write(arguments[j]);
						clafile.newLine();
					}
					break;
				}
			}

			if(flagmacro==1){
				if(temp.contains("MEND")){
					flagmacro=0;
					mdtfile.write(temp);
					mdtfile.newLine();
				}
				else{
					mdtable[mdtc++]=temp;
					mdtfile.write(temp);
					mdtfile.newLine();
				}
			}
			
			if(temp.contains("MACRO")){
				flagmacro=1;
				linearr=temp.split(" ");
				macroname=linearr[1];
				macronamelist[mntc]=macroname;
				mntable[mntc]=mntc+" "+macroname;
				mntfile.write(mntable[mntc]);
				mntfile.newLine();
				mntc++;
				for(i=2;i<linearr.length;i++){
					if(linearr[i].charAt(0)=='&'){
						//means it is an argument
						if(i==linearr.length-1)
							platable[plac]=plac+" "+linearr[i];
						else
							platable[plac]=plac+" "+linearr[i].substring(0,linearr[i].length()-1);
						plafile.write(platable[plac]);
						plafile.newLine();
						plac++;
					}
				}
			}

		}

		System.out.print("\n\nMACRO NAME TABLE");
		for(i=0;i<mntc;i++){
			System.out.print("\n"+mntable[i]);
		}

		System.out.print("\n\nMACRO DEFIINITION TABLE");
		for(i=0;i<mdtc;i++){
			System.out.print("\n"+mdtable[i]);
		}

		System.out.print("\n\nPREVIOUS ARGUEMENT LIST ARRAY");
		for(i=0;i<plac;i++){
			System.out.print("\n"+platable[i]);
		}

		System.out.print("\n\nCURRENT ARGUEMENT LIST ARRAY");
		for(i=0;i<clac;i++){
			System.out.print("\n"+clatable[i]);
		}
		br.close();
		mntfile.close();
		mdtfile.close();
		plafile.close();
		clafile.close();
	}
}
