package DataStructures.Queue.BankSimul;

public class BankSimulationRunner
{
   public static void main(String[] args)
   {
      final double START_TIME = 9 * 60; // 9 a.m.
      final double END_TIME = 17 * 60; // 5 p.m.

      final int NTELLERS = 5;

      Simulation sim = new BankSimulation(NTELLERS);
      sim.addEvent(new Arrival(START_TIME));
      sim.run(START_TIME, END_TIME);

      /*
         Output explanation:
            
            -Inside the bank, there are 5 bank teller to help costumers
         
         ('C' tellers that are accomodating ) < ('C' Costumers that are in a queue)

            * After each customer completes their appointment, they are immediately replaced by another customer.
            * The simulation continues until reaching the END_TIME.
            * Finally, it displays all accommodated customers within the specified time frame and calculates the 
               average duration of a customer's appointment.
               
       
      */
   }
}

