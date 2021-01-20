# EyepetizerSimulation
Eyepetizer开源视频app模仿实现，使用Kotlin-jetpack方式实现

API新接口地址

### 首页模块：
 首页顶部导航栏，包括推荐、关注、日报和logo品牌墙
 http://api.eyepetizer.net/v1/card/page/get_nav

 首页各个item的详情信息请求地址，请求参数page_label为recommend,follow,daily_issue，brand_wall
 (其中recommend包含顶部视频，每日资讯，每日资讯详情页为H5页面)
 http://api.eyepetizer.net/v1/card/page/get_page

 首页（推荐，关注和日报）的 底部滑动内容，其中data_source为 recommend_feed,follow_feed，history_issue_feed
 https://api.eyepetizer.net/v1/card/metro/call_metro_list_v2

 分享及更多
 http://api.eyepetizer.net/v1/content/item/get_item_share_info_v2

 视频播放
 http://baobab.kaiyanapp.com/api/v2/video/


 ### 社区模块

 获取社区顶部导航栏个数与详情，tab_label为community
 http://api.eyepetizer.net/v1/card/page/get_nav

 社区顶部滑动列表，page_label为community
 http://api.eyepetizer.net/v1/card/page/get_page

 社区今日热门话题
 http://baobab.kaiyanapp.com/api/v6/tag/index
 http://baobab.kaiyanapp.com/api/v6/tag/dynamics

 社区今日热门话题展开页顶部item详情数 tab_label为topic_square
 http://api.eyepetizer.net/v1/card/page/get_nav

 社区今日热门话题展开页各个item详情信息
 http://api.eyepetizer.net/v1/card/page/get_page

 社区今日热门话题展业页item底部滑动内容详情
 https://api.eyepetizer.net/v1/card/metro/call_metro_list_v2


### 发现模块：
发现模块顶部滑动栏，page_label为discover
http://api.eyepetizer.net/v1/card/page/get_page

发现模块本周热门视频,热门作者，page_label为
https://api.eyepetizer.net/v1/card/page/get_page


发现模块关于分类，专题，话题，专栏的信息请求page_label为discovery_category,discovery_special_topic,
discovery_topic,discovery_special_column
http://api.eyepetizer.net/v1/card/page/get_page

eyepetizer老接口

### 首页

1.发现更多

- 请求地址： http://baobab.kaiyanapp.com/api/v7/index/tab/discovery

2.每日推荐

- 请求地址： http://baobab.kaiyanapp.com/api/v5/index/tab/allRec

3.日报精选

- 请求地址 ： http://baobab.kaiyanapp.com/api/v5/index/tab/feed


### 社区

1.推荐

- 请求地址： http://baobab.kaiyanapp.com/api/v7/community/tab/rec

2.关注

- 请求地址： http://baobab.kaiyanapp.com/api/v6/community/tab/follow


### 通知

1.主题

- 请求地址： http://baobab.kaiyanapp.com/api/v7/tag/tabList

2.通知

- 请求地址 ：  http://baobab.kaiyanapp.com/api/v3/messages

3.互动

- 请求地址 ：  http://baobab.kaiyanapp.com/api/v7/topic/list

### 视频详情页

1.相关推荐

- 请求地址 ：http://baobab.kaiyanapp.com/api/v4/video/related?id=186856


|参数说明 |说明 |是否必须 |默认值 |
|-|-|-|-|
|id|当前播放视频的id，从跳转页面视频item中获取|是|无|


2. 评论

- 请求地址 ：http://baobab.kaiyanapp.com/api/v2/replies/video?videoId=186856


|参数说明 |说明 |是否必须 |默认值 |
|-|-|-|-|
|videoId|当前播放视频的id，从跳转页面视频item中获取|是|无|

