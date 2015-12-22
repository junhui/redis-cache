package com.edw.mybatisredisexample.mapper;

import com.edw.mybatisredisexample.bean.Testing;
import java.util.List;
import java.util.Map;

public interface TestingMapper2 {
    void insert(Testing testing);
    List<Map> select();
}