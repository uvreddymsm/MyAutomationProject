package com.applaudGS.automation.modules.general;

import java.util.Scanner;

import org.testng.annotations.Test;

import com.itextpdf.text.log.SysoCounter;

public class BasicPrograms {
	
	@Test(description="Print Alphabets", enabled=false)
	public void sample(){
		for(char i='a';i<='z';i++){
			System.out.println(i);
		}
	}
	
	@Test(description="Print Tables Based On The Number", enabled=false)
	public void table(){
		int n,c;
		System.out.println("Please Enter The Numer : ");
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		for(c=1;c<=10;c++){
			System.out.println(n+"*"+c+"="+(n*c));
		}
	}
	
	@Test(description="Check Given No is Even or Not")
	public void evenornot(){
		int n;
		System.out.println("Please Enter The Number: ");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		if(n%2==0){
			System.out.println("GIven No is Even");
		}
		else
		{
			System.out.println("GIven No is Not Even");
		}
	}

}
