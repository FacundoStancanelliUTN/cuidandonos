package org.example.domain;

import lombok.Getter;

@Getter
public class Direccion implements Comparable<Direccion> {

    private final String direccion;
    private final int orden;

    public Direccion(String direccion, int orden) {
        this.direccion = direccion;
        this.orden = orden;
    }

    @Override
    public int compareTo(Direccion o) {
        return Integer.compare(this.orden, o.orden);
    }
}
