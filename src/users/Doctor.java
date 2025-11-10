package users;

import appointments.Appointment;
import appointments.Calendar;
import data.EletronicHealthRecord;
import data.Registration;
import java.util.List;

/**
 * Representa um médico do sistema hospitalar.
 * Possui informações de identificação profissional e métodos para gerenciar
 * registros e prontuários de pacientes, além de gerar documentos médicos.
 * 
 * @author Acer
 */
public class Doctor extends People {
    
    /** Número de licença médica (CRM). */
    private String medicalLicenseNumber;
    
    /** Especialidade médica do profissional. */
    private String specialty;
    
    /** Número do consultório onde o médico atende. */
    private int officeNumber;

    /**
     * Construtor da classe Doctor.
     * 
     * @param medicalLicenseNumber Número de licença médica (CRM).
     * @param specialty Especialidade médica.
     * @param officeNumber Número do consultório.
     * @param id Identificador do médico.
     * @param firstName Primeiro nome.
     * @param lastName Sobrenome.
     * @param birthday Data de nascimento.
     * @param document Documento de identificação.
     * @param email Endereço de e-mail.
     * @param phoneNumber Número de telefone.
     */
    public Doctor(String medicalLicenseNumber, String specialty, int officeNumber, String id, String firstName, String lastName, String birthday, String document, String email, String phoneNumber) {
        super(id, firstName, lastName, birthday, document, email, phoneNumber);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialty = specialty;
        this.officeNumber = officeNumber;
    }

    /** @return Número de licença médica (CRM). */
    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    /** @param medicalLicenseNumber Novo número de licença médica (CRM). */
    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    /** @return Especialidade médica. */
    public String getSpecialty() {
        return specialty;
    }

    /** @param specialty Nova especialidade médica. */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /** @return Número do consultório. */
    public int getOfficeNumber() {
        return officeNumber;
    }

    /** @param officeNumber Novo número de consultório. */
    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    } 
    
    /**
     * Registra informações médicas do paciente em seu cadastro.
     * 
     * @param patient Paciente a ser atualizado.
     * @param isSmoker Se o paciente é fumante.
     * @param isDrinker Se o paciente consome álcool.
     * @param cholesterolLevel Nível de colesterol.
     * @param hasDiabetes Indica se o paciente tem diabetes.
     * @param hasHeartDisease Indica se o paciente tem doença cardíaca.
     * @param surgeries Lista de cirurgias realizadas.
     * @param allergies Lista de alergias conhecidas.
     */
    public void insertPatientRegistration(
            Patient patient,
            boolean isSmoker,
            boolean isDrinker,
            double cholesterolLevel,
            boolean hasDiabetes,
            boolean hasHeartDisease,
            List<String> surgeries,
            List<String> allergies
    ) {
        if (patient == null) {
            throw new RuntimeException("Patient cannot be null.");
        }
        
        Registration registration = patient.getRegistration();
        
        registration.setIsSmoker(isSmoker);
        registration.setIsDrinker(isDrinker);
        registration.setCholesterolLevel(cholesterolLevel);
        registration.setHasDiabetes(hasDiabetes);
        registration.setHasHeartDisease(hasHeartDisease);
        registration.setSurgeries(surgeries);
        registration.setAllergies(allergies);
    }

    /**
     * Atualiza informações médicas do paciente no registro.
     * Campos nulos são ignorados.
     * 
     * @param patient Paciente a ser atualizado.
     * @param isSmoker Se é fumante (opcional).
     * @param isDrinker Se consome álcool (opcional).
     * @param cholesterolLevel Nível de colesterol (opcional).
     * @param hasDiabetes Se tem diabetes (opcional).
     * @param hasHeartDisease Se tem doença cardíaca (opcional).
     * @param surgeries Lista de cirurgias (opcional).
     * @param allergies Lista de alergias (opcional).
     */
    public void updatePatientRegistrationDoctor(
            Patient patient,
            Boolean isSmoker,
            Boolean isDrinker,
            Double cholesterolLevel,
            Boolean hasDiabetes,
            Boolean hasHeartDisease,
            List<String> surgeries,
            List<String> allergies
    ) {
        if (isSmoker != null) {
            patient.getRegistration().setIsSmoker(isSmoker);
        }
        if (isDrinker != null) {
            patient.getRegistration().setIsDrinker(isDrinker);
        }
        if (cholesterolLevel != null) {
            patient.getRegistration().setCholesterolLevel(cholesterolLevel);
        }
        if (hasDiabetes != null) {
            patient.getRegistration().setHasDiabetes(hasDiabetes);
        }
        if (hasHeartDisease != null) {
            patient.getRegistration().setHasHeartDisease(hasHeartDisease);
        }
        if (surgeries != null) {
            patient.getRegistration().setSurgeries(surgeries);
        }
        if (allergies != null) {
            patient.getRegistration().setAllergies(allergies);
        }
    }

    /**
     * Remove as informações médicas do registro do paciente.
     * 
     * @param patient Paciente a ser limpo.
     */
    public void removePatientRegistrationDoctor(Patient patient) {
        patient.getRegistration().setIsSmoker(false);
        patient.getRegistration().setIsDrinker(false);
        patient.getRegistration().setCholesterolLevel(0.0);
        patient.getRegistration().setHasDiabetes(false);
        patient.getRegistration().setHasHeartDisease(false);
        patient.getRegistration().setSurgeries(null);
        patient.getRegistration().setAllergies(null);
    }

    /**
     * Cria um novo prontuário eletrônico (EHR) para o paciente.
     * 
     * @param patient Paciente a ser vinculado.
     * @param id Identificador do EHR.
     * @param doctor Médico responsável.
     * @param symptoms Lista de sintomas.
     * @param diagnosis Diagnóstico realizado.
     * @param treatmentPrescription Lista de tratamentos prescritos.
     */
    public void insertEHR(
            Patient patient,
            String id,
            Doctor doctor,
            List<String> symptoms,
            String diagnosis,
            List<String> treatmentPrescription
    ) {
        EletronicHealthRecord EHR = new EletronicHealthRecord(id, doctor, symptoms, diagnosis, treatmentPrescription);
        patient.setEHR(EHR);
    }

    /**
     * Atualiza um prontuário eletrônico existente do paciente.
     * 
     * @param patient Paciente cujo prontuário será atualizado.
     * @param id Novo identificador do EHR.
     * @param doctor Médico responsável.
     * @param symptoms Lista de sintomas.
     * @param diagnosis Diagnóstico atualizado.
     * @param treatmentPrescription Novas prescrições.
     */
    public void updateEHR(
            Patient patient,
            String id,
            Doctor doctor,
            List<String> symptoms,
            String diagnosis,
            List<String> treatmentPrescription
    ) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }

        EletronicHealthRecord ehr = patient.getEHR();
        if (ehr == null) {
            throw new IllegalStateException("No EHR found to update.");
        }

        ehr.setId(id);
        ehr.setDoctor(doctor);
        ehr.setSymptoms(symptoms);
        ehr.setDiagnosis(diagnosis);
        ehr.setTreatmentPrescription(treatmentPrescription);
    }

    /**
     * Remove o prontuário eletrônico do paciente.
     * 
     * @param patient Paciente cujo prontuário será removido.
     */
    public void removeEHR(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }

        if (patient.getEHR() == null) {
            throw new IllegalStateException("No EHR found to remove.");
        }

        patient.setEHR(null);
    }

    /**
     * Gera uma string com os tratamentos prescritos para o paciente.
     * 
     * @param patient Paciente cujo tratamento será listado.
     * @return Texto com os tratamentos.
     */
    public String buildTreatmentRegistration(Patient patient) {
        EletronicHealthRecord EHR = patient.getEHR();
        List<String> treatmentPrescription = EHR.getTreatmentPrescription();

        StringBuilder msg = new StringBuilder();
        msg.append("Tratamentos...\n");

        for (int i = 0; i < treatmentPrescription.size(); i++) {
            msg.append("Tratamento ").append(i + 1).append(": ").append(treatmentPrescription.get(i)).append("\n");
        }

        return msg.toString();
    }

    /**
     * Gera um atestado médico para o paciente.
     * 
     * @param patient Paciente atendido.
     * @param restDays Quantidade de dias de repouso recomendados.
     * @return Texto do atestado médico.
     */
    public String buildMedicalCertificate(Patient patient, int restDays) {
        return  """
                Atestado Médico
                
                Paciente: """ + patient.getFirstName()+ "\n" +
               "Diagnóstico: " + patient.getEHR().getDiagnosis() + "\n" +
               "Recomenda-se repouso de " + restDays + " dias.\n\n" +
               "Médico: Dr(a). " + this.getFirstName() + "\n" +
               "CRM: " + this.medicalLicenseNumber;
    }

    /**
     * Gera um relatório de atendimento médico.
     * 
     * @param patient Paciente atendido.
     * @return Texto com informações do atendimento.
     */
    public String buildAttendanceReport(Patient patient) {
        EletronicHealthRecord ehr = patient.getEHR();
        return """
               Relatório de Atendimento
               
               Paciente: """ + patient.getFirstName()+ "\n"
                + "Sintomas: " + ehr.getSymptoms()+ "\n"
                + "Diagnóstico: " + ehr.getDiagnosis() + "\n"
                + "Prescrição: " + ehr.getTreatmentPrescription();
    }

    /**
     * Gera uma declaração de acompanhamento médico.
     * 
     * @param patient Paciente atendido.
     * @param calendar Agenda de consultas.
     * @return Texto da declaração de acompanhamento.
     */
    public String buildFollowUpDeclaration(Patient patient, Calendar calendar) {
        Appointment appointment = calendar.getAppointment("App"+patient.getId()+this.getId());
    return """
           Declaração de Acompanhamento
           
           Declaro que o(a) paciente """ + " " + patient.getFirstName()+ 
           " esteve em consulta médica com Dr(a). " + this.getFirstName()+
           " no dia " + appointment.getScheduleDate()+ ".\n\n" +
           "Assinatura: ______________________";
    }
    
    /**
     * Conta quantas consultas o médico realizou em um determinado mês.
     * 
     * @param month Mês (em formato numérico, ex: "10").
     * @param calendar Agenda de consultas.
     * @return Quantidade de consultas realizadas no período.
     */
    public int buildAttendedInPeriod(String month, Calendar calendar) {
        return calendar.getAttendedAppointmentsByPeriod(this.getId(), month);
    }
}
