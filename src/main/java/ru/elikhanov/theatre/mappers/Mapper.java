package ru.elikhanov.theatre.mappers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class Mapper {
    private final ModelMapper modelMapper;
    public    <S, T> List<T> convertToList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
    public    <S, T> T convertTo( S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }
}
