MyBatis Redis Extension
=========================

[![Build Status](https://travis-ci.org/mybatis/redis-cache.svg?branch=master)](https://travis-ci.org/mybatis/redis-cache)
[![Coverage Status](https://coveralls.io/repos/mybatis/redis-cache/badge.svg?branch=master&service=github)](https://coveralls.io/github/mybatis/redis-cache?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/5619b547a193340f3200063c/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5619b547a193340f3200063c)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis.caches/mybatis-redis/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis.caches/mybatis-redis)
[![Apache 2](http://img.shields.io/badge/license-Apache%202-red.svg)](http://www.apache.org/licenses/LICENSE-2.0)

![mybatis-redis](http://mybatis.github.io/images/mybatis-logo.png)

MyBatis-Redis extension Redis support for MyBatis Cache.

Essentials
----------

* [See the docs](http://mybatis.github.io/redis-cache/)


## Update @12/22/2015

Original mybatis redis couldn't set expiration date, this version add this support.

To support expiration date, i changed the data structure for mybatis object in redis from hash table to flat key value.

data view in redis: ![](http://i.imgur.com/suCIJNI.png)

example you can see in `/example` folder

- default ttl is infinite
- unit is minute

### How to set:

use your mybatis mapper namespace as redis cache set unit, for example, the mapper file:


```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.edw.mybatisredisexample.mapper.TestingMapper2" >
    
    <cache type="org.mybatis.caches.redis.RedisCache" />
    
    <select resultType="java.util.Map" id="select" >
        SELECT * FROM testing
    </select>
</mapper>

```

the mapper namespace is `com.edw.mybatisredisexample.mapper.TestingMapper`

so, in your `redis.properties` file, you can set the ttl under above namespace use 5 minutes to cache

```
host=localhost
port=6379
connectionTimeout=5000
soTimeout=4000
password=
database=0
com.edw.mybatisredisexample.mapper.TestingMapper2=5
```

## References:

- the example code use: http://edwin.baculsoft.com/2015/05/a-simple-mybatis-caching-using-redis/