package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Employee {

	// employee_id column, using the @Id and @GeneratedValue annotations to tell spring the id should be auto-generated

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	private String employeeFirstName;
	private String employeeLastName;
	
	// employee_phone column - annotation to identify as this value needing to be unique
	@Column(unique = true)
	private String employeePhone;
	
	private String employeeJobTitle;
	
	
	// annotation identifying this as a many-to-one relationship, mapping many employees to one store,  
	// using the @EqualsandHashCode and @ToString annotations to prevent recursion
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_store_id")
	private PetStore petStore; 
}
