package Adaptador;

import Modelos.Persona;
import Utiles.ErrorLog;

public class PersonaAdapter {

    String consulta;
    ErrorLog perror;
    Persona persona;
    public String Consulta(Persona personaDatos){
        persona.setNombre(personaDatos.getNombre());
        consulta = "Nombre = " + persona.getNombre();
        return consulta;
    }
}
