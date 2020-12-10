import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;
import java.io.PrintStream;

public class FlammiaM_Q37_Java{
	public static void main(String[] args)throws Exception{
		File data = new File(args[0]);
		bucketsort sorter = new bucketsort();
		sorter.getMax(data);
		sorter.makeAry();
		data = new File(args[0]);
		Scanner read = new Scanner(data);
		while(read.hasNextInt()){
			int temp = read.nextInt();
			sorter.dataAry[temp]++;
		}
		PrintStream fileout = new PrintStream(new FileOutputStream(args[1], true));
		System.setOut(fileout);
		for(int i=0;i!=sorter.maxInt;i++){
			if(sorter.dataAry[i] > 0){
				for(int j=0;j<sorter.dataAry[i];j++){
					System.out.println(i);
				}
			}
		}
		fileout.close();
	}
}
class bucketsort{
	int maxInt;
	int dataAry[];
	
	bucketsort(){
		maxInt = 0;
	}
	
	void getMax(File data)throws Exception{
		this.maxInt = 0;
		Scanner read = new Scanner(data);
		while(read.hasNextInt()){
			int temp = read.nextInt();
			if(temp > this.maxInt){
				this.maxInt = temp;
			}
		}
	}
	void makeAry(){
		this.dataAry = new int[this.maxInt + 1];
	}
}