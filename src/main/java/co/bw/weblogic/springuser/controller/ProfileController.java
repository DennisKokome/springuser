package co.bw.weblogic.springuser.controller;

import co.bw.weblogic.springuser.model.Profile;
import co.bw.weblogic.springuser.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/")
    public Profile save(@RequestBody Profile profile) {
        return profileService.save(profile);
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable UUID id) {
        return profileService.findById(id);
    }

    @GetMapping("/")
    public List<Profile> getProfiles() {
        return profileService.findAll();
    }
}
