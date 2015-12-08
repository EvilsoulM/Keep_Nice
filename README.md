
##结构
- 1.app-上层业务 
- 2.common - 公用模块 工具类 只有app依赖 
- 3.model －为上层提供model greendao生成 只有app依赖 
- 4.modeldaogenerator 用于生成model 不依赖于任何包 

技术选型
- 图片->glide (picasso 某些继续load 不出来大图，fresco 库太大)
- 网络->retrofit+okhttp
- 解析->logansquare
- 注入 dagger2 比guice性能更好

所有模块都单项引用，方便后续拆包

##练习
- groovy简单使用 - info.groovy
- gradle使用
