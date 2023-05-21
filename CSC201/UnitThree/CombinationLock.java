package CSC201.UnitThree;
//Algorithm:
// create three separate variables that represents each digit in each turn
/*
    •	A method named resetDial that resets the dial to position 0.
    •	A method named turnLeft that will turn the dial to the left a certain number of ticks from the current position. The number of ticks to turn will be passed as an input argument to this method.
    •	A method named turnRight that will turn the dial to the right a certain number of ticks from the current position. The number of ticks to turn will be passed as an input argument to this method.
    •	A method named openLock that will try to open the lock with a combination. The combination that is tried will be passed as three input arguments to this method. This method will return true if the lock opens successfully and will return false if the lock is not opened successfully.
*/
public class CombinationLock 
{
    // attribute
    private boolean unlockOrNot;
    private int[] triedValue = new int[3];
    private int currentNumber = 0;
    private int arrayPosition = 0;
    private int[] combination = new int[3];

    public CombinationLock()
    {
        this(0,0,0);
    }

    public CombinationLock(int digitOne, int digitTwo, int digitThree)
    {
        combination[0] = digitOne;
        combination[1] = digitTwo;
        combination[2] = digitThree;
    }

    public void setCombination(int digitOne, int digitTwo, int digitThree)
    {
        combination[0] = digitOne;
        combination[1] = digitTwo;
        combination[2] = digitThree;
    }

    public String getCombination()
    {
       StringBuilder combine = new StringBuilder();
       combine.append(combination[0]);
       combine.append(combination[1]);
       combine.append(combination[2]);
       return combine.toString();
    }

    public int getFirstTriedValue()
    {
        return triedValue[0];
    }
    public int getSecondTriedValue()
    {
        return triedValue[1];
    }
    public int getThirdTriedValue()
    {
        return triedValue[2];
    }

    public int resetDial()
    {
       return  currentNumber = 0;
    }

    public int turnLeft(int ticks)
    {
        currentNumber = currentNumber - ticks; 
        if(currentNumber <= 0) // this will set the boundary strictly not less than zero and 39
        {
            currentNumber = 39 - (currentNumber + ticks);
        }
        else 
        {  
            currentNumber = currentNumber - ticks;
            arrayPosition++;
        }

        return triedValue[arrayPosition] = currentNumber;
    }  
    
    public int turnRight(int ticks)
    {
        currentNumber = currentNumber + ticks;
        if(currentNumber > 39)
        {
            currentNumber = 0 + ticks; // this resets the dial back to zero if it goes beyond 39
            arrayPosition++;
        }
        else 
        {
            currentNumber = currentNumber + ticks;
            arrayPosition++;
        }

        return triedValue[arrayPosition] = currentNumber;
    }

    public boolean openLock(int num1, int num2, int num3)
    {
        if((num1 == combination[0]) && (num2 == combination[1]) && (num3 == combination[2]))
            unlockOrNot = true;
        else
            unlockOrNot = false;

        return unlockOrNot;
    }

    

/*    public static void main(String[] args) 
    {
        CombinationLock student = new CombinationLock(4, 23, 19);
        
        student.turnRight(4);
        student.turnLeft(10);
        student.turnRight(15);

        System.out.println(student.openLock(student.getFirstTriedValue(), student.getSecondTriedValue(), student.getThirdTriedValue()));

        System.out.println(student.getCombination());
        System.out.println(student.getFirstTriedValue() + "" + student.getSecondTriedValue() + "" + student.getThirdTriedValue());
    }
*/
}
