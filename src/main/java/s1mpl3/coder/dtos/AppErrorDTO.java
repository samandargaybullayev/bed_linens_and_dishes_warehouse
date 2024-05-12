package s1mpl3.coder.dtos;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AppErrorDTO {
    private Timestamp timestamp;
    private String friendlyMessage;
    private String developerMessage;

    public AppErrorDTO(String friendlyMessage, String developerMessage) {
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.friendlyMessage = friendlyMessage;
        this.developerMessage = developerMessage;
    }



    public AppErrorDTO(String friendlyMessage) {
        this(friendlyMessage, friendlyMessage);
    }
}
