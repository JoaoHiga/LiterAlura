package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idioma idiomas;
    private Double numeroDeDescargas;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autor;

    public Libro(){}

    public Libro(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.idiomas =Idioma.fromString(datosLibros.idiomas().stream().limit(1).collect(Collectors.joining()));
        this.numeroDeDescargas = datosLibros.numeroDeDescargas();
    }

    @Override
    public String toString() {
        return "LibroDd{" +
                "titulo='" + titulo + '\'' +
                ", idiomas=" + idiomas +
                ", numeroDeDescargas=" + numeroDeDescargas +
                ", autores=" + autor +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public Idioma getIdiomas() {
        return idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        autor.forEach(a-> a.setLibro(this));
        this.autor = autor;
    }
}
