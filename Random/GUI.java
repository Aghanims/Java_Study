package Random;
import javax.swing.JOptionPane;

public class GUI {
    
    public static void main(String[] args) {
        
        // pg. 188 (using if statements on JOptionPane w/ method .showConfirmDialog)

        JOptionPane.showMessageDialog(null, "Greetings human, It is my pleasure to meet you in this virtual space");
        
        String name = JOptionPane.showInputDialog("What's your name?");
        JOptionPane.showMessageDialog(null, "Hello "+name.substring(0,1).toUpperCase() + name.substring(1));

        //String answer = JOptionPane.showInputDialog("Can we be friends?");
        int answer = JOptionPane.showConfirmDialog(null, "Can we be friends? ", "Can we be friends?", JOptionPane.YES_NO_OPTION);

        if(answer == 0 )
        {
            JOptionPane.showMessageDialog(null, "I'm so glad we could be friends "+ name );
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please be my friend, I'm certain that you won't be dissapointed");
        }

        String food = JOptionPane.showInputDialog("What's your favorite food?");
        JOptionPane.showMessageDialog(null, food.substring(0,1).toUpperCase() + food.substring(1) + "..."+ " YOU HAVE NO TASTE!!!");

        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));

        if(age >= 5 && age <= 25)
        {
            JOptionPane.showMessageDialog(null, "Make good friends in school, OKAY??");
        }
        else if(age > 25 && age <= 100)
        {
            JOptionPane.showMessageDialog(null, "Hopefully you lived a happy life. Please share your widom to the world");
        }

        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height(cm)"));
        if(height >= 170 && height <= 205)
        {
            JOptionPane.showMessageDialog(null, "PLEASE TELL ME YOUR SECRET");
        }
        else if(height < 170 && height >= 0)
        {
            JOptionPane.showMessageDialog(null, "Pro tip : Excercise and eat nutritious food together with proper sleep can help you grow taller");
        }

        String hobby = JOptionPane.showInputDialog("What's your hobby?");
        JOptionPane.showMessageDialog(null, "I also love "+hobby.toLowerCase());

        String soon = " soon; JUST BELIEVE";
        String dream = JOptionPane.showInputDialog("What do you want to be when you grow up?");
        JOptionPane.showMessageDialog(null, "I'm very sure you'll be a " +dream.toLowerCase() +soon);

        System.exit(0);
    } 
}
