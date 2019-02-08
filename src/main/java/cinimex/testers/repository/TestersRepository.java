package cinimex.testers.repository;

import cinimex.testers.Model.Testers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for {@link cinimex.testers.Model.Testers} class.
 */
public interface TestersRepository extends JpaRepository<Testers, Long> {
}
