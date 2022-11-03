package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
	private ProductRepository pr;
	
	@Autowired
	public ProductService(ProductRepository pr) {
		this.pr=pr;
	}
	
	
    public List<Product> getAllProducts(){
        return pr.findAll();
    }
	

    public List<Product> getProductsCheaperThan(double price) {
        return pr.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return pr.findTypeByName(typeName);
    }

    public Product save(Product p){
        return null;       
    }
    
    public List<ProductType> findAllProductTypes() {
    	return pr.findAllProductTypes();
    }

    
}
