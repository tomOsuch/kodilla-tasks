package pl.tomaszosuch.kodillatasks.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.tomaszosuch.kodillatasks.config.AdminConfig;
import pl.tomaszosuch.kodillatasks.domain.Mail;
import pl.tomaszosuch.kodillatasks.repository.TaskRepository;
import pl.tomaszosuch.kodillatasks.service.SimpleEmailService;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;
    private static final String SUBJECT = "Tasks: Once a day";

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();

        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        null,
                        SUBJECT,
                        messageTaskCount(taskRepository.count())
                )
        );

    }

    private String messageTaskCount(long size) {
        return String.format("Currently in database you got: ", size == 1 ? size + " task" : size + " tasks");
    }
}
