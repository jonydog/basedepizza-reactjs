package com.jpinto.basedepizza.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpinto.basedepizza.model.Ingredient;

@Repository
public interface IngredientDAO extends JpaRepository<Ingredient,Long>{
	
	
	@Query("select i from Ingredient i where i.name=:ingredientName")
	public List<Ingredient> getIngredientByName( @Param("ingredientName") String name);
	
	@Query("select i from Ingredient i")
	public List<Ingredient> getAllIngredients();
	
}
