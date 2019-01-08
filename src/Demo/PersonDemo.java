package Demo;

import PersonAndDate.Date;
import PersonAndDate.Person;

public class PersonDemo
{
    public static void main(String[] args)
    {
    	
    	Date birthDateOfCanada = new Date("July", 1, 1867);
//    	Date birthDateOfCanada = new Date(7, 1, 1867);
    	
    	Date bachBirthDate = new Date("March", 21, 1685);
    	Date bachDeathDate = new Date("July", 28, 1750);
        Person bach = new Person("Johann Sebastian Bach",
            		bachBirthDate, bachDeathDate);
        
//        Person bach = 
//                new Person("Johann Sebastian Bach",
//                     new Date("March", 21, 1685), new Date("July", 28, 1750));


        Person bach1 = bach;
        boolean bSameObjects = (bach1 == bach); 
        if (bach1 == bach)
            System.out.println("Same reference for both.");
        else
            System.out.println("Distinct copies.");
        
        Person bach2 = 
                new Person("Johann Sebastian Bach",
                     new Date("March", 21, 1685), new Date("July", 28, 1750));

        bSameObjects = (bach2 == bach); 
        if (bach2 == bach)
            System.out.println("Same reference for both.");
        else
            System.out.println("Distinct copies.");

        if (bach2.equals(bach))
            System.out.println("Same data.");
        else
            System.out.println("Not same data.");
                        
        Person stravinsky = 
            new Person("Igor Stravinsky",
                 new Date("June", 17, 1882), new Date("April", 6, 1971));
        Person adams = 
            new Person("John Adams",
                 new Date("February", 15, 1947), null);

        System.out.println("A Short List of Composers:");
        System.out.println(bach);
        System.out.println(stravinsky);
        System.out.println(adams);

        Person bachTwin = new Person(bach);
        System.out.println("Comparing bach and bachTwin:");
        if (bachTwin == bach)
             System.out.println("Same reference for both.");
        else
             System.out.println("Distinct copies.");

        if (bachTwin.equals(bach))
             System.out.println("Same data.");
        else
             System.out.println("Not same data.");
     }
}
