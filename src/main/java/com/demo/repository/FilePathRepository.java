package com.demo.repository;


import org.springframework.data.repository.CrudRepository;
import com.demo.entity.FilePath;

public interface FilePathRepository extends CrudRepository<FilePath, Integer> {

}
