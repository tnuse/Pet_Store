package pet.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.PetStore;


// PetStoreDAO Interface for PetStore class, extending JpaRepository
public interface PetStoreDao extends JpaRepository<PetStore, Long> {

}
