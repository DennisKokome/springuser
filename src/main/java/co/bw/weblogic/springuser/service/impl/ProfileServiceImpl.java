package co.bw.weblogic.springuser.service.impl;

import co.bw.weblogic.springuser.model.Profile;
import co.bw.weblogic.springuser.model.User;
import co.bw.weblogic.springuser.repository.ProfileRepository;
import co.bw.weblogic.springuser.repository.UserRepository;
import co.bw.weblogic.springuser.service.ProfileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Profile save(Profile profile) {
        User user = profile.getUser();
        if(user.getId() == null){
            userRepository.save(user);
        }
        profile.setUser(user);
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile findById(UUID id) {
        return profileRepository.findById(id).orElse(null);
    }
}
