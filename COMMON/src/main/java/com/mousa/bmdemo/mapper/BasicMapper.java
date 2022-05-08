package com.mousa.bmdemo.mapper;

import org.mapstruct.MappingTarget;
import java.util.*;

public interface BasicMapper<Entity, DTO> {
	Entity dtoToEntity(DTO dto);

	DTO entityToDto(Entity entity);

	List<DTO> listToDto(List<Entity> list);

	List<Entity> listToEntity(List<DTO> list);
 

	void updateEntityFromDto(DTO dto, @MappingTarget Entity entity);

}
