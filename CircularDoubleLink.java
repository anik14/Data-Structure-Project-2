/*
File: CircularDoubleLink.java
Author: Mohammad Islam
Date: 10/04/16
HW: 2
Description: CircularDoubleLink class.
Worked with ZJ Zhang, Abdullah Alkhudhayr
*/

public class CircularDoubleLink
{
   private int size = 0;
   private Node<Term> head;
   private Node<Term> tail;
   
    public boolean add(Term data)
   {
      add(data,size);
      return true;
   }
   
   public void add(Term data, int index)
   {
      if(index<0 || index>size)
         throw new IndexOutOfBoundsException(Integer.toString(index));
      Node<Term> temp = getNode(index-1);
      if(size == 0)
         addFirst(data);
      else
         addAfter(data, temp);
   }
   


      private void addFirst(Term data)
   {
      Node<Term> temp = new Node(data, head);
      head = temp;
      if(temp.next!=null)
      {
         temp.next.prev = temp;
         temp = temp.next;
      }
      Node<Term> poly = getNode(size);
      poly.next = head;
      size++;
   }
   
   private void addAfter(Term data, Node<Term> node)
   {
      Node<Term> temp = new Node(data);
      temp.next = node.next;
      temp.prev = node;
      if(temp.next != null)
      {
         temp.next.prev = temp;
         temp.prev.next = temp;
      }
      
      size++;
   }
   
   private Term removeFirst()
   {
      Node<Term> temp = head;
      if(temp != null)
      {
         head = temp.next;
         temp.next.prev = null;
         temp.prev.next = null;
         temp.next=null;
         temp.prev=null;
         size--;
         
         Node<Term> poly = getNode(size-1);
         poly.next = head;
         head.prev = poly;
         return temp.data;
      }
      else
         return null;
   }
   private Term removeAfter(Node<Term> node)
   {
      Node<Term> temp = node.next;
      if(temp != null)
      {
         node.next = temp.next;
         node.next.prev = null;
         node.next.next = null;
         temp.next.prev = temp.prev;
         
         size--;
         
         Node<Term> poly = getNode(size-1);
         poly.next = head;
         head.prev = poly;
         return temp.data;
      }
      else
         return null;
   }
   public boolean removeLast()
   {
      Node<Term> temp = getNode(size-2);
      temp.next = null;
      size--;
      return true;
   }
   
   public int getSize()
   {
      return size;
   }


   public String toString()
   {
      Node<Term> nodeRef = head;
      StringBuilder result = new StringBuilder();
      int x = 0;
      while(x<size)
      {
         result.append(nodeRef.data);
         
            result.append("==>");
         nodeRef = nodeRef.next;
         x++;
      }
      return result.toString();
   }
   
   private Node<Term> getNode(int index)
   {
      Node<Term> temp = head;
      for(int i=0; i<index && temp != null; i++)
         temp = temp.next;
      return temp;
   }
   
        
   public boolean changeNodes (int i, int j)
   {
      Node<Term> temp1 = getNode(i);
      Term data1 = getNode(i).data;
      Node<Term> temp2 = getNode(j);
      
      temp1.data = temp2.data;
      temp2.data = data1;
      return true;
   }
   
   public Term get(int index)
   {
      if(index<0 || index>size)
         throw new IndexOutOfBoundsException(Integer.toString(index));
      Node<Term> temp = getNode(index);
      return temp.data;
   }
   
   public Term set(Term data, int index)
   {
      if(index<0 || index>size)
         throw new IndexOutOfBoundsException(Integer.toString(index));
      Node<Term> temp = getNode(index);
      temp.data = data;
      return temp.data;
   }
   private class Node<Term>
   {
      private Term data;
      private Node<Term> next;
      private Node<Term> prev;
      
      private Node(Term data)
      {  
         this.data = data;
      }
      
      private Node(Term data, Node<Term> node)
      {
         this.data = data;
         this.next = node;
      }
   }
   
   
  }