package com.sunline.car.util;

import com.sunline.car.common.dto.RestControllerResult;
import java.util.Collections;
import java.util.Map;

/**
 * feign接口调用后续处理工具.
 *
 * @author : 薛乐乐
 * @since : 2019/5/7 16:39
 */
public class FeignPostHandleUtil {

  public static RestControllerResult savePostHandle(
      RestControllerResult<Map<String, Object>> result) {
    RestControllerResult restControllerResult = new RestControllerResult();
    if (!result.getSuccess()) {
      restControllerResult.setSuccess(false);
      restControllerResult.setErrorMsg(result.getErrorMsg());
      return restControllerResult;
    }
    String info = (String) result.getData().get("success");
    restControllerResult.setSuccess(true);
    restControllerResult.setInfoMsgs(Collections.singletonList(info));
    restControllerResult.setCode(200);
    return restControllerResult;
  }

}
