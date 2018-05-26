package crud;

import crud.PlayerRepository;
import crud.PlayerManipulator;
import crud.Player;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static PlayerManipulator playerManipulator;
    private PlayerRepository playerRepository;

    @Autowired
    Controller(PlayerManipulator playerManipulator, PlayerRepository playerRepository){
        this.playerManipulator = playerManipulator;
        this.playerRepository = playerRepository;
    }


    @RequestMapping(value = "/Player/add", method = RequestMethod.POST)
    public String addPlayer(@RequestParam(value = "steamid") long name,
                            @RequestParam(value = "nickname") String nickname,
                            @RequestParam(value = "vacBan") byte vacBanned,
                            @RequestParam(value = "accountValue") double accountValue) {
        playerManipulator.addPlayer(name,nickname,vacBanned,accountValue);
        return "Player was added successfully.";
    }

    @RequestMapping(value = "/Player/get", method = RequestMethod.GET)
    public Player getPlayer(@RequestParam(value = "steamid") long steamId) {
        return playerManipulator.getBySteamId(steamId);
    }

    @RequestMapping(value = "/Player/update", method = RequestMethod.PUT)
    public String updatePlayer(@RequestParam(value = "steamId") long steamid,
                               @RequestParam(value = "nickname") String nickname,
                               @RequestParam(value = "vacBanned") byte vacBanned,
                               @RequestParam(value = "accountValue") double accountValue){
        playerManipulator.updatePlayer(steamid, nickname, vacBanned,  accountValue);
        return "Player was updated successfully.";
    }

    @RequestMapping(value = "/Player/delete", method = RequestMethod.DELETE)
    public String deletePlayer(@RequestParam(value = "id") Long steamId) throws NotFoundException {
        if(!playerRepository.existsById(steamId))
            throw new NotFoundException("There is no Player with such id.");
        playerRepository.deleteById(steamId);
        return "Player was deleted successfully.";
    }




}



