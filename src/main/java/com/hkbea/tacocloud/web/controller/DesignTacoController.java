package com.hkbea.tacocloud.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkbea.tacocloud.domain.Ingredient;
import com.hkbea.tacocloud.domain.Ingredient.Type;
import com.hkbea.tacocloud.domain.Taco;

@Controller
@RequestMapping(value = {"/design"})
public class DesignTacoController {

	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		ingredients.add(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		ingredients.add(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		ingredients.add(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		ingredients.add(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
		ingredients.add(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		ingredients.add(new Ingredient("CHED", "Cheddar", Type.CHEESE));
		ingredients.add(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
		ingredients.add(new Ingredient("SLSA", "Salsa", Type.SAUCE));
		ingredients.add(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
		
		Type[] types = Ingredient.Type.values();
		for(Type type:types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		model.addAttribute("design", new Taco());
		
		return "design";
	}
	
	
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		List<Ingredient> result = new ArrayList<Ingredient>();
		for(Ingredient ingredient:ingredients) {
			if(ingredient.getType().equals(type)) {
				result.add(ingredient);
			}
		}
		
		return result;
	}
}
