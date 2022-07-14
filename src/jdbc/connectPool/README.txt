实际开发中“获得连接”或“释放资源”是非常消耗系统资源的两个过程，
为了解决此类性能问题，通常情况我们采用连接池技术，来共享连接Connection。
这样我们就不需要每次都创建连接、释放连接了，这些操作都交给了连接池
必须项

driverClassName 数据库驱动名称
url 数据库的地址
username 用户名
password 密码
基本项（扩展）

maxActive 最大连接数量
minIdle 最小空闲连接
maxIdle 最大空闲连接
initialSize 初始化连接