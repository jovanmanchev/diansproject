package mk.ukim.finki.usersservice.repository.dataholder;

import lombok.Data;

@Data
public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }
}
