package snowboard.orchestrationservice.route;

import org.apache.camel.builder.RouteBuilder;

public class Route extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:placeOrder")
                .bean("order", "validate")
                .bean("order", "place")
                .to("kafka:newOrder")
                .end();
    }
}
