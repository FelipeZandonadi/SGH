package appointments;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe responsável por gerenciar os compromissos (consultas) de um sistema.
 * Fornece operações para adicionar, remover, buscar e filtrar compromissos
 * de acordo com critérios como data e médico responsável.
 * 
 * @author Acer
 */
public class Calendar {
    
    /** Lista que armazena todos os compromissos registrados no calendário. */
    private List<Appointment> appointments = new ArrayList<>();

    /**
     * Construtor padrão da classe {@code Calendar}.
     * Inicializa a lista de compromissos vazia.
     */
    public Calendar() {
        
    }

    /**
     * Retorna todos os compromissos armazenados no calendário.
     * 
     * @return uma lista de {@link Appointment} contendo todos os compromissos.
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }
    
    /**
     * Busca um compromisso específico pelo seu identificador único.
     * 
     * @param id identificador do compromisso desejado.
     * @return o objeto {@link Appointment} correspondente ao ID, ou {@code null} se não for encontrado.
     */
    public Appointment getAppointment(String id) {
        Iterator<Appointment> it = appointments.iterator();
        
        while (it.hasNext()) {
            Appointment appointment = it.next();
            if (id.equals(appointment.getId())) {
                return appointment;
            }
        }
        return null;
    }
    
    /**
     * Remove um compromisso específico do calendário com base em seu identificador.
     * 
     * @param id identificador do compromisso a ser removido.
     * @throws RuntimeException se o compromisso não existir na lista.
     */
    public void removeAppointment(String id) {
        Iterator<Appointment> it = appointments.iterator();
        boolean find = false;
        while (it.hasNext() && !find) {
            Appointment appointment = it.next();
            if (id.equals(appointment.getId())) {
                it.remove();
                find = true;
            }
        }
        if (!find) {
            throw new RuntimeException("this appointment does not exist");
        }
    }

    /**
     * Adiciona um novo compromisso ao calendário.
     * 
     * @param appointment o compromisso a ser adicionado.
     */
    public void setAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }
    
    /**
     * Retorna uma lista contendo todos os compromissos agendados para o dia seguinte
     * à data fornecida.
     * 
     * @param todayDate data atual no formato "yyyy-MM-dd".
     * @return uma lista de {@link Appointment} agendados para o próximo dia.
     */
    public List<Appointment> getUpComingAppointments(String todayDate) {
        List<Appointment> nextDayAppointments = new ArrayList<>();
    
        LocalDate today = LocalDate.parse(todayDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate nextDay = today.plusDays(1);

        for (Appointment appointment : appointments) {
            String scheduleDate = appointment.getScheduleDate();
            LocalDate appointmentDate = LocalDate.parse(scheduleDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            if (appointmentDate.equals(nextDay)) {
                nextDayAppointments.add(appointment);
            }
        }

        return nextDayAppointments;
    }

    /**
     * Conta o número de consultas atendidas por um determinado médico em um mês específico.
     * 
     * @param doctorId identificador do médico.
     * @param month mês desejado no formato "MM".
     * @return o número total de consultas atendidas no período informado.
     */
    public int getAttendedAppointmentsByPeriod(String doctorId, String month) {
        int count = 0;

        for (Appointment appointment : appointments) {
            if (appointment.getDoctor().getId().equals(doctorId)) {
                String scheduleDate = appointment.getScheduleDate(); 
                String appointmentMonth = scheduleDate.substring(5, 7);
                
                if (appointmentMonth.equals(month)) {
                    count++;
                }
            }
        }

        return count;
    }
}
