import java.time.LocalDate;

public class Cita {

    public Paciente paciente;
    public doctor doctor;
    public LocalDate fecha;

    public Cita(Paciente paciente, doctor  doctor, LocalDate fecha){
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;

    }
}
