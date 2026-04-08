# 微信小程序SDK
---

## 使用

#### 添加依赖

```xml

<dependency>
    <groupId>com.trionesdev.weixin</groupId>
    <artifactId>triones-weixin-miniprogram</artifactId>
    <version>版本号</version>
</dependency>
```

#### 创建一个 `WeiXinMiniProgram` 实例

```java
public WeiXinMiniProgram weiXinMiniProgram() {
    WeiXinConfig config = new WeiXinConfig();
    config.setAppId("xxx");
    config.setSecret("xxx");
    return new WeiXinMiniProgram(config);
}
```

## 方法说明

- 获取小程序全局唯一后台接口调用凭据 getAccessToken

微信官方文档 https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/access-token/auth.getAccessToken.html

请求参数

| 属性    | 类型     | 是否必填 | 说明                |
|-------|--------|------|-------------------|
| appId | String | 否    | appId，多个小程序情况下，必填 |

返回对象参数 AccessTokenResponse

| 属性          | 类型     | 说明           |
|-------------|--------|--------------|
| errorCode   | String | 错误码，请求失败时返回  |
| errorMsg    | String | 错误信息，请求失败时返回 |
| accessToken | String | accessToken  |
| expiresIn   | String | 过期时间         |

- 登录凭证校验 code2Session

微信官方文档 https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html

请求参数

| 属性    | 类型     | 是否必填 | 说明                |
|-------|--------|------|-------------------|
| appId | String | 否    | appId，多个小程序情况下，必填 |
| code  | String | 是    | 小程序获得的code        |

返回对象参数 Code2SessionResponse

| 属性         | 类型     | 说明                                                                                                                                             |
|------------|--------|------------------------------------------------------------------------------------------------------------------------------------------------|
| errorCode  | String | 错误码，请求失败时返回                                                                                                                                    |
| errorMsg   | String | 错误信息，请求失败时返回                                                                                                                                   |
| openId     | String | 小程序内的openId                                                                                                                                    |
| sessionKey | String | 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID 机制说明。                                                                                          |
| unionId    | String | 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 [UnionID 机制说明](https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/union-id.html)。 |

- 用户信息 checkEncryptedData
- 获取手机号 getUserPhoneNumber

微信官方文档 https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/user-info/phone-number/getPhoneNumber.html#%E8%B0%83%E7%94%A8%E6%96%B9%E5%BC%8F

请求对象参数 GetUserPhoneNumberRequest

| 属性          | 类型     | 是否必填 | 说明                                                                                                     |
|-------------|--------|------|--------------------------------------------------------------------------------------------------------|
| appId       | String | 否    | appId，多个小程序情况下，必填                                                                                      |
| accessToken | String | 是    | 接口调用凭证，使用access_token或者authorizer_access_token                                                         |
| code        | String | 是    | [手机号获取凭证](https://developers.weixin.qq.com/miniprogram/dev/framework/open-ability/getPhoneNumber.html) |
| openId      | String | 否    | 小程序获得的code                                                                                             |

返回对象参数 UserPhoneNumberResponse

| 属性                            | 类型     | 说明                  |
|-------------------------------|--------|---------------------|
| errorCode                     | String | 错误码，请求失败时返回         |
| errorMsg                      | String | 错误信息，请求失败时返回        |
| phoneInfo                     | Object | 用户手机号信息             |
| phoneInfo.phoneNumber         | String | 用户绑定的手机号（国外手机号会有区号） |
| phoneInfo.purePhoneNumber     | String | 没有区号的手机号            |
| phoneInfo.countryCode         | String | 区号                  |
| phoneInfo.watermark           | Object | 数据水印                |
| phoneInfo.watermark.timestamp | Long   | 用户获取手机号操作的时间戳       |
| phoneInfo.watermark.appId     | String | 小程序appid            |

- 获取小程序码 getQRCode

微信官方文档 https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/getQRCode.html

请求对象参数 GetQRCodeRequest

| 属性          | 类型     | 是否必填 | 说明                                                                                                                                                                |
|-------------|--------|------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| appId       | String | 否    | appId，多个小程序情况下，必填                                                                                                                                                 |
| accessToken | String | 是    | 接口调用凭证，使用access_token或者authorizer_access_token                                                                                                                    |
| path        | String | 是    | 扫码进入的小程序页面路径，最大长度 1024 个字符，不能为空，scancode_time为系统保留参数，不允许配置；对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。 |
| width       | String | 否    | 二维码的宽度，单位 px。默认值为430，最小 280px，最大 1280px                                                                                                                           |   
| autoColor   | Boolen | 否    | 默认值false；自动配置线条颜色，如果颜色依然是黑色，则说明不建议配置主色调                                                                                                                           |   
| lineColor   | Object | 否    | 默认值{"r":0,"g":0,"b":0} ；auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示                                                               |   
| lineColor.r | Int    | 是    | 默认值{"r":0,"g":0,"b":0} ；auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示                                                               |   
| lineColor.b | Int    | 是    | 默认值{"r":0,"g":0,"b":0} ；auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示                                                               |   
| lineColor.g | Int    | 是    | 默认值{"r":0,"g":0,"b":0} ；auto_color 为 false 时生效，使用 rgb 设置颜色 例如 {"r":"xxx","g":"xxx","b":"xxx"} 十进制表示                                                               |   
| hyaline     | Boolen | 否    | 默认值false；是否需要透明底色，为 true 时，生成透明底色的小程序码                                                                                                                            |   
| envVersion  | String | 否    | 要打开的小程序版本。正式版为 "release"，体验版为 "trial"，开发版为 "develop"。默认是正式版。                                                                                                      |   

返回值

byte[] 二进制数组

- 获取小程序二维码 createQRCode

微信官方文档 https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/qrcode-link/qr-code/createQRCode.html

| 属性          | 类型     | 是否必填 | 说明                                                                                                                                                               |
|-------------|--------|------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| appId       | String | 否    | appId，多个小程序情况下，必填                                                                                                                                                |
| accessToken | String | 是    | 接口调用凭证，使用access_token或者authorizer_access_token                                                                                                                   |
| path        | String | 是    | 扫码进入的小程序页面路径，最大长度 128 个字符，不能为空；对于小游戏，可以只传入 query 部分，来实现传参效果，如：传入 "?foo=bar"，即可在 wx.getLaunchOptionsSync 接口中的 query 参数获取到 {foo:"bar"}。scancode_time为系统保留参数，不允许配置。 |
| width       | Int    | 否    | 二维码的宽度，单位 px。最小 280px，最大 1280px;默认是430                                                                                                                           |


---
### 关注我们，一起交流
> 留言回复不及时，可以通过关注公众号联系我们
<div style="text-align: center">
<img src="../../images/shuque_wx.jpg" width="200px" alt="">
</div>