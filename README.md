# nacos+sentinle+seata

## seata  安装

以seata-server-1.3.0.tar.gz 以例



### seata-server 配置

#### 修改registry.conf

注册中心为 nacos,同时配置serverAddr

```
registry {
  # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "nacos"

  nacos {
    application = "seata-server"
    serverAddr = "127.0.0.1:8848"
    group = "SEATA_GROUP"
    namespace = ""
    cluster = "default"
    username = ""
    password = ""
  }
 }
```

#### 修改 file.conf

```
## transaction log store, only used in seata-server
store {
  ## store mode: file、db、redis
  mode = "db"
    ## database store property
  db {
    ## the implement of javax.sql.DataSource, such as DruidDataSource(druid)/BasicDataSource(dbcp)/HikariDataSource(hikari) etc.
    datasource = "druid"
    ## mysql/oracle/postgresql/h2/oceanbase etc.
    dbType = "mysql"
    driverClassName = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1:3307/seata"
    user = "root"
    password = "root"
    minConn = 5
    maxConn = 30
    globalTable = "global_table"
    branchTable = "branch_table"
    lockTable = "lock_table"
    queryLimit = 100
    maxWait = 5000
  }
}
```



### seata + nacos 配置初始化

#### 1 . 修改 config.txt

文件在: document/seata/



```
service.default.grouplist=192.168.10.11:8091 #seata 的部署 ip,配置本地的 ip 地址
store.db.datasource=druid
store.db.dbType=mysql
store.db.driverClassName=com.mysql.jdbc.Driver
store.db.url=jdbc:mysql://127.0.0.1:3307/seata?useUnicode=true    #数据库连接
store.db.user=root
store.db.password=root

```

#### 2. 初始化 nacos 配置

nacos-config.sh 修改 nacos 地址

```
if [[ -z ${host} ]]; then
    host=127.0.0.1
fi
if [[ -z ${port} ]]; then
    port=8848
fi
```

修改后进入nacos-config.sh 目录下 执行 nacos-config.sh  完成配置初始化

#### 3 运行 seata-server端

seata/bin/seata-server.sh

## sentinel-dashboard安装



以 sentinel-dashboard-1.7.2.jar以例

java -Dserver.port=8089 -Dcsp.sentinel.dashboard.server=localhost:8089 -Dsentinel.dashboard.auth.username=admin -Dsentinel.dashboard.auth.password=admin -jar /data/cloud/sentinel-dashboard-1.7.2.jar &



## 启动示例工程

spring-cloud-feign-client

spring-cloud-feign-server

测试地址:http://localhost:7777/test

### 服务已注册
![输入图片说明](https://images.gitee.com/uploads/images/2020/0803/160339_4b12a242_420949.png "image-20200803153955136.png")
### 添加限流规则

#### 快速失败效果

资源名与SentinelResource与一致

```
@GetMapping("test")
@SentinelResource("test")
public String testFeign() {
}
```

![输入图片说明](https://images.gitee.com/uploads/images/2020/0803/160443_422262e4_420949.png "image-20200803154207332.png")

测试--一个成功,一个失败

![输入图片说明](https://images.gitee.com/uploads/images/2020/0803/160459_db9f9bc0_420949.png "image-20200803154330770.png")

#### 排队等待规则

![输入图片说明](https://images.gitee.com/uploads/images/2020/0803/160510_8a0a04c1_420949.png "image-20200803154445374.png")

测试-未超时情况下都成功

![输入图片说明](https://images.gitee.com/uploads/images/2020/0803/160524_daca0545_420949.png "image-20200803154519949.png")

