package dev.harshita.AuthService.model;

import dev.harshita.AuthService.model.constant.SessionStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Session extends BaseModel{
    @ManyToOne
    private User user;
    private String token;
    private Date loginTime;
    private Date expiryTime;
    private String deviceIp;
    @Enumerated(EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}
