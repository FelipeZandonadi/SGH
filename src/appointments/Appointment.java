package appointments;
import users.Patient;
import users.Doctor;

/**
 * Representa um compromisso (consulta) entre um paciente e um médico.
 * Contém informações sobre o tipo de consulta, data, horário e os participantes.
 * 
 * @author Acer
 */
public class Appointment {
    
    /** Identificador único da consulta. */
    private String id;
    
    /** Paciente associado à consulta. */
    private Patient patient;
    
    /** Médico responsável pela consulta. */
    private Doctor doctor;
    
    /** Tipo da consulta (ex: retorno, avaliação, exame). */
    private String type;
    
    /** Horário agendado da consulta. */
    private String scheduleTime;
    
    /** Data agendada da consulta, no formato "yyyy-MM-dd". */
    private String scheduleDate;

    /**
     * Construtor que inicializa todos os atributos da classe {@code Appointment}.
     * 
     * @param id identificador único da consulta.
     * @param patient paciente que participará da consulta.
     * @param doctor médico responsável pela consulta.
     * @param type tipo da consulta (ex: retorno, avaliação, exame).
     * @param scheduleTime horário agendado da consulta.
     * @param scheduleDate data agendada da consulta no formato "yyyy-MM-dd".
     */
    public Appointment(String id, Patient patient, Doctor doctor, String type, String scheduleTime, String scheduleDate) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.type = type;
        this.scheduleTime = scheduleTime;
        this.scheduleDate = scheduleDate;
    }

    /**
     * Retorna o identificador da consulta.
     * 
     * @return o ID da consulta.
     */
    public String getId() {
        return id;
    }

    /**
     * Define o identificador da consulta.
     * 
     * @param id novo identificador da consulta.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retorna o paciente vinculado à consulta.
     * 
     * @return o objeto {@link Patient} associado à consulta.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Define o paciente da consulta.
     * 
     * @param patient novo paciente associado.
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Retorna o médico responsável pela consulta.
     * 
     * @return o objeto {@link Doctor} vinculado à consulta.
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Define o médico responsável pela consulta.
     * 
     * @param doctor novo médico associado.
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Retorna o tipo da consulta.
     * 
     * @return tipo da consulta (ex: retorno, exame).
     */
    public String getType() {
        return type;
    }

    /**
     * Define o tipo da consulta.
     * 
     * @param type novo tipo de consulta.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retorna o horário agendado da consulta.
     * 
     * @return o horário da consulta.
     */
    public String getScheduleTime() {
        return scheduleTime;
    }

    /**
     * Define o horário agendado da consulta.
     * 
     * @param scheduleTime novo horário da consulta.
     */
    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    /**
     * Retorna a data agendada da consulta.
     * 
     * @return a data da consulta no formato "yyyy-MM-dd".
     */
    public String getScheduleDate() {
        return scheduleDate;
    }

    /**
     * Define a data agendada da consulta.
     * 
     * @param scheduleDate nova data da consulta no formato "yyyy-MM-dd".
     */
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }
}
