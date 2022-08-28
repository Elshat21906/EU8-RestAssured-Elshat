package com.cybertek.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString

public class Region {

    //region_id
    //if your jsonkey and variable name not matching, you can map it with jsonProperty

    private int region_id;
    private String region_name;
    private List<Link> links;


}
