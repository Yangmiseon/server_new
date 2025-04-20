package kr.hhplus.be.server.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="user")
public class UserEntity {

    @Id
    @Column(nullable = false)
    String userId;

    @Column(nullable = false)
    String userPassword;

    @Column(nullable = false)
    String userName;

    @Column(nullable = false)
    String userAdd;

    @Column(nullable = false)
    String userPhoneNum;

    @Column(nullable = false)
    String userCouponYN;



}
