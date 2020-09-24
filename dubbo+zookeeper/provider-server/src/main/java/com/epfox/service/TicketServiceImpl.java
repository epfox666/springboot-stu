package com.epfox.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Service
@Component //放在容器中
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "epfox";
    }
}
