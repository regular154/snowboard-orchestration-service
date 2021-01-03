package snowboard.orchestrationservice;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class OrchestrationRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("netty-http")
                .bindingMode(RestBindingMode.json)
                .port(8080);

        rest("/workflow")
                .get("/{workflowId}")
                .to("direct:${header.workflowId}");

    }
}
