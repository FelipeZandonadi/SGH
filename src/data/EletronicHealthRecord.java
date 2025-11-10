package data;
import java.util.List;
import users.Doctor;

/**
 * Representa o prontuário eletrônico de um paciente (EHR - Electronic Health Record).
 * 
 * <p>Contém informações médicas importantes, como o médico responsável,
 * sintomas, diagnóstico e prescrições de tratamento.</p>
 * 
 * @author Acer
 */
public class EletronicHealthRecord {
    
    private String id;
    private Doctor doctor;
    private List<String> symptoms;
    private String diagnosis;
    private List<String> treatmentPrescription;

    /**
     * Construtor da classe EletronicHealthRecord.
     * 
     * @param id identificador único do prontuário
     * @param doctor médico responsável pelo registro
     * @param symptoms lista de sintomas apresentados pelo paciente
     * @param diagnosis diagnóstico definido pelo médico
     * @param treatmentPrescription lista de tratamentos ou medicamentos prescritos
     */
    public EletronicHealthRecord(String id, Doctor doctor, List symptoms, String diagnosis, List<String> treatmentPrescription) {
        this.id = id;
        this.doctor = doctor;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatmentPrescription = treatmentPrescription;
    }

    /**
     * Obtém o identificador do prontuário.
     * @return o ID do prontuário
     */
    public String getId() {
        return id;
    }

    /**
     * Define o identificador do prontuário.
     * @param id o novo ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém o médico responsável pelo prontuário.
     * @return o médico associado
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Define o médico responsável pelo prontuário.
     * @param doctor o novo médico associado
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * Obtém a lista de sintomas relatados no prontuário.
     * @return lista de sintomas
     */
    public List getSymptoms() {
        return symptoms;
    }

    /**
     * Define a lista de sintomas relatados no prontuário.
     * @param symptoms nova lista de sintomas
     */
    public void setSymptoms(List symptoms) {
        this.symptoms = symptoms;
    }

    /**
     * Obtém o diagnóstico médico.
     * @return o diagnóstico
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Define o diagnóstico médico.
     * @param diagnosis novo diagnóstico
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Obtém a lista de tratamentos ou prescrições médicas.
     * @return lista de prescrições
     */
    public List<String> getTreatmentPrescription() {
        return treatmentPrescription;
    }

    /**
     * Define a lista de tratamentos ou prescrições médicas.
     * @param treatmentPrescription nova lista de prescrições
     */
    public void setTreatmentPrescription(List<String> treatmentPrescription) {
        this.treatmentPrescription = treatmentPrescription;
    }
}
