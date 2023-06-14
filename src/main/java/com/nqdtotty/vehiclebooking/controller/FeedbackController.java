package com.nqdtotty.vehiclebooking.controller;

import com.nqdtotty.vehiclebooking.model.request.FeedbackCreateRequest;
import com.nqdtotty.vehiclebooking.model.request.FeedbackResponseRequest;
import com.nqdtotty.vehiclebooking.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllFeedback")
    public ResponseEntity<?> getAllFeedback() {
        ResponseEntity responseEntity = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/createFeedback")
    public ResponseEntity<?> createFeedback(@RequestBody FeedbackCreateRequest feedbackCreateRequest) {
        ResponseEntity responseEntity = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/responseFeedback/{feedbackId}")
    public ResponseEntity<?> responseFeedback(@RequestBody FeedbackResponseRequest feedbackResponseRequest,
                                            @PathVariable("feedbackId") String feedbackId) {
        ResponseEntity responseEntity = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseEntity;
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteFeedback/{feedbackId}")
    public ResponseEntity<?> deleteFeedback(@PathVariable("feedbackId") String feedbackId) {
        ResponseEntity responseEntity = null;
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return responseEntity;
        }
    }
}
