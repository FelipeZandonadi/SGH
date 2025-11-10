package users;
import data.Registration;
import data.EletronicHealthRecord;

/**
 * Representa um paciente do sistema hospitalar.
 * Contém informações pessoais, registro e prontuário eletrônico.
 * 
 * @author Acer
 */
public class Patient extends People {
    
    /** Cartão de saúde do paciente. */
    private String healthCard;
    
    /** Registro cadastral do paciente, com informações de endereço e plano. */
    private Registration registration;
    
    /** Prontuário eletrônico do paciente, contendo histórico médico e tratamentos. */
    private EletronicHealthRecord EHR;

    /**
     * Construtor da classe Patient.
     *
     * @param id Identificador do paciente.
     * @param firstName Primeiro nome.
     * @param lastName Sobrenome.
     * @param birthday Data de nascimento.
     * @param document Documento de identificação (ex: CPF).
     * @param email Endereço de e-mail.
     * @param phoneNumber Número de telefone.
     */
    public Patient(String id, String firstName, String lastName, String birthday, String document, String email, String phoneNumber) {
        super(id, firstName, lastName, birthday, document, email, phoneNumber);
    }

    /**
     * Retorna o cartão de saúde do paciente.
     * 
     * @return Cartão de saúde.
     */
    public String getHealthCard() {
        return healthCard;
    }

    /**
     * Define o cartão de saúde do paciente.
     * 
     * @param healthCard Novo cartão de saúde.
     */
    public void setHealthCard(String healthCard) {
        this.healthCard = healthCard;
    }

    /**
     * Retorna o registro cadastral do paciente.
     * 
     * @return Objeto {@link Registration} do paciente.
     */
    public Registration getRegistration() {
        return registration;
    }

    /**
     * Define o registro cadastral do paciente.
     * 
     * @param registration Novo registro {@link Registration}.
     */
    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    /**
     * Retorna o prontuário eletrônico do paciente.
     * 
     * @return Objeto {@link EletronicHealthRecord}.
     */
    public EletronicHealthRecord getEHR() {
        return EHR;
    }

    /**
     * Define o prontuário eletrônico do paciente.
     * 
     * @param EHR Novo prontuário {@link EletronicHealthRecord}.
     */
    public void setEHR(EletronicHealthRecord EHR) {
        this.EHR = EHR;
    }
}
