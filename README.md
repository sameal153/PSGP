
## 平台简介

若依是一套全部开源的快速开发平台，毫无保留给个人及企业免费使用。

* 前端采用Vue、Element UI。
* 后端采用Spring Boot、Spring Security、Redis & Jwt。
* 权限认证使用Jwt，支持多终端认证系统。
* 支持加载动态权限菜单，多方式轻松权限控制。
* 高效率开发，使用代码生成器可以一键生成前后端代码。

## 内置功能

1.  用户管理：用户是系统操作者，该功能主要完成系统用户配置。
2.  部门管理：配置系统组织机构（公司、部门、小组），树结构展现支持数据权限。
3.  岗位管理：配置系统用户所属担任职务。
4.  菜单管理：配置系统菜单，操作权限，按钮权限标识等。
5.  角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
6.  字典管理：对系统中经常使用的一些较为固定的数据进行维护。
7.  参数管理：对系统动态配置常用参数。
8.  通知公告：系统通知公告信息发布维护。
9.  操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
10. 登录日志：系统登录日志记录查询包含登录异常。
11. 在线用户：当前系统中活跃用户状态监控。
12. 定时任务：在线（添加、修改、删除)任务调度包含执行结果日志。
13. 代码生成：前后端代码的生成（java、html、xml、sql）支持CRUD下载 。
14. 系统接口：根据业务代码自动生成相关的api接口文档。
15. 服务监控：监视当前系统CPU、内存、磁盘、堆栈等相关信息。
16. 缓存监控：对系统的缓存信息查询，命令统计等。
17. 在线构建器：拖动表单元素生成相应的HTML代码。
18. 连接池监视：监视当前系统数据库连接池状态，可进行分析SQL找出系统性能瓶颈。

## 项目结构
com.ruoyi     
├── common            // 工具类（注解、过滤器，异常及工具类的封装）
│       └── annotation                    // 自定义注解
│       └── config                        // 全局配置
│       └── constant                      // 通用常量
│       └── core                          // 核心控制
│       └── enums                         // 通用枚举
│       └── exception                     // 通用异常
│       └── filter                        // 过滤器处理
│       └── utils                         // 通用类处理
├── framework         // 框架核心（事务管理）
│       └── aspectj                       // 注解实现
│       └── config                        // 系统配置
│       └── datasource                    // 数据权限
│       └── interceptor                   // 拦截器
│       └── manager                       // 异步处理
│       └── security                      // 权限控制
│       └── web                           // 前端控制
├── ruoyi-generator   // 代码生成（可移除）
├── ruoyi-quartz      // 定时任务（可移除）
├── ruoyi-system      // 系统代码
├── ruoyi-admin       // 后台服务（业务层直接和前端交互）
├── ruoyi-xxxxxx      // 其他模块


* 各个模块之间都有独立的pom.xml文件，各个模块之间通过引用类和@Autowired自动装配的方式进行通信。
* 
   



## 后台手册  
* 权限注解
* Spring Security提供了Spring EL表达式，允许我们在定义接口访问的方法上面添加注解，来控制访问权限。

## 公开接口
* 如果有些接口是不需要验证权限可以公开访问的，这个时候就需要我们给接口放行。 使用注解方式，只需要在Controller的类或方法上加入@Anonymous该注解即可

## 系统接口注解
* 使用swagger对接口进行描述
* 作用范围             API注解                    使用位置
  协议集描述	          @Api	                 用于controller类上
  对象属性	          @ApiModelProperty	     用在出入参数对象的字段上
  协议描述	          @ApiOperation	         用在controller的方法上
  Response集	      @ApiResponses	         用在controller的方法上
  Response	          @ApiResponse	         用在 @ApiResponses里边
  非对象参数集	      @ApiImplicitParams	 用在controller的方法上
  非对象参数描述	      @ApiImplicitParam	     用在@ApiImplicitParams的方法里边
  描述返回对象的意义	  @ApiModel	             用在返回对象类上


