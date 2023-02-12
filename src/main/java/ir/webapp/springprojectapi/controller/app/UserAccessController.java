package ir.webapp.springprojectapi.controller.app;

import ir.webapp.springprojectapi.model.entity.UserAccess;
import ir.webapp.springprojectapi.model.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAccessController {

    private final UserAccessService userAccessService;

    @Autowired
    public UserAccessController(UserAccessService userAccessService){
        this.userAccessService = userAccessService;
    }

    public UserAccess save(UserAccess userAccess) {
        if (userAccess.getUsername() != null && userAccess.getPassword() != null)
        return userAccessService.save(userAccess);
        return null;
    }

    public String check(String username, String password) {
        if (username != null && password != null)
            return userAccessService.check(new UserAccess(username, password));
        return "null";
    }


    public String delete(Long id) {
        if (id != null && id >= 1)
            return userAccessService.delete(id);
        return "null";
    }

    public String update(Long id, String username, String password) {
        if (id != null && id >= 0)
            if ((username != null && username.length() > 0) || (password != null && password.length() > 0))
            return userAccessService.update(new UserAccess(id, username, password));
        return "null";
    }
}
