package org.example.calculadores.distancias;

import org.example.domain.Direccion;

public interface CalculadorDistanciaEntreDirecciones {
    float calcularDistanciaEnMetros(Direccion salida, Direccion llegada);
}
