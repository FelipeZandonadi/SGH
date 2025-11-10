package services;

import users.Patient;

/**
 * Classe responsável por enviar notificações aos pacientes
 * por meio de e-mail ou SMS.
 * 
 * <p>Este serviço é utilizado para lembrar o paciente sobre
 * consultas marcadas.</p>
 * 
 * @author f_zandonadi
 */
public class NotificationService {
    
    /**
     * Envia uma mensagem de notificação por e-mail para o paciente.
     * 
     * @param patient o paciente que receberá o e-mail
     */
    public void sendMessageEmail(Patient patient) {
        System.out.println("Send to address: " + patient.getEmail());
        System.out.println("Notification: Olá, hoje você tem uma consulta!");
    }
    
    /**
     * Envia uma mensagem de notificação por SMS para o paciente.
     * 
     * @param patient o paciente que receberá o SMS
     */
    public void sendMessageSMS(Patient patient) {
        System.out.println("Send to SMS: " + patient.getPhoneNumber());
        System.out.println("Notification: Olá, hoje você tem uma consulta!");
    }
}
