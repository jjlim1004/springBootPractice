package com.example.entitiyTest.domain;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.security.Timestamp;
import java.time.LocalDateTime;


@Getter
@Entity
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;
    private String title;
    private String writer;
    private String content;

    @CreationTimestamp
    private LocalDateTime regdate;
    @UpdateTimestamp
    private LocalDateTime updatadate;

    @Builder
    public Board( String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}


//출처: https://memories95.tistory.com/135 [취미로 음악을 하는 개발자]