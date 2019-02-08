package cinimex.testers.serbice;

import cinimex.testers.Model.Testers;
import cinimex.testers.repository.TestersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementations of {@link TestersService} interface.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@Slf4j
@Service
public class TestersServiceImpl implements TestersService {

    @Autowired
    TestersRepository testersRepository;

    @Override
    public Testers getById(Long id) {
        log.info("IN TestersServiceImpl getById {}", id);
        return testersRepository.findOne(id);
    }

    @Override
    public void save(Testers testers) {
        log.info("IN TestersServiceImpl save {}", testers);
        testersRepository.save(testers);
    }

    @Override
    public void delete(Long id) {
        log.info("IN TestersServiceImpl delete {}", id);
        testersRepository.delete(id);
    }

    @Override
    public List<Testers> getAll() {
        log.info("IN TestersServiceImpl getAll");
        return testersRepository.findAll();
    }
}
