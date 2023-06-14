package com.nqdtotty.vehiclebooking.service.impl;

import com.nqdtotty.vehiclebooking.entity.Feedback;
import com.nqdtotty.vehiclebooking.model.request.FeedbackCreateRequest;
import com.nqdtotty.vehiclebooking.model.request.FeedbackResponseRequest;
import com.nqdtotty.vehiclebooking.model.response.CommonResponse;
import com.nqdtotty.vehiclebooking.model.response.FeedbackResponse;
import com.nqdtotty.vehiclebooking.repository.FeedbackRepository;
import com.nqdtotty.vehiclebooking.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public CommonResponse getAllFeedback() {
        CommonResponse commonResponse = new CommonResponse();
        try {
            List<Feedback> listFeedback = feedbackRepository.findAll();
            if(listFeedback == null) {
                commonResponse.setStatus(417);
                commonResponse.setMessage("Empty");
            } else {
                List<FeedbackResponse> list = new ArrayList<>();
                for (int i = 0; i < listFeedback.size(); i++) {
                    FeedbackResponse feedbackResponse = new FeedbackResponse();
                    feedbackResponse.setFeedbackId(listFeedback.get(i).getFeedbackId());
                    feedbackResponse.setUserId(listFeedback.get(i).getUserId());
                    feedbackResponse.setMessage(listFeedback.get(i).getMessage());
                    feedbackResponse.setResponse(listFeedback.get(i).getResponse());
                    feedbackResponse.setStatus(listFeedback.get(i).getStatus());
                    list.add(feedbackResponse);
                }
                commonResponse.setStatus(200);
                commonResponse.setMessage("Successfully");
                commonResponse.setData(list);
            }
        } catch (Exception e) {
            commonResponse.setStatus(417);
            commonResponse.setMessage("Fail to get all feedback");
            e.printStackTrace();
        } finally {
            return commonResponse;
        }
    }

    @Override
    public CommonResponse createFeedback(FeedbackCreateRequest feedbackCreateRequest) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Feedback feedback = new Feedback();
            Random random = new Random();
            feedback.setFeedbackId("fe" + feedbackCreateRequest.getMessage().substring(0,3).hashCode() +
                    (Integer.toString(random.nextInt(999))));
            feedback.setUserId(feedback.getUserId());
            feedback.setMessage(feedback.getMessage());
            feedback.setResponse("");
            feedback.setStatus("inactive");
            feedbackRepository.save(feedback);
            commonResponse.setStatus(200);
            commonResponse.setMessage("Create feedback successfully");
        } catch (Exception e) {
            commonResponse.setStatus(417);
            commonResponse.setMessage("Fail to create feedback");
            e.printStackTrace();
        } finally {
            return commonResponse;
        }
    }

    @Override
    public CommonResponse responseFeedback(FeedbackResponseRequest feedbackResponseRequest, String feedbackId) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Feedback feedback = feedbackRepository.findByFeedbackId(feedbackId);
            if(feedback == null) {
                commonResponse.setStatus(417);
                commonResponse.setMessage("Feedback does not exist");
            } else {
                feedback.setResponse(feedbackResponseRequest.getResponse());
                feedback.setStatus("active");
                feedbackRepository.save(feedback);
                commonResponse.setStatus(200);
                commonResponse.setMessage("Response successfully");
            }
        } catch (Exception e) {
            commonResponse.setStatus(417);
            commonResponse.setMessage("Fail to update feedback");
            e.printStackTrace();
        } finally {
            return commonResponse;
        }
    }

    @Override
    public CommonResponse deleteFeedback(String feedbackId) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Feedback feedback = feedbackRepository.findByFeedbackId(feedbackId);
            if(feedback == null) {
                commonResponse.setStatus(417);
                commonResponse.setMessage("Feedback does not exist");
            } else {
                feedbackRepository.deleteByFeedbackId(feedbackId);
                commonResponse.setStatus(200);
                commonResponse.setMessage("Delete feedback successfully");
            }
        } catch (Exception e) {
            commonResponse.setStatus(417);
            commonResponse.setMessage("Fail to delete feedback");
            e.printStackTrace();
        } finally {
            return commonResponse;
        }
    }
}
