package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "product_type")
public class ProductType extends BaseEntity{
	@NotBlank
    @Size(min = 3, max=50)
    @Column( unique=true, name = "name")
    String name;
}
