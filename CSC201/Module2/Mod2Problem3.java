package CSC201.Module2;
import java.util.Scanner;

public class Mod2Problem3 
{  
    private static double[][] temperature = new double[12][2];//12 represents the month; 2 represenets the low and high temp
    private static String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    //input temperature for a specific month
    public static void inputTempforMonth(double[][] temp, String month)
    {
        Scanner input = new Scanner(System.in);
        switch(month.toLowerCase())
        {
            case "january":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for Janruary: ");
                        temperature[0][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for Janruary: ");
                        temperature[0][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "februray":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for February: ");
                        temperature[1][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for February: ");
                        temperature[1][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "march":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for March: ");
                        temperature[2][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for March: ");
                        temperature[2][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "april":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for April: ");
                        temperature[3][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for April: ");
                        temperature[3][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "may":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for May: ");
                        temperature[4][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for May: ");
                        temperature[4][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "june":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for June: ");
                        temperature[5][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for June: ");
                        temperature[5][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "july":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for July: ");
                        temperature[6][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for July: ");
                        temperature[6][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "august":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for August: ");
                        temperature[7][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for August: ");
                        temperature[7][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "september":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for September: ");
                        temperature[8][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for September: ");
                        temperature[8][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "october":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for October: ");
                        temperature[9][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for October: ");
                        temperature[9][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "november":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for November: ");
                        temperature[10][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for November: ");
                        temperature[10][1] = input.nextDouble();
                    }
                }
                break;
            }
            case "december":
            {   
                for(int index = 0; index < 2; index++)
                {
                    if(index == 0)
                    {
                        System.out.println("Enter high temperature for December: ");
                        temperature[11][0] = input.nextDouble();
                    }
                    else if(index == 1)
                    {
                        System.out.println("Enter low temperature for December: ");
                        temperature[11][1] = input.nextDouble();
                    }
                }
                break;
            }
        }

        input.close();
    }
    
    //inputs all of the high(0) and low(1) temperature for the entire year
    public static double[][] inputTempforYear()
    {
        Scanner input = new Scanner(System.in);
        for(int row = 0; row < temperature.length; row++)
        {
            for(int col = 0; col < temperature[row].length; col++)
            {
                System.out.println("Enter temperature for " + month[row] + ":");
                if(col == 0)
                {
                    System.out.print("High: ");
                    temperature[row][col] = input.nextDouble();
                }
                else  
                {
                    System.out.print("Low: ");
                    temperature[row][col] = input.nextDouble();
                }

            }
        }

        input.close();
        return temperature;
    }
    
    //calculates the average of all high temperatures
    public static double calculateAverageHigh(double[][] temp)
    {   
        //all of high temperature are stored in 0 index in column; temperature[row][0]
        double sum = 0;
        double totalAverage;
        for(int row = 0; row < temp.length; row++)
        {
            sum = temp[row][0] + sum;
        }
        totalAverage = sum / temp.length;
        return totalAverage;
    }

    //calculates the average of all low temperatures
    public static double calculateAverageLow(double[][] temp)
    {   
        // all low temperatures are stored in 1 index in column
        double sum = 0;
        double totalAverage;
        for(int row = 0; row < temp.length; row++)
        {
            sum = temp[row][1] + sum;
        }
        totalAverage = sum / temp.length;
        return totalAverage;
    }

    public static String findHighestTemp(double[][] temp)
    {
        double candidate = 0;
        int rowIndex = 0;
        for(int row = 0; row < temp.length; row++)
        {
            if(temp[row][0] > candidate)
            {
                candidate = temperature[row][0];
                rowIndex = row;      
            }
        }
        return "Index: " + rowIndex +","+ 0 +"; " + month[rowIndex];
    }
    
    public static String findLowestTemp(double[][] temp)
    {
        double candidate = 0;
        int rowIndex = 0;
        for(int row = 0; row < temp.length; row++)
        {
            if(candidate > temp[row][1])
            {
                candidate = temp[row][1];
                rowIndex = row;      
            }
        }
        return "Index: " + rowIndex +","+ 1 +"; " + month[rowIndex];
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
    
       inputTempforYear();
       //inputTempforMonth(temperature, "May");

       System.out.println("High temperture total average: " +calculateAverageHigh(temperature));
       System.out.println("Low temperature total average: " + calculateAverageLow(temperature));

       System.out.println(findHighestTemp(temperature));
       System.out.println(findLowestTemp(temperature));

       input.close();
    }
    
}
