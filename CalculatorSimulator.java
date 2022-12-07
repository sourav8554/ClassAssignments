package com.cognizant.tax;
import java.util.*;
/* Problem Statement 1:
Develop a simple java application to calculate the tax for a particular employee based on his salary.
Develop  a  class  named  “TaxCalculator" with a method named calculateTax with the following method parameters,
Variable Name	   Data Type
  empName			String
  isIndian			boolean
  empSal			double
This method should return a double taxAmount.
The business logic for calculating the tax  is as follows, this has to be implemented inside the method,
If the employee is not a Indian
   The calculator should throw a CountryNotValidException
If the employee name is null or empty
   The calculator should throw a EmployeeNameInvalidException
If  empSal is greater than one lakh and isIndian true
taxAmount =empSal *8/100 
Otherwise  If  empSal  is between 50K and 1lakh and isIndian true
taxAmount =empSal *6/100 
Otherwise  If  empSal  is between 30 and 50 Thousand  and isIndian true
taxAmount =empSal *5/100 
Otherwise  If  empSal  is between 10 and 30 Thousand  and isIndian true
 taxAmount =empSal *4/100 
Otherwise
   The calculator should throw a TaxNotEligibleException. 
Develop a main class CalculatorSimulator  , implement the following logic in main method
1.	Execute the calculateTax Method and print the tax amount as “Tax amount is “<Tax Amount>
2.	In case the calculateTaxMethod throws exceptions, this method needs to catch the appropriate exception print the stack trace and display the following messages,
a.	Country not valid:  “The employee should be an Indian citizen for calculating tax”
b.	Employee name not valid:  “The employee name cannot be empty”
c.	Not eligible for Tax calculation:  “The employee does not need to pay tax”
The following test cases to be executed, change the data in main method and run it and verify the output messages
Test Cases	Employee Name	Employee Salary	Is Indian	Message Expected
Test Case 1		Ron				34000		False		The employee should be an Indian citizen for calculating tax.
Test Case 2		Tim				1000		True		The employee does not need to pay tax
Test Case 3		Jack			55000		True		Tax amount is 3300
Test Case 4						30000		True		The employee name cannot be empty    */	
// all sub classes of exception
class CountryNotValidException extends Exception { 										
	public CountryNotValidException(String str) {  // constructor
		super(str);}}   // "str" using to passing through super class
class EmployeeNameInvalidException extends Exception { 										
	public EmployeeNameInvalidException(String str) {
		super(str);}}
class TaxNotEligibleException extends Exception { 										
	public TaxNotEligibleException(String str) {
		super(str);}}
//class with calculateTax method
class TaxCalculator{ 														
	public double calculateTax(String empName, double empSal, boolean isIndian) 
		throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
		double taxAmount = 0;
// if employee is an indian
	if(isIndian==false) { 												
		throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");
		}
// if employee name is empty
		else if(empName==null) { 											
			throw new EmployeeNameInvalidException("The employee name cannot be empty");
		}
//calculating tax
		else if (empSal>=10000){ 
			 if(empSal>=100000 && isIndian==true)
				taxAmount=empSal*8/100;
		else if(empSal<100000 && empSal>=50000 && isIndian==true)
				taxAmount=empSal*6/100;
		else if(empSal<50000 && empSal>=30000 && isIndian==true)
				taxAmount=empSal*5/100;
		else if(empSal<30000 && empSal>=10000 && isIndian==true)
				taxAmount=empSal*4/100;
			return taxAmount;
			}
// if employee salary is too low to pay tax
		else { 														
			throw new TaxNotEligibleException("The employee does not need to pay tax");}
	}}
// main method
		public class CalculatorSimulator { 												

			public static void main(String[] args) 
					throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
// creat object of TaxCalculator
		TaxCalculator tax = new TaxCalculator(); 									
//calculate tax with different input
		{
			try {
			System.out.print("The amount is : " + tax.calculateTax("Ron",34000,false));}
		catch(CountryNotValidException u) {
			System.out.println(u.getMessage());
			}}
		{
			try {
			System.out.print("The amount is : " + tax.calculateTax("Tim",1000,true));}
		catch(TaxNotEligibleException u) {
			System.out.println(u.getMessage());
			}}
		System.out.println("The amount is : " + tax.calculateTax("Jack",55000,true));
		{
			try {
				System.out.print("The amount is : " + tax.calculateTax(null,30000,true));
		}
		catch(EmployeeNameInvalidException u) {
			System.out.println(u.getMessage());
			}}}}
