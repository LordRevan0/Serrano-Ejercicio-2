package com.Revan;
import com.Revan.Exepciones.ErrorValidacion;

import java.util.ArrayList;


public class Main {
    static ArrayList<Visitante> visitantes = new ArrayList();

    public static void main(String[] args) throws ErrorValidacion {
        while (true) {

            System.out.println("*******     Bienvenido     ******");
            System.out.println("1. Registrar visita");
            System.out.println("2. Mostrar visitantes");
            System.out.println("3. Salir");
            System.out.println("________________");
            int opcion= Lector.solicitarEntero("Seleccione alguna opcion: ");
            switch (opcion){
                case 1:
                    System.out.println("Por favor ingrese sus datos personales");
                    String nombre= Lector.solicitarString("Ingrese su nombre:");
                    String telefono= Lector.solicitarString("Ingrese su telefono: ");
                    int visita=1;
                    Visitante nuevoVisitante= new Visitante();
                    try{
                        nuevoVisitante.setNombreCompleto(nombre);
                        nuevoVisitante.setTelefono(telefono);
                    } catch (ErrorValidacion e) {
                        System.err.println(e.getMessage());
                    }
                    nuevoVisitante.setNumVisitas(visita);
                    int indice=-1;
                    int cont=0;
                    if(!visitantes.isEmpty()) {
                        for (Visitante c : visitantes) {
                            if (c.getTelefono().equals(telefono)) {
                                System.out.println("El numero de telefono ya ha sido ingresado");
                                indice = cont;
                            }
                            cont++;
                        }
                    }
                    if (indice!=-1) {
                        visitantes.get(indice).setNumVisitas(visita);
                    } else {
                        if (nuevoVisitante.getTelefono()!=null && nuevoVisitante.getNombreCompleto()!=null) {
                            visitantes.add(nuevoVisitante);
                            System.out.println("Registro ingresado correctamente");
                        }else{
                            System.out.println("Ingreso el nombre o telefono de forma incorrecta no se agrega este registro");
                        }
                    }
                    break;
                case 2:
                    if(visitantes.isEmpty()){
                        System.out.println("No ha ingresado registros");
                    } else{
                        System.out.println("Mostrando todos los registros:");
                        int contador=1;
                        for (Visitante c : visitantes) {
                            System.out.println(contador + " visitante");
                            System.out.println("Nombre: " + c.getNombreCompleto());
                            System.out.println("Telefono: " + c.getTelefono());
                            System.out.println("Cantidad de visitas: " + c.getNumVisitas());
                            contador++;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Por favor, seleccione una opcion valida.");
                    break;
            }

            if (opcion == 3) {
                break;
            }
        }
    }
}