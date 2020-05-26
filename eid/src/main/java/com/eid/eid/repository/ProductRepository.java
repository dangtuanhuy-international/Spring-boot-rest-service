/**
 * 
 */
package com.eid.eid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eid.eid.entity.Product;

/**
 * @author HUY
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
