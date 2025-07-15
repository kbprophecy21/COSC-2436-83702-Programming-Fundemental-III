package Chapter25.Lab_Assignment_4;

public class PatientSchedulerDemo {
    
    public static void main(String[] args) {
        PatientScheduler scheduler = new PatientScheduler();

        // Adding patients to the scheduler
        scheduler.addPatient(3, "Kyle");
        scheduler.addPatient(1, "Zack");
        scheduler.addPatient(2, "Chris");
        scheduler.addPatient(4, "Josh");
        scheduler.addPatient(5, "Sindy");

        // Printing the schedule
        System.out.println("Patient Schedule:");
        scheduler.printSchedule();

        // Getting the highest priority patient
        System.out.println("Highest Priority Patient: " + scheduler.getHighestPriorityPatient());
    }

}