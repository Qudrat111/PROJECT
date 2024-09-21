package com.example.jakartapdponline.service;
import com.example.jakartapdponline.model.Group;
import com.example.jakartapdponline.repository.GroupRepository;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
public class GroupService {
    private GroupRepository groupRepository;
    public GroupService() {
        groupRepository = new GroupRepository();
    }
    public void save(Group group) {
        group.setCreatedBy(group.getId());
        groupRepository.insertGroup(group);
    }
    public void update(Group group, int id) {
        group.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        group.setUpdatedBy(group.getId());
        groupRepository.updateGroup(id, group);
    }
    public void delete(int id) {
        groupRepository.deleteGroup(id);
    }
    public List<Group> getAll() {
        Optional<List<Group>> all = groupRepository.getAll();
        return all.get();
    }
}