/*
File: MyPolynomial.java
Author: Mohammad Islam
Date: 10/04/16
HW: 2
Description: MyPolynomial class with methods such as add, subtract and multiply.
Worked with ZJ Zhang, Abdullah Alkhudhayr
*/

public class MyPolynomial {
   private CircularDoubleLink polynomial;
   public MyPolynomial(){
      polynomial = new CircularDoubleLink();
   }
   
   public MyPolynomial (MyPolynomial other)
   {
      polynomial = other.polynomial;
   }
	
   public MyPolynomial add(MyPolynomial poly){
      MyPolynomial Poly = new MyPolynomial();
      for (int i = 0; i < polynomial.getSize(); i++){
         Term tempTerm = new Term (polynomial.get(i).getCoefficients(), polynomial.get(i).getExponent());
         Poly.addTerm(tempTerm);
      }
      for (int i = 0; i < poly.polynomial.getSize(); i++){
         Term tempTerm = poly.polynomial.get(i);
         Poly.addTerm(tempTerm);
      }
      Poly.decOrder();
      return Poly;
   }
	
   public void addTerm(Term term){
      int expo = term.getExponent();
      int coef = term.getCoefficients();
      if (polynomial.getSize() == 0){
         polynomial.add(term);
      	
      }
      else{
         int position = findPosition(term);
      	
         if(position == polynomial.getSize()){
            polynomial.add(term);
         }
         else{
            if (expo == polynomial.get(position).getExponent()){
               Term tempTerm = polynomial.get(position);
               Term newTerm = new Term(tempTerm.getCoefficients() + coef, expo);
               polynomial.set( newTerm, position);
            }
            else{
               polynomial.add(term, position);
            }
         }
      	
      }
   	
   }
	
   public void addTerm(int coef, int expo){
   	
      Term term = new Term(coef, expo);
   	
      if (polynomial.getSize() == 0){
         polynomial.add(term);
      	
      }
      else{
         int position = findPosition(term);
      	
         if(position == polynomial.getSize()){
            polynomial.add(term);
         }
         else{
            if (expo == polynomial.get(position).getExponent()){
               Term tempTerm = polynomial.get(position);
               Term newTerm = new Term(coef, expo);
               polynomial.set( newTerm,position);
            }
            else{
               polynomial.add( term,position);
            }
         }
      	
      }
   	
   	
      int position = findPosition(term);
      if(polynomial.get(position) != null){
         if(term.getExponent() != polynomial.get(position).getExponent()){
            polynomial.add( term,position);
         }
         else{
            int tempCoef = 
               polynomial.get(position).getCoefficients();
            Term temp = new Term(tempCoef, expo);
            polynomial.set( temp,position);
         }
      }
      else{
         polynomial.set( term,position);
      }
   	
   	
   }
	
   public int findPosition(Term term){
      for (int i = 0; i < polynomial.getSize(); i++){
         if( polynomial.get(i).getExponent() <= term.getExponent() )
            return i; 
      }
      return polynomial.getSize();
   }
	
   public String toString(){
      String reStr = " ";
      for(int i = 0; i < polynomial.getSize(); i++){
         Term term = polynomial.get(i);
         int coef = term.getCoefficients();
         int expo = term.getExponent();
         if (expo == 0)
            reStr += "+"+coef  ;
         else if (coef >= 0){
            reStr += "+"+coef +"x^" + expo;
         }
         else{
            reStr += coef + "x^" + expo;
         }
      }
   
      return reStr;
   }
   public int degree()
   {
      return polynomial.get(0).getExponent(); 
   }
   public int getCoef(int exp)
   {
      for(int i=0; i<polynomial.getSize(); i++)
      {
         int exp1 =polynomial.get(i).getExponent();
         if(exp1 == exp)
            return polynomial.get(i).getCoefficients();
      }
      return 0;
   }
   public void setCoef(int coef, int exp)
   {
      int cof = 0;
      for(int i=0; i<polynomial.getSize(); i++)
      {
         int exp1 =polynomial.get(i).getExponent();
         if(exp1 == exp)
         {
            Term temp= new Term (coef,polynomial.get(i).getExponent())  ;
            polynomial.set(temp,i);
            cof = polynomial.get(i).getCoefficients();
         }
      }
      if(cof == 0  && coef != 0)
         polynomial.add(new Term(coef,exp));
   
   }
   
   public boolean equals(Object other)
   {
      if(other == null)
         return false;
      else if(getClass() != other.getClass())
         return false;
      else
      {
         MyPolynomial poly = (MyPolynomial) other;
         return this.toString().equals(poly.toString());
      }
   }
   
   public MyPolynomial subtract(MyPolynomial poly){
      MyPolynomial rePoly = new MyPolynomial();
      for (int i = 0; i < polynomial.getSize(); i++){
         Term tempTerm = new Term (polynomial.get(i).getCoefficients(), polynomial.get(i).getExponent());
         rePoly.subTerm(tempTerm);
      }
      for (int i = 0; i < poly.polynomial.getSize(); i++){
         Term tempTerm = poly.polynomial.get(i);
         rePoly.subTerm(tempTerm);
      }
      rePoly.decOrder();
      return rePoly;
   }
   public void subTerm(Term term){
      int expo = term.getExponent();
      int coef = term.getCoefficients();
      if (polynomial.getSize() == 0){
         polynomial.add(term);
      }
      else{
         int position = findPosition(term);
      	
         if(position == polynomial.getSize()){
            polynomial.add(term);
         }
         else{
            if (expo == polynomial.get(position).getExponent()){
               Term tempTerm = polynomial.get(position);
               Term newTerm = new Term(tempTerm.getCoefficients() - coef, expo);
               polynomial.set( newTerm, position);
            }
            else{
               int newCof = -1*term.getCoefficients();
               int newExp = term.getExponent();
               polynomial.add( new Term(newCof, newExp), position);
            }
         }
      }
   	
   }
   
   
   public MyPolynomial multiply(MyPolynomial poly)
   {
      MyPolynomial rePoly = new MyPolynomial();
      for (int i = 0; i < polynomial.getSize(); i++)
      {
      
         Term tempTerm = new Term (polynomial.get(i).getCoefficients(), polynomial.get(i).getExponent());
         rePoly.multTerm(tempTerm);
      }
      for (int i = 0; i < poly.polynomial.getSize(); i++){
         Term tempTerm = poly.polynomial.get(i);
         rePoly.multTerm(tempTerm);
      }
      return rePoly;
   }
   public void multTerm(Term term){
      int expo = term.getExponent();
      int coef = term.getCoefficients();
      if (polynomial.getSize() == 0){
         polynomial.add(term);
      }
      else{
         int position = findPosition(term);
      	
         if(position == polynomial.getSize()){
            polynomial.add(term);
         }
         else{
            if (expo == polynomial.get(position).getExponent()){
               Term tempTerm = polynomial.get(position);
               Term newTerm = new Term((tempTerm.getCoefficients() * coef), (tempTerm.getExponent() + expo));
               polynomial.set( newTerm, position);
            }
            else{
               polynomial.add(term, position);
            }
         }
      }
   	
   }
   
   public int evaluate (int x)
   {
      int result=0;
      for(int i=0; i<polynomial.getSize(); i++)
      {
         result += polynomial.get(i).getCoefficients()* (Math.pow(x, polynomial.get(i).getExponent()) );
      }
      return result;
   }

   public void decOrder()
   {
      for(int i=0; i<=polynomial.getSize(); i++)
      {
         for(int j=i+1; j<polynomial.getSize(); j++)
         {
            if(polynomial.get(j).getExponent()>polynomial.get(i).getExponent())
               polynomial.changeNodes(i,j);
         }
      }
   }
}