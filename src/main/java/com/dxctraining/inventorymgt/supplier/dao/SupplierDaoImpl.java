package com.dxctraining.inventorymgt.supplier.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNotFoundException;
@Repository
public class SupplierDaoImpl implements ISupplierDao {
	
	@PersistenceContext
    private EntityManager entityManager1;
	
	 @Override
	    public Supplier findSupplierById(int id) {
	        Supplier supplier=entityManager1.find(Supplier.class,id);
	        if(supplier==null){
	            throw new SupplierNotFoundException("supplier not found for id="+id);
	        }
	        return supplier;
	    }
	 @Override
	    public Supplier add(Supplier supplier) {
	        entityManager1.persist(supplier);
	        return supplier;
	    }
	 @Override
	    public void remove(int id) {
	     Supplier supplier= findSupplierById(id) ;
	     entityManager1.remove(supplier);
	    }

}
