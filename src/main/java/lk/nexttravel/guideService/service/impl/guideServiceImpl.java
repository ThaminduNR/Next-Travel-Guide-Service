package lk.nexttravel.guideService.service.impl;

import lk.nexttravel.guideService.dto.GuideDto;
import lk.nexttravel.guideService.entity.Guide;
import lk.nexttravel.guideService.exception.InvalidException;
import lk.nexttravel.guideService.exception.NotFoundException;
import lk.nexttravel.guideService.repo.GuideRepository;
import lk.nexttravel.guideService.service.GuideService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class guideServiceImpl implements GuideService {

    @Autowired
    GuideRepository guideRepository;
    @Autowired
    ModelMapper mapper;

    @Override
    public void saveGuide(GuideDto dto) {
        if (!guideRepository.existsById(dto.getGuideId())){
            guideRepository.save(mapper.map(dto, Guide.class));
        }else {
            throw new NotFoundException("Guide Already Exist");
        }

    }

    @Override
    public void updateGuide(GuideDto dto) {
        if (guideRepository.existsById(dto.getGuideId())){
            guideRepository.save(mapper.map(dto,Guide.class));
        }else {
            throw new NotFoundException("Guide not Found");
        }
    }

    @Override
    public void deleteGuide(String id) {
        if (guideRepository.existsById(id)){
            guideRepository.deleteById(id);
        }else {
            throw new NotFoundException("Guide Not Found");
        }
    }

    @Override
    public List<GuideDto> getAllGuide() {
        return mapper.map(guideRepository.findAll(), new TypeToken<List<GuideDto>>() {
        }.getType());
    }

    @Override
    public GuideDto searchGuide(String id) {
        if (guideRepository.existsById(id)){
            Guide guide = guideRepository.findById(id).get();
            return mapper.map(guide,GuideDto.class);
        }else {
            throw new NotFoundException("Guide Not Found");
        }

    }
}
