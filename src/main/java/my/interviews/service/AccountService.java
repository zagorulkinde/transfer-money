package my.interviews.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;

import my.interviews.dao.AccountMapper;

public class AccountService {
  private static final String MY_BATIS_CONFIG = "mybatis-config.xml";

  public static AccountMapper getMapper() {
    return getSession().getMapper(AccountMapper.class);
  }

  private static SqlSession getSession() {
    try (InputStream inputStream = Resources.getResourceAsStream(MY_BATIS_CONFIG)) {
      SqlSessionManager build = SqlSessionManager.newInstance(inputStream);
      return build.openSession(true);
    } catch (IOException e) {
      throw new Error("my batis config not found!");
    }
  }


}
