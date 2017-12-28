package com.isle.student.dao.mongo;

import com.isle.student.dao.document.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by 61066 on 2017/12/28.
 */
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

}
