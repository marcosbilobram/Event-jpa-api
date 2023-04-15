package br.com.fiap.cp.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_product")
@SequenceGenerator(name="prd", sequenceName = "SQ_TB_PRODUCT", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "prd")
    @Column(name = "nr_product_id")
    private Long id;

    @Column(name = "nm_product_name", nullable = false, length = 25)
    private String name;
    
    @Column(name = "ds_product_desc", nullable = false)
    private String description;
    
    @Column(name = "nr_product_price", scale = 3, precision = 2, nullable = false)
    private Double pricePerUnit;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "tb_category", 
    
    		joinColumns = @JoinColumn(
    				name = "prod_id", 
    				referencedColumnName = "nr_product_id"
    		),
    		
    		inverseJoinColumns = @JoinColumn(
    				name = "categ_id",
    				referencedColumnName = "nr_category_id")
    		)
    private List<Category> categories;
    
    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Order> orders;

}
