// Step 1: Create a New Project and Patient Class
public class Patient {
    // Step 2: Define fields
    private int id;
    private String name;
    private int birthYear;
    private double height; // in centimeters
    private double weight; // in kilograms

    // Constructor
    public Patient(int id, String name, int birthYear, double height, double weight) {
        if (birthYear <= 0 || height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("Invalid input for birthYear, height, or weight. Must be positive.");
        }
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.height = height;
        this.weight = weight;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    // Method to calculate age
    public int getAge(int currentYear) {
        if (currentYear <= birthYear) {
            throw new IllegalArgumentException("Current year must be greater than birth year.");
        }
        return currentYear - birthYear;
    }

    // Method to display patient details
    public void displayDetails(int currentYear) {
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + getAge(currentYear));
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
    }

    // Step 3: Test the Patient Class
    public static void main(String[] args) {
        int currentYear = 2024;

        // Valid Patient
        Patient patient = new Patient(1001, "John Doe", 1978, 175.5, 78.0);
        patient.displayDetails(currentYear);

        System.out.println();

        // Invalid Patient (should throw exception)
        try {
            Patient invalidPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0);
            invalidPatient.displayDetails(currentYear);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
