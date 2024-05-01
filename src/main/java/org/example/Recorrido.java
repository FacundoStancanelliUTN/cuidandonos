package org.example;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class Recorrido {

    private List<Direccion> direcciones;

    @Getter
    private int avisoEstadoSaludEnMinutos;

    private List<Direccion> direccionesOrdenadas() {
        List<Direccion> direccionesOrdenadas = direcciones.stream().sorted(Direccion::compareTo).collect(Collectors.toList());
        return direccionesOrdenadas;
    }

    public Direccion getDireccion(int index) {
        return direccionesOrdenadas().get(index);
    }

    public int sizeDirecciones() {
        return direccionesOrdenadas().size();
    }
}
