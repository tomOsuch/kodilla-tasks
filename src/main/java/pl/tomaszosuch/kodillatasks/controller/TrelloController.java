package pl.tomaszosuch.kodillatasks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.kodillatasks.client.TrelloClient;
import pl.tomaszosuch.kodillatasks.domain.CreatedTrelloCard;
import pl.tomaszosuch.kodillatasks.dto.TrelloBoardDto;
import pl.tomaszosuch.kodillatasks.dto.TrelloCardDto;

import java.util.List;

@RestController
@RequestMapping("/v1/trello/")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
            System.out.println("This board contains lists");

            trelloBoardDto.getLists().forEach(trelloListDto -> {
                System.out.println(trelloListDto.getName() + " - " + trelloListDto.getId() + " - " + trelloListDto.isClosed());
            });
        });

        /*
        trelloBoards.stream()
                .filter(trelloBoardDto -> trelloBoardDto.getId() != null)
                .filter(trelloBoardDto -> trelloBoardDto.getName() != null)
                .filter(trelloBoardDto -> trelloBoardDto.getName().contains("Kodilla"))
                .forEach(trelloBoardDto -> {
                    System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
                });*/

    }

    @PostMapping("createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
