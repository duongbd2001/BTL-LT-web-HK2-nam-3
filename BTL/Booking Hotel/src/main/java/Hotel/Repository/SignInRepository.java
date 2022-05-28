package Hotel.Repository;

import Hotel.Model.UserSignIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignInRepository extends JpaRepository<UserSignIn,Integer> {
    @Query(value = "select a.* from tb_USers a where a.user_name = :name and a.pass_wd = :pass", nativeQuery = true)
    Optional<UserSignIn> findByUsernameAndPassword(@Param("name") String username, @Param("pass") String password);
    UserSignIn findUserSignInByUsernameAndPassword(String username, String password);
}
