# Spring Cloud 实践学习案例

> 转载请标明出处：https://haoyizebo.com/tags/Spring-Cloud/ 本文出自 [好一则博](https://haoyizebo.com)

Spring Cloud 实践学习案例，由浅入深一步一步学习 Spring Cloud，是 Spring Cloud 初学者及核心技术巩固的最佳实践。

## Docker 支持

> 如果使用 Docker for Mac 请先参考 https://haoyizebo.com/2019/08/30/docker-for-mac-network/

创建 network

```shell script
docker network create micro-service
```

### Eureka Server

服务注册基本上每次都要用到，为了方便我做了一个 Dockerfile。
使用以下命令可以直接拉取使用镜像：

```shell script
docker run --rm --name eureka-server --network micro-service -p 8761:8761 haoyizebo/eureka-server:latest
```

### Producer

```shell script
docker run --rm --name eureka-producer --network micro-service -p 8080:8080 haoyizebo/eureka-producer:latest
```
