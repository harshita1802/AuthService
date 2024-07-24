package dev.harshita.AuthService.model;

import dev.harshita.AuthService.model.constant.SessionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Session extends BaseModel{
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    private String token;
    private Date loginTime;
    private Date expiryTime;
    private String deviceIp;
    @Enumerated(EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}
