/**
 * 
 */
package com.software.group2.repos;

import org.springframework.data.repository.CrudRepository;

import com.software.group2.entities.MyClass;

/**
 * @author Austin
 *
 */
public interface MyClassRepo extends CrudRepository<MyClass, Integer> {

}
