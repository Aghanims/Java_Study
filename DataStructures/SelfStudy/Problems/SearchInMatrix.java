package DataStructures.SelfStudy.Problems;

public class SearchInMatrix 
{
    public static void search(int[][] matrix, int value) //only works on wise sorted matrix
    {
        int row = 1;
        int column = matrix.length - 1; //start from the top-right edge of the matrix

        while(row <= matrix.length - 1 && column >= 0)
        {
            if(matrix[row][column] == value)
            {
                System.out.println("value " + value + " is found at (" + row + ", " + column +")");
                return;
            }

            if(matrix[row][column] > value)
                column--;
            else 
                row++;
        }
        System.out.println(value + " is not found");
    }

    public static void spiralPrintMatrix(int[][] matrix)
    {
        int rowIterator = 1; // start at the beginning index
        int columnIterator = 1;

        int rowBoundary = matrix.length;
        int columnBoundary = matrix.length;

        while(rowIterator < rowBoundary && columnIterator < columnBoundary) // length of colomn and row are the same
        {
            for(int i = columnIterator; i < columnBoundary; i++ )
            {
                System.out.print(matrix[rowIterator][i] + " "); 
            }

            rowIterator++;

            for(int i = rowIterator; i < columnBoundary; i++)
            {
                System.out.print(matrix[columnBoundary - 1][i] + " ");
            }
            columnBoundary--;

            if(rowIterator < rowBoundary)
            {
                for(int i = columnBoundary - 1; i >= columnIterator; i--)
                {
                    System.out.print(matrix[rowBoundary - 1][i] + " ");
                }
                rowBoundary--;
            }

            if(columnIterator < columnBoundary)
            {
                for(int i = rowBoundary - 1; i >= rowIterator; i--)
                {
                    System.out.print(matrix[i][columnIterator] + " ");
                }
                columnIterator++;
            }
        }
    }

    public static int[][] displayMultiplicationTable(int nth)
    {
        int[][] table = new int[nth + 1][nth + 1];

        for(int i = 1; i < table.length; i++)
        {
            for(int j = 1; j < table[i].length; j++)
            {
                table[i][j] = i * j;
                System.out.format("%5s",table[i][j]);
            }
            System.out.println();
        }
        return table;
    }

/******************************************************* */
    public static void main(String[] args) 
    {
        //displayMultiplicationTable(10);

        int[][] table = displayMultiplicationTable(10);

        search(table, 14);
        search(table, 99);
        search(table, 100);
        System.out.println();

        System.out.println("New table: ");
        int[][] testTable = displayMultiplicationTable(5);
        
        System.out.println("Print table in sprial order: " );
        spiralPrintMatrix(testTable);
    }
}
