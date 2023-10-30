package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class SedeJJOOKey implements Serializable {
    @Column(name = "año")
    private Integer año;

    @Column(name = "id_tipo_jjoo")
    private Integer id_tipo_jjoo;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SedeJJOOKey castedObj)) {
            return false;
        }
        return Objects.equals(año, castedObj.getAño()) && Objects.equals(id_tipo_jjoo, castedObj.getId_tipo_jjoo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(año, id_tipo_jjoo);
    }
}
