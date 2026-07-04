package usuarios;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int contadorTurnos = 1;

    public static void main(String[] args) {
        Queue<Citas> salaDeEspera = new LinkedList<>();
        int opcion = 0;

        do {
            IO.println("\n=================================");
            IO.println("  SISTEMA DE GESTIÓN DE TURNOS   ");
            IO.println("=================================");
            IO.println("1. Agendar Cita (Especialidad/Fecha)");
            IO.println("2. Registrar Paciente y Generar Turno");
            IO.println("3. Registrar Información Médica / Atender");
            IO.println("4. Módulo de Pagos");
            IO.println("5. Salir del Sistema");

            opcion = IO.readInt("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    if (salaDeEspera.isEmpty()) {
                        IO.println("Error: No hay pacientes en la cola. Use la opción 2 primero.");
                    } else {
                        Citas citaActual = null;
                        for (Citas c : salaDeEspera) { citaActual = c; }

                        String esp = IO.readString("Ingrese la Especialidad: ");
                        String fec = IO.readString("Ingrese la Fecha (DD/MM/AAAA): ");

                        citaActual.setEspecialidad(esp);
                        citaActual.setFecha(fec);

                        IO.println("¡Cita agendada con éxito!");
                        citaActual.mostrarTicketTurno();
                    }
                    break;

                case 2:
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

                case 3:
                    if (salaDeEspera.isEmpty()) {
                        IO.println("Error: No hay pacientes en la cola para registrar información médica.");
                    } else {
                        Citas citaAtendida = salaDeEspera.poll();
                        Paciente p = citaAtendida.getPaciente();

                        IO.println("\n--- REGISTRO DE INFORMACIÓN MÉDICA PARA: " + p.getNombre() + " " + p.getApellido() + " ---");
                        p.setTipoSangre(IO.readString("Tipo de Sangre: "));
                        p.setAlergias(IO.readString("Alergias: "));
                        p.setPeso(IO.readDouble("Peso (kg): "));
                        p.setAltura(IO.readDouble("Altura (m): "));
                        p.setMedicacion(IO.readString("Medicación actual: "));

                        IO.println("\n¡Información guardada exitosamente!");
                        p.mostrarDatosBasicos();
                        p.mostrarDatosMedicos();
                        IO.println("\n>>> Pacientes que quedan en la cola de espera: " + salaDeEspera.size());
                    }
                    break;

                case 4:
                    IO.println("Módulo de pagos en construcción...");
                    break;

                case 5:
                    IO.println("Cerrando el sistema médico...");
                    IO.println("Reporte final - Pacientes que quedaron en la cola: " + salaDeEspera.size());
                    break;

                default:
                    IO.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
}

// 🛠️ PARCHE AUXILIAR: Esto hace que el código de tu profesor funcione sin errores
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
