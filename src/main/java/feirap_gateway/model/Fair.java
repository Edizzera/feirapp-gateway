package feirap_gateway.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fair {
    private Long id;
    private String name;
    private String category;
    private Address address;
    private String weekDay;
    private String start;
    private String end;
    private Double latitude; 
    private Double longitude;
    
}
