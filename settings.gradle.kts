rootProject.name = "weixin"

include("weixin-dependencies")
include("weixin-pkg")

include("weixin-pkg:weixin-base")
include("weixin-pkg:weixin-miniprogram")
include("weixin-pkg:weixin-offiaccount")
include("weixin-pkg:weixin-oplatform")
include("weixin-pkg:weixin-app")
include("weixin-pkg:weixin-web")