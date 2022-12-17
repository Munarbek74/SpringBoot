package com.peaksoft.service;

import com.peaksoft.models.Course;
import com.peaksoft.models.Group;
import com.peaksoft.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GroupService {
    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    public List<Group> getAll() {
       return groupRepository.findAll();

    }

    public void savegroup(Group group) {
        groupRepository.save(group);
    }

    public void deleteByIdgroup(Long id) {
        groupRepository.deleteById(id);
    }

    public Group findByIdgroup(Long id) {
        return groupRepository.findById(id).get();
    }

    public void assignGroup(Long courseId, Long groupId) {
        groupRepository.assignGroup(courseId, groupId);
    }
}
