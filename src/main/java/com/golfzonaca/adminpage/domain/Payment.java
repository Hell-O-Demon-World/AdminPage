package com.golfzonaca.adminpage.domain;

import com.golfzonaca.adminpage.domain.type.PG;
import com.golfzonaca.adminpage.domain.type.PayType;
import com.golfzonaca.adminpage.domain.type.PayWay;
import com.golfzonaca.adminpage.domain.type.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "Payment", columnNames = {"PAY_API_CODE"})})
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID")
    private Reservation reservation;

    @Column(name = "PAY_DATE", nullable = false)
    private LocalDate payDate;

    @Column(name = "PAY_TIME", nullable = false)
    private LocalTime payTime;

    @Column(name = "PAY_PRICE", nullable = false)
    private long price;

    @Column(name = "PAY_MILEAGE", nullable = false)
    private long payMileage;

    @Column(name = "PAY_WAY", nullable = false)
    @Enumerated(EnumType.STRING)
    private PayWay payWay;

    @Column(name = "SAVED_MILEAGE", nullable = false)
    private long savedMileage;

    @Column(name = "PAY_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private PayType type;

    @Column(name = "PAY_API_CODE", nullable = false)
    private String apiCode;

    @Column(name = "PG", nullable = false)
    @Enumerated(EnumType.STRING)
    private PG pg;

    @Column(name = "PAY_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus payStatus;

    @Builder
    public Payment(Reservation reservation, LocalDate payDate, LocalTime payTime, long price, long payMileage, PayWay payWay, long savedMileage, PayType type, String apiCode, PG pg, PaymentStatus payStatus) {
        this.reservation = reservation;
        this.payDate = payDate;
        this.payTime = payTime;
        this.price = price;
        this.payMileage = payMileage;
        this.payWay = payWay;
        this.savedMileage = savedMileage;
        this.type = type;
        this.apiCode = apiCode;
        this.pg = pg;
        this.payStatus = payStatus;
    }

    public void updatePayStatus(PaymentStatus payStatus) {
        this.payStatus = payStatus;
    }

    public void updateApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public void cancelPrice(long price) {
        this.price = price;
    }
}
