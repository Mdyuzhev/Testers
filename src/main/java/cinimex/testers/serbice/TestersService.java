package cinimex.testers.serbice;

import cinimex.testers.Model.Testers;

import java.util.List;

/**
 * Service interface for {@link cinimex.testers.Model.Testers} class.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public interface TestersService {

    Testers getById(Long id);

    void save(Testers testers);

    void delete(Long id);

    List<Testers> getAll();
}
