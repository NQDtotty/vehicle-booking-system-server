package com.nqdtotty.vehiclebooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedbacks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @Column(name = "feedback_id", nullable = false)
    private String feedbackId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "response", nullable = false)
    private String response;

    @Column(name = "status", nullable = false)
    private String status;
}
