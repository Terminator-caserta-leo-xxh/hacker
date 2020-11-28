package cn.nju.edu.hacker.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseVO {

    private boolean isSuccess;

    private int code;

    private String message;

    private Object data;

    public static ResponseVO buildFailed(String failMessage, int code) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setMessage(failMessage);
        responseVO.setCode(code);
        return responseVO;
    }

    public static ResponseVO buildSucceed(String succeedMessage, int code) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setMessage(succeedMessage);
        responseVO.setCode(code);
        return responseVO;
    }


    public static ResponseVO buildSucceed(String succeedMessage, int code, Object data) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setMessage(succeedMessage);
        responseVO.setData(data);
        responseVO.setCode(code);
        return responseVO;
    }
}
