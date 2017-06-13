package net.xaviersala;

import net.xaviersala.model.MafiaException;
import net.xaviersala.model.Mapa;
import net.xaviersala.model.Ruta;

import java.io.IOException;

/**
 * Programa que a partir d'un mapa i les rutes dels cobradors determina a quines
 * de les cases no s'ha anat.
 *
 */
public class App {

    public static final String NOM_MAPA = "cendrassi";

    public static void main(String[] args) {

        Mapa mapa = new Mapa();
        Ruta x = new Ruta();

        Lector lector = new Lector();

        try {

            String[] mapallegit = lector.llegirMapa(NOM_MAPA + ".txt");
            String[] rutes = lector.llegirRutes(NOM_MAPA + "-rutes.txt");


            // Crea el mapa a partir del que s'ha llegit
            mapa.carregaMapa(mapallegit);

            // Crea les diferents rutes i les passa pel mapa.
            for (String ruta : rutes) {

                x.creaRuta(ruta);
                mapa.passejaCobrador(x);
            }

            // Al acabar les cases per les que s'ha passat estan esborrades
            System.out.println("No s'ha anat a " + mapa.getCases());


        } catch (MafiaException e) {
            System.out.println("El mapa és incorrecte " + e.getMessage());
        } catch (IOException e) {
            System.out.println("El fitxer no existeix " + e.getMessage());
        }

    }
}
