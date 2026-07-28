import java.util.*;

class Patient {
    String id, name, gender, phone;
    int age;
    ArrayList<String> history = new ArrayList<>();

    Patient(String id, String name, int age, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
}

class Doctor {
    String id, name, specialization, phone, schedule;
    double fee;

    Doctor(String id, String name, String specialization,
           String phone, double fee, String schedule) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.fee = fee;
        this.schedule = schedule;
    }
}

class Appointment {
    String id, patientId, doctorId, date, time, reason, status;

    Appointment(String id, String patientId, String doctorId,
                String date, String time, String reason) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = "SCHEDULED";
    }
}

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static int patientId = 101;
    static int doctorId = 201;
    static int appointmentId = 301;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=== HOSPITAL MANAGEMENT SYSTEM ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Patients & History");
            System.out.println("5. View Doctors & Availability");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    addDoctor();
                    break;

                case 3:
                    bookAppointment();
                    break;

                case 4:
                    viewPatients();
                    break;

                case 5:
                    viewDoctors();
                    break;

                case 6:
                    System.out.println("Thank you! Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 1. Register Patient
    static void registerPatient() {

        String id = "P" + patientId++;

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter medical history: ");
        String history = sc.nextLine();

        Patient p = new Patient(
            id, name, age, gender, phone
        );

        if (!history.equalsIgnoreCase("None")) {
            p.history.add(history);
        }

        patients.add(p);

        System.out.println(
            "Patient registered! ID: " + id
        );
    }

    // 2. Add Doctor
    static void addDoctor() {

        String id = "D" + doctorId++;

        System.out.print("Enter doctor name: ");
        String name = sc.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter consultation fee: ");
        double fee = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter schedule: ");
        String schedule = sc.nextLine();

        doctors.add(
            new Doctor(
                id, name, specialization,
                phone, fee, schedule
            )
        );

        System.out.println(
            "Doctor added! ID: " + id
        );
    }

    // 3. Book Appointment
    static void bookAppointment() {

        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println(
                "Please register a patient and add a doctor first."
            );
            return;
        }

        System.out.print("Enter Patient ID: ");
        String pid = sc.nextLine();

        System.out.print("Enter Doctor ID: ");
        String did = sc.nextLine();

        System.out.print("Enter date: ");
        String date = sc.nextLine();

        System.out.print("Enter time: ");
        String time = sc.nextLine();

        System.out.print("Enter reason: ");
        String reason = sc.nextLine();

        String id = "A" + appointmentId++;

        appointments.add(
            new Appointment(
                id, pid, did,
                date, time, reason
            )
        );

        System.out.println(
            "Appointment booked! ID: " + id
        );
    }

    // 4. View Patients & Medical History
    static void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient p : patients) {

            System.out.println("\nPatient ID: " + p.id);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Gender: " + p.gender);
            System.out.println("Phone: " + p.phone);
            System.out.println("Medical History: " +
                    (p.history.isEmpty() ? "No medical history recorded" : p.history));
        }
    }

    // 5. View Doctors & Availability
    static void viewDoctors() {

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor d : doctors) {

            System.out.println("\nDoctor ID: " + d.id);
            System.out.println("Name: " + d.name);
            System.out.println(
                "Specialization: " + d.specialization
            );
            System.out.println("Phone: " + d.phone);
            System.out.println("Fee: $" + d.fee);
            System.out.println(
                "Available: " + d.schedule
            );
        }
    }
}