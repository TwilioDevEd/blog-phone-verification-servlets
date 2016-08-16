import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Number {
    @Id
    private String id;
    private String phoneNumber;
    private String verificationCode;
    private boolean verified;

    public Number(String phoneNumber, String verificationCode) {
        this.id = UUID.randomUUID().toString();
        this.phoneNumber = phoneNumber;
        this.verificationCode = verificationCode;
        this.verified = false;
    }

    // used by JPA
    Number() {}

}
