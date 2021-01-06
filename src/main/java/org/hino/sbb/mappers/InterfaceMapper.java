package org.hino.sbb.mappers;

import org.hino.sbb.dto.AbstractDTO;
import org.hino.sbb.model.AbstractEntity;
import org.hino.sbb.model.Station;

import java.util.Collection;
import java.util.List;

public interface InterfaceMapper<T extends AbstractDTO, E extends AbstractEntity> {

    public E toEntity(T dto) ;

    public T toDto(E entity);

    public Collection<T> toDto(Collection<E> collection);

}
