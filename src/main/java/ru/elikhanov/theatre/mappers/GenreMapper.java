package ru.elikhanov.theatre.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.elikhanov.theatre.DTO.GenreDTO;
import ru.elikhanov.theatre.models.Genre;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GenreMapper {

    private final ModelMapper modelMapper;



    public List<GenreDTO> createGenreDTOList(List<Genre> GenreList) {
        return GenreList
                .stream()
                .map(this::convertToGenreDTO)
                .collect(Collectors.toList());
    }

    public Genre convertToGenre(GenreDTO GenreDTO) {
        return modelMapper.map(GenreDTO, Genre.class);
    }

    public GenreDTO convertToGenreDTO(Genre Genre) {
        return modelMapper.map(Genre, GenreDTO.class);
    }

}
