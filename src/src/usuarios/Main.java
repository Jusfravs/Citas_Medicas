package usuarios;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int contadorTurnos = 1;

    void main() {
        Queue<Citas> salaDeEspera = new LinkedList<>();
        int opcion;

        do {
            IO.println("\n=================================");
            IO.println("  SISTEMA DE GESTIÓN DE TURNOS   ");
            IO.println("=================================");
            IO.println("1. Registrar Paciente y Generar Turno");
            IO.println("2. Agendar Cita (Especialidad/Fecha)");
            IO.println("3. Registrar Información Médica / Atender");
            IO.println("4. Salir del Sistema");

            opcion = IO.readInt("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    IO.println("\n--- REGISTRO DE NUEVO PACIENTE ---");
                    String nom = IO.readString("Nombre: ");
                    String ape = IO.readString("Apellido: ");
                    int ed = IO.readInt("Edad: ");
                    String tel = IO.readString("Teléfono: ");
                    String cor = IO.readString("Correo: ");

                    Paciente nuevoPaciente = new Paciente(nom, ape, ed, tel, cor);
                    String turnoFormateado = String.format("%03d", contadorTurnos);

                    Citas nuevaCita = new Citas(nuevoPaciente, turnoFormateado, "Por asignar", "Por asignar");
                    salaDeEspera.add(nuevaCita);
                    contadorTurnos++;

                    IO.println("\n¡Paciente registrado en cola de espera!");
                    nuevaCita.mostrarTicketTurno();
                    IO.println("Pacientes actualmente en espera: " + salaDeEspera.size());
                    break;

                case 2:
                    if (salaDeEspera.isEmpty()) {
                        IO.println("Error: No hay pacientes en la cola. Use la opción 2 primero.");
                    } else {
                        String turnoBuscado = IO.readString("Ingrese el Número de Turno a agendar (ej. 001): ");
                        boolean encontrado = false;

                        for (Citas c : salaDeEspera) {
                            if (c.getNumeroTurno().equals(turnoBuscado)) {
                                String esp = IO.readString("Ingrese la Especialidad: ");
                                String fec = IO.readString("Ingrese la Fecha (DD/MM/AAAA): ");

                                c.setEspecialidad(esp);
                                c.setFecha(fec);

                                IO.println("\n¡Cita agendada con éxito!");
                                c.mostrarTicketTurno();
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            IO.println("Error: Turno no encontrado en la sala de espera.");
                        }
                    }
                    break;

                case 3:
                    if (salaDeEspera.isEmpty()) {
                        IO.println("Error: No hay pacientes en la cola para atender.");
                    } else {

                        Citas citaAtendida = salaDeEspera.poll();
                        Paciente p = citaAtendida.getPaciente();

                        IO.println("\n--- EL DOCTOR ESTÁ ATENDIENDO AL TURNO: " + citaAtendida.getNumeroTurno() + " ---");
                        IO.println("Paciente: " + p.getNombre() + " " + p.getApellido());

                        p.setTipoSangre(IO.readString("Tipo de Sangre: "));
                        p.setAlergias(IO.readString("Alergias: "));
                        p.setPeso(IO.readDouble("Peso (kg): "));
                        p.setAltura(IO.readDouble("Altura (m): "));
                        p.setMedicacion(IO.readString("Medicación actual: "));

                        IO.println("¡Paciente atendido y despachado exitosamente!");
                        p.mostrarDatosBasicos();
                        p.mostrarDatosMedicos();
                        IO.println(">>> Pacientes que quedan esperando en la sala: " + salaDeEspera.size());
                    }
                    break;

                case 4:
                    IO.println("Cerrando el sistema médico...");
                    IO.println("Reporte final - Pacientes que quedaron en la cola: " + salaDeEspera.size());
                    break;

                default:
                    IO.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }
}


class IO {
    private static final Scanner sc = new Scanner(System.in);
    public static void println(String msg) { System.out.println(msg); }
    public static String readString(String prompt) { System.out.print(prompt); return sc.nextLine(); }
    public static int readInt(String prompt) {
        System.out.print(prompt);
        try { return Integer.parseInt(sc.nextLine()); } catch(Exception e) { return 0; }
    }
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        try { return Double.parseDouble(sc.nextLine()); } catch(Exception e) { return 0.0; }
    }
}
