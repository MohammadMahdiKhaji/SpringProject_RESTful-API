package ir.webapp.springprojectapi.model.service.serviceimpl;

import ir.webapp.springprojectapi.model.entity.UserAccess;
import ir.webapp.springprojectapi.model.repository.UserDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDA userDA;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccess userAccess = userDA.findByUsername(username.trim().toLowerCase());
        if (userAccess == null){
            throw new UsernameNotFoundException("user name not found");
        }
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(String.valueOf(userAccess.getClassification()));
        return new User(userAccess.getUsername(), userAccess.getPassword(), Collections.singleton(grantedAuthority));
    }
}
