package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String fechaDeNacimiento;
    private String fechadeMuerte;
    @ManyToOne
    private Libro libro;

    public Autor(){}

    public Autor(DatosAutor autor) {
        this.nombre = autor.nombre();
        this.fechaDeNacimiento = autor.fechaDeNacimiento();
        this.fechadeMuerte = autor.fechadeMuerte();
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechadeMuerte() {
        return fechadeMuerte;
    }

    @Override
    public String toString() {
        return "AutorBd{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", fechadeMuerte='" + fechadeMuerte + '\'' +
                ", libroDd=" + libro +
                '}';
    }
}
