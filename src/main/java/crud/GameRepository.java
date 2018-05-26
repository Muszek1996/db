package crud;

import crud.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game,Long> {
    List<Game> findByNameContainingOrderByLastNameDesc(String toFind);
    List<Game> findByNameContainingOrderByLastNameAsc(String toFind);
}
