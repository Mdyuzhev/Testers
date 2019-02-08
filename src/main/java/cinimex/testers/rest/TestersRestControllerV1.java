package cinimex.testers.rest;

import cinimex.testers.Model.Testers;
import cinimex.testers.serbice.TestersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for {@link cinimex.testers.Model.Testers} connected requests.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping("/api/v1/testers/")
public class TestersRestControllerV1 {

    @Autowired
    private TestersService testersService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Testers> getTestersResponseEntity(@PathVariable("id") Long testersId) {
        if (testersId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Testers testers = this.testersService.getById(testersId);

        if (testers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(testers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Testers> saveTesters(@RequestBody @Valid Testers testers) {
        HttpHeaders headers = new HttpHeaders();

        if (testers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.testersService.save(testers);
        return new ResponseEntity<>(testers, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Testers> updateTesters(@RequestBody @Valid Testers testers, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (testers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.testersService.save(testers);

        return new ResponseEntity<>(testers, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Testers> deleteTesters(@PathVariable("id") Long id) {
        Testers testers = this.testersService.getById(id);

        if (testers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.testersService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Testers>> getAllTesters() {
        List<Testers> testers = this.testersService.getAll();

        if (testers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(testers, HttpStatus.OK);
    }
}
