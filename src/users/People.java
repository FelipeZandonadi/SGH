package users;

/**
 * Representa uma pessoa no sistema, servindo como classe base para outros tipos
 * específicos de usuários (como estudantes, funcionários, etc.).
 * <p>
 * Esta classe contém informações pessoais fundamentais como nome, data de
 * nascimento, documento, e dados de contato.
 * </p>
 * 
 * @author Felipe
 * @version 1.0
 */
public abstract class People {

    /**
     * Identificador único do usuário.
     */
    private String id;

    /**
     * Primeiro nome do usuário.
     */
    private String firstName;

    /**
     * Sobrenome do usuário.
     */
    private String lastName;

    /**
     * Data de nascimento no formato yyyy-MM-dd.
     */
    private String birthday;

    /**
     * Documento de identificação no formato 000.000.000-00 (CPF).
     */
    private String document;

    /**
     * Endereço de e-mail válido.
     */
    private String email;

    /**
     * Número de telefone no formato (00) 9.8888-7777.
     */
    private String phoneNumber;

    /**
     * Construtor responsável por inicializar os atributos da pessoa com validação.
     *
     * @param id identificador do usuário
     * @param firstName primeiro nome do usuário
     * @param lastName sobrenome do usuário
     * @param birthday data de nascimento (yyyy-MM-dd)
     * @param document documento no formato 000.000.000-00
     * @param email e-mail válido
     * @param phoneNumber número de telefone (00) 9.8888-7777
     * @throws IllegalArgumentException caso algum dado esteja fora do formato esperado
     */
    public People(String id, String firstName, String lastName, String birthday,
                  String document, String email, String phoneNumber) {

        validateDateFormat(birthday);
        validateDocumentFormat(document);
        validateEmailFormat(email);
        validatePhoneNumberFormat(phoneNumber);

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.document = document;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retorna o ID da pessoa.
     *
     * @return o ID da pessoa
     */
    public String getId() {
        return id;
    }

    /**
     * Define o ID da pessoa.
     *
     * @param id novo ID
     * @throws IllegalArgumentException caso o ID seja nulo ou vazio
     */
    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID não pode ser vazio.");
        }
        this.id = id;
    }

    /**
     * @return primeiro nome da pessoa
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Define o primeiro nome da pessoa.
     *
     * @param firstName nome a ser definido
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return sobrenome da pessoa
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Define o sobrenome da pessoa.
     *
     * @param lastName sobrenome a ser definido
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return data de nascimento no formato yyyy-MM-dd
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Atualiza a data de nascimento após validação do formato.
     *
     * @param birthday nova data no formato yyyy-MM-dd
     * @throws IllegalArgumentException se a data for inválida
     */
    public void setBirthday(String birthday) {
        validateDateFormat(birthday);
        this.birthday = birthday;
    }

    /**
     * @return documento no formato 000.000.000-00
     */
    public String getDocument() {
        return document;
    }

    /**
     * Atualiza o documento após validação do formato.
     *
     * @param document documento em formato padrão
     * @throws IllegalArgumentException caso o formato seja inválido
     */
    public void setDocument(String document) {
        validateDocumentFormat(document);
        this.document = document;
    }

    /**
     * @return e-mail da pessoa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Atualiza o e-mail após validação do formato.
     *
     * @param email e-mail a ser definido
     * @throws IllegalArgumentException se o e-mail não for válido
     */
    public void setEmail(String email) {
        validateEmailFormat(email);
        this.email = email;
    }

    /**
     * @return número de telefone da pessoa
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Atualiza o número de telefone após validação.
     *
     * @param phoneNumber número no formato (00) 9.8888-7777
     * @throws IllegalArgumentException caso o formato não seja respeitado
     */
    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumberFormat(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
    

    private void validateDateFormat(String date) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";

        if (!date.matches(regex)) {
            throw new IllegalArgumentException("Data inválida! Formato esperado: yyyy-MM-dd");
        }
    }

    private void validateDocumentFormat(String document) {
        String regex = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";

        if (!document.matches(regex)) {
            throw new IllegalArgumentException("Documento inválido! Formato esperado: 000.000.000-00");
        }
    }

    private void validateEmailFormat(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!email.matches(regex)) {
            throw new IllegalArgumentException("Email inválido!");
        }
    }

    private void validatePhoneNumberFormat(String phoneNumber) {
        String regex = "^\\(\\d{2}\\) 9\\.\\d{4}-\\d{4}$";

        if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("Telefone inválido! Formato: (00) 9.8888-7777");
        }
    }
}
