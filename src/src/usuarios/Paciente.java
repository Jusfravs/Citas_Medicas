package usuarios;

public class Paciente {
    // Atributos privados básicos
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String correo;

    // Atributos privados médicos
    private String tipoSangre;
    private String alergias;
    private double peso;
    private double altura;
    private String medicacion;

    // Constructor General
    public Paciente(String nombre, String apellido, int edad, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        // Valores médicos iniciales por defecto
        this.tipoSangre = "No registrado";
        this.alergias = "Ninguna";
        this.peso = 0.0;
        this.altura = 0.0;
        this.medicacion = "Ninguna";
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTipoSangre() { return tipoSangre; }
    public void setTipoSangre(String tipoSangre) { this.tipoSangre = tipoSangre; }

    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public String getMedicacion() { return medicacion; }
    public void setMedicacion(String medicacion) { this.medicacion = medicacion; }


}
