package org.example.calculadores;

import org.example.domain.Direccion;
import org.example.domain.Recorrido;

import java.util.ArrayList;
import java.util.List;

public class CalculadorDeDemoraEnRecorrido {

    private final CalculadorDistanciaEntreDirecciones calculadorDistanciaEntreDirecciones;
    private final CalculadorTiempoEntreDistancias calculadorTiempoEntreDistancias;

    public CalculadorDeDemoraEnRecorrido(CalculadorDistanciaEntreDirecciones calculadorDistanciaEntreDirecciones, CalculadorTiempoEntreDistancias calculadorTiempoEntreDistancias) {
        this.calculadorDistanciaEntreDirecciones = calculadorDistanciaEntreDirecciones;
        this.calculadorTiempoEntreDistancias = calculadorTiempoEntreDistancias;
    }


    public List<Float> calcularDemoraPorSecciones(Recorrido recorrido) {
        return getMinutosParaRecorrerSecciones(recorrido);
    }

    public float calcularDemoraEnRecorridoTotal(Recorrido recorrido) {

        List<Float> tiempoEnMinutosParaRecorrerSecciones = getMinutosParaRecorrerSecciones(recorrido);

        Float tiempoTotal = tiempoEnMinutosParaRecorrerSecciones.stream().reduce(0F, Float::sum);

        return tiempoTotal;
    }

    private List<Float> getMinutosParaRecorrerSecciones(Recorrido recorrido) {

        float minutosParaDistancia;
        float distanciaEnMetros;
        List<Float> tiempoEnMinutosPorSeccion = new ArrayList<>();
        Direccion partida = recorrido.getDireccion(0);

        for (int i = 1; i < recorrido.sizeDirecciones(); i++) {
            Direccion proximaDireccion = recorrido.getDireccion(i);
            distanciaEnMetros = calculadorDistanciaEntreDirecciones.calcularDistanciaEnMetros(partida, proximaDireccion);
            minutosParaDistancia = calculadorTiempoEntreDistancias.getMinutosEntreDistanciasEnMetros(distanciaEnMetros);
            if (recorrido.getAvisoEstadoSaludEnMinutos() != 0) {
                minutosParaDistancia += recorrido.getAvisoEstadoSaludEnMinutos();
            }
            tiempoEnMinutosPorSeccion.add(minutosParaDistancia);
            partida = proximaDireccion;
        }

        return tiempoEnMinutosPorSeccion;
    }
}