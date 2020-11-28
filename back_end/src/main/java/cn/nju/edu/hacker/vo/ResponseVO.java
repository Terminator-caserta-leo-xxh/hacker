package cn.nju.edu.hacker.vo;

import cn.nju.edu.hacker.entity.StudentEntity;
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

    public static ResponseVO buildSucceed(String succeedMessage){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setMessage(succeedMessage);
        return responseVO;
    }


    public static ResponseVO buildSucceed(String succeedMessage, Object data) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setMessage(succeedMessage);
        responseVO.setData(data);
        return responseVO;
    }
}
