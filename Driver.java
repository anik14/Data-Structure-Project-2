/*
File: Driver.java
Author: Mohammad Islam
Date: 10/04/16
HW: 2
Description: Driver class.
Worked with ZJ Zhang, Abdullah Alkhudhayr
*/

public class Driver {
	public static void main(String[] args){
		MyPolynomial p = new MyPolynomial();
		p.addTerm(-5, 16);
		p.addTerm(9, 15);
		p.addTerm(-5, 10);
		p.addTerm(-13, 3);
      p.addTerm(4,2);
      p.addTerm(1, 1);
      
      System.out.println("Polynomial poly is: " + p.toString());
		System.out.println("Degree of polynomial poly is: " + p.degree());
		MyPolynomial pCopy = new MyPolynomial(p);
      System.out.println("poly: Coefficient of exponent 3 is: " + p.getCoef(3));
      System.out.println("poly: Get new Coefficient of exponent 20 is 800");
      p.setCoef(800,20);
      p.decOrder();
      System.out.println("poly: After setting new coefficent poly is :" + p.toString());
      System.out.println("New Polynomial newPoly is generated with copy constructor is: " + pCopy.toString());
      MyPolynomial p1 = new MyPolynomial();
		p1.addTerm(-5,5);
      p1.addTerm(-5,4);
      p1.addTerm(-21,3);
      p1.addTerm(4,2);
      p1.addTerm(10,1);
      System.out.println("Polynomial poly1 is : " + p1.toString());
      System.out.println("Polynomial poly and poly1 is equal: " + p.equals(p1));
      System.out.println("Polynomial poly and newPoly is equal: " + p.equals(pCopy));
      System.out.println("Polynomial poly1 is evalueated for x=2: " + p1.evaluate(2) );
      
      MyPolynomial p2 = new MyPolynomial();
		p2.addTerm(2,2);
      p2.addTerm(5,1);
      p2.addTerm(1,0);
       System.out.println("Polynomial poly2 is : " + p2.toString());

      MyPolynomial p3 = new MyPolynomial();
		p3.addTerm(4,3);
      p3.addTerm(2,2);
      p3.addTerm(1,1);
      p3.addTerm(1,0);
      System.out.println("Polynomial poly3 is : " + p3.toString());
      System.out.println("Polynomial poly4 (poly2+poly3) is: " + p2.add(p3) );
      System.out.println("Polynomial poly5 (poly2-poly3) is: " + p2.subtract(p3) );
      System.out.println("Polynomial poly6 (poly2*poly3) is: " + p2.multiply(p3));


      
     	}
}
