package com.example.demo.routes;

import com.example.demo.model.STModel;
import com.example.demo.repository.STrepo;
import com.example.demo.dto.ObjectsDto;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchedulerRoute extends RouteBuilder  {

    @Autowired
    STrepo repo;

    @Override
    public void configure() throws Exception {
        from("quartz:camel?cron=0/10+*+*+*+*+?").log("scheduled to http route")
                .to("direct:http");
        log.info("Camel-Quartz Scheduler triggering http route");
        JacksonDataFormat parser = new JacksonDataFormat(ObjectsDto.class);
        from("direct:http")
                .routeId("poc http").log("inside http route"+System.lineSeparator())
                .to("http://localhost:8080/get-transaction-data")
                .unmarshal(parser)
                .split(body())
                .log("body " + "${body}")
                .process(exchange -> {
                            log.info("Inside processor");
                            ObjectsDto dtos = exchange.getIn().getBody(ObjectsDto.class);
                            log.info("Saving details in db");
                            for (int i = 0; i < dtos.getResult().size(); i++) {
                                STModel model = new STModel();
                                model.setMaterialId(dtos.getResult().get(i).getMaterialId());
                                model.setMaterialName(dtos.getResult().get(i).getMaterialName());
                                repo.save(model);
                            }
                            log.info("Saved details in db");
                        }
                );
    }
}
