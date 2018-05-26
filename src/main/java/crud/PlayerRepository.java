package crud;

import crud.Player;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Long> {

    List<Player> findPlayerWithAccountValueInRange(@Param("value1") double value1, @Param("value2") double value2) ;
}

