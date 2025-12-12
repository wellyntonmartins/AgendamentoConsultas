package classes;

import java.util.ArrayList;
import java.util.List;

public class Listagem {
    private static List<Paciente> listaPacientes = new ArrayList<>();

    public static List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public static void addPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }
    
    public static void removePaciente(int pos) {
        listaPacientes.remove(pos);
    }
    
    public static Paciente getPaciente(int pos) {
        return listaPacientes.get(pos);
    }
}
