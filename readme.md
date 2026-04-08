# 微信SDK

> 对微信API封装的SDK，便于用户使用
---

## 支持

- [公众号](weixin-pkg/weixin-offiaccount)

- [小程序](weixin-pkg/weixin-miniprogram/readme.md)

- [网页](weixin-pkg/weixin-web)

- [APP](weixin-pkg/weixin-app)

- [开放平台](weixin-pkg/weixin-oplatform)

## 使用

添加依赖

```xml

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.trionesdev.weixin</groupId>
            <artifactId>weixin-dependencies</artifactId>
            <version>版本号</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## 配置说明

| 属性           | 说明                | 类型                                       | 默认值   |
|--------------|-------------------|------------------------------------------|-------|
| appId        | 微信appId           | String                                   | -     |
| secret       | 微信secret          | String                                   | -     |
| multi        | 是否支持多个微信          | Boolen                                   | false |
| credentials  | 多个微信凭证            | `List<WeiXinCredentials>`                | -     |
| httpLogLevel | HTTP的日志级别(okhttp) | `HttpLoggingInterceptor.Level`           | -     |
| cache        | 缓存实现              | `com.trionesdev.weixin.base.WeiXinCache` | -     |

## 使用缓存

写一个 `com.trionesdev.weixin.base.WeiXinCache`的实现类，内部自行进行缓存处理。将对象赋给 `WeiXinConfig`的`cache`

---

### 关注我们，一起交流

> 留言回复不及时，可以通过关注公众号联系我们
<div style="text-align: center">
<img src="images/shuque_wx.jpg" width="200px" alt="">
</div>