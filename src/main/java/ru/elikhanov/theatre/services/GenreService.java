package ru.elikhanov.theatre.services;

import ru.elikhanov.theatre.DTO.GenreDTO;

import java.util.List;

public interface GenreService {
    List<GenreDTO> getAllGenres();

    GenreDTO getGenreById(Long genreId);

    GenreDTO createGenre(GenreDTO genreDTO);

    GenreDTO updateGenre(Long id, GenreDTO genreDTO);

    void deleteGenre(Long id);
}
