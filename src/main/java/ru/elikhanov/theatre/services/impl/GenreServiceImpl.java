package ru.elikhanov.theatre.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.elikhanov.theatre.DTO.GenreDTO;
import ru.elikhanov.theatre.exceptions.BadRequestException;
import ru.elikhanov.theatre.exceptions.NotFoundException;
import ru.elikhanov.theatre.mappers.Mapper;
import ru.elikhanov.theatre.models.Genre;
import ru.elikhanov.theatre.repositories.GenreRepository;
import ru.elikhanov.theatre.services.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GenreServiceImpl implements GenreService {
    private final Mapper mapper;

    private final GenreRepository genreRepository;

    @Override
    public List<GenreDTO> getAllGenres() {
        return mapper.convertToList(genreRepository.findAll(), GenreDTO.class);
    }

    @Override
    public GenreDTO getGenreById(Long genreId) {
        Genre genre = findGenreById(genreId);
        return mapper.convertTo(genre, GenreDTO.class);
    }

    @Override
    @Transactional
    public Long createGenre(GenreDTO genreDTO) {
        findGenreIsPresentThrow(genreDTO.getName());
        Genre genre = mapper.convertTo(genreDTO, Genre.class);
        genreRepository.save(genre);
        return genre.getId();
    }

    @Override
    @Transactional
    public GenreDTO updateGenre(Long genreId, GenreDTO genreDTO) {
        findGenreIsPresentThrow(genreDTO.getName());
        Genre updatedGenre = findGenreById(genreId);
        findGenreIsPresentThrow(genreDTO.getName());
        updatedGenre = mapper.convertTo(genreDTO, Genre.class);
        updatedGenre.setId(genreId);
        genreRepository.save(updatedGenre);

        return genreDTO;
    }

    @Override
    @Transactional
    public void deleteGenre(Long id) {
        findGenreById(id);
        genreRepository.deleteById(id);
    }

    private Genre findGenreById(Long genreId) {
        Genre genre = genreRepository.findById(genreId).orElseThrow(() ->
                new NotFoundException(
                        "Genre with id " + genreId + " not found"));
        return genre;
    }

    private void findGenreIsPresentThrow(String name) {
        genreRepository.findByName(name).ifPresent((c) -> {
            throw new BadRequestException(
                    "Genre with name  " + name + " already exist");
        });
    }
}
