package br.com.futurodev.shoppinglist.model;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category implements Serializable {
    //Não permitir cadastro duplicado
    //Não permitir cadastro com campos inválidos

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nome da categoria: Única, tipo texto, preenchimento obrigatório
    private String name;

    //Descrição da categoria: Tipo texto, preenchimento não obrigatório
    private String description;

}
