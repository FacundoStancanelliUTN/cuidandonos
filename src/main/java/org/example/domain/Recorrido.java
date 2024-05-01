package org.example.domain;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class Recorrido {

    private List<Direccion> direcciones;

    @Getter
    private int avisoEstadoSaludEnMinutos;

    private List<Direccion> getDireccionesOrdenadas() {
        List<Direccion> direccionesOrdenadas = direcciones.stream().sorted(Direccion::compareTo).collect(Collectors.toList());
        return direccionesOrdenadas;
    }

    public Direccion getDireccion(int index) {
        return getDireccionesOrdenadas().get(index);
    }

    public int sizeDirecciones() {
        return getDireccionesOrdenadas().size();
    }
}
