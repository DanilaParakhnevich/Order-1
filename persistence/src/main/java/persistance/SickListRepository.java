package persistance;

import entity.SickList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SickListRepository extends JpaRepository<SickList,Long> {
}
