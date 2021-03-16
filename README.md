# MySpringCloud
搭建微服务项目-服务注册、服务发现专题demo
MySpringCloud
搭建微服务项目-服务注册、服务发现专题demo

eureka集群配置： 前面单机的时候 eureka注册中心实例名称 是localhost，现在是集群，不能三个实例都是localhost，这里复杂的办法是搞三个虚拟机，麻烦，这里有简单办法，直接配置本机hosts，来实现本机域名映射 127.0.0.1 eureka8761.com 127.0.0.1 eureka8762.com 127.0.0.1 eureka8763.com

修改 本地host地址映射 C:\Windows\System32\drivers\etc

启动eureka项目，两个eureka集群地址为： http://eureka8762.com:8762/ http://eureka8762.com:8762/ http://eureka8763.com:8763/

启动项目： 服务提供者swagger地址http://localhost:8771/swagger-ui.html 服务消费者 swagger 地址 http://localhost:8772/swagger-ui.html

下载rabbitmq 配置完启动项目，访问地址： http://localhost:15672/#/exchanges
rabbitmq 使用了3中交换机模式demo， 直连交换机，扇形交换机 ，主题交换机

整合 reids
整合 validtion

