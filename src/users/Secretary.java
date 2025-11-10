package users;
import data.Registration;
import appointments.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma secretária do sistema hospitalar, responsável por
 * gerenciar cadastros de pacientes e consultas.
 * Permite criar, atualizar e remover registros de pacientes e consultas.
 * 
 * @author Acer
 */
public class Secretary extends People {

    /**
     * Construtor da classe Secretary.
     *
     * @param id Identificador da secretária.
     * @param firstName Primeiro nome.
     * @param lastName Sobrenome.
     * @param birthday Data de nascimento.
     * @param document Documento de identificação (ex: CPF).
     * @param email Endereço de e-mail.
     * @param phoneNumber Número de telefone.
     */
    public Secretary(String id, String firstName, String lastName, String birthday, String document, String email, String phoneNumber) {
        super(id, firstName, lastName, birthday, document, email, phoneNumber);
    }

    /**
     * Cria e associa um registro de paciente com seus dados e informações de plano.
     *
     * @param id Identificador do paciente.
     * @param firstName Primeiro nome.
     * @param lastName Sobrenome.
     * @param birthday Data de nascimento.
     * @param document Documento de identificação.
     * @param email E-mail do paciente.
     * @param phoneNumber Telefone do paciente.
     * @param adress Endereço do paciente.
     * @param planType Tipo de plano (privado/público).
     * @return Objeto {@link Patient} criado.
     */
    public Patient insertPatientRegistration(
            String id,
            String firstName,
            String lastName,
            String birthday,
            String document,
            String email,
            String phoneNumber,
            String adress,
            String planType
    ) {
        Patient patient = new Patient(
                id,
                firstName,
                lastName,
                birthday,
                document,
                email,
                phoneNumber
        );
        Registration registration = new Registration();
        registration.setId("Re" + id);
        registration.setAdress(adress);
        registration.setPlanType(planType);
        
        patient.setRegistration(registration);
        return patient;
    }

    /**
     * Atualiza os dados de um paciente existente.
     * Campos nulos não são modificados.
     *
     * @param patient Paciente a ser atualizado.
     * @param id Novo ID (opcional).
     * @param firstName Novo primeiro nome (opcional).
     * @param lastName Novo sobrenome (opcional).
     * @param birthday Nova data de nascimento (opcional).
     * @param document Novo documento (opcional).
     * @param email Novo e-mail (opcional).
     * @param phoneNumber Novo telefone (opcional).
     * @param adress Novo endereço (opcional).
     * @param planType Novo tipo de plano (opcional).
     */
    public void updatePatientRegistration(
            Patient patient,
            String id,
            String firstName,
            String lastName,
            String birthday,
            String document,
            String email,
            String phoneNumber,
            String adress,
            String planType
    ) {
        if (firstName != null) patient.setFirstName(firstName);
        if (lastName != null) patient.setLastName(lastName);
        if (birthday != null) patient.setBirthday(birthday);
        if (document != null) patient.setDocument(document);
        if (email != null) patient.setEmail(email);
        if (phoneNumber != null) patient.setPhoneNumber(phoneNumber);
        if (adress != null) patient.getRegistration().setAdress(adress);
        if (planType != null) patient.getRegistration().setPlanType(planType);
    }

    /**
     * Remove as informações de um paciente, limpando todos os seus dados.
     *
     * @param patient Paciente a ser removido.
     */
    public void removePatienteRegistration(Patient patient) {
        patient.setFirstName(null);
        patient.setLastName(null);
        patient.setBirthday(null);
        patient.setDocument(null);
        patient.setEmail(null);
        patient.setPhoneNumber(null);
        patient.getRegistration().setAdress(null);
        patient.getRegistration().setPlanType(null);
    }

    /**
     * Cadastra uma nova consulta no calendário.
     *
     * @param patient Paciente da consulta.
     * @param doctor Médico responsável.
     * @param type Tipo de consulta (normal ou retorno).
     * @param scheduleTime Horário da consulta.
     * @param scheduleDate Data da consulta (yyyy-MM-dd).
     * @param calendar Calendário onde será registrada.
     */
    public void insertAppointment(
            Patient patient,
            Doctor doctor,
            String type,
            String scheduleTime,
            String scheduleDate,
            Calendar calendar
    ) {
        Appointment appointment = new Appointment(
                "App" + patient.getId() + doctor.getId(),
                patient,
                doctor,
                type,
                scheduleTime,
                scheduleDate
        );
        calendar.setAppointment(appointment);
    }

    /**
     * Atualiza uma consulta existente.
     *
     * @param patient Paciente da consulta.
     * @param doctor Médico responsável.
     * @param type Novo tipo de consulta (opcional).
     * @param scheduleTime Novo horário (opcional).
     * @param scheduleDate Nova data (opcional).
     * @param calendar Calendário onde está a consulta.
     * @throws RuntimeException se o paciente, médico ou consulta não existirem.
     */
    public void updateAppointment(
            Patient patient,
            Doctor doctor,
            String type,
            String scheduleTime,
            String scheduleDate,
            Calendar calendar
    ) {
        if (patient == null || doctor == null) {
            throw new RuntimeException("patient or doctor cannot be null.");
        }
        Appointment appointment = calendar.getAppointment("App" + patient.getId() + doctor.getId());
        if (appointment == null) {
            throw new RuntimeException("appointment not exist");
        }
        
        if (type != null) appointment.setType(type);
        if (scheduleTime != null) appointment.setScheduleTime(scheduleTime);
        if (scheduleDate != null) appointment.setScheduleDate(scheduleDate);
    }

    /**
     * Remove uma consulta do calendário.
     *
     * @param patient Paciente da consulta.
     * @param doctor Médico responsável.
     * @param calendar Calendário onde está a consulta.
     */
    public void removeAppointment(Patient patient, Doctor doctor, Calendar calendar) {
        calendar.removeAppointment("App" + patient.getId() + doctor.getId());
    }

    /**
     * Gera uma lista de consultas do dia seguinte, filtrando por pacientes
     * que possuem (ou não) telefone e/ou e-mail, conforme os parâmetros.
     *
     * @param todayDate Data atual no formato "yyyy-MM-dd".
     * @param calendar Objeto {@link Calendar} com as consultas.
     * @param hasPhoneNumber Se verdadeiro, filtra apenas pacientes com telefone.
     * @param hasEmail Se verdadeiro, filtra apenas pacientes com e-mail.
     * @return Lista filtrada de {@link Appointment}.
     */
    public List<Appointment> buildUpcomingAppointmentsInfo(
            String todayDate,
            Calendar calendar,
            boolean hasPhoneNumber,
            boolean hasEmail
    ) {
        List<Appointment> upcomingAppointments = calendar.getUpComingAppointments(todayDate);
        List<Appointment> filteredAppointments = new ArrayList<>();

        for (Appointment appointment : upcomingAppointments) {
            Patient patient = appointment.getPatient();
            boolean patientHasPhone = patient.getPhoneNumber() != null && !patient.getPhoneNumber().isEmpty();
            boolean patientHasEmail = patient.getEmail() != null && !patient.getEmail().isEmpty();
            
            boolean matchPhone = !hasPhoneNumber || patientHasPhone;
            boolean matchEmail = !hasEmail || patientHasEmail;

            if (matchPhone && matchEmail) {
                filteredAppointments.add(appointment);
            }
        }

        return filteredAppointments;
    }
}
