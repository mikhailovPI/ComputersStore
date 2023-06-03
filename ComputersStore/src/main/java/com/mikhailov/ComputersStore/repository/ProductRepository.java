package com.mikhailov.ComputersStore.repository;

import com.mikhailov.ComputersStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


//    @Query("select  " +
//            "from  pr left join Type as t on  = us.id " +
//            "where us.id = ?1 " +
//            "and ?2 between b.start and b.end " +
//            "order by b.start DESC")
//    public List<Product>
}
