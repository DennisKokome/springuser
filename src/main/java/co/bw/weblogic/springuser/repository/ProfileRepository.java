package co.bw.weblogic.springuser.repository;

import co.bw.weblogic.springuser.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
}
