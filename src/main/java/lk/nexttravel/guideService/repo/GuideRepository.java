package lk.nexttravel.guideService.repo;

import lk.nexttravel.guideService.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<Guide,String> {
}
