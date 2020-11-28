package cn.nju.edu.hacker.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class HistoryOrderVO {

    private String description;
    private Double money;
    private String remarks;
    private List<Integer> dishId;

}
