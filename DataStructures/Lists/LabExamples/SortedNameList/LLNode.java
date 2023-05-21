package DataStructures.Lists.LabExamples.SortedNameList;

public class LLNode
{

   private Name name;
   private LLNode next;

   public LLNode()
   {
      name=null;
      next=null;
   }
   
   public LLNode(Name name, LLNode next)
   {
      setName(name); 
      setNext(next); 
   }

   public Name getName()
   {
      return name;
   }

   public LLNode getNext()
   {
      return next;
   }

   public void setName(Name name)
   {
      this.name = name;
   }

   public void setNext(LLNode next)
   {
      this.next = next;
   }

}
