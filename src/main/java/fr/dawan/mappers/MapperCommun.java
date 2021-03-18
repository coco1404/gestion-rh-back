package fr.dawan.mappers;

import org.modelmapper.ModelMapper;

public class MapperCommun {
    
    public static <TSource, Tdestination> Tdestination convert(TSource obj, Class<Tdestination> clazz){
        ModelMapper myMapper = new ModelMapper();
        
        /*myMapper.typeMap(Poste.class, PosteDto.class).addMappings(mapper->{
           mapper.map(src->src.getDateDebut(), PosteDto::setDateDebut);
           mapper.map(src->src.getDateFin(), PosteDto::setDateFin);
           mapper.map(src->src.getTitre(), PosteDto::setTitre);
           mapper.map(src->src.getId(), PosteDto::setId);
           mapper.map(src->src.getSalarie(), PosteDto::setSalarie);
           mapper.map(src->src.getTypeContrat(), PosteDto::setTypeContrat);
        });*/
        
        return myMapper.map(obj,  clazz);
    }
    
}
