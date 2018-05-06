## 这是一个spring boot整合mybatis的项目模板

1、只需要将`application.yml`下的数据库配置更换为自己的数据库配置

2、将schema文件夹下的default.sql文件在目标数据库中执行一下(需要确保没有叫user重名的库)

3、调用localhost:8080/addUser接口  参数传username=xxx&password=xxx 返回值为true  说明运行成功

**有问题欢迎给我提issue**


## This is spring boot integration with mybatis project demo

1、You just need replace `application.yml`'s mysql config with yours

2、Execution the default.sql file in mysql(ensure database don't have the table name with user)

3、Send request to localhost:8080/addUser interface,the params are username=xxx&password=xxx,and return value is true,that means everything is ok

**You can create an issue if you have any question**