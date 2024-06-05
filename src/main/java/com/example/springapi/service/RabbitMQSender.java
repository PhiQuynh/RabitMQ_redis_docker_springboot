package com.example.springapi.service;

import com.example.springapi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${backend.rabbitmq.exchange}")
    private String exchange;

    @Value("${backend.rabbitmq.routingkey}")
    private String routingkey;

    public void send(TBLKhoa khoa) {
        rabbitTemplate.convertAndSend(exchange, routingkey, khoa);
        log.info("Send msg = {} ", khoa);
    }

    public void sendGiangVien(TBLGiangVien giangVien) {
        rabbitTemplate.convertAndSend(exchange, routingkey, giangVien);
        log.info("Send msg = {} ", giangVien);
    }

    public void sendSinhVien(TBLSinhvien sinhvien) {
        rabbitTemplate.convertAndSend(exchange, routingkey, sinhvien);
        log.info("Send msg = {} ", sinhvien);
    }

    public void sendHuongDan(TBLHuongDan huongDan) {
        rabbitTemplate.convertAndSend(exchange, routingkey, huongDan);
        log.info("Send msg = {} ", huongDan);
    }

    public void sendDetai(TBLDetai detai) {
        rabbitTemplate.convertAndSend(exchange, routingkey, detai);
        log.info("Send msg = {} ", detai);
    }
}
