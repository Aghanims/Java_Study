import javax.swing.JOptionPane;


public class DialogBox 
{
    
    
    public static void main(String[] args) 
    {
        /*
            JOptionPane -> pop up a standard dialog boxes taht prompts users
                            for a value or informs them of something.
        */

        //inform user of something:
        //JOptionPane.showMessageDialog(null, "Some Usesless Info", "Title", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Some Usesless Info", "Title", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Some Usesless Info", "Title", JOptionPane.QUESTION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Some Usesless Info", "Title", JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Some Usesless Info", "Title", JOptionPane.ERROR_MESSAGE);

        //prompts user:
        //"yes" return 0, "No" return 1, "Cancel" return 2, exit button returns -1
        int ans =JOptionPane.showConfirmDialog(null, "Have you finished your projects?", "HR escalation", JOptionPane.YES_NO_CANCEL_OPTION);
        if(ans == 0)
            System.out.println("Congrats!!! You are eligible for a paid 1 year vacation\ncontact HR for more info");
        else if(ans == 1)
            System.out.println("Projects extensions is needed to be initialized, Contact your manager by today");
        else if(ans == 2)
            System.out.println("You violated a policy for not cooperating");
        else if(ans == -1)
            System.out.println("Your action will be escalated to the HR");

        //user can enter a dialog:
        String x = JOptionPane.showInputDialog("Do you like spicy foods?");
        System.out.println(x);

        //user can be asked for a multiple choice
        String[] option = {"Yummy", "So-So", "ehh", "Don't want it near me"};
        String y = (String)JOptionPane.showInputDialog(null, "Do you like sushi?", "Favorite Food", JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
        System.out.println(y);

        //combinations:
        String[] responses = {"Data Structures", "Calculus III", "Organic Chemistry", "English Literature"};
        JOptionPane.showOptionDialog
        (
            null, 
            "Favorite Course", 
            "Student Preferences", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
            null, 
            responses, 
            null
        );
    }
}
