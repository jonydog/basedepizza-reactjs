package com.jpinto.basedepizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="por_ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max=50)
	private String name;
	
	@NotNull
	private boolean isVegetarian;
	
	public Ingredient(){}
	
	public Ingredient (String name, boolean isVegetarian){
		this.name = name;
		this.isVegetarian = isVegetarian;
	}
	
}
