import java.util.*;

public class SeanItemType <T extends Comparable<T>> implements StackOverflowInterface, StackUnderflowInterface
{

   
   private T title;
   private T author;
   private T ISBN;
   private int size;
   
   
   
   public SeanItemType (T x, T y, T z)
   {
   
      this.title = x;
      this.author = y;
      this.ISBN = z;
   
   }
   
   public SeanItemType (int a)
   {
      this.size = a;
   
   }
   
   public String getData() 
   {
        return this.title + "," + this.author + "," + this.ISBN;
   }
   

   @Override
   public String toString() 
   {
        return this.title + ", " + this.author + ", " + this.ISBN;
   }
   
   public void checkOverException (int a) throws StackOverflowException
   {
      if (a>100)
      {
         throw new StackOverflowException("database cannot have more than 100 books stored");  
      
      }
   
   
   }
   
   public void checkUnderException (int a) throws StackUnderflowException
   {
      if (a<=0)
      {
          throw new StackUnderflowException("no values left in database");
      }
   }

   

}