package com.nqdtotty.vehiclebooking.repository;

import com.nqdtotty.vehiclebooking.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, String> {
    Feedback findByFeedbackId(String feedbackId);

    Feedback deleteByFeedbackId(String feedbackId);
}
