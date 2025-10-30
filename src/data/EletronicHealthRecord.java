/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.List;
import users.Doctor;

/**
 *
 * @author Acer
 */
public class EletronicHealthRecord {
    
    private String id;
    private Doctor doctor;
    private List<String> symptoms;
    private String diagnosis;
    private String treatmentPrescription;

    public EletronicHealthRecord() {
    }

    public EletronicHealthRecord(String id, Doctor doctor, List symptoms, String diagnosis, String treatmentPrescription) {
        this.id = id;
        this.doctor = doctor;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatmentPrescription = treatmentPrescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentPrescription() {
        return treatmentPrescription;
    }

    public void setTreatmentPrescription(String treatmentPrescription) {
        this.treatmentPrescription = treatmentPrescription;
    }
    
    
    
}
