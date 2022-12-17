package com.peaksoft.repository;

import com.peaksoft.models.Group;
import com.peaksoft.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("select c, g from Course c, Group g where c.id=g.id")
    void assignGroup(Long courseId, Long groupId);
}