package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class PetStore {

	// pet_store_id column, using the @Id and @GeneratedValue annotations to tell spring the id should be auto-generated

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petStoreId;
	
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;

	// pet_store_phone column - annotation to identify as this value needing to be unique

	@Column(unique = true)
	private String petStorePhone;

	// generates a set of customers and creates the pet_store_customer join table, using the pet_store_id from the pet_store table and 
	// customer_id column from the customer table
	@EqualsAndHashCode.Exclude
	@ToString.Exclude	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pet_store_customer", 
	joinColumns = @JoinColumn(name = "pet_store_id"), 
	inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private Set<Customer> customers = new HashSet<>();

	// annotation identifying this as a one-to-many relationship, mapping one store to many employees 
	// using the @EqualsandHashCode and @ToString annotations to prevent recursion
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Employee> employees = new HashSet<>();
	
}
