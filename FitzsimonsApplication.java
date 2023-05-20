import java.util.*;
import java.io.*;
import java.io.FileWriter;  
import java.io.IOException; 

public class FitzsimonsApplication
{
   public static void main(String[] args) {
   

      ArrayList<SeanItemType> datalist = new ArrayList<>();
      int selection = -1;
      Scanner kbd = new Scanner(System.in);
      int size = 0;
      
          
      
      
      while(selection!=0)
      {
      
         System.out.println("*****************************************************");
         System.out.println("Enter 0 to stop");
         System.out.println("Enter 1 to import CSV data file");
         System.out.println("Enter 2 to add a book");
         System.out.println("Enter 3 to list all books");
         System.out.println("Enter 4 to remove last book in database");
         System.out.println("Enter 5 to export database to text file");
         System.out.println("*****************************************************");
         
         
         selection = kbd.nextInt();
         
      
         if(selection==1)
         {
            
            
            try 
            {
              File input_file = new File("Data_Input.txt");
              Scanner myReader = new Scanner(input_file);
              while (myReader.hasNextLine()) {
                String input = myReader.nextLine();
                String[] arr = new String[3];
                arr = input.split(",");
                size = datalist.size();
                SeanItemType <String> item = new SeanItemType<String>(arr[0], arr[1], arr[2]);
                item.checkOverException(size);
                datalist.add(item);
             }
             System.out.println("File " + input_file.getName() + " imported successfully");
             myReader.close();
               } 
               catch (FileNotFoundException e) 
               {
                    System.out.println("File not found");
                    e.printStackTrace();
               }
               catch (Exception StackOverflowException)
               {
                    StackOverflowException.printStackTrace();
            
               }
            
         }   
            
            
         else if(selection==2)
         {
         
            try
            {
            String book = "";
            String author = "";
            String ISBN = "";
         
            
            System.out.println("Enter title of book: ");
            book = kbd.next();
            System.out.println("Enter author of book: ");
            author = kbd.next();
            System.out.println("Enter ISBN-10 of book: ");
            ISBN = kbd.next();
            SeanItemType data = new SeanItemType(book,author,ISBN);
            datalist.add(data);
            data.checkOverException(size);
            System.out.println("Entry added");
            
            }
            catch (Exception StackOverflowException)
            {
               StackOverflowException.printStackTrace();
            
            }   
               
                  
         }   
         
         else if(selection==3)
         {   
         
            
            
            if(size==0)
               System.out.println("No books in database");
            
            else
            
            for (int i = 0; i<datalist.size(); i++)
            {
               
              System.out.println(datalist.get(i));
            }   
               
               
               
         }      
         
         else if(selection==4)
         {   
         
            try
            {
               String input = "";
               SeanItemType <String> data = new SeanItemType<String>(input, input, input);
               data.checkUnderException(size);
               datalist.remove(datalist.size()-1);
               System.out.println("Last book in database removed");
            }
            
            catch(Exception StackUnderflowException)
            {
               StackUnderflowException.printStackTrace();
            
            }
            
           
         }
         
         else if(selection==5)
         {   
         
         try 
         {
            FileWriter myWriter = new FileWriter("Output.txt");
            for (int i = 0; i<datalist.size();i++)
            {
               myWriter.write(datalist.get(i).getData());
               myWriter.write("\n");
               
            }   
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         
          }
         
         
         }
                  
                
         else if(selection!=0)
            System.out.println("Invalid entry - please enter a valid selection: ");  

      
      }
    
      
   
   }
}      