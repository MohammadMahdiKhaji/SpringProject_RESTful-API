package ir.webapp.springprojectapi.controller.api;

import ir.webapp.springprojectapi.controller.app.UserAccessController;
import ir.webapp.springprojectapi.model.entity.UserAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserAccessApi {

    private final UserAccessController userAccessController;

    @Autowired
    public UserAccessApi(UserAccessController userAccessController){
        this.userAccessController = userAccessController;
    }

    @GetMapping(path = "/check/{username}&{password}")
    public String check(@PathVariable("username") String username,
                        @PathVariable("password") String password){
        return userAccessController.check(username, password);
    }

    @PostMapping(path = "/save")
    public UserAccess save(@RequestBody UserAccess userAccess){
            return userAccessController.save(userAccess);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String check(@PathVariable("id") Long id){
        return userAccessController.delete(id);
    }

    @PutMapping(path = "/update/{id}")
    public String update(@PathVariable("id") Long id,
                         @RequestParam(required = false) String username,
                         @RequestParam(required = false) String password){
        return userAccessController.update(id, username, password);
    }
}
