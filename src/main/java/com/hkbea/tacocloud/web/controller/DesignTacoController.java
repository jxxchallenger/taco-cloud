package com.hkbea.tacocloud.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hkbea.tacocloud.domain.Ingredient;
import com.hkbea.tacocloud.domain.Ingredient.Type;
import com.hkbea.tacocloud.domain.Taco;

@Controller
@RequestMapping(value = {"/design"})
public class DesignTacoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DesignTacoController.class);
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
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
	}
	
	@GetMapping
	public String showDesignForm(Model model) {
		LOGGER.info("start deal /design request");
		
		model.addAttribute("design", new Taco());
		LOGGER.info("end deal /design request");
		return "design";
	}
	
	/**
	 * 
	 * @param design 如果不使用@ModelAttribute注解指定名称,则默认将类名(首字母小写)当作名称,
	   *                                              与design.html页面th:object="${design}"指定的名称对应不上
	 * @param errors
	 * @return
	 */
	@PostMapping
	public String processDesign(@Valid @ModelAttribute(value = "design") Taco design, Errors errors)
	{
		if(errors.hasErrors())
		{
			return "design";
		}
		LOGGER.info("Processing Desing: " + design);
		return "redirect:/orders/current";
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
