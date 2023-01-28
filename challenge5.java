import java.lang.Thread;

class mainThread extends Thread{
	private int basicsalary;
	private int finalsalary;
	private int payPerDay;
	private int numOfDays;
	private int allowance;
	private int EPF;

	public mainThread(int payPerDay, int numOfDays){
		this.payPerDay = payPerDay;
		this.numOfDays = numOfDays;
	}

	public void run(){
		try{
		basicsalary = payPerDay*numOfDays;
		thread1 t1 = new thread1(basicsalary);
		thread2 t2 = new thread2(payPerDay);
		t1.start();
		t2.start();
		if(t1.isAlive() == false && t2.isAlive() == false){
			allowance = t1.getAllowance();
			EPF = t2.getEPF1();
			finalsalary = basicsalary+allowance+EPF;
			System.out.println("Final Salary is : "+finalsalary);
		}
		t1.sleepMethod();
		t2.sleepMethod();
		}
		catch(InterruptedException e){}
	}
}

class thread1 extends Thread{
	private int basicsalary;
	private int allowance;

	public thread1(int basicsalary){
		this.basicsalary = basicsalary;
	}

	public int getAllowance(){
		return allowance;
	}

	public void run(){
		allowance = basicsalary*5/100;
		System.out.println("Allowance: "+allowance);
	}
}

class thread2 extends Thread{

	private int payPerDay;
	private int EPF;

	public thread2(int payPerDay){
		this.payPerDay = payPerDay;
	}

	public int getEPF1(){
		return EPF;
	}

	public void run(){
		EPF = (payPerDay*30*12/100)-(payPerDay*30*8/100);
		System.out.println("EPF : "+EPF1);
	}
}

public class challenge5{
	public static int payPerDay = 5000;
	public static int numOfDays = 15;
	
	public static void main(String[] args){
		mainThread mt = new mainThread(payPerDay,numOfDays);
		System.out.println("Basic Salary = Per Day Payment * Number of Days");
		System.out.println("Allowance = 5% of Basic Salary");
		System.out.println("EPF = (12% of PerDayPayment*30) - (8% of PerDayPayment*30)");
		System.out.println("Final Salary = Basic salary + Allowance + EPF");
		mt.start();
	}
}
