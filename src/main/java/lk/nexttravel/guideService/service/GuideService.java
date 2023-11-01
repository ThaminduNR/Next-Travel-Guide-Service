package lk.nexttravel.guideService.service;

import lk.nexttravel.guideService.dto.GuideDto;

import java.util.List;

public interface GuideService {

    void saveGuide(GuideDto dto);
    void updateGuide(GuideDto dto);
    void deleteGuide(String id);
    List<GuideDto> getAllGuide();
    GuideDto searchGuide(String id);
}
