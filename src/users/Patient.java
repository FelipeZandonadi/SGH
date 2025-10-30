/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;
import data.Registration;
import data.EletronicHealthRecord;

/**
 *
 * @author Acer
 */
public class Patient extends People {
    private Registration registration;
    private EletronicHealthRecord EHR;

    public Patient() {
    }

    public Patient(EletronicHealthRecord EHR, Registration registration, String id, String firstName, String lastName, String birthday, String document, String email, String phoneNumber) {
        super(id, firstName, lastName, birthday, document, email, phoneNumber);
        this.registration = registration;
        this.EHR = EHR;
    }

    public EletronicHealthRecord getHealthCard() {
        return EHR;
    }

    public void setHealthCard(EletronicHealthRecord ehr) {
        this.EHR = EHR;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public EletronicHealthRecord getEHR() {
        return EHR;
    }

    public void setEHR(EletronicHealthRecord EHR) {
        this.EHR = EHR;
    }
    
    
    
}
