package com.example.market.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
@Entity
public class Goods extends AuditingFields{

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @ManyToOne(optional = false)private UserAccount userAccount;

    @Setter @Column(nullable = false) private String title;
    @Setter @Column(nullable = false, length = 2000) private String content;

    public Goods() {}
    Goods(UserAccount userAccount, String title, String content) {
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
    }


    public static Goods of(UserAccount userAccount, String title, String content){
        return new Goods(userAccount, title, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods goods)) return false;
        return id != null && id.equals(goods.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
