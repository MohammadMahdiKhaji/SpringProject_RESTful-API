package ir.webapp.springprojectapi.model.service;

import ir.webapp.springprojectapi.model.entity.UserAccess;
import ir.webapp.springprojectapi.model.repository.UserDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserAccessService {

    private final UserDA userDA;

    @Autowired
    public UserAccessService(UserDA userDA){
        this.userDA = userDA;
    }

    public UserAccess save(UserAccess userAccess) {
        return userDA.save(userAccess);
    }

    public String check(UserAccess userAccess) {
        Optional<UserAccess> userAccessOptional = userDA.findByUsernameAndPassword(userAccess.getUsername(), userAccess.getPassword());
        if(userAccessOptional.isPresent())
            return "Already Exists";
        return  "It Doesn't Exist";
    }

    public String delete(Long id) {
        if(userDA.existsById(id)) {
            userDA.deleteById(id);
            return "Deleted";
        }
        return "User Doesn't Exist";
    }

    @Transactional
    public String update(UserAccess userAccessNew) {
            UserAccess userAccessOld = userDA.findById(userAccessNew.getId())
                    .orElseThrow(() -> new IllegalStateException(
                            "Student with id" + userAccessNew.getId() + "doesn't exist"));
            if(userAccessNew.getUsername() != null && !userAccessNew.getUsername().equals(userAccessOld.getUsername())){
                userAccessOld.setUsername(userAccessNew.getUsername());
            }
            if (userAccessNew.getPassword() != null && !userAccessNew.getPassword().equals(userAccessOld.getPassword())){
                Optional<UserAccess> userAccessOptional = userDA.findByPassword(userAccessNew.getPassword());
                if(userAccessOptional.isPresent()){
                    throw new IllegalStateException("Password taken");
                }
                userAccessOld.setPassword(userAccessNew.getPassword());
            }
            return null;
    }
}
