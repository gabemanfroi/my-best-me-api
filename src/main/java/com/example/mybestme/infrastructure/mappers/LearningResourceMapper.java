package com.example.mybestme.infrastructure.mappers;

import com.example.mybestme.domain.DTOS.LearningResourceDTO;
import com.example.mybestme.domain.models.LearningResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LearningResourceMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "description", target = "description")
    LearningResourceDTO mapOneEntityToDTO(LearningResource learningResource);

    List<LearningResourceDTO> mapMultipleEntitiesToDTOs(List<LearningResource> learningResources);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "url", target = "url")
    @Mapping(source = "description", target = "description")
    LearningResource mapOneDTOToEntity(LearningResourceDTO learningResourceDTO);
}
