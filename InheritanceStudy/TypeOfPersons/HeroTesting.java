package InheritanceStudy.TypeOfPersons;

public class HeroTesting 
{
    public static void main(String[] args)
    {
        Hero heroA = new Hero("Midoriya", 18, 'M', "One For All");
        Human citizen = new Human("Midoriya", 18, 'M');
        TitledHuman boss = new TitledHuman("Sigrid", 67, 'M', "Dr.");

        
        heroA.viewInfo();
        System.out.println();
        heroA.heroInfo();
        System.out.println(citizen.getName());
        System.out.println(boss.equals(citizen));
        System.out.println();
        boss.writeOutput();
    }
}
