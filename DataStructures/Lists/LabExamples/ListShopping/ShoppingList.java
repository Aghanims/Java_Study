package DataStructures.Lists.LabExamples.ListShopping;

public class ShoppingList
{
    //Array-based List

   public void add(Item item)
   {
      /* 
      Requirements: 
    
         1. if null item is not allowed: do nothing if null
         2. if the list is full, double the array size-dynamic array allocation
         3. No duplicated items-all items' names must be unique. If an item with the same name
            already exists in the list, simply add quantity to the existing item in the list
         4. insert the item to the array to maintain sorted-items are sorted based on item names. 
      */

      boolean judge = false;

      //if null item is not allowed: do nothing if null
      if(item != null)
      {
         // if the list is full, double the array size-dynamic array allocation
         if ( list.length == numberOfItems) 
         {
            doubling();
         }
            
         //No duplicated items-all items' names must be unique. 
         for(int i = 0; i < numberOfItems; i++)
         {
            Item compareItem = list[i];

            //If an item with the same name already exists in the list, simply add quantity to the existing item in the list
            if(item.getName().equalsIgnoreCase(compareItem.getName()))
            {
               list[i].setQuantity(item.getQuantity() + list[i].getQuantity());
               judge = true;
                        
               break; 
            }
         }

         //insert the item to the array 
         if(!judge)
         {
            list[numberOfItems] = item;
            numberOfItems++;
         }

         // maintain sorted-items are sorted based on item names.
         for (int i = 1; i < numberOfItems; i++) 
         {
            int j = i;

            while (j > 0 && list[j].compareTo(list[j - 1]) < 0 ) 
            {
               // Swap numbers[j] and numbers [j - 1]
               Item temp = list[j];
               list[j] = list[j - 1];
               list[j - 1] = temp;
               j--;
            }
         }   
      }
   }
   
   public void remove(Item item)
   {
      //remove all items with the same name.
      /* 
	Requirements: 
  
      1. If item not found(item name), display the item does not exists in the list
      	otherwise, remove the item from the list.
      2. Hint: You do need to shift all items after removed one.
     */

     boolean itemFound = false;
     int index = 0; //index of item to be removed

     for(int i = 0; i < numberOfItems; i++)
     {
         Item twin = list[i];

         if(item.getName().equalsIgnoreCase(twin.getName()))
         {
            itemFound = true;
            index = i;

            break;
         }
     }

     //If item not found(item name), display the item does not exists in the list
     if(!itemFound)
     {
         System.out.println("Item does not exists in the list");
     }
     else //otherwise, remove the item from the list.
     {
       // Shift down all items after the given index
       for (int i = index; i < numberOfItems - 1; ++i) 
       {
          list[i] = list[i + 1];
       }

       // Update the array's length
       numberOfItems--;
     }

   }
   
   public void remove(String name)
   {	
      // remove item by its name
      /* 
	Requirements: 

      	1. If item not found(item name), display the item does not exists in the list
      	   otherwise, remove the item from the list.
      	2. Hint: You do need to shift all items after removed one.
     */

     boolean itemFound = false;   
     int index = 0; //index of name to be removed

     for(int i = 0; i < numberOfItems; i++)
     {
         String twin = list[i].getName();

         if(name.equalsIgnoreCase(twin))
         {
            itemFound = true;
            index = i;

            break;
         }
     }
     

     if(!itemFound)
     {
         System.out.println("Item does not exists in the list");
     }
     else
     {
         // Shift down all items after the given index
         for (int i = index; i < numberOfItems - 1; ++i) 
         {
            list[i] = list[i + 1];
         }
 
         // Update the array's length
         numberOfItems--;
     }

   }
   
   //*****************DONOT modify codes below this line****************************
   private Item[] list;
   private int numberOfItems;
   
   public ShoppingList(int initialSize)
   {
      list=new Item[initialSize];
   }
   private void doubling()
   {
      //Double the list size but keep all items in the list.
      Item[] tmp=new Item[list.length*2];
      for(int i=0; i<list.length; i++){
         tmp[i]=list[i];
      }
      list=tmp;
   }
   
   public int indexOf(Item item)
   {
      // return the index of the item that has the same item name in the list array, return -1 if not found
      for(int i=0; i<numberOfItems; i++)
      {
         if(list[i].compareTo(item)==0)
            return i;
      }
      return -1; // not found
   }

   public int indexOf(String name)
   {
      // return the index of the item that has the same item name in the list array, return -1 if not found
      name=name.toLowerCase();

      for(int i=0; i<numberOfItems; i++)
      {
         if(list[i].getName().toLowerCase().compareTo(name)==0)
            return i;
      }
      return -1; // not found
   }

   public boolean isFull()
   {
      return numberOfItems==list.length;
   }

   public boolean isEmpty()
   {
      return numberOfItems==0;
   }

   public int size()
   {
      return numberOfItems;
   }

   public void printNames()
   {
      System.out.print("[");
      for(int i=0; i<numberOfItems; i++)
      {
         System.out.print(list[i].getName());

         if(i<numberOfItems-1)
            System.out.print(", ");
      }
      System.out.println("]");
   }
   
   public void print()
   {
      for(int i=0; i<numberOfItems; i++)
      {
         System.out.println((i+1)+". "+list[i].toString());
      }
   }
   public void printItems()
   {
      for(int i=0; i<numberOfItems; i++)
      {
         System.out.printf("%3s%-16s%3d %.2f\n",""+(i+1)+". ",list[i].getName(),list[i].getQuantity(), list[i].getUnitPrice());
      }
   }

   public Item[] getList()
   {
      return list;
   }


   public static void main(String[] args) 
   {
    Item item = new Item("Toothpaste", 3, 2);
    Item name = new Item("Razer", 2, 3);
    Item name2 = new Item("All", 5, 2);
    Item name3 = new Item("Toothpaste", 3, 2);

    ShoppingList entry = new ShoppingList(4);

    entry.add(item);
    entry.add(name);
    entry.add(name2);
    entry.add(name3);

    entry.printItems();
   
    System.out.println();
    entry.remove("All");

    entry.printItems();
   }
}
