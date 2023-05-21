package DataStructures.SelfStudy;

public class MaxHeap 
{

    private int[] heapArray;
    private int size;

    public MaxHeap()
    {
        heapArray = new int[2];
         size = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int getSize()
    {
        return size;
    }

    private void resizeArray()
    {
        int[] resizeArray = new int[heapArray.length * 2]; //double the size of the heap array

        if(resizeArray != null)
        {
            for(int i = 0; i < heapArray.length; i++)      
                resizeArray[i] = heapArray[i]; //copy the contents from the heap array to the new array
            
            heapArray = resizeArray;
        }
    }

    private void percolateUp(int nodeIndex)
    { 
        while(nodeIndex > 0 ) //iterate to the top of the heap.
        {
            int parentIndex = (nodeIndex - 1) / 2; //constantly calculate the parent's index of the nodeIndex each iteration

            if(heapArray[nodeIndex] <= heapArray[parentIndex])
                return;
            else
            {
                //perform swap between the parent and the nodeIndex
                int temp = heapArray[nodeIndex];
                heapArray[nodeIndex] = heapArray[parentIndex];
                heapArray[parentIndex] = temp;

                nodeIndex = parentIndex; //create a new loop where the parentIndex is now the nodeIndex
            }
        }
    }

    public void percolateDown(int nodeIndex)
    {
        int childIndex = (nodeIndex * 2) + 1;
        int value = heapArray[nodeIndex];  //value of the subparent

        while(childIndex < size)
        {
           int maxValue = value; //maxValue among the two childs
           int maxIndex = -1;
           int index = 0;

            //Find the node to be swapped between the two child nodes of the currentNode.
           while(index < 2 && childIndex + index < size)
           {
                if(heapArray[childIndex + index] > maxValue)
                {
                    maxValue = heapArray[childIndex + index];
                    maxIndex = childIndex + index;
                }
                index++;
           }
          
            //reorder the maxheap
            if(maxValue == value)//if maximum is unchanged, then it's now already ordered
                return;
            else
            {
                int temp = heapArray[nodeIndex];
                heapArray[nodeIndex] = heapArray[maxIndex];
                heapArray[maxIndex] = temp;

                //restart the loop with the maxIndex as the newNode;
                nodeIndex = maxIndex;
                childIndex = (nodeIndex * 2) + 1; //recalculate the new childIndex for the current newNode.
            }
        }
    }

    public void insert(int value)
    {
        if(size == heapArray.length)
            resizeArray();
        
        //add value to the end of the array
        heapArray[size] = value;
        size++;

        percolateUp(size -1); // restore to max heap format     
    }

    public int remove()
    {
        int maxVal = heapArray[0]; 

        int replaceValue = heapArray[size - 1];
        size--;
        if(size > 0)
        {
            heapArray[0] = replaceValue;

            percolateDown(0); //restore the maxHeap property.
        }

        return maxVal;
    }

    public String getHeapArrayString() 
    {
       if (size == 0) 
          return "[]";
       
       String arrayString = String.format("[%d", heapArray[0]);
       for (int i = 1; i < size; i++) 
          arrayString += (", " + heapArray[i]);

       return arrayString + "]";
    }

/************************************************************************ */
    public static void main(String[] args) 
    {
        MaxHeap test = new MaxHeap();

        test.insert(20);
        test.insert(15);
        test.insert(11);
        test.insert(6);
        test.insert(9);
        test.insert(7);
        test.insert(2);
        test.insert(3);
        test.insert(1);
        test.insert(5);
        test.insert(4);
        test.insert(41);
        test.insert(91);
        
        System.out.println();
        System.out.println(test.getHeapArrayString());
        System.out.println("Size: " + test.size);
        System.out.println("maximum value  removed: " + test.remove());
        System.out.println(test.getHeapArrayString());
    }    
}
