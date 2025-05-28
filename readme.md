#  微信SDK
> 对微信API封装的SDK，便于用户使用
---
## 支持
[公众号](triones-weixin-offiaccount)

[小程序](triones-weixin-miniprogram)

[网页](triones-weixin-web)

[APP](triones-weixin-app)

[开放平台](triones-weixin-oplatform)

## 使用
添加依赖
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.trionesdev.weixin</groupId>
            <artifactId>triones-weixin-dependencies</artifactId>
            <version>版本号</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## 缓存
写一个 `com.trionesdev.weixin.base.WeiXinCache`的实现类，内部自行进行缓存处理。将对象赋给 `WeiXinConfig`的`cache`

---
### 关注我们，一起交流
> 留言回复不及时，可以通过关注公众号联系我们
<div style="text-align: center">
<img src="images/shuque_wx.jpg" width="200px" alt="">
</div>