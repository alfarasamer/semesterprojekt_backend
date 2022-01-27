package com.example.semesterprojektbackend.repositories;

import com.example.semesterprojektbackend.model.Product;
import com.example.semesterprojektbackend.model.enumuration.Status;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProductSpecialRepo {

    EntityManager em;

    // constructor

    public List<Product> findProductsByActiveStatus(Status status) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> product = cq.from(Product.class);
        Predicate productStatusPredicate = cb.equal(product.get("status"), status);
        cq.where(productStatusPredicate);

        TypedQuery<Product> query = em.createQuery(cq);
        return query.getResultList();
    }
}
