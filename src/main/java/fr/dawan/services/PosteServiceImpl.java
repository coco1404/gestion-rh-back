package fr.dawan.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.dto.PosteDto;
import fr.dawan.dto.SalarieDto;
import fr.dawan.entities.Poste;
import fr.dawan.entities.Salarie;
import fr.dawan.mappers.MapperCommun;
import fr.dawan.repositories.PosteRepository;

@Service
@Transactional
public class PosteServiceImpl implements PosteService{
    
    @Autowired
    PosteRepository posteRepository;
    
    @Override
    public List<PosteDto> getAllPosteByPage(int page, int size) {
        List<Poste> lst = posteRepository.findAll(PageRequest.of(page, size)).get().collect(Collectors.toList());
        List<PosteDto> result = new ArrayList<PosteDto>();
        for (Poste c : lst) {
            result.add(MapperCommun.convert(c, PosteDto.class));
        }
        return result;
    }

    @Override
    public List<PosteDto> getPosteByTypeContrat(long idTypeContrat) {
        List<Poste> lst = posteRepository.getPosteByTypeContrat(idTypeContrat);
        List<PosteDto> result = new ArrayList<PosteDto>();
        for (Poste c : lst) {
            result.add(MapperCommun.convert(c, PosteDto.class));
        }
        return result;
    }

    @Override
    public List<PosteDto> getPosteByManager(long idManager) {
        List<Poste> lst = posteRepository.getPosteByManager(idManager);
        List<PosteDto> result = new ArrayList<PosteDto>();
        for (Poste c : lst) {
            result.add(MapperCommun.convert(c, PosteDto.class));
        }
        return result;
    }

    @Override
    public List<PosteDto> getPosteByLieuTravail(long idLieuTravail) {
        List<Poste> lst = posteRepository.getPosteByLieuTravail(idLieuTravail);
        List<PosteDto> result = new ArrayList<PosteDto>();
        for (Poste c : lst) {
            result.add(MapperCommun.convert(c, PosteDto.class));
        }
        return result;
    }

    @Override
    public List<PosteDto> recherchePoste(String recherche) {
        List<Poste> lst = posteRepository.recherchePoste(recherche.toLowerCase());
        List<PosteDto> result = new ArrayList<PosteDto>();
        for (Poste c : lst) {
            result.add(MapperCommun.convert(c, PosteDto.class));
        }
        return result;
    }

    @Override
    public List<PosteDto> recherchePoste(Date dateDebut, Date dateFin) {
        List<Poste> lst = posteRepository.recherchePoste(dateDebut, dateFin);
        List<PosteDto> result = new ArrayList<PosteDto>();
        for (Poste c : lst) {
            result.add(MapperCommun.convert(c, PosteDto.class));
        }
        return result;
    }

    @Override
    public PosteDto saveOrUpdate(PosteDto posteDto) {
        Poste p = MapperCommun.convert(posteDto, Poste.class);
        System.out.println("p = "+(p.getManager() == null));
        if(p.getManager().getId() == 0) {
            p.setManager(null);
        }
        if(p.getMaitreAppretissage().getId() == 0) {
            p.setMaitreAppretissage(null);
        }
        p = posteRepository.saveAndFlush(p);
        return MapperCommun.convert(p, PosteDto.class);
    }

    @Override
    public void delete(PosteDto posteDto) {
        Poste p = MapperCommun.convert(posteDto, Poste.class);
        posteRepository.delete(p);
    }

    @Override
    public void deleteById(long idPoste) {
        posteRepository.deleteById(idPoste);
    }

    @Override
    public long countPoste() {
        return posteRepository.count();
    }

    @Override
    public List<PosteDto> getAllPoste() {
        List<Poste> lst = posteRepository.findAll();
        List<PosteDto> result = new ArrayList<PosteDto>();
        for (Poste c : lst) {
            result.add(MapperCommun.convert(c, PosteDto.class));
        }
        return result;
    }

    @Override
    public PosteDto getPosteById(long id) {
        Optional<Poste> p = posteRepository.findById(id);
        if (p.isPresent()) {
            return MapperCommun.convert(p.get(), PosteDto.class);
        }
        return null;
    }

    @Override
    public void updateContrat(String name, long idPoste) {
        posteRepository.updateContrat(name, idPoste);
    }

    @Override
    public PosteDto cloturerPoste(PosteDto posteDto) {
        Poste p = MapperCommun.convert(posteDto, Poste.class);
        p.setDateFin(new Date());
        p = posteRepository.saveAndFlush(p);
        return MapperCommun.convert(p, PosteDto.class);
    }

}
