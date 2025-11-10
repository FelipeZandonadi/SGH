package app;

import appointments.Appointment;
import appointments.Calendar;
import java.util.Arrays;
import java.util.List;
import services.NotificationService;
import users.*;

/**
 *
 * @author
 * Felipe_zandonadi RA 138579
 * Raissa_Barossi RA 138882
 * Rafael_Campos RA 138302
 */
public class Main {

    public static void main(String[] args) {

        NotificationService notificationServer = new NotificationService();
        Calendar calendar = new Calendar();

        // ===============================================================
        // SECRETARIES
        // ===============================================================
        Secretary secretary1 = new Secretary(
                "S123", "Paulo", "Silva",
                "1984-03-07", "045.995.980-89",
                "paulo.silva@hospital.com", "(44) 9.8888-7777"
        );

        Secretary secretary2 = new Secretary(
                "S987", "Marta", "Cardoso Vieira",
                "1999-10-21", "170.791.190-81",
                "marta.vieira@hospital.com", "(11) 9.3211-0909"
        );

        // ===============================================================
        // TESTING PATIENT REGISTRATION
        // ===============================================================
        System.out.println("====== TESTING PATIENT REGISTRATION ======");

        Patient patient1 = secretary1.insertPatientRegistration(
                "P111", "Felipe", "Zandonadi",
                "1950-12-09", "144.206.730-60",
                "xaulin1950@gmail.com", "(41) 9.1234-0012",
                "Rua Tom Jobim, 766", "privado"
        );

        Patient patient2 = secretary1.insertPatientRegistration(
                "P222", "Mateus", "Santos do Rosario",
                "2003-01-30", "165.001.340-01",
                "vasco_campeao@yahoo.com.br", "(41) 9.2424-6969",
                "Av. Manga, 51", "publica"
        );

        System.out.println("Patient created:");
        System.out.println("  ID: " + patient2.getId());
        System.out.println("  Name: " + patient2.getFirstName() + " " + patient2.getLastName());
        System.out.println("  Email: " + patient2.getEmail());
        System.out.println("  Phone: " + patient2.getPhoneNumber());
        System.out.println("  Address: " + patient2.getRegistration().getAdress());
        System.out.println("  Plan: " + patient2.getRegistration().getPlanType());

        // Update patient info
        secretary1.updatePatientRegistration(patient2, null, null, null, null, null, "mateusro@outlook.com", null, null, null);
        System.out.println("\nPatient updated:");
        System.out.println("  New Email: " + patient2.getEmail());

        // ===============================================================
        // TESTING DOCTORS
        // ===============================================================
        System.out.println("\n====== TESTING DOCTOR CREATION ======");

        Doctor doctor1 = new Doctor(
                "BR-PR-MG-178", "Ortopedista", 15,
                "Dr981", "Nathan", "Almeida Silvestre",
                "1991-09-16", "364.550.870-89",
                "nathan.silvestre@hospital.com", "(11) 9.1366-6182"
        );

        Doctor doctor2 = new Doctor(
                "BR-PR-SD-521", "Cardiologista", 21,
                "Dr152", "Valder", "Nyshin Guiri",
                "1988-07-29", "822.576.970-81",
                "valder.guiri@hospital.com", "(44) 9.8413-7622"
        );

        System.out.println("Doctor created:");
        System.out.println("  Name: " + doctor2.getFirstName() + " " + doctor2.getLastName());
        System.out.println("  Specialty: " + doctor2.getSpecialty());

        // ===============================================================
        // TESTING APPOINTMENTS
        // ===============================================================
        System.out.println("\n====== TESTING APPOINTMENTS ======");

        secretary2.insertAppointment(patient1, doctor1, "normal", "14:30", "2024-10-10", calendar);
        secretary2.insertAppointment(patient2, doctor1, "retorno", "10:30", "2024-10-10", calendar);

        Appointment appointment1 = calendar.getAppointment("App" + patient2.getId() + doctor1.getId());
        System.out.println("Appointment created:");
        System.out.println("  ID: " + appointment1.getId());
        System.out.println("  Type: " + appointment1.getType());
        System.out.println("  Time: " + appointment1.getScheduleTime());
        System.out.println("  Date: " + appointment1.getScheduleDate());

        secretary2.updateAppointment(patient2, doctor1, null, "10:00", null, calendar);
        Appointment appointment2 = calendar.getAppointment("App" + patient2.getId() + doctor1.getId());
        System.out.println("\nAppointment updated:");
        System.out.println("  New Time: " + appointment2.getScheduleTime());

        secretary2.removeAppointment(patient2, doctor1, calendar);
        try {
            calendar.getAppointment("App" + patient2.getId() + doctor1.getId());
        } catch (Exception e) {
            System.out.println("\nAppointment successfully removed!");
        }

        // Reinserindo para próximos testes
        secretary2.insertAppointment(patient2, doctor1, "retorno", "10:30", "2024-10-10", calendar);

        // ===============================================================
        // TESTING EHR (Electronic Health Record)
        // ===============================================================
        System.out.println("\n====== TESTING EHR METHODS ======");

        List<String> symptoms = Arrays.asList("Febre", "Tosse seca", "Cansaço");
        List<String> treatmentPrescription = Arrays.asList("Repouso", "Hidratação");

        doctor1.insertEHR(patient1, "EHR001", doctor1, symptoms, "Gripe", treatmentPrescription);
        System.out.println("EHR inserted:");
        System.out.println("  Diagnosis: " + patient1.getEHR().getDiagnosis());
        System.out.println("  Treatment: " + patient1.getEHR().getTreatmentPrescription());

        List<String> newSymptoms = Arrays.asList("Febre alta", "Dores musculares");
        List<String> newTreatment = Arrays.asList("Hidratação intensa", "Repouso");
        doctor1.updateEHR(patient1, "EHR001", doctor1, newSymptoms, "Dengue", newTreatment);
        System.out.println("\nEHR updated:");
        System.out.println("  Diagnosis: " + patient1.getEHR().getDiagnosis());
        System.out.println("  Treatment: " + patient1.getEHR().getTreatmentPrescription());

        doctor1.removeEHR(patient1);
        System.out.println("\nEHR removed:");
        System.out.println("  Exists? " + (patient1.getEHR() != null ? "Yes" : "No"));

        // ===============================================================
        // TESTING DOCTOR REPORTS
        // ===============================================================
        System.out.println("\n====== TESTING DOCTOR REPORT BUILDS ======");

        doctor1.insertEHR(patient1, "EHR001", doctor1, symptoms, "Gripe", treatmentPrescription);

        System.out.println("\n-- TREATMENT REGISTRATION --");
        System.out.println(doctor1.buildTreatmentRegistration(patient1));

        System.out.println("-- MEDICAL CERTIFICATE --");
        System.out.println(doctor1.buildMedicalCertificate(patient1, 2));

        System.out.println("-- ATTENDANCE REPORT --");
        System.out.println(doctor1.buildAttendanceReport(patient1));

        System.out.println("-- FOLLOW-UP DECLARATION --");
        System.out.println(doctor1.buildFollowUpDeclaration(patient1, calendar));

        System.out.println("-- ATTENDED IN PERIOD --");
        System.out.println("  Appointments in month 10: " + doctor1.buildAttendedInPeriod("10", calendar));

        // ===============================================================
        // TESTING SECRETARY REPORTS
        // ===============================================================
        System.out.println("\n====== TESTING SECRETARY REPORTS ======");

        List<Appointment> upcoming = secretary1.buildUpcomingAppointmentsInfo("2024-10-09", calendar, true, true);
        if (upcoming.isEmpty()) {
            System.out.println("No upcoming appointments found for the selected filters.");
        } else {
            for (Appointment app : upcoming) {
                System.out.println("Appointment ID: " + app.getId());
                System.out.println("  Date: " + app.getScheduleDate());
                System.out.println("  Time: " + app.getScheduleTime());
                System.out.println("  Doctor: " + app.getDoctor().getFirstName() + " " + app.getDoctor().getLastName());
                System.out.println("  Patient: " + app.getPatient().getFirstName() + " " + app.getPatient().getLastName());
                System.out.println("  Patient Email: " + app.getPatient().getEmail());
                System.out.println("  Patient Phone: " + app.getPatient().getPhoneNumber());
                System.out.println("------------------------------------------");
            }
        }

        // ===============================================================
        // TESTING NOTIFICATION SERVICE
        // ===============================================================
        System.out.println("\n====== TESTING NOTIFICATION SERVICE ======");
        notificationServer.sendMessageEmail(patient1);
        notificationServer.sendMessageSMS(patient1);

        System.out.println("\n====== ALL TESTS FINISHED SUCCESSFULLY ======");
    }
}
