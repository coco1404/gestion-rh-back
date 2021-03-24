package fr.dawan.mappers;

import org.modelmapper.ModelMapper;

import fr.dawan.dto.SalarieListeDto;
import fr.dawan.entities.Poste;

public class MapperCommun {

    public static <TSource, Tdestination> Tdestination convert(TSource obj, Class<Tdestination> clazz) {
        ModelMapper myMapper = new ModelMapper();

        myMapper.typeMap(Poste.class, SalarieListeDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getSalarie().getEntreprise(), SalarieListeDto::setEntreprise);
            mapper.map(src -> src.getSalarie().getDomaine(), SalarieListeDto::setDomaine);
            mapper.map(src -> src.getTitrePoste(), SalarieListeDto::setPosteActuel);
        });
        return myMapper.map(obj, clazz);
    }

}
