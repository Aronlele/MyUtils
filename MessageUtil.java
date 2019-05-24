package com.sunline.car.util;

import com.sunline.car.common.exception.CarServerException;
import java.util.Locale;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
 * i18n消息处理工具.
 *
 * @author : 薛乐乐
 * @since : 2019/5/5 10:47
 */
public class MessageUtil {

  private static MessageSource innerMessageSource;

  @Autowired
  private MessageSource messageSource;

  public MessageUtil() {
  }

  @PostConstruct
  private void postConstruct() {
    System.out.println("-----------" + this.messageSource);
    innerMessageSource = this.messageSource;
  }

  /**
   * 获得信息.
   *
   * @param code 码值
   * @return 信息
   */
  public static String getMsg(String code) {
    if (innerMessageSource == null) {
      throw new CarServerException("工具类没有正确配置");
    } else {
      Locale locale = Locale.SIMPLIFIED_CHINESE;
      return innerMessageSource.getMessage(code, null, locale);
    }
  }

  /**
   * 获得信息.
   *
   * @param code 码值
   * @param args 参数
   * @return 信息
   */
  public static String getMsg(String code, Object... args) {
    if (innerMessageSource == null) {
      throw new CarServerException("工具类没有正确配置");
    } else {
      Locale locale = Locale.SIMPLIFIED_CHINESE;
      return innerMessageSource.getMessage(code, args, locale);
    }
  }
}
