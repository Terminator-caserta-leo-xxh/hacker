package cn.nju.edu.hacker.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseVO {
    private boolean isSuccess;

    private String message;

    private Object data;

    public static ResponseVO buildFailed(String failMessage) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setMessage(failMessage);
        return responseVO;
    }
}
