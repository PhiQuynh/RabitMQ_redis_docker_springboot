package com.example.springapi.controller;
import com.example.springapi.model.*;
import com.example.springapi.service.RabbitMQSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/rabbitmq/")
@Slf4j
public class RabbitMQController {
    @Autowired
    private AmqpTemplate rabbitTemplateBean;


    @Autowired
    private RabbitMQSender rabbitMQSender;

    //http://localhost:9090/api/rabbitmq/producer/khoa?makhoa=Bio&tenkhoa=Cong nghe Sinh hoc&dienthoai=3855412
    @GetMapping(value = "/producer/khoa")
    public String producer(@ModelAttribute TBLKhoa category) {
        log.info(" category {} , {} ", category.getMakhoa(), category.getTenkhoa(),category.getDienthoai() );
        rabbitMQSender.send(category);

        return "Message sent to the RabbitMQ Successfully";
    }

    //http://localhost:9090/api/rabbitmq/producer/giangVien?Magv=11&Hotengv=Thanh Binh&Luong=700.00&Makhoa=Geo
    @GetMapping(value = "/producer/giangVien")
    public String producerGiangVien(@ModelAttribute TBLGiangVien category) {
        log.info(" category {} , {} ", category.getMagv(), category.getHotengv(),category.getLuong(),category.getTblKhoa() );
        rabbitMQSender.sendGiangVien(category);

        return "Message sent to the RabbitMQ Successfully ";
    }

    //http://localhost:9090/api/rabbitmq/producer/sinhVien?Masv=1&Hotensv=Le Van Son&Namsinh=1990&Quequan=Nghe An&Makhoa=Bio
    @GetMapping(value = "/producer/sinhVien")
    public String producerSinhVien(@ModelAttribute TBLSinhvien category) {
        log.info(" category {} , {} ", category.getMasv(), category.getHotensv(),category.getNamsinh(),category.getQuequan(),category.getMakhoa() );
        rabbitMQSender.sendSinhVien(category);

        return "Message sent to the RabbitMQ Successfully";
    }

    //http://localhost:9090/api/rabbitmq/producer/huongDan?Masv=1&Madt=Dt01&Magv=13&KetQua=8.00
    @GetMapping(value = "/producer/huongDan")
    public String producerHuongDan(@ModelAttribute TBLHuongDan category) {
        log.info(" category {} , {} ", category.getMasv(), category.getKetQua(),category.getGiangVien(),category.getDetai() );
        rabbitMQSender.sendHuongDan(category);

        return "Message sent to the RabbitMQ Successfully";
    }
    //http://localhost:9090/api/rabbitmq/producer/detai?Tendt=GIS&Kihphi=100&Noithuctap=Nghe An
    @GetMapping(value = "/producer/detai")
    public String producerDetai(@ModelAttribute TBLDetai category) {
        log.info(" category {} , {} ", category.getMadt(), category.getTendt(),category.getKinhphi(),category.getNoithuctap() );
        rabbitMQSender.sendDetai(category);

        return "Message sent to the RabbitMQ Successfully";
    }

    //http://localhost:9090/api/rabbitmq/exchange?exchangeName=topic-exchange&routingKey=queue.admin&messageData=MessageData
    @GetMapping(value = "/exchange")
    public String producer(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey,
                           @RequestParam("messageData") String messageData) {

        rabbitTemplateBean.convertAndSend(exchange, routingKey, messageData);

        return "Message sent to the RabbitMQ Successfully";
    }

    //http://localhost:9090/api/rabbitmq/fanout?exchangeName=fanout-exchange&messageData=message
    @GetMapping(value = "/fanout")
    public String fanout(@RequestParam("exchangeName") String exchange,
                         @RequestParam("messageData") String messageData) {

        log.info("send to mq {} {}", exchange, messageData);
        rabbitTemplateBean.convertAndSend(exchange, "", messageData);

        return "Message sent to the RabbitMQ Fanout Successfully";
    }

    //http://localhost:9090/api/rabbitmq/topic?exchangeName=topic-exchange&routingKey=queue.admin&messageData=MessageData
    @GetMapping(value = "/topic")
    public String producerTopic(@RequestParam("exchangeName") String exchange, @RequestParam("routingKey") String routingKey, @RequestParam("messageData") String messageData) {

        log.info("send to mq with topic type{} {}", exchange, messageData);
        rabbitTemplateBean.convertAndSend(exchange, routingKey, messageData);
        return "Message sent to the RabbitMQ Topic Exchange Successfully";
    }


    //http://localhost:9090/api/rabbitmq/header?exchangeName=header-exchange&department=admin&messageData=MessageValue
    @GetMapping(value = "/header")
    public String producerHeader(@RequestParam("exchangeName") String exchange, @RequestParam("department") String department, @RequestParam("messageData") String messageData) {

        final MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("department", department);
        MessageConverter messageConverter = new SimpleMessageConverter();
        Message message = messageConverter.toMessage(messageData, messageProperties);
        rabbitTemplateBean.send(exchange, "", message);

        return "Message sent to the RabbitMQ Header Exchange Successfully";
    }
}
