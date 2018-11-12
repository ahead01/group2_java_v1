/**
 * 
 */
package com.software.group2.repos;

import org.springframework.data.repository.CrudRepository;

import com.software.group2.entities.Student;

/**
 * @author Austin
 *
 */
public interface StudentRepo extends CrudRepository<Student, Integer> {

}
