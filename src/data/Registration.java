package data;
import java.util.List;

/**
 * Representa o registro médico e administrativo de um paciente.
 * 
 * <p>Contém informações como endereço, tipo de plano de saúde,
 * hábitos de vida (fumo, álcool), condições médicas e histórico
 * de cirurgias e alergias.</p>
 * 
 * @author Acer
 */
public class Registration {
    
    private String id;
    private String adress;
    private String planType;
    private boolean isSmoker;
    private boolean isDrinker;
    private double cholesterolLevel;
    private boolean hasDiabetes;
    private boolean hasHeartDisease;
    private List<String> surgeries;
    private List<String> allergies;

    /**
     * Construtor padrão da classe Registration.
     */
    public Registration() {}

    /**
     * Obtém o identificador do registro.
     * @return o ID do registro
     */
    public String getId() {
        return id;
    }

    /**
     * Define o identificador do registro.
     * @param id o novo ID do registro
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtém o endereço do paciente.
     * @return o endereço
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Define o endereço do paciente.
     * @param adress o novo endereço
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    /**
     * Obtém o tipo de plano de saúde.
     * @return o tipo de plano
     */
    public String getPlanType() {
        return planType;
    }

    /**
     * Define o tipo de plano de saúde.
     * @param planType o novo tipo de plano
     */
    public void setPlanType(String planType) {
        this.planType = planType;
    }

    /**
     * Verifica se o paciente é fumante.
     * @return {@code true} se o paciente for fumante, caso contrário {@code false}
     */
    public boolean isIsSmoker() {
        return isSmoker;
    }

    /**
     * Define se o paciente é fumante.
     * @param isSmoker valor booleano indicando se é fumante
     */
    public void setIsSmoker(boolean isSmoker) {
        this.isSmoker = isSmoker;
    }

    /**
     * Verifica se o paciente consome bebidas alcoólicas.
     * @return {@code true} se o paciente for consumidor, caso contrário {@code false}
     */
    public boolean isIsDrinker() {
        return isDrinker;
    }

    /**
     * Define se o paciente consome bebidas alcoólicas.
     * @param isDrinker valor booleano indicando se é consumidor
     */
    public void setIsDrinker(boolean isDrinker) {
        this.isDrinker = isDrinker;
    }

    /**
     * Obtém o nível de colesterol do paciente.
     * @return o nível de colesterol
     */
    public double getCholesterolLevel() {
        return cholesterolLevel;
    }

    /**
     * Define o nível de colesterol do paciente.
     * @param cholesterolLevel novo valor de colesterol
     */
    public void setCholesterolLevel(double cholesterolLevel) {
        this.cholesterolLevel = cholesterolLevel;
    }

    /**
     * Verifica se o paciente tem diabetes.
     * @return {@code true} se o paciente tiver diabetes, caso contrário {@code false}
     */
    public boolean isHasDiabetes() {
        return hasDiabetes;
    }

    /**
     * Define se o paciente tem diabetes.
     * @param hasDiabetes valor booleano indicando se tem diabetes
     */
    public void setHasDiabetes(boolean hasDiabetes) {
        this.hasDiabetes = hasDiabetes;
    }

    /**
     * Verifica se o paciente tem doença cardíaca.
     * @return {@code true} se o paciente tiver doença cardíaca, caso contrário {@code false}
     */
    public boolean isHasHeartDisease() {
        return hasHeartDisease;
    }

    /**
     * Define se o paciente tem doença cardíaca.
     * @param hasHeartDisease valor booleano indicando se tem doença cardíaca
     */
    public void setHasHeartDisease(boolean hasHeartDisease) {
        this.hasHeartDisease = hasHeartDisease;
    }

    /**
     * Obtém a lista de cirurgias realizadas pelo paciente.
     * @return lista de cirurgias
     */
    public List getSurgeries() {
        return surgeries;
    }

    /**
     * Define a lista de cirurgias realizadas pelo paciente.
     * @param surgeries nova lista de cirurgias
     */
    public void setSurgeries(List surgeries) {
        this.surgeries = surgeries;
    }

    /**
     * Obtém a lista de alergias do paciente.
     * @return lista de alergias
     */
    public List getAllergies() {
        return allergies;
    }

    /**
     * Define a lista de alergias do paciente.
     * @param allergies nova lista de alergias
     */
    public void setAllergies(List allergies) {
        this.allergies = allergies;
    }
}
