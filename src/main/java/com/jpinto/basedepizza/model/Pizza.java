package com.jpinto.basedepizza.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "por_pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Boolean isVegetarian;
	
	@NotNull
	@Size(max=50)
	private String name;
	
	
	@Size(max=255)
	private String description;
	
	@NotNull
	private Float priceInEuros;
	
	@NotNull
	@Valid
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Ingredient> ingredients;
	
	

	
	public Pizza (){}
	
	public Pizza (String name, String description, Float priceInEuros, Boolean isVegetarian, List<Ingredient> ingredients){
		this.name = name;
		this.description = description;
		this.priceInEuros = priceInEuros;
		this.isVegetarian = isVegetarian;
		this.ingredients = ingredients;
	}
	
	
	
}
