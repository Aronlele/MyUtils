package com.sunline.car.util;

import com.sunline.car.common.dto.RestControllerResult;
import com.sunline.car.common.exception.CarServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * feign调用工厂工具.
 *
 * @author : 薛乐乐
 * @since : 2019/5/7 9:13
 */
public class FeignUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(FeignUtil.class);

  public FeignUtil() {
  }

  public static <T> RestControllerResult<T> getFailResult(Throwable throwable) {
    LOGGER.error("服务调用异常", throwable);
    throw new CarServerException("服务调用异常", throwable);
  }

}
