package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	 private ProductService productService;

	 private static final String VIEWS_PRODUCT_CREATE_FORM = "products/createOrUpdateProductForm";
	    
	 @Autowired
	 public ProductController(ProductService productService) {
		 this.productService=productService;
	 }
	 
	    
	 
	 @InitBinder
	    public void setAllowedFields(WebDataBinder dataBinder) {
	        dataBinder.setDisallowedFields("id");
	    }
	 
	 @ModelAttribute("types")
	    public List<ProductType> populateProductTypes() {
	        return this.productService.findAllProductTypes();
	    }
	 
	 @GetMapping(value = "/product/create")
		public String initCreationForm(Map<String, Object> model) {
			Product product = new Product();
			model.put("product", product);
			return VIEWS_PRODUCT_CREATE_FORM;
		}
	 
	 @PostMapping(value = "/product/create")
		public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {
			if (result.hasErrors()) {
				return "products/createOrUpdateProductForm";
			}
			else {
				this.productService.save(product);
				return "welcome";
			}
		}   
	    
	
    
}
