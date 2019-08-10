package com.Revan;

import com.Revan.Exepciones.ErrorValidacion;

public class Visitante {
    public String nombreCompleto;
    public String telefono;
    public int numVisitas =0;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNumVisitas() {
        return numVisitas;
    }

    public void setNombreCompleto(String nombreCompleto) throws ErrorValidacion {
        if(nombreCompleto.length()>50){
            throw new ErrorValidacion("El nombre debe tener menos de 50 caracteres");
        }
        this.nombreCompleto = nombreCompleto;
    }


    public void setTelefono(String telefono) throws ErrorValidacion {
        if (!telefono.matches("[0-9]{4}\\-[0-9]{4}")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }

    public void setNumVisitas(int numVisitas) {

        this.numVisitas = numVisitas + this.numVisitas;
    }
}
