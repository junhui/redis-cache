package com.edw.mybatisredisexample;

import com.edw.mybatisredisexample.config.MyBatisSqlSessionFactory;
import com.edw.mybatisredisexample.mapper.TestingMapper;
import com.edw.mybatisredisexample.mapper.TestingMapper2;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {

    private Logger logger = Logger.getLogger(this.getClass());

    public static void main(String[] args) throws Exception {
        new Main().testQuery();
    }

    private void testQuery() throws Exception {
        logger.debug("start ----");

        for (int i = 0; i < 10; i++) {
            SqlSession sqlSession = null;
            try {
                sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession(true);
                
                TestingMapper2 testingMapper2 = sqlSession.getMapper(TestingMapper2.class);
                List<Map> maps2 = testingMapper2.select();

                for (Map map : maps2) {
                    logger.debug(map);
                }
                
                
                TestingMapper testingMapper = sqlSession.getMapper(TestingMapper.class);
                List<Map> maps = testingMapper.select();

                for (Map map : maps) {
                    logger.debug(map);
                }
               
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
            }
            
            Thread.sleep(5000);
        }

        logger.debug("end ----");
    }
}
