/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;
import appointments.Calendar;
/**
 *
 * @author Acer
 */
public class Doctor extends People {
    private String medicalLicenseNumber;
    private String specialization;
    private short officeNumber;
    private Calendar Calendar;

    public Doctor() {
    }

    public Doctor(String medicalLicenseNumber, String specialization, short officeNumber, Calendar Calendar, String id, String firstName, String lastName, String birthday, String document, String email, String phoneNumber) {
        super(id, firstName, lastName, birthday, document, email, phoneNumber);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialization = specialization;
        this.officeNumber = officeNumber;
        this.Calendar = Calendar;
    }

    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public short getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(short officeNumber) {
        this.officeNumber = officeNumber;
    }

    public Calendar getCalendar() {
        return Calendar;
    }

    public void setCalendar(Calendar Calendar) {
        this.Calendar = Calendar;
    }
    
    
    
    public void insertPatientRegistration() {
        
    }
    
    public void updatePatientRegistration() {
        
    }
    
    public void removePatienteRegistration() {
        
    }
    
    public void insertEHR() {
        
    }
    
    public void updateEHR() {
        
    }
    
    public void removeEHR() {
        
    }
    
    public String buildTreatmentRegistration() {
        return "";
    }
    
    public String buildMedicalCertificate() {
        return "";
    }
    
    public String buildAttendanceReport() {
        return "";
    }
    
    public String buildFollowUpDeclaration() {
        return "";
    }
    
    public int buildAttendedInPeriod() {
        return 0;
    }
    
}
