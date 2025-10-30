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
public class Secretary extends People {
    
    private Calendar calendar;
    

    public Secretary() {
    }

    public Secretary(Calendar calendar, String id, String firstName, String lastName, String birthday, String document, String email, String phoneNumber) {
        super(id, firstName, lastName, birthday, document, email, phoneNumber);
        this.calendar = calendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
    
    
    
    
    public void insertPatientRegistration() {
        
    }
    
    public void updatePatientRegistration() {
        
    }
    
    public void removePatienteRegistration() {
        
    }
    
    public void insertAppointment() {
        
    }
    
    public void updateAppointment() {
        
    }
    
    public void removeAppointment() {
        
    }
    
    public String buildUpcomingAppointmentsInfo() {
        
        return "";
        
    }
    
}
