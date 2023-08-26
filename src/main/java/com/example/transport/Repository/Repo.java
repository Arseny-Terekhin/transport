package com.example.transport.Repository;

import com.example.transport.entity.Transport;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends CrudRepository<Transport, Long> {
    static Specification<Transport> hasBrand(String brand) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("brand"), "%" + brand + "%"));
    }

    static Specification<Transport> hasModel(String model) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("model"), "%" + model + "%"));
    }

    static Specification<Transport> hasCategory(String category) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("category"), "%" + category + "%"));
    }

    static Specification<Transport> hasLicenseNumber(String licenseNumber) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("licenseNumber"), "%" + licenseNumber + "%"));
    }

    static Specification<Transport> hasReleaseYear(String releaseYear) {
        if (releaseYear == null || releaseYear.equals("")) {
            return null;
        }
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("releaseYear"), releaseYear));
    }

    List<Transport> findAll(Specification<Transport> specification);
}

