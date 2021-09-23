# 使用方法
- 安装插件
```shell
mvn install
```
- 使用
```shell
mvn org.maven.plugin.mp:mpg-maven-plugin:run -Dprefix=xx -Dtables=xx,xx -Doutput=xx -DbasePackage=xx.xx -Duser=xx -Dpassword=xx -Durl=xx
```
- prefix 数据库表前缀
- tables 表全名，多个英文逗号隔开
- output 输出项目根目录
- basePackage 输出包前缀
- user 数据库用户名
- password 密码
- url 数据库地址

