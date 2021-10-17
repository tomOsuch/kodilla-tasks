package pl.tomaszosuch.kodillatasks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.tomaszosuch.kodillatasks.client.TrelloClient;
import pl.tomaszosuch.kodillatasks.dto.CreatedTrelloCardDto;
import pl.tomaszosuch.kodillatasks.dto.TrelloBoardDto;
import pl.tomaszosuch.kodillatasks.dto.TrelloCardDto;
import pl.tomaszosuch.kodillatasks.service.TrelloService;

import java.util.List;

@RestController
@RequestMapping("/v1/trello/")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;
    private final TrelloService trelloService;

    @GetMapping("getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
    }

    @PostMapping("createTrelloCard")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}
