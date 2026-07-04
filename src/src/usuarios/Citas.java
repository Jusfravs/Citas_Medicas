package usuarios;

public class Citas {

    private Paciente paciente;
    private String numeroTurno;
    private String especialidad;
    private String fecha;


    // Constructor General de la Clase Cita
    public Citas(Paciente paciente, String numeroTurno, String especialidad, String fecha) {
        this.paciente = paciente;
        this.numeroTurno = numeroTurno;
        this.especialidad = especialidad;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public String getNumeroTurno() { return numeroTurno; }
    public void setNumeroTurno(String numeroTurno) { this.numeroTurno = numeroTurno; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }


    // Metodo Impresion
    public void mostrarTicketTurno() {
        System.out.println("================================");
        System.out.println("        TICKET DE TURNO         ");
        System.out.println("================================");
        System.out.println("Turno Nro: " + numeroTurno);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Fecha: " + fecha);
        if (paciente != null) {
            System.out.println("Paciente: " + paciente.getNombre() + " " + paciente.getApellido());
        }
        System.out.println("================================");
    }



}
