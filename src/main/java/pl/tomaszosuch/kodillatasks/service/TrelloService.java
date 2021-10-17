package pl.tomaszosuch.kodillatasks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.tomaszosuch.kodillatasks.client.TrelloClient;
import pl.tomaszosuch.kodillatasks.config.AdminConfig;
import pl.tomaszosuch.kodillatasks.domain.Mail;
import pl.tomaszosuch.kodillatasks.dto.CreatedTrelloCardDto;
import pl.tomaszosuch.kodillatasks.dto.TrelloBoardDto;
import pl.tomaszosuch.kodillatasks.dto.TrelloCardDto;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class TrelloService {

    private static final String SUBJECT = "Tasks: New Trello card";
    private final TrelloClient trelloClient;
    private final SimpleEmailService emailService;
    private final AdminConfig adminConfig;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);

        ofNullable(newCard).ifPresent(card -> emailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        null,
                        SUBJECT,
                        "new card: " + trelloCardDto.getName() + " has bean created on your Trello account"
                )));

        return newCard;
    }


}
