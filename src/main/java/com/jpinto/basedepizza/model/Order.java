package com.jpinto.basedepizza.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="por_order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Date orderStartingDate;

	@NotNull
	private Float price;

	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull
	private User orderOwner;

	@ManyToMany( cascade=CascadeType.DETACH , fetch=FetchType.EAGER)
	private List<Pizza> pizzas;
	
	@NotNull
	private Boolean finished; 
	

}
