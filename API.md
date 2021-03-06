<!-- TOC -->

- [0 tips](#0-tips)
- [1.1 登陆相关[完成]](#11-登陆相关完成)
    - [1.1.1 获取openid](#111-获取openid)
    - [1.1.2 添加用户](#112-添加用户)
    - [1.1.3 获取用户信息](#113-获取用户信息)
    - [1.1.4 修改用户信息](#114-修改用户信息)
- [1.2 轮播图设置[完成]](#12-轮播图设置完成)
    - [1.2.1 获取轮图](#121-获取轮图)
    - [1.2.2 新增轮播图](#122-新增轮播图)
    - [1.2.3 修改轮播图](#123-修改轮播图)
    - [1.2.4 删除轮播图](#124-删除轮播图)
- [1.3 图片相关 [完成]](#13-图片相关-完成)
    - [1.3.1 获取uptoken](#131-获取uptoken)
    - [1.3.2 上传图片](#132-上传图片)
    - [1.3.3 获取商品图片](#133-获取商品图片)
    - [1.3.4 获取单个图片](#134-获取单个图片)
    - [1.3.5 删除图片](#135-删除图片)
- [1.4 商品相关 [完成]](#14-商品相关-完成)
    - [1.4.1 发布商品](#141-发布商品)
    - [1.4.2 获取分类商品](#142-获取分类商品)
    - [1.4.3 获取具体商品](#143-获取具体商品)
    - [1.4.4 获取发布商品列表](#144-获取发布商品列表)
    - [1.4.5 修改商品](#145-修改商品)
    - [1.4.6 删除商品](#146-删除商品)
- [1.5 分类[完成]](#15-分类完成)
    - [1.5.1 获取分类 [完成]](#151-获取分类-完成)
- [1.6 评论相关 [完成]](#16-评论相关-完成)
    - [1.6.1 发布评论](#161-发布评论)
    - [1.6.2 获取评论](#162-获取评论)
    - [1.6.3 删除评论](#163-删除评论)
- [1.7 收藏相关 [完成]](#17-收藏相关-完成)
    - [1.6.1 添加收藏](#161-添加收藏)
    - [1.6.2 获取收藏列表](#162-获取收藏列表)
    - [1.6.3 取消收藏](#163-取消收藏)
    - [1.6.4 是否收藏](#164-是否收藏)

<!-- /TOC -->

# 0 tips

- code :
	- 0 : 一切正常
	- 1 : 直接将 message 展示给用户
	- 2 : 验证用户无效，跳转到登陆页


# 1.1 登陆相关[完成]

## 1.1.1 获取openid 

- POST /openid
- payload : 
	- code : 微信登陆code
```json
{
	"code" : "XXXXXXXX"
}
```

- return :
	- openid : 微信用户唯一标识
	- sessionKey :

```json 
{
	"code" : 0,
	"data" : {
		"openId" : "asdasd",
		"sessionKey" : "asdsa"
	}
	
}
```

## 1.1.2 添加用户

- POST /singup
- payload : （允许为空）
	- name : 真实姓名
	- telNumber : 手机号码
	- addr : 收货地址

```json
{
	"wechatName" : "改个名字太急人了",
	"gender" : "男",
	"profileImg" : "http://baidu.com",
	"name" : "陈",
	"telNumber" : "123123",
	"address" : "新校区",
	"openId" : "asdasd",
	"sessionKey" : "asdsa"
}
```

- return :
传参注册成功
```json
{
	"code" : 0,
	"userId" : 12
}
```

传空已经被注册
```json
{
    "code": 2,
    "data": {
        "message": "欢迎回来!",
        "userId": 100045
    }
}
```

传空未被注册
```json
{
    "code": 0,
    "data": "请重新登陆"
}
```



## 1.1.3 获取用户信息

- GET /info/{userId}
- return :
```json
{
        "telNumber": "123123",
        "address": "新校区",
        "gender": "男",
        "sessionKey": "asdsa",
        "createTime": "2018-07-28 00:00:00.0",
        "openId": "oFlyK5dL0fSurY_d4g5Dzi2X6UKI",
        "name": "陈",
        "wechatName": "玳玳花",
        "profileImg": "http://baidu.com",
        "lastEditTime": "2018-07-28 00:00:00.0",
        "userId": 100046
}
```

## 1.1.4 修改用户信息

- PUT /info
- payload ：

```json
{
  "userId" : 123,
  "wechatName" : "昵称",
  "name" : "真实姓名",
  "telNumber" : 123,
  "address" : "校区修改"
}
```

- return :
```json
{
  "code" : 0,
  "data" : true
}
```

# 1.2 轮播图设置[完成]

## 1.2.1 获取轮图

- GET /pic
- return:
	* index : 图片序号
	* name : 图片名称
	* url ： 图片地址

```json
{
    "code": 0,
    "data": [
        {
            "picId" : 123,
            "name": "图片1",
            "url": "http://www.baidu.com"
        },
        {
            "picId" : 123,
            "name": "图片2",
            "url": "http://www.baidu.com"
        }
    ]
}

```

## 1.2.2 新增轮播图

- POST /pic
- payload :

```json
{
    "name": "1",
    "url": "http://123",
    "enable": 1
}
```

- return :

```json
{
    "code": 0,
    "picId" : 123
}
```

## 1.2.3 修改轮播图

- PUT /pic
- payload :

```json
{
    "picId": "1",
    "name" : "bala",
    "url" : "http://123",
	"enable" : 0
}
```

- return :

```json
{
    "code": 0,
    "data": true
}
```

## 1.2.4 删除轮播图

- DELETE /pic/{systemId}
- return :

```json
{
    "code": 0,
    "data": true
}
```

# 1.3 图片相关 [完成]

## 1.3.1 获取uptoken 
- GET /uptoken
- return : 
```json
{
	"code" : 0,
	"uptoken" : "123"
}
```

## 1.3.2 上传图片

- POST /img
- payload :

```json
[
    {
		"itemId" : 1,
        "imgUrl" : "http://baidu.com"
    },
    {
		"itemId" : 1,
        "imgUrl" : "http://google.com"
    }
]
```

- return :
```json
{
	"code" : 0,
	"data" : [
		{
			"imgId" :1
		},
		{
			"imgId" :2
		}
	]
}
```

## 1.3.3 获取商品图片

- GET /img/{itemId}
- payload : 
	- itemId : 当前商品的ID
	//根据添加的时间升序排序
- return :
```json
{
    "code": 0,
    "data": [
        {
            "imgId": 1,
            "imgUrl": "http://google.com",
            "itemId": 1
        },
        {
            "imgId": 1,
            "imgUrl": "http://baidu.com",
            "itemId": 1
        },
        {
            "imgId": 1,
            "imgUrl": "http://google.com",
            "itemId": 1
        },
        {
            "imgId": 1,
            "imgUrl": "http://baidu.com",
            "itemId": 1
        }
    ]
}
```

## 1.3.4 获取单个图片

- GET /img/{imgId}
- payload : 
	- imgId : 当前图片的ID

- return :
```json
{
  "code" : 0,
  "data" : {
      "itemId" : 123,
      "imgUrl" : "http://baidu.com"
  }
}
```

## 1.3.5 删除图片
- DELETE /img/{imgId}
- return :
```json
{
	"code" : 0,
	"data" : true
}
```

# 1.4 商品相关 [完成]

## 1.4.1 发布商品

- POST /item
- payload ： 
	- name ：商品名
	- price ： 价格
	- sortId ： 分类id
	- content ： 内容
	- views : 查看人数
	- publishId : 发布者ID
	- status : 商品状态   0 审核未通过|1 审核通过|2 已出售|3 已关闭

```json
{
	"name" : "商品1",
	"price" : 123,
	"sortId" : 1,
	"content" : "balabalabalablab",
	"publishId" : 123,
	"views" : 1,
	"status" : 1
}

```

- return :

```json
{
	"code" : 0,
	"data" : 123
}
```

## 1.4.2 获取分类商品

- GET /item/?sortId=1?page=1
- payload :
	- sortId : 为空返回全部商品，否则返回对应分类商品
	- page : 商品页数 默认为1
- return ： 
	- itmId ：商品ID
	- name ：商品名
	- price ： 价格
	- sortId : 123
	- publishId : 发布者ID
    - profileImg：发布者头像地址
    - wechatName：发布者昵称
    - createTime : 创建时间
    - views ：浏览人数

```json
{
	"code" : 0,
	"data" : [
		{
		"itmId" : 123,
		"name" : "商品1",
		"price" : 123,
		"sortId" : 123,
		"publishId" : 123,
        "profileImg" : "http:",
        "wechatName" : "name",
        "createTime" : "2010-10-10",
        "views" : 100,
		"img" : [
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				},
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				}
			]
	},
	{
		"itmId" : 123,
		"name" : "商品1",
		"price" : 123,
		"sortId" : 123,
		"publishId" : 123,
        "profileImg" : "http:",
        "wechatName" : "name",
        "createTime" : "2010-10-10",
        "views" : 100,
		"img" : [
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				},
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				}
			]
	}	
	],
	"page": {
        "currentPage": 1,
        "totalPage": 3,
        "pageSize": 4,
        "totalSize": 12
    }
	
}

```

## 1.4.3 获取具体商品
- GET /item?itemId=1
- payload :
	itemId : 商品Id 为空返回全部商品，否则返回对应商品
	page : 请求页数 默认为1;
	head : userId
- return :
    - itmId ：商品ID
	- name ：商品名
	- price ： 价格
	- sortId : 123
	- publishId : 发布者ID
    - createTime : 创建时间
    - view ：浏览人数
	- status : 商品状态   0 审核未通过|1 审核通过|2 已出售|3 已关闭
```json 
{
	"code" : 0,
	"data" : {
		"itmId" : 123,
		"name" : "商品1",
		"price" : 123,
		"sortId" : 123,
		"content" : "asdasd",
		"publishId" : 123,
        "profileImg" : "http:",
        "wechatName" : "name",
        "createTime" : "2010-10-10",
        "views" : 100,
		"status" : 1,
		"img" : [
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				},
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				}
			]
	}
}
```

## 1.4.4 获取发布商品列表
- GET /item?publishId=
- payload :
	publishId : 用户Id 获取当前的发布

- return : 
```json
{
	"code" : 0,
	"data" : [
		{
			"itmId" : 123,
			"name" : "商品1",
			"price" : 123,
			"sortId" : 123,
			"publishId" : 123,
			"profileImg" : "http:",
			"wechatName" : "name",
			"createTime" : "2010-10-10",
			"views" : 100,
			"img" : [
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				},
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				}
			]
		},
		{
			"itmId" : 123,
			"name" : "商品1",
			"price" : 123,
			"sortId" : 123,
			"publishId" : 123,
			"profileImg" : "http:",
			"wechatName" : "name",
			"createTime" : "2010-10-10",
			"views" : 100,
			"img" : [
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				},
				{
					"imgId": 104,
                    "itemId": 123,
                    "imgUrl": "http://baidu.com"
				}
			]
		}
	],
	"page": {
        "currentPage": 1,
        "totalPage": 3,
        "pageSize": 4,
        "totalSize": 12
    }
}
```

## 1.4.5 修改商品

- PUT /item
- payload :
```json
{
	"name" : "新名字",
	"price" : "",
	"content" : "",
	"sortId" : "",
	"status" : ""
}
```
- return : 
```json
{
	"code" : 0,
	"data" : true
}
```

## 1.4.6 删除商品

- DELETE /item/{itemId}
- return :
```json
{
	"code" : 0,
	"data" : true
}
```

# 1.5 分类[完成]

## 1.5.1 获取分类 [完成]

- GET /sort
- return :

```json
{
	"code" : 0,
	"data" : [
		{
			"sortId" : 1,
			"sortIndex" : 1,
			"sortName" : "手机数码"
		},
		{
			"sortId" : 2,
            "sortIndex" : 2,
			"sortName" : "二手书籍"
		},
	]
}
```

# 1.6 评论相关 [完成]

## 1.6.1 发布评论

- POST /comment
- payload ：
	- content ： 评论内容

```json
{
	"userId" : 123,
	"itemId" : 123,
	"content" : "bababba",
	"parentId" : //如果是发布者回复再带这个字段 (默认为空)
}
	
```

- return :
	- data : 评论ID
```json
{
	"code" : 0,
	"data" : 123
}
```

## 1.6.2 获取评论

- GET /comment
- paload : 
	- 要查哪个就传哪个参
```json
{
	"itemId" : 123,
	"userId" : 123
}
```

- return ：
	- commentId ：评论id
	- userId ：用户id
	- content ：评论内容

```json
{
	"code" : 0,
	"data" : [
		{
			"commentId" : 111,
			"userId" : 111,
			"content" : "dhfshfs"
		
		},
		{
			"commentId" : 111,
			"userId" : 111,
			"content" : "dhfshfs"
		}
	],
	"page": {
        "currentPage": 1,
        "totalPage": 3,
        "pageSize": 4,
        "totalSize": 12
    }
}
```

## 1.6.3 删除评论

- DELETE /comment/{commentId}
- return ：

```json
{
	"code" : 0,
	"data" : true
}
```

# 1.7 收藏相关 [完成]

## 1.6.1 添加收藏

- POST /star
- payload ：
	- itemId ： 收藏商品id

```json
{
	"userId" : 123,
	"itemId" : 123		
}
	
```

- return :
	- data : 收藏ID
```json
{
	"code" : 0,
	"data" : true
}
```

## 1.6.2 获取收藏列表

- GET /star?userId=
- return ：
	- starId ：收藏id
	- userId ：用户id
	- itemId ：商品id

```json
{
	"code" : 0,
	"data" : [
		{
			"startId" : 111,
			"userId" : 111,
			"itemId" : 111		
		}
		{
			"starId" : 111,
			"userId" : 111,
			"itemId" : 111			
		}
	],
	"page": {
        "currentPage": 1,
        "totalPage": 3,
        "pageSize": 4,
        "totalSize": 12
    }
}
```

## 1.6.3 取消收藏
- DELETE /star/{starId}
- return ：

```json
{
	"code" : 0,
	"data" : true
}
```

## 1.6.4 是否收藏

- GET /isstar
- pyaload :
	- userId
	- itemId

```json
{
	"userId" : 123,
	"itemId" : 123
}
```

- return :
	- data : 被收藏 StarId 未收藏 false
```json
{
	"code" : 0,
	"data" : true
}
```
