public class Paciente {
    private String nombre;
    private String identificador;
    private String correo;
    private String numero;
    private String motivo;

    //contructor paciente
    //parametro (String = nombre)
    public Paciente(String nombre, String identificador, String correo, String numero, String motivo) {

        this.nombre = nombre;
        this.identificador = identificador;
        this.correo = correo;
        this.numero = numero;
        this.motivo = motivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
