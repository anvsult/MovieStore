package com.example.moviestore.presentationLayer;

import com.example.moviestore.dataAccessLayer.Director;
import com.example.moviestore.serviceLayer.DirectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping("/add-directors")
    public List<DirectorResponseDTO> addDirectors(@RequestBody List<DirectorRequestDTO> newDirectorsData) {
        return directorService.addDirectors(newDirectorsData);
    }
    @PostMapping("/add-director")
    public DirectorResponseDTO addDirector(@RequestBody DirectorRequestDTO newDirectorData) {
        return directorService.addDirector(newDirectorData);
    }
    @GetMapping("/get-directors")
    public List<DirectorResponseDTO> getDirectors() {
        return directorService.getDirectors();
    }
    @GetMapping("/get-director/{directorId}")
    public DirectorResponseDTO getDirectorById(@PathVariable String directorId) {
        return directorService.getDirectorById(directorId);
    }
    @PutMapping("/update-director/{directorId}")
    public DirectorResponseDTO updateDirector(@PathVariable String directorId, @RequestBody DirectorRequestDTO updatedDirectorData) {
        return directorService.updateDirector(directorId, updatedDirectorData);
    }
    @DeleteMapping("/delete-director/{directorId}")
    public String deleteDirector(@PathVariable String directorId) {
        return directorService.deleteDirector(directorId);
    }

}
