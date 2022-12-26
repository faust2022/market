package com.example.market.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "userId", unique = true),
        @Index(columnList = "email", unique = true),
})
@Entity
public class UserAccount{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable = false, length = 50) private String userId;
    @Setter @Column(nullable = false)  private String userPassword;
    @Setter @Column(length = 100) private String email;
    @Setter @Column(length = 100) private String nickname;

    protected UserAccount(){}

    public UserAccount(String userId, String userPassword, String email, String nickname) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.email = email;
        this.nickname = nickname;
    }

    public static UserAccount of(String userId, String userPassword, String email, String nickname){
        return new UserAccount(userId, userPassword, email, nickname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount userAccount)) return false;
        return id != null && id.equals(userAccount.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

