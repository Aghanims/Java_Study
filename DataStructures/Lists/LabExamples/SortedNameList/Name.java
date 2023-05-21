package DataStructures.Lists.LabExamples.SortedNameList;

public class Name implements Comparable<Name>
{

   private String firstName;
   private String lastName;

   public Name(String firstName, String lastName)
   {
      setFirstName(firstName); 
      setLastName(lastName); 
   }

   public String getFirstName()
   {
      return firstName;
   }
   
   public String getLastName()
   {
      return lastName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public int compareTo(Name n)
   {
      String lastA = lastName.toUpperCase();
      String firstA = firstName.toUpperCase();

      String lastB = n.getLastName().toUpperCase();
      String firstB = n.getFirstName().toUpperCase();
      
      if(lastA.compareTo(lastB) == 0)
      {
         return firstA.compareTo(firstB);
      }
      
      return lastA.compareTo(lastB);
   }

   public String toString()
   {
      return String.format("%15s%15s", firstName, lastName);
   }
}
